package streamingmusica;

import java.util.ArrayList;

public class Playlist {
    protected String nome;
    protected String descricao;
    protected ArrayList<Musica> musicas;

    public Playlist(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.musicas = new ArrayList<>();
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public void reproduzir() {
        System.out.println("\n🎵 Playlist: " + nome);

        for (Musica musica : musicas) {
            System.out.println("▶ " + musica.getTitulo());
            musica.reproduzir();
        }
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }
}