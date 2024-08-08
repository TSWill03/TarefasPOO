import java.util.ArrayList;
import java.util.Scanner;

public class Locadora {
    private String nome;
    private String endereco;
    private String telefone;
    ArrayList<Veiculo> veiculos;
    ArrayList<Cliente> clientes;
    ArrayList<Emprestimo> emprestimos;

    public Locadora(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.veiculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void realizarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void finalizarEmprestimo(Emprestimo emprestimo) {
        emprestimo.finalizar();
        emprestimos.remove(emprestimo);
    }

    public Veiculo buscarVeiculoPorPlaca(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.placa.equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public Cliente buscarClientePorNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.nome.equals(nome)) {
                return cliente;
            }
        }
        return null;
    }

    public Emprestimo buscarEmprestimoPorCliente(Cliente cliente) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getCliente().equals(cliente)) {
                return emprestimo;
            }
        }
        return null;
    }
}