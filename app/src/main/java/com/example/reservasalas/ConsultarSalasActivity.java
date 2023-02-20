package com.example.reservasalas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ConsultarSalasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_salas);
        adicionaLinhas();
    }

    public void adicionaLinhas () {
        TableLayout tabela = findViewById(R.id.tabelaSalas);
        TableRow cabecalho = new TableRow(this);
        TextView id_cabecalho = new TextView(this);
        TextView numero_cabecalho = new TextView(this);
        TextView bloco_cabecalho = new TextView(this);
        TextView andar_cabecalho = new TextView(this);
        TextView tipo_cabecalho = new TextView(this);
        id_cabecalho.setText("Id");
        id_cabecalho.setPadding(40, 10, 40, 10);
        id_cabecalho.setBackgroundColor(Color.LTGRAY);
        id_cabecalho.setTextColor(Color.BLACK);
        numero_cabecalho.setText("Número");
        numero_cabecalho.setPadding(40, 10, 40, 10);
        numero_cabecalho.setBackgroundColor(Color.LTGRAY);
        numero_cabecalho.setTextColor(Color.BLACK);
        bloco_cabecalho.setText("Bloco");
        bloco_cabecalho.setPadding(40, 10, 40, 10);
        bloco_cabecalho.setBackgroundColor(Color.LTGRAY);
        bloco_cabecalho.setTextColor(Color.BLACK);
        andar_cabecalho.setText("Andar");
        andar_cabecalho.setPadding(40, 10, 40, 10);
        andar_cabecalho.setBackgroundColor(Color.LTGRAY);
        andar_cabecalho.setTextColor(Color.BLACK);
        tipo_cabecalho.setText("Tipo");
        tipo_cabecalho.setPadding(40, 10, 40, 10);
        tipo_cabecalho.setBackgroundColor(Color.LTGRAY);
        tipo_cabecalho.setTextColor(Color.BLACK);
        tipo_cabecalho.setMinWidth(800);
        cabecalho.addView(id_cabecalho);
        cabecalho.addView(numero_cabecalho);
        cabecalho.addView(bloco_cabecalho);
        cabecalho.addView(andar_cabecalho);
        cabecalho.addView(tipo_cabecalho);
        tabela.addView(cabecalho);

        SQLiteDatabase db = Globais.db.getReadableDatabase();
        String query = "SELECT * FROM salas;";
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            TableRow linha = new TableRow(this);
            TextView id_linha = new TextView(this);
            TextView numero_linha = new TextView(this);
            TextView bloco_linha = new TextView(this);
            TextView andar_linha = new TextView(this);
            TextView tipo_linha = new TextView(this);
            id_linha.setText(cursor.getString(0));
            id_linha.setPadding(40, 10, 40, 10);
            numero_linha.setText(cursor.getString(1));
            numero_linha.setPadding(40, 10, 40, 10);
            bloco_linha.setText(cursor.getString(2));
            bloco_linha.setPadding(40, 10, 40, 10);
            andar_linha.setText(cursor.getString(3));
            andar_linha.setPadding(40, 10, 40, 10);
            tipo_linha.setText(cursor.getString(4));
            tipo_linha.setPadding(40, 10, 40, 10);
            tipo_linha.setMinWidth(800);
            linha.addView(id_linha);
            linha.addView(numero_linha);
            linha.addView(bloco_linha);
            linha.addView(andar_linha);
            linha.addView(tipo_linha);
            tabela.addView(linha);
        }
    }
}