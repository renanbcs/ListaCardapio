package com.example.renan.atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetalhesActivity extends AppCompatActivity {

    private TextView idTextView,tipoTextView,disponibilidadeTextView,descricaoTextView,precoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);


        idTextView = (TextView) findViewById(R.id.idTextView);
        tipoTextView = (TextView) findViewById(R.id.tipoTextView);
        disponibilidadeTextView = (TextView) findViewById(R.id.disponibilidadeTextView);
        descricaoTextView = (TextView) findViewById(R.id.descricaoTextView);
        precoTextView = (TextView) findViewById(R.id.precoTextView);



        Intent intent = getIntent();

        Cardapio c = (Cardapio) intent.getSerializableExtra("cardapio");

        idTextView.setText(c.getId()+"");
        tipoTextView.setText(c.getTipo());
        disponibilidadeTextView.setText(c.getDisponibilidade());
        descricaoTextView.setText(c.getDescricao());
        precoTextView.setText(c.getPreco()+"");



        idTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = ((TextView)view).getText().toString();
                Toast.makeText(DetalhesActivity.this, texto, Toast.LENGTH_SHORT).show();

            }
        });

        tipoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = ((TextView)view).getText().toString();
                Toast.makeText(DetalhesActivity.this, texto, Toast.LENGTH_SHORT).show();

            }
        });

        disponibilidadeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = ((TextView)view).getText().toString();
                Toast.makeText(DetalhesActivity.this, texto, Toast.LENGTH_SHORT).show();

            }
        });

        descricaoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = ((TextView)view).getText().toString();
                Toast.makeText(DetalhesActivity.this, texto, Toast.LENGTH_SHORT).show();

            }
        });

        precoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = ((TextView)view).getText().toString();
                Toast.makeText(DetalhesActivity.this, texto, Toast.LENGTH_SHORT).show();

            }
        });

    }
}
