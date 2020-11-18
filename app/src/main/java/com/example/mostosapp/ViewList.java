package com.example.mostosapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mostosapp.adapter.ViewAdapter;
import com.example.mostosapp.models.MotoModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.Serializable;
import java.util.ArrayList;

public class ViewList extends AppCompatActivity {
    protected FirebaseFirestore db;
    private String TAG = "LFNOT";
    final private String collection = "motorcycle";
    private ArrayList list;
    private ViewAdapter adapter;
    private MotoModel model;
    private ListView listar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);
        db = FirebaseFirestore.getInstance();
        listar = (ListView)findViewById(R.id.listar);

        list = new ArrayList<>();

        db.collection(collection)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                model = document.toObject(MotoModel.class);
                                list.add(model);
                            }
                            adapter = new ViewAdapter(getApplicationContext(), list);
                            listar.setAdapter(adapter);
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
        listar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(), String.valueOf(list.get(i).toString()), Toast.LENGTH_LONG).show();
                Intent sig = new Intent(getApplicationContext(),FullMoto.class);
                sig.putExtra("data", (Serializable) list.get(i));
                startActivity(sig);
            }
        });

    }
}