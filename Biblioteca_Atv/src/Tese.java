import java.util.Date;
import java.util.List;

public class Tese extends Publicacao {
    private int numeroPaginas;
    private String resumo;
    private Date dataDefesa;
    private String instituicao;

    public Tese(Date dataPublicacao, String titulo, List<Publicacao> referencias, List<Autor> autores, double valorMulta,
                int numeroPaginas, String resumo, Date dataDefesa, String instituicao) {
        super(dataPublicacao, titulo, referencias, autores, valorMulta);
        this.numeroPaginas = numeroPaginas;
        this.resumo = resumo;
        this.dataDefesa = dataDefesa;
        this.instituicao = instituicao;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Date getDataDefesa() {
        return dataDefesa;
    }

    public void setDataDefesa(Date dataDefesa) {
        this.dataDefesa = dataDefesa;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
}
