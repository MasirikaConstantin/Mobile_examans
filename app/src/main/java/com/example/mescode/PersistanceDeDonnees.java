package com.example.mescode;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PersistanceDeDonnees extends MainActivity {

    private EditText mEditTextnom;
    private EditText getmEditTextage;
    private Button mButtonEnregistrer;
    private Button mButtonLire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Persistance de données");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persistance_de_donnees);

        init();
    }


    private void init(){

        mEditTextnom = findViewById(R.id.editText_nom);
        getmEditTextage = findViewById(R.id.editext_age);
        mButtonEnregistrer = findViewById(R.id.butn);
        mButtonLire = findViewById(R.id.butn2);


        definirEcouteurs();
    }

    protected void definirEcouteurs(){
        mButtonEnregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enregistrer();
            }

        });

        mButtonLire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lire();
            }

        });



    }

    protected void enregistrer(){
        SharedPreferences p = getSharedPreferences("myData", Context.MODE_PRIVATE);

        SharedPreferences.Editor ed = p.edit();

        ed.putString("nom", mEditTextnom.getText().toString());
        ed.putString("age", getmEditTextage.getText().toString());
        ed.commit();

        mEditTextnom.setText("");
        getmEditTextage.setText("");
    }

    protected  void Lire(){
        SharedPreferences p = getSharedPreferences("myData", Context.MODE_PRIVATE);

        //Afficher
        String nom = p.getString("nom", null);
        String age = p.getString("age", null);

        mEditTextnom.setText(nom);
        getmEditTextage.setText(age);


    }
}