package Aplicacion;

import Dominio.Archivo;
import Dominio.Directorio;
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

    public void cargarVocabularioArchivo(String pathArchivo){
        Archivo archivo = new Archivo(pathArchivo);
        indexador.cargarVocabularioArchivo(archivo);
    }

    public void cargarVocabularioDirectorio(String pathDirectorio){
        Directorio directorio = new Directorio(pathDirectorio);
        indexador.cargarVocabularioDirectorio(directorio);
    }

    public String mostrarVocabulario(){
        return indexador.mostrarVocabulario();
    }

    public int mostrarCantidadTerminosVocabulario(){
        return indexador.mostrarCantidadTerminosVocabulario();
    }
}
