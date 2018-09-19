package com.platiplus.agenda;

import android.widget.EditText;
import android.widget.RatingBar;

import com.platiplus.agenda.Model.Aluno;

public class FormularioHelper  {

    private EditText campoNome;
    private EditText campoEndereco;
    private EditText campoTelefone;
    private EditText campoSite;
    private RatingBar campoNota;

    public FormularioHelper(FormularioActivity activity)  {
        campoNome = activity.findViewById(R.id.formulario_name);
        campoEndereco = activity.findViewById(R.id.formulario_address);
        campoTelefone = activity.findViewById(R.id.formulario_tel);
        campoSite = activity.findViewById(R.id.formulario_site);
        campoNota = activity.findViewById(R.id.formulario_nota);
    }

    public Aluno getAluno() {
        Aluno aluno = new Aluno ();

        aluno.setNome(campoNome.getText().toString());
        aluno.setEndereco(campoEndereco.getText().toString());
        aluno.setTelefone(campoTelefone.getText().toString());
        aluno.setSite(campoSite.getText().toString());
        aluno.setNota(Double.valueOf(campoNota.getProgress()));

        return aluno;
    }
}