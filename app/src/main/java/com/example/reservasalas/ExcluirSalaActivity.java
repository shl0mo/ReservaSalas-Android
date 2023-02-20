package com.example.reservasalas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ExcluirSalaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excluir_sala);
    }

    public void excluir (View v) {
        EditText editText_id = findViewById(R.id.idSalaExcluida);
        String id = editText_id.getText().toString();
        SQLiteDatabase db = Globais.db.getWritableDatabase();
        String query = "SELECT * FROM salas WHERE id = " + id;
        Cursor cursor = db.rawQuery(query, null);
        int ocorrencias = 0;
        while (cursor.moveToNext()) {
            ocorrencias++;
        }
        if (ocorrencias == 0) {
            Toast.makeText(this, "Não foi possível excluir. O Id selecionado não corresponde a nenhuma sala", Toast.LENGTH_SHORT).show();
            return;
        }
        query = "DELETE FROM salas WHERE id = " + id;
        db.execSQL(query);
        Toast.makeText(this, "Sala excluída com sucesso", Toast.LENGTH_SHORT).show();
    }

    public void cancelar (View v) {
        Intent in = new Intent(ExcluirSalaActivity.this, MenuAdminActivity.class);
        startActivity(in);
    }
}