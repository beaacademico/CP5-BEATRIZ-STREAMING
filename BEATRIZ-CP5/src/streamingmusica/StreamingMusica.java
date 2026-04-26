package streamingmusica;

import java.util.ArrayList;
import java.util.Scanner;

public class StreamingMusica {

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static ArrayList<Musica> musicas = new ArrayList<>();

    static Usuario usuarioLogado = null;

    public static void main(String[] args) {

        carregarMusicasIniciais();

        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE STREAMING ===");
            System.out.println("1. Criar usuário");
            System.out.println("2. Login");
            System.out.println("3. Listar usuários");
            System.out.println("4. Estatísticas");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    criarUsuario();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    listarUsuarios();
                    break;
                case 4:
                    mostrarEstatisticas();
                    break;
                case 0:
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    public static void carregarMusicasIniciais() {
        musicas.add(new Musica("Numb", "Linkin Park", "Rock"));
        musicas.add(new Musica("Believer", "Imagine Dragons", "Rock"));
        musicas.add(new Musica("Shape of You", "Ed Sheeran", "Pop"));
        musicas.add(new Musica("Blinding Lights", "The Weeknd", "Pop"));
        musicas.add(new Musica("Thunderstruck", "AC/DC", "Rock"));
    }

    public static void criarUsuario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.println("1. Free");
        System.out.println("2. Premium");
        System.out.print("Tipo: ");

        int tipo = Integer.parseInt(scanner.nextLine());

        if (tipo == 1) {
            usuarios.add(new UsuarioFree(nome, email));
        } else {
            System.out.print("Plano (Mensal/Anual/Familiar): ");
            String plano = scanner.nextLine();

            usuarios.add(new UsuarioPremium(nome, email, plano));
        }

        System.out.println("✅ Usuário criado com sucesso!");
    }

    public static void login() {

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        listarUsuarios();

        System.out.print("Escolha usuário: ");
        int escolha = Integer.parseInt(scanner.nextLine());

        usuarioLogado = usuarios.get(escolha - 1);

        System.out.println("✅ Login realizado: " + usuarioLogado.getNome());

        menuUsuario();
    }

    public static void menuUsuario() {
        int opcao;

        do {
            System.out.println("\n=== MENU USUÁRIO ===");
            System.out.println("1. Ouvir música");
            System.out.println("2. Playlist automática");
            System.out.println("3. Ver detalhes");
            System.out.println("0. Logout");
            System.out.print("Escolha: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    ouvirMusica();
                    break;
                case 2:
                    playlistAutomatica();
                    break;
                case 3:
                    detalhesUsuario(usuarioLogado);
                    break;
                case 0:
                    usuarioLogado = null;
                    System.out.println("Logout realizado.");
                    break;
            }

        } while (opcao != 0);
    }

    public static void ouvirMusica() {

        for (int i = 0; i < musicas.size(); i++) {
            System.out.println((i + 1) + ". " + musicas.get(i));
        }

        System.out.print("Escolha música: ");
        int escolha = Integer.parseInt(scanner.nextLine());

        usuarioLogado.reproduzirMusica(musicas.get(escolha - 1));
    }

    public static void playlistAutomatica() {

        PlaylistAutomatica p =
            new PlaylistAutomatica("Top Hits", "Gerada pelo sistema", "top");

        p.atualizar(musicas);
        p.reproduzir();
    }

    public static void listarUsuarios() {

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        for (int i = 0; i < usuarios.size(); i++) {

            Usuario u = usuarios.get(i);

            if (u instanceof UsuarioPremium) {
                System.out.println((i + 1) + ". " + u.getNome() + " (Premium)");
            } else {
                System.out.println((i + 1) + ". " + u.getNome() + " (Free)");
            }
        }
    }

    public static void detalhesUsuario(Usuario usuario) {

        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Email: " + usuario.getEmail());

        if (usuario instanceof UsuarioPremium) {

            UsuarioPremium premium = (UsuarioPremium) usuario;

            System.out.println("Tipo: Premium");
            System.out.println("Plano: " + premium.getPlano());
            System.out.println("Downloads: " +
                    premium.getMusicasBaixadas().size());

        } else {

            System.out.println("Tipo: Free");
        }

        System.out.println("Reproduções: " +
                usuario.getTotalReproducoes());
    }

    public static void mostrarEstatisticas() {

        int free = 0;
        int premium = 0;
        int total = 0;

        for (Usuario u : usuarios) {

            total += u.getTotalReproducoes();

            if (u instanceof UsuarioPremium) {
                premium++;
            } else {
                free++;
            }
        }

        System.out.println("\n=== ESTATÍSTICAS ===");
        System.out.println("Total usuários: " + usuarios.size());
        System.out.println("Free: " + free);
        System.out.println("Premium: " + premium);
        System.out.println("Reproduções totais: " + total);
    }
}