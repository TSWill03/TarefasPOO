class SUV extends Veiculo {
    private String tamanhoPortaMalas;
    private String tipoTracao;
    private String tipoCombustivel;

    public SUV(String marca, String modelo, String placa, int ano, double valorLocacao, double valorMulta, String tamanhoPortaMalas, String tipoTracao, String tipoCombustivel) {
        super(marca, modelo, placa, ano, valorLocacao, valorMulta);
        this.tamanhoPortaMalas = tamanhoPortaMalas;
        this.tipoTracao = tipoTracao;
        this.tipoCombustivel = tipoCombustivel;
    }

    @Override
    public double calcularValorTotal(int renovacoes) {
        int renovacoesExtras = Math.max(0, renovacoes - 3);
        return valorLocacao + renovacoesExtras * valorMulta;
    }
}