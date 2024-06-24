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

    //Metodo alterar dados Professor
    public String dadosProfessor() {
        return super.dadosUsuario() + "\nMatricula: " + registro;
    }

    public void alterarNome(String novoNome) {
        this.setNome(novoNome);
    }

   
    public void alterarSenha(String novaSenha) {
        this.setSenha(novaSenha);
    }

    public void alterarRegistro(int novoRegistro) {
        this.setRegistro(novoRegistro);
    }
    //#endregion
    //#region String Manipulation
    @Override
    public String toString() {
        return super.toString() + ", " + registro;
    }
    public static Professor fromString(String linha) {
        String[] dadosProfessor = linha.split(", ");

        return new Professor(dadosProfessor[0], dadosProfessor[1], dadosProfessor[2], Integer.parseInt(dadosProfessor[3]));
    }
    //#endregion
}