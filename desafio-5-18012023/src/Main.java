import javax.xml.crypto.Data;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;


/*5) Tendo a estrutura de dados abaixo

        CodFuncionario : Inteiro
        Nome : String
        ValorSalario : String
        DataAdmissao : Date

        Leia uma lista desses funcionário até que seja informado o CodFuncionario igual a zero, após concluir a leitura apresentar :

        a) Total de funcionarios
        b) Lista completa de funcionários mostrando o tempo de empresa de cada um deles (Data Atual - Data de Admissão)
        c} Soma dos Salário
        d) Média dos Salários
        e) Mostrar os dados do Maior e do Menor Salário
*/
public class Main {
    public static void main(String[] args) {
        int CodFuncionarioScanner = 1;
        String Nome;
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
        double somaDosSalarios= 0;

        while (CodFuncionarioScanner != 0 ) {


            System.out.print("Digite um codigo de Funcionario:");
            Scanner scanner = new Scanner(System.in);
            while(!scanner.hasNextInt()) {

                System.out.print("Digite um codigo de Funcionario:");
                scanner = new Scanner(System.in);
            }
            CodFuncionarioScanner= scanner.nextInt();
            if (CodFuncionarioScanner != 0) {




                System.out.print("Digite o nome desse Funcionario:");
                Scanner nomeScanner = new Scanner(System.in);
                Nome = nomeScanner.nextLine();
             while(!((Nome.getClass().getSimpleName()).equals("String"))){
                    System.out.print("Digite o nome desse Funcionario:");
                    nomeScanner = new Scanner(System.in);
                    Nome = nomeScanner.nextLine();
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                System.out.println("Digite a data de admissao do funcionario: ");
                Scanner dataAdmissaoScanner = new Scanner(System.in);
                String DataAdmissao = dataAdmissaoScanner.nextLine();
                while(!((DataAdmissao.getClass().getSimpleName()).equals("String")) ){
                    System.out.println("Digite a data de admissao do funcionario: ");
                     dataAdmissaoScanner = new Scanner(System.in);
                    DataAdmissao = dataAdmissaoScanner.next();
                }

                while(DataAdmissao.length()<10){
                    System.out.println("Digite a data de admissao do funcionario: ");
                    dataAdmissaoScanner = new Scanner(System.in);
                    DataAdmissao = dataAdmissaoScanner.next();
                }

                System.out.print("Digite o salário desse funcionário:");

                Scanner scannerSalario = new Scanner(System.in);
                double salarioDoFuncionario=0;
                while(!scannerSalario.hasNextDouble()) {
                    System.out.print("Digite o salário desse funcionário:");
                    scannerSalario = new Scanner(System.in);
                }
                salarioDoFuncionario = scannerSalario.nextDouble();
                somaDosSalarios += salarioDoFuncionario;
/*
                double  correcaoDeBissextos= 0;
                double tempAnos = anos;
            for(int x=0; x<tempAnos; x++) {
                if ((x % 4 == 0) && (x % 100 != 0) || (x % 400 == 0)) {
                    correcaoDeBissextos++;
                }

            }
                double dias = correcaoDeBissextos+ (dataDaAdmissaoLocalTime.until(hoje, ChronoUnit.DAYS))-   anos*365;
                System.out.println(anos);
                System.out.println(meses);
                System.out.println(dias);
  */
                listaFuncionarios = adicionaFuncionarios(listaFuncionarios, CodFuncionarioScanner, Nome, DataAdmissao, salarioDoFuncionario);
            }
        }
        System.out.print("Total de funcionários: " +listaFuncionarios.size() + '\n\n');
        System.out.println("Funcionários: \n" + mostraTodosOsFuncionarios(listaFuncionarios));
        System.out.println("A soma dos salários é " + somaDosSalarios+ " reais. \n");
        System.out.println("A média dos salários é " + somaDosSalarios/listaFuncionarios.size() + " reais.");
        System.out.println("O menor salário é " + pegaMenorSalario(listaFuncionarios) + " reais e o maior é " + pegaMaiorSalario(listaFuncionarios) + ".");

    }
    public static class Funcionario {
        private final int codigo;
        private final String nome;
        private final String datadeadmissao;
        private final double salario;
        public Funcionario(int codigo, String nome, String datadeadmissao, double salario) {
            this.codigo = codigo;
            this.nome = nome;
            this.datadeadmissao = datadeadmissao;
            this.salario= salario;
        }
    }
    public static ArrayList<Funcionario> adicionaFuncionarios(ArrayList lista, int codigo, String nome, String datadeadmissao, double salario) {
        Funcionario myObject = new Funcionario(codigo, nome, datadeadmissao, salario);
        lista.add(myObject);
        return lista;
    }

    public static LocalDateTime transformaData(String DataAdmissao){
        int diaDaAdmissao = Integer.valueOf(DataAdmissao.substring(0, 2));
        int mesDaAdmissao = Integer.valueOf(DataAdmissao.substring(3, 5));
        int anoDaAdmissao = Integer.valueOf(DataAdmissao.substring(6, 10));

        LocalDateTime dataFormatada = LocalDateTime.of(anoDaAdmissao, mesDaAdmissao, diaDaAdmissao, 0, 0);

        return dataFormatada;
    }
    public static String mostraTodosOsFuncionarios(ArrayList<Funcionario> listaFuncionarios) {
       String resultado = "";
   double anos =0;
   double meses=0;
        for(int x=0; x<listaFuncionarios.size(); x++) {
            LocalDateTime dataDaAdmissaoLocalTime = transformaData(listaFuncionarios.get(x).datadeadmissao);
            LocalDateTime hoje = LocalDateTime.now();
             anos = dataDaAdmissaoLocalTime.until(hoje, ChronoUnit.YEARS);
             meses = (dataDaAdmissaoLocalTime.until(hoje, ChronoUnit.MONTHS)) - anos * 12;
            resultado += "Código: " + (listaFuncionarios.get(x)).codigo + "\nNome: " +
                    "\nTempo na empresa: " + anos + " anos e " + meses + " meses.\n\n";
        }

        return resultado;
    }

    public static double pegaMenorSalario(ArrayList<Funcionario> listaFuncionarios){
        double menor = listaFuncionarios.get(0).salario;
        for(int x=0; x<listaFuncionarios.size(); x++){
            if(listaFuncionarios.get(x).salario< menor){
                menor= listaFuncionarios.get(x).salario;
            }
        }
        return menor;
    }

    public static double pegaMaiorSalario(ArrayList<Funcionario> listaFuncionarios){
        double maior = listaFuncionarios.get(0).salario;
        for(int x=0; x<listaFuncionarios.size(); x++){
            if(listaFuncionarios.get(x).salario>maior){
                maior= listaFuncionarios.get(x).salario;
            }
        }
        return maior;
    }
}