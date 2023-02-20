package com.example.reservasalas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ReservaSalaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_sala);
    }

    public void reservar (View v) {
        EditText editText_numero = findViewById(R.id.numeroReservaSala);
        EditText editText_bloco = findViewById(R.id.blocoReservaSala);
        EditText editText_andar = findViewById(R.id.andarReservaSala);
        RadioButton radioButton_sala_reuniao = findViewById(R.id.radioReservaSalaReuniao);
        RadioButton radioButton_auditorio = findViewById(R.id.radioReservaAuditorio);
        RadioButton radioButton_lab_graduacao = findViewById(R.id.radioLaboratorioGraduacao);
        String numero = editText_numero.getText().toString();
        String bloco = editText_bloco.getText().toString();
        String andar = editText_andar.getText().toString();
        String tipo = "";
        if (radioButton_sala_reuniao.isChecked()) tipo = "Sala de Reunião";
        else if (radioButton_auditorio.isChecked()) tipo = "Auditório";
        else if (radioButton_lab_graduacao.isChecked()) tipo = "Laboratório de Graduação";
        EditText editText_data = findViewById(R.id.dataReservaSala);
        String data = editText_data.getText().toString();
        SQLiteDatabase db = Globais.db.getWritableDatabase();
        String query = "SELECT * FROM salas WHERE numero = \"" + numero + "\" AND bloco = \"" + bloco + "\" AND andar = \"" + andar + "\" AND tipo = \"" + tipo + "\";";
        Cursor cursor = db.rawQuery(query, null);
        int ocorrencias = 0;
        while (cursor.moveToNext()) {
            ocorrencias++;
        }
        if (ocorrencias == 0) {
            Toast.makeText(this, "A sala solicitada não está cadastrada no banco de dados", Toast.LENGTH_SHORT).show();
            return;
        }
        query = "SELECT * FROM reservas WHERE ";

    }

    public void cancelar (View v) {

    }
}
