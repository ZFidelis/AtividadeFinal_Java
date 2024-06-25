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
    
    public Administrador(String nome, String email, String senha) {
        super(nome, email, senha);
    }
    //#endregion
    //#region Getters & Setters

    //#endregion
    //#region Methods
    public String dadosAdministrador() {
        return super.dadosUsuario();
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
    //#endregion
    //#region String Manipulation
    @Override
    public String toString() {
        return super.toString();
    }

    public static Administrador fromString(String linha) {
        String[] dadosAdministrador = linha.split(", ");

        return new Administrador(dadosAdministrador[0], dadosAdministrador[1], dadosAdministrador[2]);
    }
    //#endregion
}
