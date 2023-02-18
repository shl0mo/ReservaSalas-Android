package com.example.reservasalas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void botaoLogar (View v) {
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
        Toast.makeText(this, "Procurando pelo usuário", Toast.LENGTH_SHORT).show();
    }
}