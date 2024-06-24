package model;
//#region Import
import controller.*;
import model.*;
import view.*;
import java.util.List;
import java.util.ArrayList;
//#endregion

public class Curso {
    private String titulo;
    private String descricao;
    private int duracao;
    private String nomeProfessor;
    private ArrayList<Aluno> alunosInscritos = new ArrayList<>();

    //#region Constructors
    public Curso() {

    }

    public Curso(String titulo, String descricao, int duracao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.duracao = duracao;
    }
    
    public Curso(String titulo, String descricao, int duracao, String nomeProfessor) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.duracao = duracao;
        this.nomeProfessor = nomeProfessor;
    }
    //#endregion
    //#region Getter & Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setProfessor(String professor) {
        this.nomeProfessor = professor;
    }
    //#endregion
    //#region Methods
    public void inserirAluno(Aluno aluno) {
        alunosInscritos.add(aluno);
    }

    public void deletarAluno(Aluno aluno) {
        alunosInscritos.remove(aluno);
    }

    public String dadosCurso() {
        return "Título: " + titulo + " (" + duracao + "h)" + "\nDescrição: " + descricao + "\nProfessor: " + nomeProfessor;
    }
    //#endregion
    //#region String Manipulation
    @Override
    public String toString() {
        String listaAlunos = "";
        for (Aluno aluno : alunosInscritos) {
            listaAlunos += "; " + aluno.getMatricula();
        }
        return titulo + ", " + descricao + ", " + duracao + ", " + nomeProfessor + ", Alunos(RGM) maticulados: ";
    }

    public static Curso fromString(String linha) {
        String[] dadosCurso = linha.split(", ");

        return new Curso(dadosCurso[0], dadosCurso[1], Integer.parseInt(dadosCurso[2]), dadosCurso[3]);
    }
    //#endregion
}
