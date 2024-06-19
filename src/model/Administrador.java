package model;
//#region Import
import controller.*;
import model.*;
import view.*;
//#endregion

public class Administrador extends Usuario {
    private int nivelAcesso;

    //#region Constructors
    public Administrador(String nome, String email, String senha, int nivelAcesso) {
        super(nome, email, senha);
        this.nivelAcesso = nivelAcesso;
    }
    //#endregion
    //#region Getters & Setters
    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
    //#endregion
    //#region Methods
    public void criarCurso() {

    }

    public void removerCurso() {

    }
    //#endregion

}
