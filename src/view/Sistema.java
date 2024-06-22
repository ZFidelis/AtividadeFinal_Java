package view;

public class Sistema {

    public static void executar(){
        inicializar();
    }
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
    //#endregion
    //#region Initial Page
    public static void signIn() {
        System.out.print("\nE-mail: ");
        String email = Console.lerString();
        System.out.print("Senha: ");
        String senha = Console.lerString();
        verificarIdentidade(email);

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
                String matricula = Console.lerString();
                Aluno aluno = new Aluno(nome, email, senha, matricula);
                GerenciadorAlunos.adicionarAluno(aluno);
                break;
            case 2: 
                System.out.print("\nRegistro: ");
                String registro = Console.lerString();
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
        int tentativas = 0;
        // enviar código para o email digitado
        System.out.println("\nCódigo de Verificação foi enviado para seu email");
        do {
            System.out.print("\n\nDigite o código recebido: ");
            codigoDigitado = Console.lerInt();
            if (codigoDigitado == codigo || tentativas > 3) {
                break;
            }
            tentativas+=1;
            System.out.println("Código Inválido");
        } while (true);
        
        if (tentativas > 3) {
            System.out.println("\nCódigo Inválido 3 vezes!");
            System.out.println("Conta bloqueada, por motivos de segurança enviar email para suporte@cursosUP.com.br");
            finalizar();
        }

        System.out.println("\nVerificação Concluída!");
    }
}
