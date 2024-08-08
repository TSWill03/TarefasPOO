abstract class Veiculo {
    protected String marca;
    protected String modelo;
    protected String placa;
    protected int ano;
    protected double valorLocacao;
    protected double valorMulta;

    public Veiculo(String marca, String modelo, String placa, int ano, double valorLocacao, double valorMulta) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.valorLocacao = valorLocacao;
        this.valorMulta = valorMulta;
    }

    public abstract double calcularValorTotal(int renovacoes);

    public String getPlaca() {
        return placa;
    }
}




