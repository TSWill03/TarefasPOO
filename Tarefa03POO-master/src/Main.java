import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double media = 0;
        int menor = 0;
        int maior = 0;
        int qtd = 0;

        while (true) {
            System.out.println("Digite um número: ");
            int num = scan.nextInt();
            if (num == -1) {
                break;
            }
            if (qtd == 0) {
                menor = num;
                maior = num;
            }
            if (num < menor) {
                menor = num;
            }
            if (num > maior) {
                maior = num;
            }
            media += num;
            media = media / qtd;
            qtd++;


        }
        System.out.println("Quantidade de números digitados: " + qtd);
        System.out.println("Maior número digitado: " + maior);
        System.out.println("Menor número digitado: " + menor);
        System.out.println("Média dos números digitados: " + media);
        scan.close();
    }
}