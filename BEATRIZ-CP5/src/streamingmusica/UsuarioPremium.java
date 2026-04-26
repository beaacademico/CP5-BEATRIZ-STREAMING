package streamingmusica;

import java.util.ArrayList;

public class UsuarioPremium extends Usuario {
    private String plano;
    private ArrayList<Musica> musicasBaixadas;

    public UsuarioPremium(String nome, String email, String plano) {
        super(nome, email);
        this.plano = plano;
        this.musicasBaixadas = new ArrayList<>();
    }

    @Override
    public void reproduzirMusica(Musica musica) {
        System.out.println("💎 Conta Premium - Alta Qualidade:");
        super.reproduzirMusica(musica);
    }

    public void baixarMusica(Musica musica) {
        musicasBaixadas.add(musica);
        System.out.println("⬇ Música baixada: " + musica.getTitulo());
    }

    public String getPlano() {
        return plano;
    }

    public ArrayList<Musica> getMusicasBaixadas() {
        return musicasBaixadas;
    }
}