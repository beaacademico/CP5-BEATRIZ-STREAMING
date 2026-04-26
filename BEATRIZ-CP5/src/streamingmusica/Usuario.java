package streamingmusica;

import java.util.ArrayList;

public class Usuario {
    protected String nome;
    protected String email;
    protected ArrayList<Playlist> playlists;
    protected int totalReproducoes;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.playlists = new ArrayList<>();
        this.totalReproducoes = 0;
    }

    public void reproduzirMusica(Musica musica) {
        System.out.println("🎵 Reproduzindo: " + musica.getTitulo());
        musica.reproduzir();
        totalReproducoes++;
    }

    public void criarPlaylist(String nome, String descricao) {
        playlists.add(new Playlist(nome, descricao));
    }

    public final void validarEmail(String email) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email inválido.");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public int getTotalReproducoes() {
        return totalReproducoes;
    }
}