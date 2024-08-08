class Emprestimo {
    private Cliente cliente;
    private Veiculo veiculo;
    private int renovacoes;

    public Emprestimo(Cliente cliente, Veiculo veiculo) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.renovacoes = 0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void renovar() {
        renovacoes++;
    }

    public void finalizar() {
        double valorTotal = veiculo.calcularValorTotal(renovacoes);
        System.out.println("Valor total do empréstimo: " + valorTotal);
    }
}
