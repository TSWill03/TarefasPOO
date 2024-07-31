import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criação de autores
        Autor autor1 = new Autor("Autor Um", "PhD");
        Autor autor2 = new Autor("Autor Dois", "Mestre");
        Autor autor3 = new Autor("Autor Três", "Bacharel");

        // Criação de publicações
        Artigo artigo1 = new Artigo(
                new Date(),
                "Artigo de Pesquisa",
                new ArrayList<>(),
                List.of(autor1, autor2),
                5.0,
                "Resumo do artigo de pesquisa."
        );

        Livro livro1 = new Livro(
                new Date(),
                "Livro de Ciência",
                List.of(artigo1),
                List.of(autor2, autor3),
                10.0,
                2,
                "Editora Ciência",
                "123-4567890123"
        );

        Tese tese1 = new Tese(
                new Date(),
                "Tese de Doutorado",
                List.of(livro1),
                List.of(autor1),
                15.0,
                250,
                "Resumo da tese",
                new Date(),
                "Universidade XYZ"
        );

        // Criação de usuários
        Usuario usuarioComum = new UsuarioComum("Usuário Comum", "123456789", "comum@exemplo.com", "111.222.333-44");
        Usuario usuarioEspecial = new UsuarioEspecial("Usuário Especial", "987654321", "especial@exemplo.com", "555.666.777-88");

        // Criação de biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "Rua Principal, 123");

        // Adicionando publicações à biblioteca
        biblioteca.adicionarPublicacao(artigo1);
        biblioteca.adicionarPublicacao(livro1);
        biblioteca.adicionarPublicacao(tese1);

        // Realizando empréstimos
        Emprestimo emprestimo1 = biblioteca.realizarEmprestimo(usuarioComum, artigo1);
        if (emprestimo1 != null) {
            System.out.println("Empréstimo realizado: " + artigo1.getTitulo() + " para " + usuarioComum.getNome());
        }

        Emprestimo emprestimo2 = biblioteca.realizarEmprestimo(usuarioEspecial, livro1);
        if (emprestimo2 != null) {
            System.out.println("Empréstimo realizado: " + livro1.getTitulo() + " para " + usuarioEspecial.getNome());
        }

        // Tentativa de realizar empréstimo adicional para usuário comum
        Emprestimo emprestimo3 = biblioteca.realizarEmprestimo(usuarioComum, tese1);
        if (emprestimo3 == null) {
            System.out.println("Usuário comum não pode pegar mais de um empréstimo por vez.");
        }

        // Renovação de empréstimos
        biblioteca.renovarEmprestimo(emprestimo1);
        biblioteca.renovarEmprestimo(emprestimo1);
        biblioteca.renovarEmprestimo(emprestimo1);
        biblioteca.renovarEmprestimo(emprestimo1); // A partir daqui, será cobrada multa

        // Calcular multa na devolução
        double multa = biblioteca.devolverEmprestimo(emprestimo1);
        System.out.println("Multa para o empréstimo de " + artigo1.getTitulo() + ": R$ " + multa);
    }
}