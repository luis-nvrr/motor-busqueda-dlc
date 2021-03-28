import Aplicacion.GestorIndexacion;

public class Main {

    public static void main(String[] args) {
        GestorIndexacion gestorIndexacion = new GestorIndexacion();

        //String pathArchivo = "C:\\Users\\luis\\Downloads\\prueba\\00ws110.txt";
        String stopWordsPath = "C:\\Users\\luis\\Downloads\\DLC\\stopWords.txt";
        String directorioPath = "C:\\Users\\luis\\Downloads\\DLC\\prueba";

        gestorIndexacion.cargarStopWords(stopWordsPath);
        gestorIndexacion.cargarVocabularioDirectorio(directorioPath);
        //gestorIndexacion.cargarVocabularioArchivo(pathArchivo);

        System.out.println(gestorIndexacion.mostrarVocabulario());
        System.out.println(gestorIndexacion.mostrarCantidadTerminosVocabulario());
        //System.out.println(gestorVisualizacion.mostrarOrdenPosteo());
    }
}
