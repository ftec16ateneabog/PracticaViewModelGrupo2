package com.atenea.practicaviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.atenea.practicaviewmodel.Models.Usuario;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        EditText nombreTextView;
        EditText apellidoTextView;
        EditText passwordTextView;
        Button sumaButton;
        nombreTextView = findViewById(R.id.NombreTextViewPersistente);
        apellidoTextView = findViewById(R.id.ApellidoTextViewPersistente);
        passwordTextView = findViewById(R.id.ContrasenaTextViewPersistente);
        sumaButton = findViewById(R.id.registrarButton);

        sumaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario = new Usuario(nombreTextView.getText().toString(),apellidoTextView.getText().toString(),passwordTextView.getText().toString());
                viewModel.registrar(usuario);

                Intent intent = new Intent(MainActivity.this,ResumenUser.class);
                //intent.putExtra("ViewModel",viewModel);
                intent.putExtra("Usuario",usuario);
                startActivity(intent);
            }
        });

        Observer<Usuario> observer = new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario result) {
                nombreTextView.setText(result.getNombre().toString());
                apellidoTextView.setText(result.getApellido().toString());
                passwordTextView.setText(result.getPassword().toString());
            }
        };

        viewModel.getResultado().observe(this,observer);

    }
}