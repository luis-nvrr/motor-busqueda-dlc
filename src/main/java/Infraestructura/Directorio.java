package Infraestructura;

import Dominio.IArchivo;
import Dominio.IDirectorio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Directorio implements IDirectorio {
    private final File directorio;
    private final ArrayList<IArchivo> archivos;

    public Directorio(String path){
        this.directorio = new File(path);
        this.archivos = new ArrayList<>();
    }

    public List<IArchivo> getArchivos(){
        for (File file: directorio.listFiles()) {
            IArchivo archivo = new Archivo(file.getAbsolutePath());
            archivos.add(archivo);
        }
        return archivos;
    }

}
