package com.example.arthurfb.mplayer;

public class Musicas {

    private String mnomeMusica;

    private String mnomeArtista;

    public Musicas(String nomeMusica, String nomeArtista) {
        mnomeMusica = nomeMusica;
        mnomeArtista = nomeArtista;
    }

    //Pega o nome da música//
    public String getMnomeMusica() {
        return mnomeMusica;
    }

    //Pega o nome do artista//
    public String getMnomeArtista() {
        return mnomeArtista;
    }
}