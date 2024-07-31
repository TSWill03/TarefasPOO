public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente pessoaFisica) {
        super(pessoaFisica);
    }

    @Override
    public void sacar(double valor) {
        if (saldo - valor >= 0) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    public void renderJuros() {
        saldo += saldo * 0.005;
    }
}
