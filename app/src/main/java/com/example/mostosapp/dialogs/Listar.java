package com.example.mostosapp.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.mostosapp.R;

public class Listar {

    public interface Respuesta {
        void resultado(Boolean ver);
    }
    private Respuesta Finalizar;
    public Listar(final Context context, Respuesta accion) {
        final Dialog Objdialogo = new Dialog(context);
        Finalizar = accion;
        Objdialogo.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objdialogo.setCancelable(false);
        Objdialogo.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Objdialogo.setContentView(R.layout.confirmacion);
        Button view = (Button) Objdialogo.findViewById(R.id.view);
        Button add = (Button) Objdialogo.findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Objdialogo.dismiss();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean ver = true;
                Finalizar.resultado(ver);
                Objdialogo.dismiss();
            }
        });

        Objdialogo.show();
    }

}
