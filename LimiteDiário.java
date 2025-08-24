import java.util.InputMismatchException;
import java.util.Scanner;


public class LimiteDiário {
    public static void main(String [] args) {

        double saldo = 2200;
        double saque_diario = 0.0;
        double limite_saque_diario= 2000.0;

        Scanner leitor = new Scanner(System.in);
        int opcao = 0;

        do{
            System.out.println("Escolha uma das seguintes opções \n" +
                    "1 para verificar saldo \n " +
                    "2 para guardar dineiro \n " +
                    "3 para sacar dinheir \n" +
                    "4 para sair");

            try{opcao = leitor.nextInt();}catch(InputMismatchException e){
                System.out.println("erro, por favor escolha um numero de 1 até 4");
                leitor.nextLine();
                continue;
            }

            switch (opcao){
                case 1:
                    System.out.println("Seu saldo é de: " + saldo + ".");
                    break;

                case 2:
                    System.out.println("quanto você gostaaria de guardar?");
                    try{
                        double deposito = leitor.nextDouble();
                        if (deposito > 0){
                            saldo = saldo + deposito;
                            System.out.println(" seu novo saldo é de: " + saldo + ".");
                        }
                        else System.out.println("tipo de valor invalido");

                    }catch (InputMismatchException e){
                        System.out.println("Por favor digite um número");
                        leitor.nextLine();
                    }
                    break;
                case 3:
                    System.out.println("quanto gostaria de sacar?");
                    try{
                        double saque = leitor.nextDouble();

                        if (saque < 0){
                            System.out.println("Saque invalidado, use apenas números posítivos");
                        }
                        else if (saque > limite_saque_diario) {
                            System.out.println("Seu saque foi inválidado pois sua tentativa de saque de " + saque + " foi acima do limite diario de " + limite_saque_diario);
                        }
                        else if (saque > saldo){
                            System.out.println("saque inválido pois sua tentativa de saque de " + saque + " é maior que seu saldo de " + saldo);
                        }
                        else if (saque_diario > limite_saque_diario){
                            System.out.println("erro você tentou sacar " + saque_diario + " mas o seu limite de saque diário é de: " + limite_saque_diario);
                        }
                        else {
                            saque_diario = saque_diario + saque;
                            saldo = saldo - saque;

                            System.out.println("Seu saque de: " + saque + "foi realizado com sucesso e o seu saldo é de " + saldo);
                            System.out.println("Seu limite diario de saque é de " + limite_saque_diario + " \n você já sacou " + saque + " você ainda pode sacar" + (limite_saque_diario - saque_diario));
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("erro, tente numeros");
                        leitor.nextLine();

                    }
                    break;
                case 4:
                    System.out.println("saindo...");
                    break;
                default:
                    System.out.println("erro, por favor digite valores de 1 até 4");

            }
        }while(opcao != 4);
        leitor.close();

    }
}