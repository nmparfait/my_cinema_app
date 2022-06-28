package br.com.vrstudios.meusfilmesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.vrstudios.meusfilmesapp.model.Filme;

public class MainActivity extends AppCompatActivity {

    Button buttonComprar;
    Button buttonAlugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Primeiro método executado logo quando o aplicativo é inicializado
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "OnCreate - Main", Toast.LENGTH_SHORT).show();

        buttonComprar = findViewById(R.id.buttonComprar);
        buttonAlugar = findViewById(R.id.buttonAlugar);

        // "Escutar" o click do botão comprar
        buttonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActivityComprar(true);
            }
        });

        // "Escutar" o click do botão alugar
        buttonAlugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActivityComprar(false);
            }
        });
    }

    @Override
    protected void onStart() { // Executado quando a activity está ativa para o usuário porém ainda não permite interação
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart - Main", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() { // É executado quando a tela já é interativa
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume - Main", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() { // É executado quando a tela fica visível mas não interativa (ex.: ao abrir um popup)
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause - Main", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() { // É executado quando a activity entra em standby
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop - Main", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() { // É executado quando o aplicativo ou a activity é fechado
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy - Main", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart - Main", Toast.LENGTH_SHORT).show();
    }

    public void abrirActivityComprar(Boolean isLifetime) {
        // Intent: tenta acionar um recurso dentro ou fora do aplicativo (Ex.: Activity, que é um recurso interno dentro do aplicativo)
        Intent intent = new Intent(getApplicationContext(), Comprar.class);

        Filme filme = new Filme("E o vento levou", 9.90f, isLifetime);
        intent.putExtra("compraObj", filme); // Eniar dados (objeto) para outra Activity

        startActivity(intent);
    }
}