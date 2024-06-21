package view;
//#region Import
import java.util.InputMismatchException;
import java.util.Scanner;
import java.security.SecureRandom;
//#endregion

public class Console {
    
    
    private static Scanner scanner = new Scanner(System.in);
    private static SecureRandom secureRandom = new SecureRandom();

    public static int lerInt(){
        int valor = 0;

        while(true){
            try {
                valor = scanner.nextInt();
                break;
            
            } catch (InputMismatchException e) {
                System.out.println("O valor informado não é um inteiro. Digite novamente: ");

            }
            finally {
                scanner.nextLine();

            }
        }
        return valor;
    }

    public static float lerFloat() {
        float valor = 0;

        while (true) {
            try {
                valor = scanner.nextFloat();
                scanner.nextLine();
                break;

            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("O valor informado não é um 'float'. Digite novamente: ");
            }
        }
        return valor;
    }

    public static String lerString() {
        return scanner.nextLine();
    }

    // Função à seguir será utilizada apenas para criação de código aleatório
    public static int gerarCodigoVerificacao(){
        int codigoV;
        int min = 100000;
        int max = 999999;

        codigoV = secureRandom.nextInt(max-min) + min;
        return codigoV;
    }

}