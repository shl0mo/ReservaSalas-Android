package com.example.reservasalas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SelecionarSalaAlteradaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_sala_alterada);
    }

    public void selecionarId (View v) {
        EditText editText_id = findViewById(R.id.idSelecionarSalaAlterada);
        String id = editText_id.getText().toString();
        if (id.equals("")) {
            Toast.makeText(this, "Selecione o Id", Toast.LENGTH_SHORT).show();
            return;
        }
        SQLiteDatabase db = Globais.db.getReadableDatabase();
        String consulta = "SELECT * FROM salas WHERE id = " + id;
        Cursor cursor = db.rawQuery(consulta, null);
        int ocorrencias = 0;
        while (cursor.moveToNext()) {
            ocorrencias++;
        }
        if (ocorrencias == 0) {
            Toast.makeText(this, "O Id selecionado não corresponde a nenhuma sala", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent in = new Intent(SelecionarSalaAlteradaActivity.this, AlterarSalaActivity.class);
        in.putExtra("Id", id);
        startActivity(in);
    }

    public void cancelar (View v) {
        Intent in = new Intent(SelecionarSalaAlteradaActivity.this, MenuAdminActivity.class);
        startActivity(in);
    }
}