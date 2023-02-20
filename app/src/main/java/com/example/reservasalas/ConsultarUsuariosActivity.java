package com.example.reservasalas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
        id_cabecalho.setPadding(40, 10, 40, 10);
        id_cabecalho.setBackgroundColor(Color.LTGRAY);
        id_cabecalho.setTextColor(Color.BLACK);
        nome_cabecalho.setText("Nome");
        nome_cabecalho.setPadding(40, 10, 40, 10);
        nome_cabecalho.setBackgroundColor(Color.LTGRAY);
        nome_cabecalho.setTextColor(Color.BLACK);
        sobrenome_cabecalho.setText("Sobrenome");
        sobrenome_cabecalho.setPadding(40, 10, 40, 10);
        sobrenome_cabecalho.setBackgroundColor(Color.LTGRAY);
        sobrenome_cabecalho.setTextColor(Color.BLACK);
        usuario_cabecalho.setText("Usuário");
        usuario_cabecalho.setPadding(40, 10, 40, 10);
        usuario_cabecalho.setBackgroundColor(Color.LTGRAY);
        usuario_cabecalho.setTextColor(Color.BLACK);
        tipo_cabecalho.setText("Tipo");
        tipo_cabecalho.setPadding(40, 10, 40, 10);
        tipo_cabecalho.setBackgroundColor(Color.LTGRAY);
        tipo_cabecalho.setTextColor(Color.BLACK);
        cabecalho.addView(id_cabecalho);
        cabecalho.addView(nome_cabecalho);
        cabecalho.addView(sobrenome_cabecalho);
        cabecalho.addView(usuario_cabecalho);
        cabecalho.addView(tipo_cabecalho);
        tabela.addView(cabecalho);

        SQLiteDatabase db = Globais.db.getReadableDatabase();
        String query = "SELECT * FROM usuarios;";
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            TableRow linha = new TableRow(this);
            TextView id_linha = new TextView(this);
            TextView nome_linha = new TextView(this);
            TextView sobrenome_linha = new TextView(this);
            TextView usuario_linha = new TextView(this);
            TextView tipo_linha = new TextView(this);
            id_linha.setText(cursor.getString(0));
            id_linha.setPadding(40, 10, 40, 10);
            nome_linha.setText(cursor.getString(1));
            nome_linha.setPadding(40, 10, 40, 10);
            sobrenome_linha.setText(cursor.getString(2));
            sobrenome_linha.setPadding(40, 10, 40, 10);
            usuario_linha.setText(cursor.getString(3));
            usuario_linha.setPadding(40, 10, 40, 10);
            tipo_linha.setText(cursor.getString(5));
            tipo_linha.setPadding(40, 10, 40, 10);
            linha.addView(id_linha);
            linha.addView(nome_linha);
            linha.addView(sobrenome_linha);
            linha.addView(usuario_linha);
            linha.addView(tipo_linha);
            tabela.addView(linha);
        }

    }
}