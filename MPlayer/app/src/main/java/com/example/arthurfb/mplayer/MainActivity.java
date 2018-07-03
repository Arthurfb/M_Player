package com.example.arthurfb.mplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button voltar = findViewById(R.id.voltar_menu);
        Button rewButon = findViewById(R.id.rew_button);
        final Button playPause = findViewById(R.id.play_pause);
        Button ffButton = findViewById(R.id.ff_button);

        playPause.setBackgroundResource(android.R.drawable.ic_media_play);

        //Pega o nome da musica à ser tocada
        Intent musicaTocada = getIntent();
        String nomeMusica = musicaTocada.getStringExtra("nomeM");
        //Coloca o nome da música na view//
        TextView nomeMusicaView = findViewById(R.id.nome_musica);
        nomeMusicaView.setText(nomeMusica);

        //Pega o nome do artista da música//
        Intent artistaTocada = getIntent();
        String nomeArtista = artistaTocada.getStringExtra("nomeA");
        //Coloca o nome do artista na view//
        TextView nomeArtistaView = findViewById(R.id.nome_artista);
        nomeArtistaView.setText(nomeArtista);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltarLista = new Intent(MainActivity.this, ListaMusicas.class);
                startActivity(voltarLista);

                voltarLista.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                MainActivity.this.finish();
            }
        });

        rewButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Rewind", Toast.LENGTH_SHORT).show();
            }
        });

        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Toast.makeText(MainActivity.this, "Play", Toast.LENGTH_SHORT).show();
                    //Transforma o o ícone do botão play em pause//
                    playPause.setBackgroundResource(android.R.drawable.ic_media_pause);
                }
            }
        });

        ffButton.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Fast Foward", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

