
class PessoaJuridica extends Cliente {
    private String cnpj;
    private String nomeRepresentante;

    public PessoaJuridica(String nome, String telefone, String endereco, String cnpj, String nomeRepresentante) {
        super(nome, telefone, endereco);
        this.cnpj = cnpj;
        this.nomeRepresentante = nomeRepresentante;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNomeRepresentante() {
        return nomeRepresentante;
    }
}