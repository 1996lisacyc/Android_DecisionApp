package com.example.user.decisionguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.view.View;

public class STEP1 extends Activity {
    Spinner spinner1,spinner2,spinner3,spinner4,spinner5,spinner6,spinner7;
    Button next;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step1);
        next=(Button)findViewById(R.id.next);
        next.setOnClickListener(myListner);

        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner3 = (Spinner)findViewById(R.id.spinner3);
        spinner4 = (Spinner)findViewById(R.id.spinner4);
        spinner5 = (Spinner)findViewById(R.id.spinner5);
        spinner6 = (Spinner)findViewById(R.id.spinner6);
        spinner7 = (Spinner)findViewById(R.id.spinner7);
        ArrayAdapter<CharSequence> lis1 = ArrayAdapter.createFromResource(STEP1.this, R.array.arr2, android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(lis1);
        spinner2.setAdapter(lis1);
        spinner3.setAdapter(lis1);
        spinner4.setAdapter(lis1);
        spinner5.setAdapter(lis1);
        spinner6.setAdapter(lis1);
        spinner7.setAdapter(lis1);
    }
    private Button.OnClickListener myListner=new Button.OnClickListener(){
        public void onClick(View v){
            Intent intent=new Intent();
            intent.setClass(STEP1.this,STEP2.class);

            //Bundle bundle=new Bundle();
            Bundle bundle = getIntent().getExtras();
            //intent.putExtras(bundle);

            String text1 = spinner1.getSelectedItem().toString();
            int tem1,tem2,tem3,output1,output2,output3,output4,output5,output6,output7, output;
            int Weight=0;
            output1=output2=output3=0;
            Weight=Integer.parseInt(text1);//get current weight
            tem1 = bundle.getInt("output1_1");
            tem2= bundle.getInt("output2_1");
            tem3= bundle.getInt("output3_1");
            output1=output1+tem1*Weight;
            output2=output2+tem2*Weight;
            output3=output3+tem3*Weight;
            text1 = spinner2.getSelectedItem().toString();
            Weight=Integer.parseInt(text1);//get current weight
            tem1 = bundle.getInt("output1_2");
            tem2= bundle.getInt("output2_2");
            tem3= bundle.getInt("output3_2");
            output1=output1+tem1*Weight;
            output2=output2+tem2*Weight;
            output3=output3+tem3*Weight;
            text1 = spinner3.getSelectedItem().toString();
            Weight=Integer.parseInt(text1);//get current weight
            tem1 = bundle.getInt("output1_3");
            tem2= bundle.getInt("output2_3");
            tem3= bundle.getInt("output3_3");
            output1=output1+tem1*Weight;
            output2=output2+tem2*Weight;
            output3=output3+tem3*Weight;
            text1 = spinner4.getSelectedItem().toString();
            Weight=Integer.parseInt(text1);//get current weight
            tem1 = bundle.getInt("output1_4");
            tem2= bundle.getInt("output2_4");
            tem3= bundle.getInt("output3_4");
            output1=output1+tem1*Weight;
            output2=output2+tem2*Weight;
            output3=output3+tem3*Weight;
            text1 = spinner5.getSelectedItem().toString();
            Weight=Integer.parseInt(text1);//get current weight
            tem1 = bundle.getInt("output1_5");
            tem2= bundle.getInt("output2_5");
            tem3= bundle.getInt("output3_5");
            output1=output1+tem1*Weight;
            output2=output2+tem2*Weight;
            output3=output3+tem3*Weight;
            text1 = spinner6.getSelectedItem().toString();
            Weight=Integer.parseInt(text1);//get current weight
            tem1 = bundle.getInt("output1_6");
            tem2= bundle.getInt("output2_6");
            tem3= bundle.getInt("output3_6");
            output1=output1+tem1*Weight;
            output2=output2+tem2*Weight;
            output3=output3+tem3*Weight;
            text1 = spinner7.getSelectedItem().toString();
            Weight=Integer.parseInt(text1);//get current weight
            tem1 = bundle.getInt("output1_7");
            tem2= bundle.getInt("output2_7");
            tem3= bundle.getInt("output3_7");
            output1=output1+tem1*Weight;
            output2=output2+tem2*Weight;
            output3=output3+tem3*Weight;

            bundle.putInt("output1", output1);
            bundle.putInt("output2", output2);
            bundle.putInt("output3", output3);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };

}
