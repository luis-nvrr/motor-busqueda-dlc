package Dominio;

import java.io.File;
import java.util.ArrayList;

public class Directorio {
    private final File directorio;
    private final ArrayList<Archivo> archivos;

    public Directorio(String path){
        this.directorio = new File(path);
        this.archivos = new ArrayList<>();
    }

    public ArrayList<Archivo> getArchivos(){
        for (File archivo: directorio.listFiles()) {
            archivos.add(new Archivo(archivo.getAbsolutePath()));
        }
        return archivos;
    }

}
