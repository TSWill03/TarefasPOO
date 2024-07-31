import java.util.Date;

class Emprestimo {
    private Usuario usuario;
    private Publicacao publicacao;
    private Date dataEmprestimo;
    private int renovacoes;

    public Emprestimo(Usuario usuario, Publicacao publicacao, Date dataEmprestimo) {
        this.usuario = usuario;
        this.publicacao = publicacao;
        this.dataEmprestimo = dataEmprestimo;
        this.renovacoes = 0;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public int getRenovacoes() {
        return renovacoes;
    }

    public void renovar() {
        this.renovacoes++;
    }

    public double calcularMulta() {
        int renovaçõesExcedidas = Math.max(0, renovacoes - 3);
        return renovaçõesExcedidas * publicacao.getValorMulta();
    }
}