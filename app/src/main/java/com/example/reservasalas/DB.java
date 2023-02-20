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
        String tabela_salas = "CREATE TABLE IF NOT EXISTS salas (id INTEGER PRIMARY KEY AUTOINCREMENT, numero TEXT, bloco TEXT, andar TEXT, tipo TEXT, reservada INTEGER);";
        db.execSQL(tabela_usuarios);
        db.execSQL(tabela_salas);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String tabela_usuarios = "DROP TABLE IF EXISTS usuarios";
        String tabela_salas = "DROP TABLE IF EXISTS salas";
        db.execSQL(tabela_usuarios);
        db.execSQL(tabela_salas);
        onCreate(db);
    }

    public void cadastraUsuario (String nome, String sobrenome, String usuario, String senha, String tipo) {
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

    public void cadastraSala (String numero, String bloco, String andar, String tipo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("numero", numero);
        valores.put("bloco", bloco);
        valores.put("andar", andar);
        valores.put("tipo", tipo);
        valores.put("reservada", 0);
        db.insert("salas", null, valores);
        db.close();
    }
}
