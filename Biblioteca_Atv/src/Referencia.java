public class Referencia {
    private final String titulo;
    private final int dataPublicacao;
    private final String Fonte;

    public Referencia(String titulo, int dataPublicacao, String fonte) {
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
        this.Fonte = fonte;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDataPublicacao() {
        return dataPublicacao;
    }
}
