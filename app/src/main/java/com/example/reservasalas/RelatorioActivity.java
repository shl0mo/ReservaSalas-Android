package com.example.reservasalas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class RelatorioActivity extends AppCompatActivity {
    TableLayout tabela;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);
        geraCabecalho();
    }

    public void gerar (View v) {
        this.tabela.removeAllViews();
        geraCabecalho();
        EditText editText_id = findViewById(R.id.idSalaRelatorio);
        String id_sala = editText_id.getText().toString();
        SQLiteDatabase db = Globais.db.getReadableDatabase();
        String query = "SELECT b.nome, b.sobrenome, a.data\r\n"
                + "FROM (SELECT * FROM reservas WHERE id_sala = " + id_sala + ") AS a\r\n"
                + "JOIN usuarios AS b\r\n"
                + "ON a.id_usuario = b.id";
        Cursor cursor = db.rawQuery(query, null);
        int ocorrencias = 0;
        while (cursor.moveToNext()) {
            TableRow linha = new TableRow(this);
            TextView nome = new TextView(this);
            TextView data = new TextView(this);
            nome.setText(cursor.getString(0) + " " + cursor.getString(1));
            nome.setPadding(40, 10, 40, 10);
            data.setText(cursor.getString(2));
            data.setPadding(40, 10, 40, 10);
            linha.addView(nome);
            linha.addView(data);
            this.tabela.addView(linha);
            ocorrencias++;
        }
        if (ocorrencias == 0) {
            Toast.makeText(this, "O Id informado não corresponde a nenhuma sala. Informe um Id válido", Toast.LENGTH_SHORT).show();
        }

    }

    public void geraCabecalho () {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int largura_tela = displayMetrics.widthPixels;
        this.tabela = findViewById(R.id.tabelaRelatorio);
        TableRow cabecalho = new TableRow(this);
        TextView nome = new TextView(this);
        TextView data = new TextView(this);
        nome.setText("Reservada por");
        nome.setPadding(40, 10, 40, 10);
        nome.setBackgroundColor(Color.LTGRAY);
        nome.setTextColor(Color.BLACK);
        nome.setMinWidth(largura_tela/2);
        data.setText("Data");
        data.setPadding(40, 10, 40, 10);
        data.setBackgroundColor(Color.LTGRAY);
        data.setTextColor(Color.BLACK);
        data.setMinWidth(largura_tela/2);
        cabecalho.addView(nome);
        cabecalho.addView(data);
        this.tabela.addView(cabecalho);
    }
}