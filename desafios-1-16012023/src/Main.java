

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double salario = scanner.nextDouble();
        System.out.println(calculaValor(salario));
    }

    public static double calculaValor(double salario) {

        double valorINSS = 0;
        double faixaSalarial1= 1100;
        double faixaSalarial2= 2203.49;
        double faixaSalarial3= 3305.22;
        double faixaSalarial4= 6433.57;
        double valorPadraoDa1 = 82.50;
        double valorPadraoDa2= 99.31;
        double valorPadraoDa3= 132.20;
        if(salario<=faixaSalarial4) {
            if (salario >= faixaSalarial3) {
                valorINSS = ((valorPadraoDa1 + valorPadraoDa2 + valorPadraoDa3 + ((salario - faixaSalarial3) * 14 / 100)));
            } else if (salario > faixaSalarial2) {
                valorINSS = ((valorPadraoDa1 + valorPadraoDa2+ ((salario - faixaSalarial2) * 12 / 100)));
            } else if (salario > faixaSalarial1) {
                valorINSS = ((valorPadraoDa1 + ((salario - faixaSalarial1) * 9 / 100)));
            } else if (salario <= faixaSalarial1) {
                valorINSS = (salario * 7.5 / 100);
            }
        } else{
            valorINSS = 82.50 + 99.31 + 132.20;
        }
        return valorINSS;

    }


}

