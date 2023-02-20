package com.example.reservasalas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class CadastroSalaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_sala);

        RadioButton radio_sala_reuniao = (RadioButton) findViewById(R.id.radioSalaReuniao);
        RadioButton radio_auditorio = (RadioButton) findViewById(R.id.radioAuditorio);
        RadioButton radio_lab_grad = (RadioButton) findViewById(R.id.radioLaboratorioGraduacao);

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

    public void cadastrar (View v) {
        EditText editText_numero = findViewById(R.id.numeroSala);
        EditText editText_bloco = findViewById(R.id.blocoSala);
        EditText editText_andar = findViewById(R.id.andarSala);
        String numero = editText_numero.getText().toString();
        String bloco = editText_bloco.getText().toString();
        String andar = editText_andar.getText().toString();
        String tipo = "";
        RadioButton radioButton_sala_reuniao = findViewById(R.id.radioSalaReuniao);
        RadioButton radioButton_auditorio = findViewById(R.id.radioAuditorio);
        RadioButton radioButton_lab_grad = findViewById(R.id.radioLaboratorioGraduacao);
        if (radioButton_sala_reuniao.isChecked()) tipo = "Sala de Reunião";
        else if (radioButton_auditorio.isChecked()) tipo = "Auditório";
        else if (radioButton_lab_grad.isChecked()) tipo = "Laboratório de Graduação";
        if (numero.equals("") || bloco.equals("") || andar.equals("") || tipo.equals("")) {
            Toast.makeText(this, "É necessário preencher todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }
        SQLiteDatabase db = Globais.db.getReadableDatabase();
        String query = "SELECT * FROM salas WHERE numero = \"" + numero + "\" AND bloco = \"" + bloco + "\" AND andar = \"" + andar + "\" AND tipo = \"" + tipo + "\";";
        Cursor cursor = db.rawQuery(query, null);
        int ocorrencias = 0;
        while (cursor.moveToNext()) {
            ocorrencias++;
        }
        if (ocorrencias > 0) {
            Toast.makeText(this, "Falha ao cadastrar. Sala já cadastrada", Toast.LENGTH_SHORT).show();
            return;
        }
        Globais.db.cadastraSala(numero, bloco, andar, tipo);
        Toast.makeText(this, "Sala cadastrada com sucesso", Toast.LENGTH_SHORT).show();
    }

    public void cancelar (View v) {
        Intent in = new Intent(CadastroSalaActivity.this, MenuAdminActivity.class);
        startActivity(in);
    }
}