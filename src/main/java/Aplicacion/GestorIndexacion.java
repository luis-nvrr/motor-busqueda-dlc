package Aplicacion;
import Dominio.*;

public class GestorIndexacion {

    Indexador indexador;
    Vocabulario vocabulario;
    StopWord stopWord;

    public GestorIndexacion(){
        this.vocabulario = new Vocabulario();
        this.stopWord = new StopWord();
        this.indexador = new Indexador(vocabulario, stopWord);
    }

    public void cargarStopWords(String archivoPath){
        IArchivo archivo = new ArchivoLocal(archivoPath);
        indexador.cargarStopWords(archivo);
    }

    public void cargarVocabularioArchivo(String archivoPath){
        IArchivo archivo = new ArchivoLocal(archivoPath);
        indexador.cargarVocabularioArchivo(archivo);
    }

    public void cargarVocabularioDirectorio(String directorioPath){
        IDirectorio directorio = new DirectorioLocal(directorioPath);
        indexador.cargarVocabularioDirectorio(directorio);
    }

    public String mostrarVocabulario(){
        return vocabulario.mostrarTerminos();
    }

    public int mostrarCantidadTerminosVocabulario(){
        return vocabulario.cantidadTerminos();
    }

    public String mostrarOrdenPosteo(){
        return vocabulario.mostrarOrdenPosteo();
    }
}
