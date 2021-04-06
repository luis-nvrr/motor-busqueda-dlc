package Aplicacion;
import Dominio.*;
import Dominio.Archivo.ArchivoLocal;
import Dominio.Archivo.DirectorioLocal;
import Dominio.Archivo.IArchivo;
import Dominio.Archivo.IDirectorio;
import Infraestructura.MySQLDocumentoRepository;
import Infraestructura.MySQLTerminoRepository;

public class GestorIndexacion {

    Indexador indexador;
    Vocabulario vocabulario;
    StopWord stopWord;
    TerminoRepository terminoRepository;
    DocumentoRepository documentoRepository;

    public GestorIndexacion(){
        this.vocabulario = new Vocabulario();
        this.stopWord = new StopWord();
        this.indexador = new Indexador(vocabulario, stopWord);
        this.terminoRepository = new MySQLTerminoRepository();
        this.documentoRepository = new MySQLDocumentoRepository();
    }

    public void cargarStopWords(String archivoPath){
        IArchivo archivo = new ArchivoLocal(archivoPath);
        indexador.cargarStopWords(archivo);
    }

    public void cargarVocabularioArchivo(String archivoPath){
        IArchivo archivo = new ArchivoLocal(archivoPath);
        indexador.cargarVocabularioArchivo(archivo);
        //persistir();
    }

    public void cargarVocabularioDirectorio(String directorioPath){
        IDirectorio directorio = new DirectorioLocal(directorioPath);
        indexador.cargarVocabularioDirectorio(directorio);
        persistir();
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

    private void persistir(){
        vocabulario.saveTerminos(terminoRepository);
        vocabulario.saveDocumentos(documentoRepository);
    }
}
