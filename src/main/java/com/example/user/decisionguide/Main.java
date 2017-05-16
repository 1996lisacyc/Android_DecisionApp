package com.example.user.decisionguide;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button button=(Button)findViewById(R.id.next);
        button.setOnClickListener(myListner);
    }

    private Button.OnClickListener myListner=new Button.OnClickListener(){
        public void onClick(View v){
            Intent intent=new Intent();
            intent.setClass(Main.this,Page1.class);
            startActivity(intent);
        }
    };

}
