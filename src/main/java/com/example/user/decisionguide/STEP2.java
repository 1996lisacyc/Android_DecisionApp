package com.example.user.decisionguide;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class STEP2 extends Activity {
    private Button next;
    Spinner spinner1;
    private RadioGroup radioGroup1;
    int step2_ans1=0;
    int step2_ans2=0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step2);

        next = (Button)findViewById(R.id.next);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        radioGroup1= (RadioGroup)findViewById(R.id.radioGroup1);

        ArrayAdapter<CharSequence> step2_list = ArrayAdapter.createFromResource(STEP2.this, R.array.step2_arr, android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(step2_list);
        next.setOnClickListener(myListner);
        spinner1.setOnItemSelectedListener(spiListner);
    }
    public void get_step2_ans1(int id){
        switch(id) {
            case R.id.radio1:
                step2_ans1 = 1;
                break;
            case R.id.radio2:
                step2_ans1 = 2;
                break;
            case R.id.radio3:
                step2_ans1 = 3;
                break;
            default:
                step2_ans1 = 0;
        }
    }
    public void rbclick(View v) {
        int rbId = radioGroup1.getCheckedRadioButtonId();
        get_step2_ans1(rbId);
        //test
        //RadioButton rb = (RadioButton)findViewById(rbId);
        //Toast.makeText(STEP2.this,rb.getText(), Toast.LENGTH_SHORT).show();
    }
    private Button.OnClickListener myListner=new Button.OnClickListener(){
        public void onClick(View v){
            if(step2_ans1!=0 && step2_ans2<=0)
            {
                Toast.makeText(STEP2.this, "第二題未作答", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent = new Intent();
                intent.setClass(STEP2.this, STEP2_2.class);
                //Bundle bundle = new Bundle();
                Bundle bundle = getIntent().getExtras();
                int output1 = bundle.getInt("output1");
                int output2 = bundle.getInt("output2");
                int output3 = bundle.getInt("output3");
                bundle.putInt("output1", output1);
                bundle.putInt("output2", output2);
                bundle.putInt("output3",output3);
                bundle.putInt("step2_ans1",step2_ans1);
                bundle.putInt("step2_ans2",step2_ans2);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
    };
    private Spinner.OnItemSelectedListener spiListner = new  Spinner.OnItemSelectedListener(){
        public void onItemSelected(AdapterView adapterView, View view, int position, long id){
            step2_ans2 = Integer.parseInt(adapterView.getSelectedItem().toString());
            //test
            //Toast.makeText(STEP2.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        }
        public void onNothingSelected(AdapterView arg0) {

        }
    };

}