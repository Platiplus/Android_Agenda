package com.platiplus.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.FloatProperty;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.ref.SoftReference;
import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        String[] listaDeAlunos = {
                "Stuart",
                "Garrison",
                "Christian",
                "Fulton",
                "Philip",
                "Stewart",
                "Xander",
                "Chase",
                "Jerry",
                "Shad"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaDeAlunos);

        ListView listaAlunos = findViewById(R.id.lista_alunos);
        listaAlunos.setAdapter(adapter);

        Button botaoNovoAluno = findViewById(R.id.lista_button);

        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbrirFormulario = new Intent(ListaAlunosActivity.this, FormularioActivity.class);
                startActivity(intentAbrirFormulario);
            }
        });
    }
}
