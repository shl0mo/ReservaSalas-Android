package com.example.reservasalas;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {
    public DB(@Nullable Context context) {
        super(context, "reserva_salas", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String tabela_usuarios = "CREATE TABLE IF NOT EXISTS usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, sobrenome TEXT, usuario TEXT, senha TEXT, tipo TEXT);";
        db.execSQL(tabela_usuarios);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String tabela_usuarios = "DROP TABLE IF EXISTS usuarios";
        db.execSQL(tabela_usuarios);
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
        db.insert("usuarios", null, valores);
        db.close();
    }
}
