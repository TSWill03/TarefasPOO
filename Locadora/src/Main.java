import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locadora locadora = new Locadora("Locadora Exemplo", "Rua Exemplo, 123", "1234-5678");

        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("1. Cadastrar Veículo");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Realizar Empréstimo");
            System.out.println("4. Renovar Empréstimo");
            System.out.println("5. Finalizar Empréstimo");
            System.out.println("6. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Tipo de veículo (1. Popular, 2. SUV, 3. Luxo): ");
                    int tipoVeiculo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Marca: ");
                    String marca = scanner.nextLine();

                    System.out.println("Modelo: ");
                    String modelo = scanner.nextLine();

                    System.out.println("Placa: ");
                    String placa = scanner.nextLine();

                    System.out.println("Ano: ");
                    int ano = scanner.nextInt();

                    System.out.println("Valor da locação: ");
                    double valorLocacao = scanner.nextDouble();

                    System.out.println("Valor da multa: ");
                    double valorMulta = scanner.nextDouble();
                    scanner.nextLine();

                    switch (tipoVeiculo) {
                        case 1:
                            System.out.println("Possui ar-condicionado (true/false): ");
                            boolean arCondicionado = scanner.nextBoolean();
                            scanner.nextLine();
                            locadora.cadastrarVeiculo(new Popular(marca, modelo, placa, ano, valorLocacao, valorMulta, arCondicionado));
                            break;
                        case 2:
                            System.out.println("Tamanho do porta-malas: ");
                            String tamanhoPortaMalasSUV = scanner.nextLine();

                            System.out.println("Tipo de tração: ");
                            String tipoTracao = scanner.nextLine();

                            System.out.println("Tipo de combustível: ");
                            String tipoCombustivel = scanner.nextLine();
                            locadora.cadastrarVeiculo(new SUV(marca, modelo, placa, ano, valorLocacao, valorMulta, tamanhoPortaMalasSUV, tipoTracao, tipoCombustivel));
                            break;
                        case 3:
                            System.out.println("Quantidade de airbags: ");
                            int quantidadeAirbags = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Tamanho do porta-malas: ");
                            String tamanhoPortaMalasLuxo = scanner.nextLine();

                            System.out.println("Possui GPS integrado (true/false): ");
                            boolean gpsIntegrado = scanner.nextBoolean();
                            scanner.nextLine();
                            locadora.cadastrarVeiculo(new Luxo(marca, modelo, placa, ano, valorLocacao, valorMulta, quantidadeAirbags, tamanhoPortaMalasLuxo, gpsIntegrado));
                            break;
                        default:
                            System.out.println("Tipo de veículo inválido.");
                    }
                    break;

                case 2:
                    System.out.println("Tipo de cliente (1. Pessoa Física, 2. Pessoa Jurídica): ");
                    int tipoCliente = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Nome: ");
                    String nomeCliente = scanner.nextLine();

                    System.out.println("Telefone: ");
                    String telefoneCliente = scanner.nextLine();

                    System.out.println("Endereço: ");
                    String enderecoCliente = scanner.nextLine();

                    switch (tipoCliente) {
                        case 1:
                            System.out.println("CPF: ");
                            String cpf = scanner.nextLine();
                            locadora.cadastrarCliente(new PessoaFisica(nomeCliente, telefoneCliente, enderecoCliente, cpf));
                            break;
                        case 2:
                            System.out.println("CNPJ: ");
                            String cnpj = scanner.nextLine();

                            System.out.println("Nome do representante: ");
                            String nomeRepresentante = scanner.nextLine();
                            locadora.cadastrarCliente(new PessoaJuridica(nomeCliente, telefoneCliente, enderecoCliente, cnpj, nomeRepresentante));
                            break;
                        default:
                            System.out.println("Tipo de cliente inválido.");
                    }
                    break;

                case 3:
                    System.out.println("Clientes Cadastrados:");
                    for (Cliente client : locadora.clientes) {
                        System.out.println(client.getNome());
                    }
                    System.out.println("Nome do cliente: ");
                    String nomeEmprestimo = scanner.nextLine();

                    Cliente cliente = locadora.buscarClientePorNome(nomeEmprestimo);
                    if (cliente == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }

                    if (cliente instanceof PessoaFisica) {
                        boolean temEmprestimo = false;
                        for (Emprestimo emp : locadora.emprestimos) {
                            if (emp.getCliente().equals(cliente)) {
                                temEmprestimo = true;
                                break;
                            }
                        }
                        if (temEmprestimo) {
                            System.out.println("Pessoa Física já possui um empréstimo ativo.");
                            break;
                        }
                    }
                    System.out.println("Veículos Cadastrados:");
                    for (Veiculo veiculo : locadora.veiculos) {
                        System.out.println(veiculo.getPlaca());
                    }
                    System.out.println("Placa do veículo: ");
                    String placaEmprestimo = scanner.nextLine();

                    Veiculo veiculo = locadora.buscarVeiculoPorPlaca(placaEmprestimo);
                    if (veiculo == null) {
                        System.out.println("Veículo não encontrado.");
                        break;
                    }

                    boolean veiculoAlugado = false;
                    for (Emprestimo emp : locadora.emprestimos) {
                        if (emp.getVeiculo().equals(veiculo)) {
                            veiculoAlugado = true;
                            break;
                        }
                    }

                    if (veiculoAlugado) {
                        System.out.println("Veículo já está alugado.");
                    } else {
                        locadora.realizarEmprestimo(new Emprestimo(cliente, veiculo));
                        System.out.println("Empréstimo realizado com sucesso.");
                    }
                    break;

                case 4:
                    System.out.println("Nome do cliente: ");
                    String nomeRenovar = scanner.nextLine();

                    Cliente clienteRenovar = locadora.buscarClientePorNome(nomeRenovar);
                    if (clienteRenovar == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }

                    Emprestimo emprestimoRenovar = locadora.buscarEmprestimoPorCliente(clienteRenovar);
                    if (emprestimoRenovar == null) {
                        System.out.println("Empréstimo não encontrado para este cliente.");
                    } else {
                        emprestimoRenovar.renovar();
                        System.out.println("Empréstimo renovado com sucesso.");
                    }
                    break;

                case 5:

                    System.out.println("Nome do cliente: ");
                    String nomeFinalizar = scanner.nextLine();

                    Cliente clienteFinalizar = locadora.buscarClientePorNome(nomeFinalizar);
                    if (clienteFinalizar == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }

                    Emprestimo emprestimoFinalizar = locadora.buscarEmprestimoPorCliente(clienteFinalizar);
                    if (emprestimoFinalizar == null) {
                        System.out.println("Empréstimo não encontrado para este cliente.");
                    } else {
                        locadora.finalizarEmprestimo(emprestimoFinalizar);
                        System.out.println("Empréstimo finalizado com sucesso.");
                    }
                    break;

                case 6:
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}