package com.example.reservasalas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ExcluirUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excluir_usuario);
    }

    public void excluirUsuario (View v) {
        EditText editText_usuario = findViewById(R.id.usuarioExcluido);
        String usuario = editText_usuario.getText().toString();
        if (usuario.equals("")) {
            Toast.makeText(this, "Selecione um usuário para ser excluído", Toast.LENGTH_SHORT).show();
            return;
        }
        SQLiteDatabase db = Globais.db.getWritableDatabase();
        String query = "SELECT * FROM usuarios WHERE usuario = '" + usuario + "';";
        Cursor cursor = db.rawQuery(query, null);
        int ocorrencias = 0;
        while (cursor.moveToNext()) {
            ocorrencias++;
        }
        if (ocorrencias == 0) {
            Toast.makeText(this, "O usuário selecionado não existe", Toast.LENGTH_SHORT).show();
            return;
        }
        query = "DELETE FROM usuarios WHERE usuario = '" + usuario + "';";
        db.execSQL(query);
        Toast.makeText(this, "Usuário excluído com sucesso", Toast.LENGTH_SHORT).show();
    }

    public void voltar (View v) {
        Intent in = new Intent(ExcluirUsuarioActivity.this, MenuAdminActivity.class);
        startActivity(in);
    }
}