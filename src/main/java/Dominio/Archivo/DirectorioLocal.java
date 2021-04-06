package Dominio.Archivo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectorioLocal implements IDirectorio {
    private final File directorio;
    private final ArrayList<IArchivo> archivos;

    public DirectorioLocal(String path){
        this.directorio = new File(path);
        this.archivos = new ArrayList<>();
    }

    public List<IArchivo> getArchivos(){
        for (File file: directorio.listFiles()) {
            IArchivo archivo = new ArchivoLocal(file.getName());
            archivos.add(archivo);
        }
        return archivos;
    }

}
