package com.example.reservasalas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MenuAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);
    }

    public void cadastrarUsuario () {
        Intent in = new Intent(MenuAdminActivity.this, CadastroUsuarioActivity.class);
        startActivity(in);
    }
}