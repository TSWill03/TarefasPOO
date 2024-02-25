import java.util.List;
import java.util.Scanner;

public class Conta_Corrente {
    Scanner scanner = new Scanner(System.in);
    private String nome_Conta;
    private String data_Nascimento;
    private int id_Conta;
    private double saldo_Conta;
    private boolean conta_Ativa;

    public Conta_Corrente(String nomeConta, int id, double saldo, boolean conta_Ativa, String data_Nascimento) {
        this.nome_Conta = nomeConta;
        this.id_Conta = id;
        this.saldo_Conta = saldo;
        this.conta_Ativa = conta_Ativa;
        this.data_Nascimento = data_Nascimento;
    }

    String getNome_Conta() {
        return nome_Conta;
    }

    int getId_Conta() {
        return id_Conta;
    }

    private double getSaldo_Conta() {
        return saldo_Conta;
    }

    private boolean getConta_Ativa() {
        return conta_Ativa;
    }

    private String getData_Nascimento() {
        return data_Nascimento;
    }

    public void setNome_Conta(String nome_Conta) {
        this.nome_Conta = nome_Conta;
    }

    public void setId_Conta(int id_Conta) {
        this.id_Conta = id_Conta;
    }

    public void setSaldo_Conta(double saldo_Conta) {
        this.saldo_Conta = saldo_Conta;
    }

    public void setConta_Ativa(boolean conta_Ativa) {
        this.conta_Ativa = conta_Ativa;
    }

    public void setData_Nascimento(String data_Nascimento) {
        this.data_Nascimento = data_Nascimento;
    }

    public void depositar(double valor) {
        System.out.println("Depósito de " + valor + " realizado com sucesso.\nConta de "+ getNome_Conta() + " ID: " + getId_Conta()+"\n");
        saldo_Conta += valor;
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo_Conta >= valor) {
            saldo_Conta -= valor;
            System.out.println("Saque de " + valor + " realizado com sucesso.\nConta de "+ getNome_Conta() + " ID: " + getId_Conta()+"\n");
            return true;
        } else {
            System.out.println("Saldo insuficiente para saque de " + valor + ".");
            return false;
        }
    }

    public boolean transferir(double valor, Banco banco) {
        List<Conta_Corrente> contas = banco.getContas();
        if (contas.size() <= 1) {
            System.out.println("Nenhuma outra conta foi criada.");
            System.out.println("Deseja criar uma para exemplo? (1 para sim, 2 para não)");
            int opcao = scanner.nextInt();
            if (opcao == 1) {
                System.out.print("Digite o nome da nova conta: ");
                String nomeConta = scanner.next();
                int idConta;
                do {
                    System.out.print("Digite o ID da nova conta (até 999): ");
                    idConta = scanner.nextInt();
                    if (idConta > 999) {
                        System.out.println("O ID da conta deve ser até 999.");
                    }
                } while (idConta > 999);
                Conta_Corrente novaConta = new Conta_Corrente(nomeConta, idConta, 1000.0, true, "01/01/2000");
                banco.adicionarConta(novaConta);
                System.out.println("Nova conta criada com sucesso!");
                return transferir(valor, banco); // Tente transferir novamente
            }
            return false;
        } else {
            System.out.println("Contas disponíveis para transferência:");
            for (Conta_Corrente conta : contas) {
                if (conta != this) {
                    System.out.println("ID da Conta: " + conta.getId_Conta() + ", Nome da Conta: " + conta.getNome_Conta());
                }
            }
            System.out.println("Digite o ID da conta para a qual deseja transferir:");
            int idConta = scanner.nextInt();
            for (Conta_Corrente conta : contas) {
                if (conta.getId_Conta() == idConta && conta != this) {
                    if (valor > 0 && saldo_Conta >= valor) {
                        saldo_Conta -= valor;
                        System.out.println("Transferencia de " + valor + " realizado com sucesso.\nConta de "+ getNome_Conta() + " ID: " + getId_Conta()+ "\nPara a conta de "+ conta.getNome_Conta() + " ID: " + conta.getId_Conta()+"\n");
                        conta.saldo_Conta += valor;
                        return true;
                    } else {
                        System.out.println("Saldo insuficiente para transferencia de " + valor + ".");
                        return false;
                    }
                }
            }
            System.out.println("ID de conta inválido.");
            return false;
        }
    }
    public void mostrarSaldo(){
        System.out.println("conta de "+ getNome_Conta()+ " \nID: "+ getId_Conta() + "\n" + "Saldo: " +getSaldo_Conta() + "\n");
    }

}
