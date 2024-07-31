public class Main {
    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente(new PessoaFisica("João", "Rua 1", "123.456.789-00"));
        contaCorrente.depositar(1000);
        contaCorrente.sacar(500);
        System.out.println("Saldo da conta corrente: " + contaCorrente.getSaldo());

        ContaPoupanca contaPoupanca = new ContaPoupanca(new PessoaFisica("Maria", "Rua 2", "987.654.321-00"));
        contaPoupanca.depositar(1000);
        contaPoupanca.sacar(500);
        contaPoupanca.renderJuros();
        System.out.println("Saldo da conta poupança: " + contaPoupanca.getSaldo());

        ContaEspecial contaEspecial = new ContaEspecial(new PessoaFisica("José", "Rua 3", "123.456.789-00"), 1000);
        contaEspecial.depositar(1000);
        contaEspecial.sacar(500);
        contaEspecial.sacar(1500);
        System.out.println("Saldo da conta especial: " + contaEspecial.getSaldo());
        contaEspecial.sacar(1500);

        ContaEmpresarial contaEmpresarial = new ContaEmpresarial(new PessoaJuridica("Empresa 1", "Rua 4", "00.000.000/0000-00"), 1000);
        contaEmpresarial.depositar(1000);
        contaEmpresarial.sacar(500);
        System.out.println("Saldo da conta empresarial: " + contaEmpresarial.getSaldo());
        contaEmpresarial.sacar(1500);
        System.out.println("Saldo da conta empresarial: " + contaEmpresarial.getSaldo());
        contaEmpresarial.sacar(1500);
    }
}