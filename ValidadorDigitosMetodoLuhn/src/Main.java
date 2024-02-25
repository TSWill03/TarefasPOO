public class Main {
    public static void main(String[] args) {
        Validador validador = new Validador();
        String string_Validada = "1234 5678 1234 5678";
        if (validador.validar_tamanho(string_Validada)) {
            System.out.println(validador.validar_Metodo_Lehn(string_Validada));
        }
    }
}