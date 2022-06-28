package br.com.vrstudios.meusfilmesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.com.vrstudios.meusfilmesapp.model.Filme;

public class Comprar extends AppCompatActivity {

    TextView textViewNomeFilme;
    TextView textViewPrecoFilme;
    TextView textViewValidadeFilme;
    Button buttonConfirmarCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar);

        textViewNomeFilme = findViewById(R.id.textViewNomeFilme);
        textViewPrecoFilme = findViewById(R.id.textViewPrecoFilme);
        textViewValidadeFilme = findViewById(R.id.textViewValidadeFilme);
        buttonConfirmarCompra = findViewById(R.id.buttonConfirmarCompra);

        // Recuperar dados vindos de outra Activity
        Bundle dados = getIntent().getExtras();
        Filme filme = (Filme) dados.getSerializable("compraObj");

        textViewNomeFilme.setText(filme.getTitulo());
        textViewPrecoFilme.setText(String.format("R$: %.2f", filme.getPreco()));
        textViewValidadeFilme.setText(filme.getValidade());

        buttonConfirmarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(getApplicationContext(), Finalizar.class);
                    startActivity(intent);
                } catch (ActivityNotFoundException activityNotFoundException) {
                    Toast.makeText(getApplicationContext(), "Erro ao realizar compra. Pedimos desculpas pelo transtorno.", Toast.LENGTH_SHORT).show();
                } catch (Exception exception) {
                    Toast.makeText(getApplicationContext(), "Erro ao processar a compra. Tente mais tarde.", Toast.LENGTH_SHORT).show();
                } finally {
                    finish();
                }
            }
        });
    }

    public void voltar(View v) {
        finish();
    }
}