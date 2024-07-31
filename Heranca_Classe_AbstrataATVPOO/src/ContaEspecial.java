public class ContaEspecial extends Conta {
    private double limiteChequeEspecial;

    public ContaEspecial(Cliente pessoaFisica, double limiteChequeEspecial) {
        super(pessoaFisica);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if (saldo - valor >= -limiteChequeEspecial) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente, além do limite de cheque especial.");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }
}
