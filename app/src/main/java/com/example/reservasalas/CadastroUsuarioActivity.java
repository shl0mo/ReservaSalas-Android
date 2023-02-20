package com.example.reservasalas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CadastroUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        RadioButton radio_professor = (RadioButton) findViewById(R.id.radio_professor);
        RadioButton radio_funcionario = (RadioButton) findViewById(R.id.radio_funcionario);

        radio_professor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((RadioButton) view).isChecked();
                switch(view.getId()) {
                    case R.id.radio_professor:
                        if (checked)
                            break;
                    case R.id.radio_funcionario:
                        if (checked)
                            break;
                }
            }
        });

        radio_funcionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((RadioButton) view).isChecked();
                switch(view.getId()) {
                    case R.id.radio_professor:
                        if (checked)
                            break;
                    case R.id.radio_funcionario:
                        if (checked)
                            break;
                }
            }
        });
    }

    public void voltarCadastro (View v) {
        Intent in = new Intent(CadastroUsuarioActivity.this, MenuAdminActivity.class);
        startActivity(in);
    }
}