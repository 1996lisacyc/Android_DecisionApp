package com.example.user.decisionguide;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/*import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;*/

import java.math.BigDecimal;
//import java.util.ArrayList;

public class STEP3 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step3);

        Bundle bundle = getIntent().getExtras();

        float result1 = (float)bundle.getInt("output1");    // 不動手術
        float result2 = (float)bundle.getInt("output2");    // 植入體
        float result3 = (float)bundle.getInt("output3");    // 自體移植
        float result = result1+result2+result3;
        float step2_ans1 = (float)bundle.getInt("step2_ans1");  // 重要他人比較喜歡哪種重建方式
        float step2_ans2 = (float)bundle.getInt("step2_ans2");  // 他的意見對使用者決定的影響程度
        float step2_ans3 = (float)bundle.getInt("step2_ans3");  // 他對使用者的決定會給予多少支持
        float step2_ans4 = (float)bundle.getInt("step2_ans4");  // 使用者做決定的時候希望可以

        if(step2_ans4 == 1){    // 聽完建議以後自己做決定
            result = result1+result2+result3;
            result1 = result1/result*100;
            result2 = result2/result*100;
            result3 = result3/result*100;
        }
        else if(step2_ans4 == 2){   // 和重要他人一起做決定
            // 原始自我分數與"重要他人影響程度"與"重要他人支持"之加權
            if(step2_ans1 == 1){    // 重要他人比較喜歡第一種
                result1 += result*(step2_ans2/10)*((11-step2_ans3)/10);
            }
            else if(step2_ans1 == 2){   // 重要他人比較喜歡第二種
                result2 += result*(step2_ans2/10)*((11-step2_ans3)/10);
            }
            else{   // 重要他人比較喜歡第三種
                result3 += result*(step2_ans2/10)*((11-step2_ans3)/10);
            }
        }
        else{   //由重要他人幫我做決定
            // 原始自我分數與"重要他人支持"之加權
            if(step2_ans1 == 1){    // 重要他人比較喜歡第一種
                result1 += result*((11-step2_ans3)/10);
            }
            else if(step2_ans1 == 2){   // 重要他人比較喜歡第二種
                result2 += result*((11-step2_ans3)/10);
            }
            else{   // 重要他人比較喜歡第三種
                result3 += result*((11-step2_ans3)/10);
            }
        }

        result = result1+result2+result3;
        result1 = result1/result*100;
        result2 = result2/result*100;
        result3 = result3/result*100;

        BigDecimal b1 = new BigDecimal(result1);
        result1 = b1.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();

        BigDecimal b2 = new BigDecimal(result2);
        result2 = b2.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();

        BigDecimal b3 = new BigDecimal(result3);
        result3 = b3.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();

        LinearLayout layout=(LinearLayout) findViewById(R.id.step3);
        final PanelPieChart1 view=new PanelPieChart1(this);
        view.PieChart(new float[]{result1, result2, result3, 0f});
        view.setMinimumHeight(500);
        view.setMinimumWidth(300);
        //通知view组件重绘
        view.invalidate();
        layout.addView(view);

        Button button=(Button)findViewById(R.id.next);
        button.setOnClickListener(myListner);
    }

    private Button.OnClickListener myListner=new Button.OnClickListener(){
        public void onClick(View v){
            Intent intent=new Intent();
            intent.setClass(STEP3.this,Main.class);
            startActivity(intent);
        }
    };
}
