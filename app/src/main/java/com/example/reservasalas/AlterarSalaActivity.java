package com.example.reservasalas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class AlterarSalaActivity extends AppCompatActivity {
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_sala);

        Intent in = getIntent();
        this.id = in.getStringExtra("Id");

        RadioButton radio_sala_reuniao = (RadioButton) findViewById(R.id.radioAlterarSalaReuniao);
        RadioButton radio_auditorio = (RadioButton) findViewById(R.id.radioAlterarAuditorio);
        RadioButton radio_lab_grad = (RadioButton) findViewById(R.id.radioAlterarLaboratorioGraduacao);

        radio_sala_reuniao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((RadioButton) view).isChecked();
                switch(view.getId()) {
                    case R.id.radio_professor:
                        if (checked)
                            break;
                    case R.id.radio_funcionario:
                        if (checked)
                            break;
                }
            }
        });

        radio_auditorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((RadioButton) view).isChecked();
                switch(view.getId()) {
                    case R.id.radio_professor:
                        if (checked)
                            break;
                    case R.id.radio_funcionario:
                        if (checked)
                            break;
                }
            }
        });

        radio_lab_grad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((RadioButton) view).isChecked();
                switch(view.getId()) {
                    case R.id.radio_professor:
                        if (checked)
                            break;
                    case R.id.radio_funcionario:
                        if (checked)
                            break;
                }
            }
        });
    }

    public void onStart () {
        super.onStart();
        String numero = "";
        String bloco = "";
        String andar = "";
        String tipo = "";
        SQLiteDatabase db = Globais.db.getReadableDatabase();
        String query = "SELECT * FROM salas WHERE id = " + this.id;
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            numero = cursor.getString(1);
            bloco = cursor.getString(2);
            andar = cursor.getString(3);
            tipo = cursor.getString(4);
        }
        EditText editText_numero = findViewById(R.id.numeroAlterarSala);
        EditText editText_bloco = findViewById(R.id.blocoAlterarSala);
        EditText editText_andar = findViewById(R.id.andarAlterarSala);
        editText_numero.setText(numero);
        editText_bloco.setText(bloco);
        editText_andar.setText(andar);
        RadioButton radioButton_sala_reuniao = findViewById(R.id.radioAlterarSalaReuniao);
        RadioButton radioButton_auditorio = findViewById(R.id.radioAlterarAuditorio);
        RadioButton radioButton_lab_grad = findViewById(R.id.radioAlterarLaboratorioGraduacao);
        if (tipo.equals("Sala de Reunião")) radioButton_sala_reuniao.setChecked(true);
        else if (tipo.equals("Auditório")) radioButton_auditorio.setChecked(true);
        else if (tipo.equals("Laboratório de Graduação")) radioButton_lab_grad.setChecked(true);
    }

    public void  alterar (View v) {
        EditText editText_numero = findViewById(R.id.numeroAlterarSala);
        EditText editText_bloco = findViewById(R.id.blocoAlterarSala);
        EditText editText_andar = findViewById(R.id.andarAlterarSala);
        RadioButton radioButton_sala_reuniao = findViewById(R.id.radioAlterarSalaReuniao);
        RadioButton radioButton_auditorio = findViewById(R.id.radioAlterarAuditorio);
        RadioButton radioButton_lab_grad = findViewById(R.id.radioAlterarLaboratorioGraduacao);
        String numero = editText_numero.getText().toString();
        String bloco = editText_bloco.getText().toString();
        String andar = editText_andar.getText().toString();
        String tipo = "";
        if (radioButton_sala_reuniao.isChecked()) tipo = "Sala de Reunião";
        else if (radioButton_auditorio.isChecked()) tipo = "Auditório";
        else if (radioButton_lab_grad.isChecked()) tipo = "Laboratório de Graduação";
        if (numero.equals("") || bloco.equals("") || andar.equals("") || tipo.equals("")) {
            Toast.makeText(this, "É necessário preencher todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }
        SQLiteDatabase db = Globais.db.getWritableDatabase();
        String query = "UPDATE salas SET numero = \"" + numero + "\", bloco = \"" + bloco + "\", andar = \"" + andar + "\", tipo = \"" + tipo + "\" WHERE id = " + this.id;
        db.execSQL(query);
        Toast.makeText(this, "Usuário atualizado com sucesso", Toast.LENGTH_SHORT).show();
    }

    public void cancelar (View v) {
        Intent in = new Intent(AlterarSalaActivity.this, SelecionarSalaAlteradaActivity.class);
        startActivity(in);
    }
}