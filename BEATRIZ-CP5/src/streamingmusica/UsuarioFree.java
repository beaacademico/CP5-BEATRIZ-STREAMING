package streamingmusica;

public class UsuarioFree extends Usuario {
    private int contadorAnuncios;

    public UsuarioFree(String nome, String email) {
        super(nome, email);
        this.contadorAnuncios = 0;
    }

    @Override
    public void reproduzirMusica(Musica musica) {
        contadorAnuncios++;

        if (contadorAnuncios % 3 == 0) {
            exibirAnuncio();
        }

        System.out.println("🎧 Conta Free:");
        super.reproduzirMusica(musica);
    }

    public void exibirAnuncio() {
        System.out.println("📢 Anúncio: Assine o Premium e ouça sem interrupções!");
    }
}