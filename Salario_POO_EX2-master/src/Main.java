import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int salario = 0;
        int produtos_vendidos= 0;
        double valor_debitado_por_faltas = 0;
        System.out.println("Coloque o Salario Base: ");
        salario = scanner.nextInt();
        System.out.println("Digite as faltas do funcionário: ");
        int faltas = scanner.nextInt();

        System.out.println("Digite a quantidade de produtos vendidos: ");
        int produtos = scanner.nextInt();

        if (produtos > 20) {
            produtos_vendidos = (produtos * 13);
            salario = salario + produtos_vendidos;
        } else {
            produtos_vendidos = (produtos * 10);
            salario = salario + produtos_vendidos;
        }

        if (faltas > 5) {
            valor_debitado_por_faltas = salario * 15 / 100;
            salario = salario * 85 / 100;
        }


        System.out.printf("O salário do funcionário é: " + salario + "\nCom "+produtos_vendidos+" recebido de produtos vendidos é "+ valor_debitado_por_faltas +" debiado por faltas faltas");
        /*Ler numero de faltas se falto mais que 5 vezes salario = salario * 0.85
        ler numero de produtos vendidos cada produto vale 10 se vendeu mais que 20 produtos o valor e de 13
        * */
    }
}
