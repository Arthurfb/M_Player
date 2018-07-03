package com.example.arthurfb.mplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListaMusicas extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lista);

        Button tocandoAgora = findViewById(R.id.tocando_agora);

        final ArrayList<Musicas> musicasListadas = new ArrayList<Musicas>();

        //Adicionar valores à lista//
        musicasListadas.add(new Musicas("Música 1", "Fulano"));
        musicasListadas.add(new Musicas("Música 2", "MC Beltrano"));
        musicasListadas.add(new Musicas("Música 3", "Cicrano"));

        WordAdapter adapter = new WordAdapter(this, musicasListadas);

        final ListView listView = (ListView) findViewById(R.id.layout_lista_musica);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                //Abre a tela da música que está tocando//
                Intent musicaSelecionada = new Intent(ListaMusicas.this, MainActivity.class);

                //Pega o nome da música e prepara para enviar à próxima tela//
                String musicaTocando = musicasListadas.get(pos).getMnomeMusica();
                //Pega o nome do artista e prepara para enviar à próxima tela//
                String artistaTocando = musicasListadas.get(pos).getMnomeArtista();

                //Envia o nome da música à próxima tela//
                musicaSelecionada.putExtra("nomeM", musicaTocando);
                //Envia o nome do artista à próxima tela//
                musicaSelecionada.putExtra("nomeA", artistaTocando);
                startActivity(musicaSelecionada);
            }
        });

        tocandoAgora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tocandoAgora = new Intent(ListaMusicas.this, MainActivity.class);
                startActivity(tocandoAgora);

                tocandoAgora.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                ListaMusicas.this.finish();
            }
        });
    }
}