import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Menu {
    private static Conta_Corrente contaAtiva;

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();
        contaAtiva = criarConta(scanner, banco);
        while (true) {
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Transferir");
            System.out.println("4. Mostrar Saldo");
            System.out.println("5. Criar Conta");
            System.out.println("6. Trocar Conta Ativa");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    contaAtiva.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Digite o valor a sacar: ");
                    double valorSaque = scanner.nextDouble();
                    contaAtiva.sacar(valorSaque);
                    break;
                case 3:
                    System.out.print("Digite o valor a transferir: ");
                    double valorTransferencia = scanner.nextDouble();
                    contaAtiva.transferir(valorTransferencia, banco);
                    break;
                case 4:
                    contaAtiva.mostrarSaldo();
                    break;
                case 5:
                    criarConta(scanner, banco);
                    break;
                case 6:
                    trocarContaAtiva(scanner, banco);
                    break;
                case 7:
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static Conta_Corrente criarConta(Scanner scanner, Banco banco) {
        LocalDate dataNascimento = null;
        System.out.println("Bem-vindo! Vamos criar sua conta.");
        scanner.nextLine();
        System.out.print("Digite o nome da conta: ");
        String nomeConta = scanner.nextLine();
        int idConta;
        do {
            System.out.print("Digite o ID da conta (até 999): ");
            idConta = scanner.nextInt();
            scanner.nextLine();
            if (idConta > 999) {
                System.out.println("O ID da conta deve ser até 999.");
            }
        } while (idConta > 999);
        do {
            System.out.print("Digite a data de nascimento (formato dd/MM/yyyy): ");
            String dataNascimentoStr = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
                if (Period.between(dataNascimento, LocalDate.now()).getYears() > 100 || dataNascimento.isAfter(LocalDate.now())) {
                    System.out.println("A data de nascimento deve ser até 100 anos atrás e não pode ser uma data futura.");
                    dataNascimento = null;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Tente novamente.");
            }
        } while (dataNascimento == null);
        Conta_Corrente conta = new Conta_Corrente(nomeConta, idConta, 1000.0, true, dataNascimento.toString());
        banco.adicionarConta(conta);
        System.out.println("Conta criada com sucesso!");
        return conta;
    }
    private static void trocarContaAtiva(Scanner scanner, Banco banco) {
        System.out.println("Contas disponíveis:");
        for (Conta_Corrente conta : banco.getContas()) {
            System.out.println("ID da Conta: " + conta.getId_Conta() + ", Nome da Conta: " + conta.getNome_Conta());
        }
        System.out.print("Digite o ID da conta que deseja tornar ativa: ");
        int idConta = scanner.nextInt();
        for (Conta_Corrente conta : banco.getContas()) {
            if (conta.getId_Conta() == idConta) {
                contaAtiva = conta;
                System.out.println("Conta ativa alterada com sucesso!");
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }
}
