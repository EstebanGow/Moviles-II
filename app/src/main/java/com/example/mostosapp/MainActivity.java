package com.example.mostosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;
import com.example.mostosapp.adapter.NoConection;

public class MainActivity extends AppCompatActivity {
    public String usuario, score;
    NoConection dialog;
    LottieAnimationView bar, libro;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Handler handler = new Handler();
        dialog = new NoConection(this);
        bar = (LottieAnimationView) findViewById(R.id.bar);
        libro = (LottieAnimationView) findViewById(R.id.libro);
        libro.setSpeed(1);
        bar.setSpeed(4);
        context = this;
        if(Conexion(this)){
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                  siguiente();
                }
            },2000);
        }else{
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    dialog.StartLoading();
                }
            },2000);

        }
    }

    public void siguiente(){
        Intent sig = new Intent(this,Home.class);
        startActivity(sig);
        finish();
    }

    public static boolean Conexion(Context context)
    {
        boolean connected = false;
        ConnectivityManager connec = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        // Recupera todas las redes (tanto móviles como wifi)
        NetworkInfo[] redes = connec.getAllNetworkInfo();

        for (int i = 0; i < redes.length; i++) {
            // Si alguna red tiene conexión, se devuelve true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                connected = true;
            }
        }
        return connected;
    }
}