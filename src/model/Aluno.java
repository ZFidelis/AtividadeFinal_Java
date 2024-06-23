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
    public void entrarCurso(String nomeCurso) {
        
    }

    public String dadosAluno() {
        return super.dadosUsuario() + "\nMatricula: " + matricula;
    }
    //#endregion
    //#region String Manipulation
    @Override
    public String toString() {
        return super.toString() + ", " + matricula;
    }

    public static Aluno fromString(String linha) {
        String[] dadosAluno = linha.split(", ");

        return new Aluno(dadosAluno[0], dadosAluno[1], dadosAluno[2], Integer.parseInt(dadosAluno[3]));
    }
    //#endregion
}
