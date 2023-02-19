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
            Toast.makeText(this, "É necessário prreencher todos os campos de dados", Toast.LENGTH_SHORT).show();
            return;
        }
        if (usuario.equals("admin") && senha.equals("admin")) { // Redirecionamento para o menu do administrador
            View view_login = findViewById(R.id.viewLogin);
            Intent in = new Intent(MainActivity.this, MenuAdminActivity.class);
            startActivity(in);
            return;
        }
        this.db.adicionaUsuario("Paulo", "D'Arc", "johanna", "senhajoana", "Professor");
        String sql = "SELECT * FROM usuarios_3";
        Cursor cursor = this.db.getReadableDatabase().rawQuery(sql, null);
        String nome = "";
        while (cursor.moveToNext()) {
            nome = cursor.getString(1);
            System.out.println("NOME: " + nome);
        }
        Toast.makeText(this, "Usuário adicionado com sucesso. Banco de dados criado", Toast.LENGTH_SHORT).show();
    }
}