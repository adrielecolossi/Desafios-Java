
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double salario = scanner.nextDouble();
        System.out.println(calculaValor(salario));
    }
    public static double calculaValor(double salario) {
        double valor = 0;
        if (salario <= 1100) {
            valor = salario * 0.075;
        }
        else if (salario <= 2203.48) {
            valor = salario * 0.09;
        }
        else if (salario <= 3305.22) {
            valor = salario * 0.12;
        }
        else if (salario <= 6433.57) {
            valor = salario * 0.14;
        }

        return valor;
    }
}