import Aplicacion.GestorIndexacion;
import Aplicacion.GestorVisualizacion;
import Dominio.*;

public class Main {

    public static void main(String[] args) {

        Vocabulario vocabulario = new Vocabulario();
        StopWord stopWord = new StopWord();
        Indexador indexador = new Indexador(vocabulario, stopWord);
        GestorIndexacion gestorIndexacion = new GestorIndexacion(indexador);
        GestorVisualizacion gestorVisualizacion = new GestorVisualizacion(vocabulario);

        //String pathArchivo = "C:\\Users\\luis\\Downloads\\prueba\\00ws110.txt";
        IArchivo stopWwords = new ArchivoLocal("C:\\Users\\luis\\Downloads\\stopWords.txt");
        IDirectorio directorio = new DirectorioLocal("C:\\Users\\luis\\Downloads\\prueba");


        gestorIndexacion.cargarStopWords(stopWwords);
        gestorIndexacion.cargarVocabularioDirectorio(directorio);
        //gestorIndexacion.cargarVocabularioArchivo(pathArchivo);

        System.out.println(gestorVisualizacion.mostrarVocabulario());
        System.out.println(gestorVisualizacion.mostrarCantidadTerminosVocabulario());
        //System.out.println(gestorVisualizacion.mostrarOrdenPosteo());
    }
}
