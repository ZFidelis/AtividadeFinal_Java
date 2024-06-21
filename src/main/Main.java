package main;
//#region Import
import controller.*;
import model.*;
import view.*;
//#endregion

public class Main {
    public static void main(String[] args) {
        Sistema.inicializar();
        int selecao = 1;
        
        while(selecao != 0) {
            Sistema.menuPrincipal();
            selecao = Console.lerInt();
            Sistema.direcionarOpcaoPrincipal(selecao);

        }
    }
}
