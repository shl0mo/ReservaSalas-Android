package com.example.reservasalas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuario);
    }

    public void reservarSala (View v) {
        Intent in = new Intent(MenuUsuarioActivity.this, ReservaSalaActivity.class);
        startActivity(in);
    }

    public void consultarSalas (View v) {
        Intent in = new Intent(MenuUsuarioActivity.this, ConsultarSalasActivity.class);
        startActivity(in);
    }

    public void sair (View v) {
        Globais.id = "";
        Globais.usuario = "";
        Intent in = new Intent(MenuUsuarioActivity.this, MainActivity.class);
        startActivity(in);
    }
}