package streamingmusica;

public class Musica {
    private String titulo;
    private String artista;
    private String genero;
    private int reproducoes;

    public Musica(String titulo, String artista, String genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.reproducoes = 0;
    }

    public void reproduzir() {
        reproducoes++;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public String getGenero() {
        return genero;
    }

    public int getReproducoes() {
        return reproducoes;
    }

    @Override
    public String toString() {
        return titulo + " - " + artista + " (" + genero + ")";
    }
}