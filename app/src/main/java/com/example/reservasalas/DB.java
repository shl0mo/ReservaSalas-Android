package com.example.reservasalas;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {
    public DB(@Nullable Context context) {
        super(context, "reserva_salas", null, 1);
        System.out.println("DATABASE CRIADA");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String tabela_usuarios_3 = "CREATE TABLE IF NOT EXISTS usuarios_3 (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, sobrenome TEXT, usuario TEXT, senha TEXT, tipo TEXT);";
        db.execSQL(tabela_usuarios_3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String tabela_usuarios_3 = "DROP TABLE IF EXISTS usuarios_3";
        db.execSQL(tabela_usuarios_3);
        onCreate(db);
    }

    public void adicionaUsuario (String nome, String sobrenome, String usuario, String senha, String tipo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nome", nome);
        valores.put("sobrenome", sobrenome);
        valores.put("usuario", usuario);
        valores.put("senha", senha);
        valores.put("tipo", tipo);
        db.insert("usuarios_3", null, valores);
        db.close();
    }
}
