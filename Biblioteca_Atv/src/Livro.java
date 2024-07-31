import java.util.Date;
import java.util.List;

public class Livro extends Publicacao {
    private int numeroEdicao;
    private String nomeEditora;
    private String isbn;

    public Livro(Date dataPublicacao, String titulo, List<Publicacao> referencias, List<Autor> autores, double valorMulta,
                 int numeroEdicao, String nomeEditora, String isbn) {
        super(dataPublicacao, titulo, referencias, autores, valorMulta);
        this.numeroEdicao = numeroEdicao;
        this.nomeEditora = nomeEditora;
        this.isbn = isbn;
    }

    public int getNumeroEdicao() {
        return numeroEdicao;
    }

    public void setNumeroEdicao(int numeroEdicao) {
        this.numeroEdicao = numeroEdicao;
    }

    public String getNomeEditora() {
        return nomeEditora;
    }

    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
