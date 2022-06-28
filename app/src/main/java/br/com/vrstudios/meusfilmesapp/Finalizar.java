package br.com.vrstudios.meusfilmesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Finalizar extends AppCompatActivity {

    Button buttonCompartilharCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalizar);

        buttonCompartilharCompra = findViewById(R.id.buttonCompartilharCompra);

        buttonCompartilharCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compartilharCompra();
            }
        });
    }

    public void voltar(View view) {
        finish();
    }

    public void compartilharCompra() {
        // Criar um objeto do tipo Intent
        Intent compartilhar = new Intent();

        // Ação a ser realizada
        compartilhar.setAction(Intent.ACTION_SEND);

        // Extras
        compartilhar.putExtra(Intent.EXTRA_TEXT, "Venha assistir o filme \"E o vento levou\"!");

        // Definir o tipo do dado (Mime Type)
        compartilhar.setType("text/plain");

        // Criar um seletor (Intents implicitas)
        Intent seletor = Intent.createChooser(compartilhar, "Selecione o app para compartilhar esta mensagem.");

        // Inicializar
        if (compartilhar.resolveActivity(getPackageManager()) != null) {
            startActivity(seletor);
        }

        /*
        // Definir quem pode compartilhar  - Intent Explicita
        compartilhar.setPackage("com.whatsapp");

        // Inicializar a intent
        try {
            startActivity(compartilhar);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        */
    }
}