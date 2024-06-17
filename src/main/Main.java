package main;
//#region Import
// import controller.*;
// import model.*;
import view.*;
//#endregion

public class Main {
    public static void main(String[] args) {
        int val = Console.gerarCodigoVerificacao();
        System.out.println(val);
    }
}
