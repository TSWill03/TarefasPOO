import java.util.Date;
import java.util.List;

public class Artigo extends Publicacao {
    private String resumo;

    public Artigo(Date dataPublicacao, String titulo, List<Publicacao> referencias, List<Autor> autores, double valorMulta, String resumo) {
        super(dataPublicacao, titulo, referencias, autores, valorMulta);
        this.resumo = resumo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
}
