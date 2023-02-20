package com.example.reservasalas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);
    }

    public void cadastrarUsuario (View v) {
        Intent in = new Intent(MenuAdminActivity.this, CadastroUsuarioActivity.class);
        startActivity(in);
    }

    public void consultarUsuario (View v) {

    }

    public void alterarUsuario (View v) {
        Intent in = new Intent(MenuAdminActivity.this, SelecionarUsuarioAlterado.class);
        startActivity(in);
    }

    public void excluirUsuario (View v) {
        Intent in = new Intent(MenuAdminActivity.this, ExcluirUsuarioActivity.class);
        startActivity(in);
    }

    public void sairMenuAdmin (View v) {
        Globais.id = "";
        Globais.usuario = "";
        Intent in = new Intent(MenuAdminActivity.this, MainActivity.class);
        startActivity(in);
    }
}