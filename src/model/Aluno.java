package model;
//#region Import
import controller.*;
import model.*;
import view.*;
//#endregion

public class Aluno extends Usuario {
    private int matricula;

    //#region Contructors
    public Aluno(String nome, String email, String senha, int matricula) {
        super(nome, email, senha);
        this.matricula = matricula;
    }
    //#endregion
    //#region Getters & Setters
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    //#endregion

}
