
class Popular extends Veiculo {
    private boolean arCondicionado;

    public Popular(String marca, String modelo, String placa, int ano, double valorLocacao, double valorMulta, boolean arCondicionado) {
        super(marca, modelo, placa, ano, valorLocacao, valorMulta);
        this.arCondicionado = arCondicionado;
    }

    @Override
    public double calcularValorTotal(int renovacoes) {
        int renovacoesExtras = Math.max(0, renovacoes - 1);
        return valorLocacao + renovacoesExtras * valorMulta;
    }
}

