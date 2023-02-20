package com.example.reservasalas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

    public void cadastrar (View v) {
        EditText editText_nome = findViewById(R.id.nomeCadastro);
        EditText editText_sobrenome = findViewById(R.id.sobrenomeCadastro);
        EditText editText_usuario = findViewById(R.id.usuarioCadastro);
        EditText editText_senha = findViewById(R.id.senhaCadastro);
        RadioButton radioButton_professor = findViewById(R.id.radio_professor);
        RadioButton radioButton_funcionario = findViewById(R.id.radio_funcionario);
        String nome = editText_nome.getText().toString();
        String sobrenome = editText_sobrenome.getText().toString();
        String usuario = editText_usuario.getText().toString();
        String senha = editText_senha.getText().toString();
        if (nome.equals("") || sobrenome.equals("") || usuario.equals("") || senha.equals("") || (!radioButton_professor.isChecked() && !radioButton_funcionario.isChecked())) {
            Toast.makeText(this, "É necessário preencher todos os campos de dados", Toast.LENGTH_SHORT).show();
            return;
        }
        String tipo = "";
        if (radioButton_professor.isChecked()) tipo = "Professor";
        else if (radioButton_funcionario.isChecked()) tipo = "Funcionário";
        Globais.db.adicionaUsuario(nome, sobrenome, usuario, senha, tipo);
        Toast.makeText(this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
    }

    public void voltarCadastro (View v) {
        Intent in = new Intent(CadastroUsuarioActivity.this, MenuAdminActivity.class);
        startActivity(in);
    }
}