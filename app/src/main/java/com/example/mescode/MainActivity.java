package com.example.mescode;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button addition, soustraction, multiplication, division;
    private EditText n1, n2;
    private TextView c;
    private Button Vi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        addition = findViewById(R.id.add);
        soustraction = findViewById(R.id.sous);
        multiplication = findViewById(R.id.multi);
        division = findViewById(R.id.div);
        n1 =  findViewById(R.id.valun);
        n2 = findViewById(R.id.valdeux);
        c= findViewById(R.id.resultat);
        Vi = findViewById(R.id.videos);


        soustraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              try {
                  int aa = Integer.parseInt(n1.getText().toString());
                  int bb = Integer.parseInt(n2.getText().toString());
                  int s= aa-bb;
                  //System.out.println(aa);
                  c.setText("Résultat :  "+ String.valueOf(s));
              }catch (Exception e){
                  n1.setError("Vérifier vos données");
                  n1.requestFocus();
                  n2.setError("Vérifier vos données");
                  n2.requestFocus();
                  Toast.makeText(getApplicationContext(),"Erreur ..." , Toast.LENGTH_LONG).show();
              }


            }
        });

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int aa = Integer.parseInt(n1.getText().toString());
                    int bb = Integer.parseInt(n2.getText().toString());
                    int s= aa+bb;
                    //System.out.println(aa);
                    c.setText("Résultat :  "+ String.valueOf(s));
                }catch (Exception e){
                    n1.setError("Vérifier vos données");
                    n1.requestFocus();
                    n2.setError("Vérifier vos données");
                    n2.requestFocus();
                    Toast.makeText(getApplicationContext(),"Erreur ..." , Toast.LENGTH_LONG).show();
                }


            }
        });

        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int aa = Integer.parseInt(n1.getText().toString());
                    int bb = Integer.parseInt(n2.getText().toString());
                    int s= aa*bb;
                    //System.out.println(aa);
                    c.setText("Résultat :  "+ String.valueOf(s));
                }catch (Exception e){
                    n1.setError("Vérifier vos données");
                    n1.requestFocus();
                    n2.setError("Vérifier vos données");
                    n2.requestFocus();
                    Toast.makeText(getApplicationContext(),"Erreur ..." , Toast.LENGTH_LONG).show();
                }


            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    float aa = Integer.parseInt(n1.getText().toString());
                    float bb = Integer.parseInt(n2.getText().toString());
                    double s= aa/bb;
                    //System.out.println(aa);
                    c.setText("Résultat :  "+ String.valueOf(s));
                }catch (Exception e){
                    n1.setError("Vérifier vos données");
                    n1.requestFocus();
                    n2.setError("Vérifier vos données");
                    n2.requestFocus();
                    Toast.makeText(getApplicationContext(),"Erreur ..." , Toast.LENGTH_LONG).show();
                }


            }
        });


        Vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VideosTest.class);
                startActivity(intent);
            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id =item.getItemId();

        if(id==R.id.math_info){
            Toast.makeText(this, "Sciences Séléctionner", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Math_info.class);
            startActivity(i);


            return true;
        }
        if(id==R.id.fac_medecine){
            Toast.makeText(this, "Médecine Séléctionner", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, faculte_medecine.class);
            startActivity(i);

            return true;
        }
        if(id==R.id.fac_droit){
            Toast.makeText(this, "Droit Séléctionner", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, fac_droit.class);
            startActivity(i);
            return true;
        }
        if(id==R.id.menu_item_camera_video){
            Toast.makeText(this, "Caméra Vidéos Séléctionnée", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, VideosTest.class);
            startActivity(i);
            return true;
        }

        if(id==R.id.menu_item_persistance_donnees){
            Toast.makeText(this, "Persistance de données", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, PersistanceDeDonnees.class);
            startActivity(i);
            return true;
        }

        else {
            return super.onOptionsItemSelected(item);
        }
    }



}