package com.example.user.decisionguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Page1 extends Activity {
    Spinner spinner1,spinner2,spinner3,spinner4,spinner5,spinner6,spinner7,spinner8,spinner9,spinner10,spinner11,spinner12,spinner13,spinner14;
    Spinner spinner15,spinner16,spinner17,spinner18,spinner19,spinner20,spinner21;
    Button next;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1);
        next=(Button)findViewById(R.id.next);
        next.setOnClickListener(myListner);

        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner3 = (Spinner)findViewById(R.id.spinner3);
        spinner4 = (Spinner)findViewById(R.id.spinner4);
        spinner5 = (Spinner)findViewById(R.id.spinner5);
        spinner6 = (Spinner)findViewById(R.id.spinner6);
        spinner7 = (Spinner)findViewById(R.id.spinner7);
        spinner8 = (Spinner)findViewById(R.id.spinner8);
        spinner9 = (Spinner)findViewById(R.id.spinner9);
        spinner10 = (Spinner)findViewById(R.id.spinner10);
        spinner11 = (Spinner)findViewById(R.id.spinner11);
        spinner12 = (Spinner)findViewById(R.id.spinner12);
        spinner13 = (Spinner)findViewById(R.id.spinner13);
        spinner14 = (Spinner)findViewById(R.id.spinner14);
        spinner15 = (Spinner)findViewById(R.id.spinner15);
        spinner16 = (Spinner)findViewById(R.id.spinner16);
        spinner17 = (Spinner)findViewById(R.id.spinner17);
        spinner18 = (Spinner)findViewById(R.id.spinner18);
        spinner19 = (Spinner)findViewById(R.id.spinner19);
        spinner20 = (Spinner)findViewById(R.id.spinner20);
        spinner21 = (Spinner)findViewById(R.id.spinner21);
        ArrayAdapter<CharSequence> lis1 = ArrayAdapter.createFromResource(Page1.this, R.array.arr1, android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(lis1);
        spinner3.setAdapter(lis1);
        spinner5.setAdapter(lis1);
        spinner7.setAdapter(lis1);
        spinner9.setAdapter(lis1);
        spinner11.setAdapter(lis1);
        spinner13.setAdapter(lis1);
        spinner2.setAdapter(lis1);
        spinner4.setAdapter(lis1);
        spinner6.setAdapter(lis1);
        spinner8.setAdapter(lis1);
        spinner10.setAdapter(lis1);
        spinner12.setAdapter(lis1);
        spinner14.setAdapter(lis1);
        spinner15.setAdapter(lis1);
        spinner16.setAdapter(lis1);
        spinner17.setAdapter(lis1);
        spinner18.setAdapter(lis1);
        spinner19.setAdapter(lis1);
        spinner20.setAdapter(lis1);
        spinner21.setAdapter(lis1);
    }

    private Button.OnClickListener myListner=new Button.OnClickListener(){
        public void onClick(View v){
            Intent intent=new Intent();
            intent.setClass(Page1.this,STEP1.class);

            Bundle bundle=new Bundle();
            //Bundle bundle = getIntent().getExtras();
            //intent.putExtras(bundle);
            int output1_1,output1_2,output1_3,output1_4,output1_5,output1_6,output1_7;
            int output2_1,output2_2,output2_3,output2_4,output2_5,output2_6,output2_7;
            int output3_1,output3_2,output3_3,output3_4,output3_5,output3_6,output3_7;
            String text1 = spinner1.getSelectedItem().toString();
            String text2 = spinner2.getSelectedItem().toString();
            String text3 = spinner3.getSelectedItem().toString();
            output1_1=Integer.parseInt(text1);
            output2_1=Integer.parseInt(text2);
            output3_1=Integer.parseInt(text3);
            text1 = spinner4.getSelectedItem().toString();
            text2 = spinner5.getSelectedItem().toString();
            text3 = spinner6.getSelectedItem().toString();
            output1_2=Integer.parseInt(text1);
            output2_2=Integer.parseInt(text2);
            output3_2=Integer.parseInt(text3);
            text1 = spinner7.getSelectedItem().toString();
            text2 = spinner8.getSelectedItem().toString();
            text3 = spinner9.getSelectedItem().toString();
            output1_3=Integer.parseInt(text1);
            output2_3=Integer.parseInt(text2);
            output3_3=Integer.parseInt(text3);
            text1 = spinner10.getSelectedItem().toString();
            text2 = spinner11.getSelectedItem().toString();
            text3 = spinner12.getSelectedItem().toString();
            output1_4=Integer.parseInt(text1);
            output2_4=Integer.parseInt(text2);
            output3_4=Integer.parseInt(text3);
            text1 = spinner13.getSelectedItem().toString();
            text2 = spinner14.getSelectedItem().toString();
            text3 = spinner15.getSelectedItem().toString();
            output1_5=Integer.parseInt(text1);
            output2_5=Integer.parseInt(text2);
            output3_5=Integer.parseInt(text3);
            text1 = spinner16.getSelectedItem().toString();
            text2 = spinner17.getSelectedItem().toString();
            text3 = spinner18.getSelectedItem().toString();
            output1_6=Integer.parseInt(text1);
            output2_6=Integer.parseInt(text2);
            output3_6=Integer.parseInt(text3);
            text1 = spinner19.getSelectedItem().toString();
            text2 = spinner20.getSelectedItem().toString();
            text3 = spinner21.getSelectedItem().toString();
            output1_7=Integer.parseInt(text1);
            output2_7=Integer.parseInt(text2);
            output3_7=Integer.parseInt(text3);


            //int CHOICE = bundle.getInt("CHOICE");
            //bundle.putInt("CHOICE", CHOICE);
            bundle.putInt("output1_1", output1_1);
            bundle.putInt("output1_2", output1_2);
            bundle.putInt("output1_3", output1_3);
            bundle.putInt("output1_4", output1_4);
            bundle.putInt("output1_5", output1_5);
            bundle.putInt("output1_6", output1_6);
            bundle.putInt("output1_7", output1_7);
            bundle.putInt("output2_1", output2_1);
            bundle.putInt("output2_2", output2_2);
            bundle.putInt("output2_3", output2_3);
            bundle.putInt("output2_4", output2_4);
            bundle.putInt("output2_5", output2_5);
            bundle.putInt("output2_6", output2_6);
            bundle.putInt("output2_7", output2_7);
            bundle.putInt("output3_1", output3_1);
            bundle.putInt("output3_2", output3_2);
            bundle.putInt("output3_3", output3_3);
            bundle.putInt("output3_4", output3_4);
            bundle.putInt("output3_5", output3_5);
            bundle.putInt("output3_6", output3_6);
            bundle.putInt("output3_7", output3_7);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };

}