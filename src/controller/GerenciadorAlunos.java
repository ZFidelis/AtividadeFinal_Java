package controller;
//#region Import
import controller.*;
import model.*;
import view.*;
import java.io.*;
import java.util.ArrayList;
//#endregion
public class GerenciadorAlunos {
    private static final File ALUNO_REGISTRADOS = new File("src/database/alunos.txt");
    
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
            try(FileWriter fw = new FileWriter(ALUNOS_REGISTRADOS, true);BufferedWriter bw = new BufferedWriter(fw)) {
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

    public static void buscarAlunos() {}


    public static ArrayList<Aluno> getListaAlunos() {
        return listaAlunos;
    }
    //#endregion
}