import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Digite o total das compras: ");
        Scanner scannerTotalCompras = new Scanner(System.in);
        double totalDasCompras = scannerTotalCompras.nextDouble();
        while (totalDasCompras<=0){
            System.out.println("Digite o total das compras: ");
             scannerTotalCompras = new Scanner(System.in);
            totalDasCompras = scannerTotalCompras.nextDouble();
        }
        System.out.println("Digite o número de parcelas: ");
        Scanner scannerNumeroParcelas = new Scanner(System.in);
        double numeroDeParcelas = scannerNumeroParcelas.nextDouble();
        while(numeroDeParcelas<=0){
            System.out.println("Digite o número de parcelas: ");
            scannerNumeroParcelas = new Scanner(System.in);
            numeroDeParcelas = scannerNumeroParcelas.nextDouble();
        }
        System.out.println(calculaParcelas(totalDasCompras, numeroDeParcelas));
    }

    public static ArrayList calculaParcelas(double totalDasCompras, double numeroDeParcelas) {

        String totalParcelas = Double.toString(totalDasCompras / numeroDeParcelas);
        String totalParcelasSemVirgula = totalParcelas.replace(',', '.');
        Double totalParcelaNumerico = Double.valueOf(totalParcelasSemVirgula);
        Double valorDeCadaParcela = ((double) Math.round(totalParcelaNumerico*100))/100;
        ArrayList<Double> parcelas = new ArrayList();
        for (int x = 0; x < numeroDeParcelas; x++) {
            parcelas.add(valorDeCadaParcela);
        }

        Double somaAtualDasParcelas = valorDeCadaParcela* numeroDeParcelas;
        Double centavosParaCorrecao = totalDasCompras - somaAtualDasParcelas;
        centavosParaCorrecao= ((double) Math.round(centavosParaCorrecao*100))/100;
        int numeroDeCorrecoes = 0;
        System.out.println(centavosParaCorrecao);
        if (centavosParaCorrecao != 0.00) {

            if(centavosParaCorrecao<0) {
                while (centavosParaCorrecao < 0) {
                    if (centavosParaCorrecao < 0) {
                        parcelas.set(numeroDeCorrecoes, ((double) Math.round((parcelas.get(numeroDeCorrecoes) - 0.01) * 100)) / 100);
                        numeroDeCorrecoes++;
                    }
                    centavosParaCorrecao += 0.01;

                }
            } else {
                while (centavosParaCorrecao > 0) {
                    if (centavosParaCorrecao > 0) {
                        parcelas.set(numeroDeCorrecoes, ((double) Math.round((parcelas.get(numeroDeCorrecoes) + 0.01) * 100)) / 100);
                        numeroDeCorrecoes++;
                    }
                    centavosParaCorrecao -= 0.01;

                }
            }
        }

        return parcelas;
    }

}