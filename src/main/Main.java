package main;
//#region Import
import controller.*;
import model.*;
import view.*;
//#endregion

public class Main {
    public static void main(String[] args) {
        Sistema.inicializar();
        Sistema.executar();
        Sistema.finalizar();
    }
}
