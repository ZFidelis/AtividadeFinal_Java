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

    public Curso(String titulo, String descricao, int duracao, String nomeProfessor, ArrayList<Aluno> alunosRegistrados) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.duracao = duracao;
        this.nomeProfessor = nomeProfessor;
        this.alunosInscritos = alunosRegistrados;
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
    
    public ArrayList<Aluno> getAlunosInscritos() {
        return alunosInscritos;
    }

    public void setAlunosInscritos(ArrayList<Aluno> alunosInscritos) {
        this.alunosInscritos = alunosInscritos;
    }
    //#endregion
    //#region Methods
    public String dadosCurso() {
        return "Título: " + titulo + " (" + duracao + "h)" + "\nDescrição: " + descricao + "\nProfessor: " + nomeProfessor;
    }

    public void adicionarAluno(Aluno aluno) {
        alunosInscritos.add(aluno);
    }

    public void mostrarAlunos() {
        for (Aluno aluno : alunosInscritos) {
            System.out.println(aluno.dadosAluno());
            System.out.println();
        }
    }
    //#endregion
    //#region String Manipulation
    @Override
    public String toString() {
        String matriculasAlunos = "";
        for (Aluno aluno : alunosInscritos) {
            matriculasAlunos += aluno.getMatricula() + "; ";
        }

        return titulo + ", " + descricao + ", " + duracao + ", " + nomeProfessor + ", Alunos Matriculados, " + matriculasAlunos;
    }

    public static Curso fromString(String linha) {
        String[] dadosCurso = linha.split(", ");

        String titulo = dadosCurso[0];
        String descricao = dadosCurso[1];
        int duracao = Integer.parseInt(dadosCurso[2]);
        String nomeProfessor = dadosCurso[3];

        ArrayList<Aluno> listaAlunos = new ArrayList<>();
        if (dadosCurso.length > 5) {
            String[] alunosRegistrados = dadosCurso[5].split("; ");
            for (String alunoId : alunosRegistrados) {
                System.out.println(Integer.parseInt(alunoId));
                Aluno tempAluno = GerenciadorAlunos.buscarAluno(Integer.parseInt(alunoId));
                System.out.println(tempAluno);
                listaAlunos.add(tempAluno);
            }
            System.out.println(listaAlunos);
        }
        return new Curso(titulo, descricao, duracao, nomeProfessor, listaAlunos);
    }
    //#endregion
}
