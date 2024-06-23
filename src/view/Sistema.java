package view;
import java.io.IOException;

//#region Import
import controller.*;
import main.*;
import model.*;
import view.*;
//#endregion
public class Sistema {
    //#region unique execution
    public static void inicializar() {
        try {
            GerenciadorCursos.carregarCursos();
            GerenciadorAlunos.carregarAlunos();
            GerenciadorProfessores.carregarProfessores();
            System.out.println("\nDados carregados com sucesso!");
            System.out.println("Programa Iniciado!\n\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void finalizar() {
        try {
            GerenciadorCursos.manterCursos();
            GerenciadorAlunos.manterAlunos();
            GerenciadorProfessores.manterProfessores();
            System.out.println("\nDados salvos com sucesso!");
            System.out.println("Sistema Finalizado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //#endregion
    //#region Menus
    public static void menuPrincipal() {

        System.out.println("\nPLATAFORMA DE CURSOS ONLINE");
        System.out.println("1) Entrar");
        System.out.println("2) Criar Conta");
        System.out.println("3) Esqueceu a Senha");
        System.out.println("0) Sair");
        System.out.print("Sua opção: ");
    }

    public static void menuTiposCadastro() {

        System.out.println("1) Aluno");
        System.out.println("2) Professor");
        System.out.println("3) Administrador");
        System.out.println("0) Cancelar");
        System.out.print("Sua opção: ");
    }

    public static void menuAdm() {
        System.out.println("\nPLATAFORMA DO ADM");
        System.out.println("1) Excluir Curso");
        System.out.println("2) Excluir Aluno");
        System.out.println("3) Menu Professor");
        System.out.println("4) Menu Aluno");
        System.out.println("5) Alterar Dados");
        System.out.println("0) Sair");
        System.out.print("Sua opção: ");
    }

    public static void menuProfessor() {
        System.out.println("\nPLATAFORMA DO PROFESSOR");
        System.out.println("1) Cadastrar Curso");
        System.out.println("2) Ver meus Cursos");
        System.out.println("3) Alterar Dados");
        System.out.println("0) Sair");
        System.out.print("Sua opção: ");
    }

    public static void menuAluno() {
        System.out.println("\nPLATAFORMA DO ALUNO");
        System.out.println("1) Ver meus Cursos");
        System.out.println("2) Entrar em algum Curso");
        System.out.println("3) Alterar Dados");
        System.out.println("0) Sair");
        System.out.print("Sua opção: ");
    }

    public static void menuCursoProfessor() {
        System.out.println("\nMENU DE CURSOS DO PROFESSOR");
        System.out.println("1) Selecionar Curso");
        System.out.println("0) Sair");
        System.out.print("Sua opção: ");
    }

    public static void menuEditarCurso() {
        System.out.println("\nEDITAR CURSO");
        System.out.println("1) Remover Aluno do Curso");
        System.out.println("2) Alterar Dados do Curso");
        System.out.println("0) Sair");
        System.out.print("Sua opção: ");
    }


    //#endregion
    //#region Cadastros
    public static void CadastrarCurso() {
        System.out.println("\nNovo Curso:");
        System.out.print("Informe o título: ");
        String titulo = Console.lerString();
        System.out.print("Informe a Descrição: ");
        String descricao = Console.lerString();
        System.out.print("Informe a Duração: ");
        int duracao = Console.lerInt();
        System.out.print("Informe seu Nome: ");
        String nomeProfessor = Console.lerString();
        Curso curso = new Curso(titulo, descricao, duracao, nomeProfessor);

        GerenciadorCursos.adicionarCurso(curso);

        System.out.println("\nCurso Criado com sucesso");
    }

    public static void signUp() {
        System.out.print("\nE-mail: ");
        String email = Console.lerString();
        verificarIdentidade(email);
        System.out.print("\nNome: ");
        String nome = Console.lerString();
        System.out.print("Senha: ");
        String senha = Console.lerString();
        menuTiposCadastro();
        int op = Console.lerInt();
        cadastrarUsuario(op,nome,email,senha);

    }
    ////#endregion
    //#region Initial Page
    public static void signIn() {
        System.out.print("\nE-mail: ");
        String email = Console.lerString();
        System.out.print("Senha: ");
        String senha = Console.lerString();
        verificarIdentidade(email);

    }

    public static void excluirCurso() {
        System.out.print("\nDigite o nome do Curso que deseja Excluir: ");
        String cursoNome = Console.lerString();
        Curso curso = GerenciadorCursos.buscarCursos(cursoNome);

        GenciadorCursos.excluirCurso(curso);
    }

    public static void excluirAluno() {
        System.out.print("\nDigite o nome do Aluno que deseja Excluir: ");
        String alunoNome = Console.lerString();
        Aluno aluno = GerenciadorAlunos.buscarAluno(alunoNome);

        GerenciadorAlunos.excluirAluno(aluno);
    }

    public static void passChange() {
        System.out.print("E-mail: ");
        String email = Console.lerString();
        verificarIdentidade(email);
    }
    //#endregion
   
    public static void cadastrarUsuario(int op, String nome, String email, String senha) {
        switch (op) {
            case 0:
                menuPrincipal();
                break;
            case 1:
                System.out.print("\nMatrícula: ");
                int matricula = Console.lerInt();
                Aluno aluno = new Aluno(nome, email, senha, matricula);
                GerenciadorAlunos.adicionarAluno(aluno);
                break;
            case 2: 
                System.out.print("\nRegistro: ");
                int registro = Console.lerInt();
                Professor professor = new Professor(nome, email, senha, registro);
                GerenciadorProfessores.adicionarProfessor(professor);
                break;
            case 3:
                // criar verificação muito segura (happyface)
            default:
                break;
        }
    }

    public static void direcionarOpcaoPrincipal(int op) {
        switch (op) {
            case 0:
                finalizar();
                break;
            case 1:
                signIn();
                break;
            case 2:
                signUp();
                break;
            case 3:
                passChange();
                break;
            default:
                break;
        }
    }




    public static void verificarIdentidade(String email) {
        int codigo = Console.gerarCodigoVerificacao();
        int codigoDigitado;
        int tentativas = 1;
        // enviar código para o email digitado
        System.out.println("\nCódigo de Verificação foi enviado para seu email");
        System.out.println("Seu código: " + codigo);
        do {
            System.out.print("\n\nDigite o código recebido: ");
            codigoDigitado = Console.lerInt();
            if (codigoDigitado == codigo || tentativas > 2) {
                break;
            }
            tentativas+=1;
            System.out.println("Código Inválido");
        } while (true);
        
        if (tentativas >= 3) {
            System.out.println("\nCódigo Inválido 3 vezes!");
            System.out.println("Conta bloqueada, por motivos de segurança enviar email para suporte@cursosUP.com.br");
            finalizar();
            return;
        }

        System.out.println("\nVerificação Concluída!");
    }
}
