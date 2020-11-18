package com.example.mostosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mostosapp.models.MotoModel;

public class FullMoto extends AppCompatActivity {
    private MotoModel item;
    private TextView marca, model, km, price;
    private ImageView imgV, meg, compart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_moto);

        item = (MotoModel) getIntent().getSerializableExtra("data");
        marca = (TextView)findViewById(R.id.marc);
        model = (TextView)findViewById(R.id.model);
        km = (TextView)findViewById(R.id.km);
        price = (TextView)findViewById(R.id.price);
        imgV = (ImageView) findViewById(R.id.img);
        meg = (ImageView) findViewById(R.id.meg);
        compart = (ImageView) findViewById(R.id.compartir);

        meg.setTag("uno");
        imgV.setImageResource(item.getImage());
        marca.setText(item.getMarca());
        model.setText(item.getModelo());
        km.setText(item.getRecorrido());
        price.setText(item.getPrecio());

        meg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Megusta();
            }
        });

        compart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent compartir = new Intent(android.content.Intent.ACTION_SEND);
                compartir.setType("text/plain");
                String mensaje = "Te recomiendo este articulo que vi en MotoApp Motocicleta "+item.getMarca()+" \nPrecio: "+item.getPrecio();
                compartir.putExtra(android.content.Intent.EXTRA_SUBJECT, "MotoApp");
                compartir.putExtra(android.content.Intent.EXTRA_TEXT, mensaje);
                startActivity(Intent.createChooser(compartir, "Compartir vía"));
            }
        });
    }

    public void Megusta(){
        int uno = R.drawable.mc;
        int dos = R.drawable.mcbg;
        if(meg.getTag().equals("uno")){
            meg.setImageResource(dos);
            meg.setTag("dos");
            Toast.makeText(this,"Agregado a Favoritos",Toast.LENGTH_SHORT).show();
        }else if(meg.getTag().equals("dos")) {
            meg.setImageResource(uno);
            meg.setTag("uno");
            Toast.makeText(this,"Borrado de Favoritos",Toast.LENGTH_SHORT).show();
        }
    }
}