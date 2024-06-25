package controller;
//#region Import
import controller.*;
import model.*;
import view.*;
import java.io.*;
import java.util.ArrayList;
//#endregion
public class GerenciadorAdministradores {
    private static final File ADMINISTRADORES_REGISTRADOS = new File("src/database/administradores.txt");
    
    private static ArrayList<Administrador> listaAdministradores = new ArrayList<>();

    //#region File Manipulation
    public static ArrayList<Administrador> carregarAdministradores() throws IOException {
        try (FileReader fr = new FileReader(ADMINISTRADORES_REGISTRADOS);BufferedReader br = new BufferedReader(fr)) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    Administrador administrador = Administrador.fromString(linha);
                    listaAdministradores.add(administrador);
                }
        } 
        System.out.println("Os Administradores foram Carregados!");
        return listaAdministradores;
    }

    public static void manterAdministradores() throws IOException {
        for (Administrador administrador : listaAdministradores) {
            try(FileWriter fw = new FileWriter(ADMINISTRADORES_REGISTRADOS);BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(administrador + "\n");
            }
        }
    }
    //#endregion
    //#region ArrayList Manipulation
    public static void adicionarAdministrador(Administrador administrador) {
        listaAdministradores.add(administrador);
    }

    public static void listarAdministradores() {
        for (Administrador administrador : listaAdministradores) {
            System.out.println(administrador.dadosAdministrador());
        }
    }

    public static Administrador buscarAdministrador(String dado) {
        for (Administrador administrador : listaAdministradores) {
            if (administrador.getNome().equals(dado) || administrador.getEmail().equals(dado)) {
                return administrador;
            }
        }
        return null;
    }

    public static ArrayList<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }
    //#endregion
}
