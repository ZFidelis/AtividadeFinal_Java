package view;
import java.io.IOException;
import java.util.ArrayList;

//#region Import
import controller.*;
import main.*;
import model.*;
import view.*;
//#endregion
public class Sistema {
    //#region unique execution

    public static void executar() {
        inicializar();

        int op;

        do {
            menuPrincipal();
            op = Console.lerInt();
            direcionarOpcaoPrincipal(op);
        } while (op != 0);

    }

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
        System.out.println("3) Excluir Professor");
        System.out.println("4) Menu Professor");
        System.out.println("5) Menu Aluno");
        System.out.println("6) Alterar meus Dados");
        System.out.println("7) Alterar Dados de Aluno");
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

    public static void menuAlterarDadosAdm() {
        System.out.println("\nALTERAR DADOS DE ADM");
        System.out.println("1) Alterar Nome");
        System.out.println("2) Alterar Senha");
        System.out.println("3) Alterar Nível de Acesso");
        System.out.println("0) Sair");
        System.out.print("Sua opção: ");
    }

    public static void menuAlterarDadosAluno() {
        System.out.println("\nALTERAR DADOS DE ALUNO");
        System.out.println("1) Alterar Nome");
        System.out.println("2) Alterar Senha");
        System.out.println("3) Alterar Matrícula");
        System.out.println("0) Sair");
        System.out.print("Sua opção: ");
    }
    public static void menuAlterarDadosProfessor(){
        
        System.out.println("\nALTERAR DADOS DO PROFESSOR");
        System.out.println("1) Alterar Nome");
        System.out.println("2) Alterar Registro");
        System.out.println("3) Alterar Senha");
        System.out.println("0) Voltar");
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

    public static void excluirProfessor() {
        System.out.print("\nDigite o nome do Professor que deseja Excluir: ");
        String professorNome = Console.lerString();
        Professor professor = GerenciadorProfessores.buscarProfessor(professorNome);

        GerenciadorProfessores.excluirProfessor(professor);
    }

    public static void passChange() {
    System.out.print("\nE-mail: ");
    String email = Console.lerString();

    // Verificar se o e-mail está registrado em alunos ou professores
    boolean emailEncontrado = GerenciadorAlunos.getAlunos().stream()
        .anyMatch(aluno -> aluno.getEmail().equalsIgnoreCase(email))
        || GerenciadorProfessores.getProfessores().stream()
        .anyMatch(professor -> professor.getEmail().equalsIgnoreCase(email));

    if (!emailEncontrado) {
        System.out.println("\nEste e-mail não está registrado no sistema.");
        return;
    }

    if (verificarIdentidade(email)) {
        System.out.println("\nInsira sua nova senha:");
        String novaSenha = Console.lerString();
        System.out.println("Senha alterada com sucesso!");
    } else {
        System.out.println("\nNão foi possível verificar sua identidade. Tente novamente mais tarde.");
    }

    public class ConfiguracaoSenha {
        private static String senhaAdministrador = "adm123";
    
        public static String getSenhaAdministrador() {
            return senhaAdministrador;
        }
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
                System.out.print("\nDigite a senha de administração: ");
                String senhaDigitada = Console.lerString();
        
                String senhaAdminStr = String.valueOf(ConfiguracaoSenha.getSenhaAdministrador());
        
                if (senhaDigitada.equals(senhaAdminStr)) {
                    System.out.println("Senha correta. Operações administrativas podem ser realizadas.");
                } else {
                    System.out.println("Senha de administração incorreta. Ação cancelada.");
                }
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
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
    public static void direcionarMenuAluno() {
        menuAluno();
        int opcao = Console.lerInt();

        switch (opcao) {
            case 1:
                listarCursos();
                break;
            case 2:
                entrarEmCurso();
                break;
            case 0:
                finalizar();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }
    public static void direcionarMenuProfessor() {
        menuAluno();
        int opcao = Console.lerInt();

        switch (opcao) {
            case 1:
                listarCursos();
                break;
            case 2:
                entrarEmCurso();
                break;
            case 0:
                finalizar();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }
    public static void direcionarMenuAdm() {
        menuAluno();
        int opcao = Console.lerInt();

        switch (opcao) {
            case 1:
                excluirCurso();
                break;
            case 2:
                excluirAluno();;
                break;
            case 3:
                excluirProfessor();
                break;
            case 4:
                menuProfessor();
                break;
            case 5:
                menuAluno();
                break;
            case 6:
                AlterarDadosAdm();
                break;
            case 7:
                AlterarDadosAluno();
                break;
            case 0:
                finalizar();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public static void AlterarDadosAdm(Administrador administrador){
       
        int opcao = Console.lerInt();
        switch (opcao) {
            case 1:
                System.out.print("Novo nome: ");
                String novoNome = Console.lerString();
                administrador.alterarNome(novoNome);
                System.out.println("Nome alterado com sucesso!");
                break;
            case 2:
                System.out.print("Novo registro: ");
                int novoRegistroAcesso = Console.lerInt();
                administrador.alterarRegistro(novoRegistroAcesso);
                System.out.println("Nivel de Acesso alterado com sucesso!");
                break;
            case 3:
                System.out.print("Nova senha: ");
                String novaSenha = Console.lerString();
                administrador.alterarSenha(novaSenha);
                System.out.println("Senha alterada com sucesso!");
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public static void alterarDadosProfessor(Professor professor){
       
        int opcao = Console.lerInt();
        switch (opcao) {
            case 1:
                System.out.print("Novo nome: ");
                String novoNome = Console.lerString();
                professor.alterarNome(novoNome);
                System.out.println("Nome alterado com sucesso!");
                break;
            case 2:
                System.out.print("Novo registro: ");
                int novoRegistro = Console.lerInt();
                professor.alterarRegistro(novoRegistro);
                System.out.println("Registro alterado com sucesso!");
                break;
            case 3:
                System.out.print("Nova senha: ");
                String novaSenha = Console.lerString();
                professor.alterarSenha(novaSenha);
                System.out.println("Senha alterada com sucesso!");
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

public static void verMeusCursos(Aluno aluno) {
        System.out.println("\nMEUS CURSOS");
        ArrayList<Curso> cursosMatriculados = aluno.getCursosMatriculados();

        if (cursosMatriculados.isEmpty()) {
            System.out.println("Você não está matriculado em nenhum curso.");
        } else {
            for (Curso curso : cursosMatriculados) {
                System.out.println(curso.dadosCurso());
            }
        }
    }

    public static void verMeusCursos(Professor professor) {
        System.out.println("\nMEUS CURSOS");
        
        ArrayList<Curso> cursosDoProfessor = new ArrayList<>();
    
        for (Curso curso : GerenciadorCursos.getListaCursos()) {
            if (curso.getNomeProfessor().equals(professor.getNome())) {
                cursosDoProfessor.add(curso);
            }
        }
        
        if (cursosDoProfessor.isEmpty()) {
            System.out.println("Você não está associado a nenhum curso.");
        } else {
            for (Curso curso : cursosDoProfessor) {
                System.out.println(curso.dadosCurso());
            }
        }
    }
  
    public static void verificarTipoUsuario(){
        boolean emailAluno = GerenciadorAlunos.getAlunos().stream()
        .anyMatch(aluno -> aluno.getEmail().equalsIgnoreCase(email));

        boolean emailProfessor = GerenciadorProfessores.getProfessores().stream()
        .anyMatch(professor -> professor.getEmail().equalsIgnoreCase(email));

        boolean emailAdm = GerenciadorAdministradores.getAdministradores().stream()
        .anyMatch(administrador -> administrador.getEmail().equalsIgnoreCase(email));

        if (!emailAluno) {
            menuAluno();
            direcionarMenuAluno();
            return;
        }

        if (!emailProfessor) {
            menuProfessor();
            return;
        }

        if (!emailAdm) {
            menuAdm();
            return;
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

        verificarTipoUsuario(email);
    }
}
