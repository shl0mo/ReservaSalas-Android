package com.example.reservasalas;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class ConsultarUsuariosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuarios);
    }

    public void onStart () {
        super.onStart();
        adicionaLinha();
    }

    public void adicionaLinha () {
        TableLayout tabela = findViewById(R.id.tabelaUsuarios);
        TableRow cabecalho = new TableRow(this);

        TextView id_cabecalho = new TextView(this);
        TextView nome_cabecalho = new TextView(this);
        TextView sobrenome_cabecalho = new TextView(this);
        TextView usuario_cabecalho = new TextView(this);
        TextView tipo_cabecalho = new TextView(this);
        id_cabecalho.setText("Id");
        id_cabecalho.setTextColor(Color.BLACK);
        nome_cabecalho.setText("Nome");
        nome_cabecalho.setTextColor(Color.BLACK);
        sobrenome_cabecalho.setText("Sobrenome");
        sobrenome_cabecalho.setTextColor(Color.BLACK);
        usuario_cabecalho.setText("Usuário");
        usuario_cabecalho.setTextColor(Color.BLACK);
        tipo_cabecalho.setText("Tipo");
        tipo_cabecalho.setTextColor(Color.BLACK);
        cabecalho.addView(id_cabecalho);
        cabecalho.addView(nome_cabecalho);
        cabecalho.addView(sobrenome_cabecalho);
        cabecalho.addView(usuario_cabecalho);
        cabecalho.addView(tipo_cabecalho);

        tabela.addView(cabecalho);

    }
}