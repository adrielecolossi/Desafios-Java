
/*
4) Dado um determinado texto responda as seguintes perguntas :
    a) quantidade de caracteres descontando os espaços
    b) quantidade de palavras
    c) cada palavra e o nro de vezes que ela aparece no texto
    d) escrever o texto na ordem inversa
    e) escrever o texto, palavra por palavra na ordem inversa

*/


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Digite uma frase: ");
        Scanner scanner = new Scanner(System.in);
        String frase = scanner.nextLine();
        while(frase==""){
            System.out.println("Digite uma frase: ");
            scanner = new Scanner(System.in);
           frase = scanner.nextLine();
        }
        System.out.println("Número de caracteres sem espaço: " + contaCaracteresSemEspacos(String.valueOf(frase)) + '\n');
        System.out.println("Quantidade de palavras: " + contaQuantidadeDePalavras(String.valueOf(frase)) + '\n');
        System.out.println(mostraPalavrasEAparecimentos(String.valueOf(frase)));
        System.out.println("A frase invertida letra por letra é : " + transformaTextoAoContrarioLetraPorLetra(String.valueOf(frase) ) +"\n");
        System.out.println("A frase invertida palavra por palavra é : " + transformaTextoAoContrarioLetraPorPalavra(String.valueOf(frase)) );
    }

    public static double contaCaracteresSemEspacos(String frase) {
        double contadorDeLetras = 0;
        for (int x = 0; x < frase.length(); x++) {
            if (!Character.isWhitespace((frase).charAt(x))) {
                contadorDeLetras++;
            }
        }
        return contadorDeLetras;
    }

    public static double contaQuantidadeDePalavras(String frase) {
        double contadorDePalavras = 0;
        frase.trim();
        String[] partesDaFrase = (frase).split(" ");
        for (int x = 0; x < partesDaFrase.length; x++) {
            if (partesDaFrase[x].length() > 0) {
                contadorDePalavras++;
            }
        }
        return contadorDePalavras;
    }

    public static String mostraPalavrasEAparecimentos(String frase) {
        ArrayList<String> palavras = new ArrayList<String>();
        String resultadoGeral = "";
        double quantidadeDeVezesQueAparece = 0;
        ArrayList<String> palavrasQueJaApareceram = new ArrayList<String>();
        frase.trim();
        String[] partes = (frase).split(" ");
        for (int x = 0; x < partes.length; x++) {
            if (partes[x].length() > 0) {
                palavras.add(partes[x]);
            }
        }
        for (String palavra : palavras) {
            quantidadeDeVezesQueAparece = 0;
            if (!palavrasQueJaApareceram.contains(palavra)) {
                for (int x = 0; x < palavras.size(); x++) {
                    if (palavras.get(x).equals(palavra)) {
                        quantidadeDeVezesQueAparece++;
                    }
                }
                palavrasQueJaApareceram.add(palavra);
                resultadoGeral = resultadoGeral + "A palavra " + palavra + " aparece " + quantidadeDeVezesQueAparece + " vezes.\n";
            }
        }

        return (resultadoGeral);
    }


    public static String transformaTextoAoContrarioLetraPorLetra(String frase) {
        StringBuilder frasePorStringBuilder = new StringBuilder();
        frasePorStringBuilder.append(frase);
        frasePorStringBuilder.reverse();
        String fraseInvertidaLetraPorLetra = frasePorStringBuilder.toString();
        return fraseInvertidaLetraPorLetra;
    }

    public static String transformaTextoAoContrarioLetraPorPalavra(String frase) {
        ArrayList<String> palavras = new ArrayList<String>();
        String fraseInvertidaPalavraPorPalavra = "";
        frase.trim();
        String[] partes = (frase).split(" ");
        for (int x = 0; x < partes.length; x++) {
            palavras.add(partes[x]);
        }
        for (int x = palavras.size() - 1; x >= 0; x--) {
            fraseInvertidaPalavraPorPalavra = fraseInvertidaPalavraPorPalavra + palavras.get(x) + " ";
        }
        return fraseInvertidaPalavraPorPalavra;
    }
}
