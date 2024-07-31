import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Biblioteca {
    private String nome;
    private String endereco;
    private List<Publicacao> publicacoes;
    private List<Emprestimo> emprestimos;

    public Biblioteca(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.publicacoes = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void adicionarPublicacao(Publicacao publicacao) {
        publicacoes.add(publicacao);
        System.out.println("Publicação adicionada: " + publicacao.getTitulo());
    }

    public Emprestimo realizarEmprestimo(Usuario usuario, Publicacao publicacao) {
        // Verifica se a publicação já está emprestada
        for (Emprestimo e : emprestimos) {
            if (e.getPublicacao().equals(publicacao)) {
                System.out.println("Publicação já está emprestada.");
                return null;
            }
        }

        // Verifica se o usuário pode pegar mais empréstimos
        long emprestimosDoUsuario = emprestimos.stream()
                .filter(e -> e.getUsuario().equals(usuario))
                .count();
        if (emprestimosDoUsuario >= usuario.getLimiteEmprestimos()) {
            System.out.println("Usuário atingiu o limite de empréstimos.");
            return null;
        }

        // Realiza o empréstimo
        Emprestimo emprestimo = new Emprestimo(usuario, publicacao, new Date());
        emprestimos.add(emprestimo);
        return emprestimo;
    }

    public void renovarEmprestimo(Emprestimo emprestimo) {
        emprestimo.renovar();
        System.out.println("Empréstimo renovado: " + emprestimo.getPublicacao().getTitulo());
    }

    public double devolverEmprestimo(Emprestimo emprestimo) {
        double multa = emprestimo.calcularMulta();
        emprestimos.remove(emprestimo);
        System.out.println("Publicação devolvida: " + emprestimo.getPublicacao().getTitulo());
        return multa;
    }
}