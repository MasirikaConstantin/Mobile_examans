package com.example.mescode;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Math_info extends MainActivity {
    private Button mMonboutton;
    private EditText mText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_info);

        init();
    }

    private void init(){
        mMonboutton = findViewById(R.id.mon_btn);
        mText=findViewById(R.id.text1);
        liste();
    }
    private void  liste(){
        mMonboutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mafonction();


            }
        });
    }
    protected void mafonction(){


       // String mot =mText.getText().toString();
        Toast.makeText(Math_info.this, "mot rtxf fchxt", Toast.LENGTH_SHORT).show();



    }

}