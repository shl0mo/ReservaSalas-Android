package com.example.reservasalas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
    DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.db = new DB(MainActivity.this);
    }

    public void botaoLogar (View v) throws SQLException {
        EditText editText_usuario = findViewById(R.id.usuario);
        String usuario = editText_usuario.getText().toString();
        EditText editText_senha = findViewById(R.id.senha);
        String senha = editText_senha.getText().toString();
        if (usuario.equals("")  || senha.equals("")) { // A inserção do usuário e da senha é obrigatória
            Toast.makeText(this, "É necessário preencher todos os campos de dados", Toast.LENGTH_SHORT).show();
            return;
        }
        if (usuario.equals("admin") && senha.equals("admin")) { // Redirecionamento para o menu do administrador
            Globais.id = "-1";
            Globais.usuario = "admin";
            Intent in = new Intent(MainActivity.this, MenuAdminActivity.class);
            startActivity(in);
            return;
        }
        String sql = "SELECT * FROM usuarios WHERE usuario = '" + usuario +"' AND senha = '" + senha + "';";
        Cursor cursor = getDB().getReadableDatabase().rawQuery(sql, null);
        int ocorrencias = 0;
        String id = "";
        while (cursor.moveToNext()) {
            ocorrencias++;
            cursor.getString(0);
        }
        if (ocorrencias == 0) {
            Toast.makeText(this, "Usuário ou senha inválidos", Toast.LENGTH_SHORT).show();
            return;
        }
        Globais.id = id;
        Globais.usuario = usuario;
        Intent in = new Intent(MainActivity.this, MenuUsuarioActivity.class);
        startActivity(in);
    }

    public DB getDB() {
        return this.db;
    }
}