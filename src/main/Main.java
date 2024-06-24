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
    
    public static void manter() {
        Sistema.inicializar();
        
        // Aluno a = new Aluno("Isaac", "isaac@h", "icaas", 123);
        // Aluno b = new Aluno("Isaac", "isaac@h", "icaas", 1234);
        // GerenciadorAlunos.adicionarAluno(a);
        // GerenciadorAlunos.adicionarAluno(b);
        // System.out.println(GerenciadorCursos.getListaCursos());
        // Curso c1 = new Curso("Aulas Java", "Aulas sobre backend intermedi rio utilizando Java como linguagem de programa  o", 220, "Jason Sobreiro");
        // Curso c = new Curso("Design Software", "Aula sobre design de software", 230, "O Melhor");
        // GerenciadorCursos.adicionarCurso(c1);
        // GerenciadorCursos.adicionarCurso(c);
        // a.entrarCurso("Aulas Java");
        // b.entrarCurso("Aulas Java");
        // b.entrarCurso("Design Software");
        // System.out.println(GerenciadorCursos.getListaCursos());
        Curso c = GerenciadorCursos.buscarCursos("Aulas Java");
        Curso c1 = GerenciadorCursos.buscarCursos("Design Software");
        // Aluno a = GerenciadorAlunos.buscarAluno(123);
        c.mostrarAlunos();
        c1.mostrarAlunos();
        Sistema.finalizar();

    }
}
