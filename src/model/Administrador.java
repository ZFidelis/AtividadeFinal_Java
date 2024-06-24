package model;
//#region Import
import controller.*;
import model.*;
import view.*;
//#endregion

public class Administrador extends Usuario {
    private int nivelAcesso;

    //#region Constructors
    public Administrador() {

    }
    
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
        System.out.println("\nCRIAÇÃO DE NOVO CURSO");
        System.out.print("Informe o título do curso: ");
        String titulo = Console.lerString();
        System.out.print("Informe a descrição do curso: ");
        String descricao = Console.lerString();
        System.out.print("Informe a duração do curso (em horas): ");
        int duracao = Console.lerInt();
        String nomeProfessor = this.getNome(); 
        Curso curso = new Curso(titulo, descricao, duracao, nomeProfessor);
        GerenciadorCursos.adicionarCurso(curso);
        System.out.println("\nCurso criado com sucesso!");
    }

    public void removerCurso() {
        System.out.println("\nREMOÇÃO DE CURSO");
        System.out.print("Informe o título do curso que deseja remover: ");
        String tituloCurso = Console.lerString();
        Curso cursoRemover = null;
        for (Curso curso : GerenciadorCursos.getListaCursos()) {
            if (curso.getTitulo().equalsIgnoreCase(tituloCurso)) {
                cursoRemover = curso;
                break;
            }
        }
        if (cursoRemover != null) {
            GerenciadorCursos.getListaCursos().remove(cursoRemover);
            System.out.println("\nCurso removido com sucesso!");
        } 
        else {
            System.out.println("\nCurso não encontrado. Verifique o título informado.");
        }
    }

    public void alterarNome(String novoNome) {
        this.setNome(novoNome);
    }
   
    public void alterarSenha(String novaSenha) {
        this.setSenha(novaSenha);
    }
    
    public void alterarRegistro(int novoRegistroAcesso) {
        this.setNivelAcesso(novoRegistroAcesso);
    }
    //#endregion
    //#region String Manipulation
    @Override
    public String toString() {
        return super.toString() + ", " + nivelAcesso;
    }

    public static Administrador fromString(String linha) {
        String[] dadosAdministrador = linha.split(", ");

        return new Administrador(dadosAdministrador[0], dadosAdministrador[1], dadosAdministrador[2], Integer.parseInt(dadosAdministrador[3]));
    }
    //#endregion
}