package Dominio.Archivo;

import java.io.*;

public class ArchivoLocal implements IArchivo {
    private String path;
    BufferedReader bufferedReader;

    public ArchivoLocal(String path){
        this.path = path;
    }

    public void openReader(){
        try{
            bufferedReader = new BufferedReader(new FileReader(path));
        }
        catch(FileNotFoundException exception){
            exception.printStackTrace();
        }
    }

    public String obtenerSiguienteLinea(){
        String linea = "";
        try{
            linea = bufferedReader.readLine();
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
        return linea;
    }

    public void closeReader(){
        try{
            bufferedReader.close();
        }
        catch(IOException exception){
            exception.printStackTrace();
        }
    }

    public String obtenerPath() {
        return path;
    }
}
