package com.example.mostosapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mostosapp.adapter.ViewAdapter;
import com.example.mostosapp.dialogs.Listar;
import com.example.mostosapp.models.MotoModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Register extends AppCompatActivity implements Listar.Respuesta {
    public TextView home;
    private EditText marca, modelo, km, price;
    private Button btn_registro;
    private MotoModel model;
    private int [] image;
    protected FirebaseFirestore db;
    private String TAG = "LFNOT";
    private Context context = this;
    final private String collection = "motorcycle";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        home = (TextView) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Home();
            }
        });

        db = FirebaseFirestore.getInstance();

        marca = (EditText)findViewById(R.id.marca);
        modelo = (EditText)findViewById(R.id.model);
        km  = (EditText)findViewById(R.id.km);
        price = (EditText)findViewById(R.id.price);

        final int [] image = {
                R.drawable.uno,
                R.drawable.dos,
                R.drawable.tres,
                R.drawable.cuatro,
                R.drawable.cinco,
                R.drawable.seis,
                R.drawable.siete,
                R.drawable.ocho
        };

        btn_registro  = (Button) findViewById(R.id.registro);
        btn_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String marc, mod, kms, pri;
                marc = marca.getText().toString();
                mod = modelo.getText().toString();
                kms = km.getText().toString();
                pri = price.getText().toString();

                model = new MotoModel(marc,mod,kms,pri,image[(int) (Math.random()*7+1)]);

                db.collection(collection)
                        .add(model)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                price.setText("");
                                marca.setText("");
                                modelo.setText("");
                                km.setText("");
                                Listar dialog = new Listar(context,Register.this);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error adding document", e);
                                Toast.makeText(getApplicationContext(), "No se guardó correctamente: " + e.getMessage() , Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });

    }

    public void Home(){
        Intent sig = new Intent(this,Home.class);
        startActivity(sig);
    }

    public void ViewList(){
        Intent sig = new Intent(this, ViewList.class);
        startActivity(sig);
    }

    @Override
    public void resultado(Boolean ver) {
        if(ver = true){
            ViewList();
        }
    }
}