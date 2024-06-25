package controller;
//#region Import
import controller.*;
import model.*;
import view.*;
import java.io.*;
import java.util.ArrayList;
//#endregion
public class GerenciadorAlunos {
    private static final File ALUNOS_REGISTRADOS = new File("src/database/alunos.txt");
    private static ArrayList<Aluno> listaAlunos = new ArrayList<>();

    //#region File Manipulation
    public static ArrayList<Aluno> carregarAlunos() throws IOException {
        try (FileReader fr = new FileReader(ALUNOS_REGISTRADOS);BufferedReader br = new BufferedReader(fr)) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    Aluno aluno = Aluno.fromString(linha);
                    listaAlunos.add(aluno);
                }
        } 
        System.out.println("Os Alunos foram Carregados!");
        return listaAlunos;
    }

    public static void manterAlunos() throws IOException {      
        for (Aluno aluno : listaAlunos) {
            try(FileWriter fw = new FileWriter(ALUNOS_REGISTRADOS);BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(aluno + "\n");
            }
        }
    }
    //#endregion
    //#region ArrayList Manipulation
    public static void adicionarAluno(Aluno aluno) {
        listaAlunos.add(aluno);
    }

    public static void listarAlunos() {
        for (Aluno aluno : listaAlunos) {
            System.out.println(aluno.dadosAluno());
        }
    }

    public static Aluno buscarAluno(String dado) {
        for (Aluno aluno : listaAlunos) {
            if (aluno.getNome().equals(dado) || aluno.getEmail().equals(dado)) {
                return aluno;
            }
        }
        return null;
    }
    
    public static Aluno buscarAluno(int matricula) {
        for (Aluno aluno : listaAlunos) {
            if (aluno.getMatricula() == matricula) {
                return aluno;
            }
        }
        return null;
    }

    public static void excluirAluno(Aluno aluno) {
        for (Aluno alunoT : listaAlunos) {
            if (alunoT.getNome().equals(aluno.getNome())) {
               listaAlunos.remove(aluno); 
            }
        }
    }

    public static ArrayList<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    
    public static ArrayList<Aluno> getAlunos() {
        return listaAlunos;
    }
    //#endregion
}
