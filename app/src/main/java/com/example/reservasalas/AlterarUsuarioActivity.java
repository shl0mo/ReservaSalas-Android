package com.example.reservasalas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class AlterarUsuarioActivity extends AppCompatActivity {
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_usuario);

        Intent in = getIntent();
        this.id = in.getStringExtra("Id");

        SQLiteDatabase db = Globais.db.getReadableDatabase();
        String consulta = "SELECT * FROM usuarios WHERE id = " + this.id;
        Cursor cursor = db.rawQuery(consulta, null);
        String nome = "";
        String sobrenome = "";
        String usuario = "";
        String senha = "";
        String tipo = "";
        while (cursor.moveToNext()) {
            nome = cursor.getString(1);
            sobrenome = cursor.getString(2);
            usuario = cursor.getString(3);
            senha = cursor.getString(4);
            tipo = cursor.getString(5);
        }
        EditText editText_nome = findViewById(R.id.nomeAlterarUsuario);
        EditText editText_sobrenome = findViewById(R.id.sobrenomeAlterarUsuario);
        EditText editText_usuario = findViewById(R.id.usuarioAlterarUsuario);
        EditText editText_senha = findViewById(R.id.senhaAlterarUsuario);
        RadioButton radioButton_professor = findViewById(R.id.radioProfessorAlterarUsuario);
        RadioButton radioButton_funcionario = findViewById(R.id.radioFuncionarioAlterarUsuario);
        editText_nome.setText(nome);
        editText_sobrenome.setText(sobrenome);
        editText_usuario.setText(usuario);
        editText_senha.setText(senha);
        if (tipo.equals("Professor")) radioButton_professor.setChecked(true);
        else if(tipo.equals("Funcionário")) radioButton_funcionario.setChecked(true);
    }

    public void alterarUsuario (View v) {
        String nome = "";
        String sobrenome = "";
        String usuario = "";
        String senha = "";
        String tipo = "";
        EditText editText_nome = findViewById(R.id.nomeAlterarUsuario);
        EditText editText_sobrenome = findViewById(R.id.sobrenomeAlterarUsuario);
        EditText editText_usuario = findViewById(R.id.usuarioAlterarUsuario);
        EditText editText_senha = findViewById(R.id.senhaAlterarUsuario);
        RadioButton radioButton_professor = findViewById(R.id.radioProfessorAlterarUsuario);
        RadioButton radioButton_funcionario = findViewById(R.id.radioFuncionarioAlterarUsuario);
        nome = editText_nome.getText().toString();
        sobrenome = editText_sobrenome.getText().toString();
        usuario = editText_usuario.getText().toString();
        senha = editText_senha.getText().toString();
        if (radioButton_professor.isChecked()) tipo = "Professor";
        else if (radioButton_funcionario.isChecked()) tipo = "Funcionário";
        if (nome.equals("") || sobrenome.equals("") || usuario.equals("") || senha.equals("") || (!radioButton_professor.isChecked() && !radioButton_funcionario.isChecked())) {
            Toast.makeText(this, "É necessário preencher todos os campos de dados", Toast.LENGTH_SHORT).show();
            return;
        }
        SQLiteDatabase db = Globais.db.getWritableDatabase();
        String query = "UPDATE usuarios SET nome = \"" + nome + "\", sobrenome = \"" + sobrenome + "\", usuario = \""+ usuario +"\", senha = \"" + senha + "\", tipo = \"" + tipo + "\" WHERE id = " + this.id;
        db.execSQL(query);
        Toast.makeText(this, "Usuário alterado com sucesso", Toast.LENGTH_SHORT).show();
    }

    public void cancelar (View v) {
        Intent in = new Intent(AlterarUsuarioActivity.this, SelecionarUsuarioAlteradoActivity.class);
        startActivity(in);
    }
}