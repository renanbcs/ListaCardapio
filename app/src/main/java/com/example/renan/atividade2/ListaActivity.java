package com.example.renan.atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    private ListView nomesListView;
    private List<String> lista = new ArrayList<>();
    private Cardapio c;
    private List<Cardapio> listaCardapio = new ArrayList<>();
    private List<Integer> listaId = new ArrayList<>();


    private void inicializaBase (){
        c = new Cardapio(1,"Sobremesa","Disponivel","Sorvete",5.50);
        listaCardapio.add(c);
        c = new Cardapio(2,"Prato","Indisponivel","Lasanha",20.50);
        listaCardapio.add(c);
        c = new Cardapio(3,"Bebida","Disponivel","Coca Lata",4.50);
        listaCardapio.add(c);
        c = new Cardapio(4,"Sobremesa","Indisponivel","Mouse",3.50);
        listaCardapio.add(c);
        c = new Cardapio(5,"Prato","Disponivel","Costelas",25.50);
        listaCardapio.add(c);
        c = new Cardapio(6,"Sobremesa","Indisponivel","Torta",6.50);
        listaCardapio.add(c);
        c = new Cardapio(7,"Bebida","Disponivel","Cola 600",5.00);
        listaCardapio.add(c);

        for(int a = 0; a<listaCardapio.size();a++){
            lista.add(listaCardapio.get(a).getDescricao());
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        nomesListView = (ListView) findViewById(R.id.nomesListView);
        Intent intentOrigem  = getIntent();
        String texto = intentOrigem.getStringExtra("txt");
        inicializaBase();
        List <String> resultado = realizaBusca(texto);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, resultado);
        nomesListView.setAdapter(adapter);
        if (resultado.size() <= 0)
            Toast.makeText(this, getString(R.string.sem_resultados, texto), Toast.LENGTH_SHORT).show();
        nomesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(ListaActivity.this, "Posição: " + i, Toast.LENGTH_SHORT).show();
                String tocou = nomesListView.getItemAtPosition(i).toString();
                Intent intent = new Intent (ListaActivity.this, DetalhesActivity.class);
                Cardapio c = listaCardapio.get(listaId.get(i));
                intent.putExtra("cardapio",c );
                startActivity(intent);
            }
        });
    }

    private List <String> realizaBusca (String texto){
        if (texto == null || texto.length() <= 0)
            return lista;
        List <String> resultado = new ArrayList<>();
        int a = 0;
        for (String s : lista){

            if (s.contains(texto)) {
                resultado.add(s);
                listaId.add(a);
            }
            a++;
        }
        return resultado;
    }
}
