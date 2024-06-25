package controller;
//#region Import
import controller.*;
import model.*;
import view.*;
import java.io.*;
import java.util.ArrayList;
//#endregion
public class GerenciadorCursos {
    private static final File CURSOS_REGISTRADOS = new File("src/database/cursos.txt");
    private static ArrayList<Curso> listaCursos = new ArrayList<>();

    //#region File Manipulation
    public static ArrayList<Curso> carregarCursos() throws IOException {
        try (FileReader fr = new FileReader(CURSOS_REGISTRADOS);BufferedReader br = new BufferedReader(fr)) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    Curso curso = Curso.fromString(linha);
                    listaCursos.add(curso);
                }
        } 
        System.out.println("Os Cursos foram Carregados!");
        return listaCursos;
    }

    public static void manterCursos() throws IOException {
        for (Curso curso : listaCursos) {
            try(FileWriter fw = new FileWriter(CURSOS_REGISTRADOS);BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(curso + "\n");
            }
        }
    }
    //#endregion
    //#region ArrayList Manipulation
    public static void adicionarCurso(Curso curso) {
        listaCursos.add(curso);
    }

    public static void listarCursos() {
        for (Curso curso : listaCursos) {
            System.out.println(curso.dadosCurso());
        }
    }

    public static Curso buscarCursos(String tituloCurso) {
        for (Curso curso : listaCursos) {
            if (curso.getTitulo().equals(tituloCurso)) {
                return curso;
            }
        }
        return null;
    }

    public static void excluirCurso(Curso curso) {
        for (Curso cursoT : listaCursos) {
            if (cursoT.getTitulo().equals(curso.getTitulo())) {
               listaCursos.remove(curso); 
            }
        }
    }

    public static ArrayList<Curso> getListaCursos() {
        return listaCursos;
    }
    //#endregion


}
