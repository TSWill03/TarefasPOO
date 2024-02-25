public class Validador {
    public boolean validar_tamanho(String sem_Validar) {
        if (sem_Validar == null) {
            System.out.println("String nula");
            return false;
        }
        if (sem_Validar.length() <= 1) {
            System.out.println("String muito curta");
            return false;
        }
        return true;
    }
    public String validar_Metodo_Lehn(String string_Validada) {
        String string_Validada_sem_espaco= string_Validada.replace(" ", "");
        int tamanho_String = string_Validada_sem_espaco.length();
        System.out.println(string_Validada_sem_espaco);
        char lista_Validada[] = string_Validada_sem_espaco.toCharArray();
        for (int i = 0; i < tamanho_String; i++) {
            if (i % 2 != 0) {
                String numero_Duplicado_String = String.valueOf(lista_Validada[i]);
                int numero_Duplicado = Integer.parseInt(numero_Duplicado_String);
                numero_Duplicado = numero_Duplicado * 2;
                System.out.println("antes subtracao "+numero_Duplicado);

                if (numero_Duplicado > 9) {
                    numero_Duplicado = numero_Duplicado - 9;
                }

                System.out.println(numero_Duplicado);
                String numero_duplicado_String = Integer.toString(numero_Duplicado);
                lista_Validada[i] = numero_duplicado_String.charAt(0);
            }
        }
        return new String(lista_Validada);
    }
}
