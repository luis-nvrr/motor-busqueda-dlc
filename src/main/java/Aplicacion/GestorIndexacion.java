package Aplicacion;
import Dominio.IArchivo;
import Dominio.IDirectorio;
import Dominio.Indexador;

public class GestorIndexacion {

    Indexador indexador;

    public GestorIndexacion(Indexador indexador){
        this.indexador = indexador;
    }

    public void cargarStopWords(IArchivo archivo){
        indexador.cargarStopWords(archivo);
    }

    public void cargarVocabularioArchivo(IArchivo archivo){
        indexador.cargarVocabularioArchivo(archivo);
    }

    public void cargarVocabularioDirectorio(IDirectorio directorio){
        indexador.cargarVocabularioDirectorio(directorio);
    }
}
