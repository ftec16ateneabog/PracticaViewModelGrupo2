package com.atenea.practicaviewmodel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.atenea.practicaviewmodel.Models.Usuario;

public class ResumenUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_user);

        //MyViewModel viewModel  = (MyViewModel) getIntent().getSerializableExtra("ViewModel");
        Usuario usuario  = (Usuario) getIntent().getSerializableExtra("Usuario");

        EditText nombreTextView;
        EditText apellidoTextView;
        EditText passwordTextView;
        nombreTextView = findViewById(R.id.NombreTextViewResumen);
        apellidoTextView = findViewById(R.id.ApellidoTextViewResumen);
        passwordTextView = findViewById(R.id.ContrasenaTextViewResumen);

        nombreTextView.setText(usuario.getNombre().toString());
        apellidoTextView.setText(usuario.getApellido().toString());
        passwordTextView.setText(usuario.getPassword().toString());
    }
}