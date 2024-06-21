package model;
//#region Import
import controller.*;
import model.*;
import view.*;
import java.util.List;
import java.util.ArrayList;
//#endregion

public class Professor extends Usuario {
    private int registro;

    //#region Constructors
    public Professor(String nome, String email, String senha, int registro) {
        super(nome, email, senha);
        this.registro = registro;
    }
    //#endregion
    //#region Getters & Setters
    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }
    //#endregion
    //#region Methods
    
    public String dadosProfessor() {
        return super.dadosUsuario() + "\nMatricula: " + registro;
    }
    //#endregion
    //#region String Manipulation
    @Override
    public String toString() {
        return super.toString() + ", " + registro;
    }
    public static Professor fromString(String linha) {
        String[] dadosProfessor = linha.split(", ");

        return new Professor(dadosProfessor[0], dadosProfessor[1], Integer.parseInt(dadosProfessor[2]), dadosProfessor[3]);
    }
    //#endregion
}
