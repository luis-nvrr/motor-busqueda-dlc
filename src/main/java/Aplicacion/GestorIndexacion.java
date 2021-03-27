package Aplicacion;

import Dominio.Archivo;
import Dominio.Indexador;

public class GestorIndexacion {

    Indexador indexador;

    public GestorIndexacion(){
        indexador = new Indexador();
    }

    public void cargarStopWords(String pathStopWords){
        Archivo archivo = new Archivo(pathStopWords);
        indexador.cargarStopWords(archivo);
    }

    public void cargarVocabulario(String pathArchivo){
        Archivo archivo = new Archivo(pathArchivo);
        indexador.cargarVocabulario(archivo);
    }

    public String mostrarVocabulario(){
        return indexador.mostrarVocabulario();
    }

    public int mostrarCantidadTerminosVocabulario(){
        return indexador.mostrarCantidadTerminosVocabulario();
    }
}
