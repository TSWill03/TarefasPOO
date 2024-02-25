import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta_Corrente> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta_Corrente conta) {
        contas.add(conta);
    }

    public List<Conta_Corrente> getContas() {
        return contas;
    }
}