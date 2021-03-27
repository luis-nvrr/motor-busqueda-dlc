package Aplicacion;
import Dominio.IArchivo;
import Dominio.IDirectorio;
import Dominio.Indexador;

public class GestorIndexacion {

    Indexador indexador;

    public GestorIndexacion(){
        indexador = new Indexador();
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

    public String mostrarVocabulario(){
        return indexador.mostrarVocabulario();
    }

    public int mostrarCantidadTerminosVocabulario(){
        return indexador.mostrarCantidadTerminosVocabulario();
    }

    public String mostrarOrdenPosteo(){
        return indexador.mostrarOrdenPosteo();
    }
}
