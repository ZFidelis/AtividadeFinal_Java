package controller;
//#region Import
import controller.*;
import model.*;
import view.*;
import java.io.*;
import java.util.ArrayList;
//#endregion
public class GerenciadorProfessores {
    private static final File PROFESSORES_REGISTRADOS = new File("src/database/professores.txt");
    
    private static ArrayList<Professor> listaProfessores = new ArrayList<>();

    //#region File Manipulation
    public static ArrayList<Professor> carregarProfessores() throws IOException {
        try (FileReader fr = new FileReader(PROFESSORES_REGISTRADOS);BufferedReader br = new BufferedReader(fr)) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    Professor professor = Professor.fromString(linha);
                    listaProfessores.add(professor);
                }
        } 
        System.out.println("Os Professores foram Carregados!");
        return listaProfessores;
    }

    public static void manterProfessores() throws IOException {
        for (Professor professor : listaProfessores) {
            try(FileWriter fw = new FileWriter(PROFESSORES_REGISTRADOS);BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(professor + "\n");
            }
        }
    }
    //#endregion
    //#region ArrayList Manipulation
    public static void adicionarProfessor(Professor professor) {
        listaProfessores.add(professor);
    }

    public static void listarProfessores() {
        for (Professor professor : listaProfessores) {
            System.out.println(professor.dadosProfessor());
        }
    }

    public static Professor buscarProfessor(String dado) {
        for (Professor professor : listaProfessores) {
            if (professor.getNome().equals(dado) || professor.getEmail().equals(dado)) {
                return professor;
            }
        }
        return null;
    }

    public static Professor buscarProfessor(int registro) {
        for (Professor professor : listaProfessores) {
            if (professor.getRegistro() == (registro)) {
                return professor;
            }
        }
        return null;
    }

    public static void excluirProfessor(Professor professor) {
        for (Professor professorT : listaProfessores) {
            if (professorT.getNome().equals(professor.getNome())) {
               listaProfessores.remove(professor); 
            }
        }
    }

    public static ArrayList<Professor> getListaProfessores() {
        return listaProfessores;
    }

    
    public static ArrayList<Professor> getProfessores() {
        return listaProfessores;
    }
    //#endregion
}
