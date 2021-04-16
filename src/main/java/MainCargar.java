import Aplicacion.GestorIndexacion;
import io.github.cdimascio.dotenv.Dotenv;

public class MainCargar {

    public static void main(String[] args) {
        GestorIndexacion gestorIndexacion = new GestorIndexacion();

        Dotenv dotenv = Dotenv.load();
        String stopWordsPath = dotenv.get("STOPWORDS");
        String directorioPath = dotenv.get("DOCUMENTOS");
        //String archivoPath = dotenv.get("ARCHIVO");

        gestorIndexacion.cargarStopWords(stopWordsPath);
        gestorIndexacion.cargarVocabularioDirectorio(directorioPath);
        //gestorIndexacion.cargarVocabularioArchivo(pathArchivo);

        //System.out.println(gestorIndexacion.mostrarVocabulario());
        System.out.println(gestorIndexacion.mostrarCantidadTerminosVocabulario());
        //System.out.println(gestorVisualizacion.mostrarOrdenPosteo());
    }
}
