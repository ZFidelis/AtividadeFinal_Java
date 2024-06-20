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
    //#region Methods
    
    public String dadosCurso() {
        return "Nome: " + nome + "\nEmail: " + email + "\nSenha: " + senha;
    }
    //#endregion
    //#region String Manipulation
    @Override
    public String toString() {
        return nome + ", " + email +  ", " + senha;
    }

    public static Aluno fromString(String linha) {
        String[] dadosAluno = linha.split(", ");

        return new Aluno(dadosAluno[0], dadosAluno[1], Integer.parseInt(dadosAluno[2]), dadosAluno[3]);
    }
    //#endregion
}
