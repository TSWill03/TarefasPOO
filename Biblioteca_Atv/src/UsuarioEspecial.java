public class UsuarioEspecial extends Usuario {

    public UsuarioEspecial(String nome, String telefone, String email, String cpf) {
        super(nome, telefone, email, cpf);
    }

    @Override
    public int getLimiteEmprestimos() {
        return Integer.MAX_VALUE; // Sem limite de empréstimos
    }
}
