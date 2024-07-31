import java.util.Date;
import java.util.List;

public abstract class Publicacao {
    private Date dataPublicacao;
    private String titulo;
    private List<Publicacao> referencias;
    private List<Autor> autores;
    private double valorMulta;

    public Publicacao(Date dataPublicacao, String titulo, List<Publicacao> referencias, List<Autor> autores, double valorMulta) {
        this.dataPublicacao = dataPublicacao;
        this.titulo = titulo;
        this.referencias = referencias;
        this.autores = autores;
        this.valorMulta = valorMulta;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Publicacao> getReferencias() {
        return referencias;
    }

    public void setReferencias(List<Publicacao> referencias) {
        this.referencias = referencias;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
    }
}
