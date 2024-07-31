public class UsuarioComum extends Usuario {

    public UsuarioComum(String nome, String telefone, String email, String cpf) {
        super(nome, telefone, email, cpf);
    }

    @Override
    public int getLimiteEmprestimos() {
        return 1;
    }
}
