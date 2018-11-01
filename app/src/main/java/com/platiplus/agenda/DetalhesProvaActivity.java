package com.platiplus.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.platiplus.agenda.Model.Prova;

import org.w3c.dom.Text;

public class DetalhesProvaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_prova);

        Intent intent = getIntent();
        Prova prova = (Prova) intent.getSerializableExtra("prova");

        TextView materia = findViewById(R.id.detalhes_prova_materia);
        TextView data = findViewById(R.id.detalhes_prova_data);
        ListView topicos = findViewById(R.id.detalhes_prova_topico);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, prova.getTopicos());

        materia.setText(prova.getMateria());
        data.setText(prova.getData());
        topicos.setAdapter(adapter);

    }
}
