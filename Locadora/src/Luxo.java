class Luxo extends Veiculo {
    private int quantidadeAirbags;
    private String tamanhoPortaMalas;
    private boolean gpsIntegrado;

    public Luxo(String marca, String modelo, String placa, int ano, double valorLocacao, double valorMulta, int quantidadeAirbags, String tamanhoPortaMalas, boolean gpsIntegrado) {
        super(marca, modelo, placa, ano, valorLocacao, valorMulta);
        this.quantidadeAirbags = quantidadeAirbags;
        this.tamanhoPortaMalas = tamanhoPortaMalas;
        this.gpsIntegrado = gpsIntegrado;
    }

    @Override
    public double calcularValorTotal(int renovacoes) {
        int renovacoesExtras = Math.max(0, renovacoes - 5);
        return valorLocacao + renovacoesExtras * valorMulta;
    }
}

