package Infraestructura;

import Aplicacion.GestorIndexacion;

public class Main {

    public static void main(String[] args) {

        //String pathArchivo = "C:\\Users\\luis\\Downloads\\prueba\\00ws110.txt";
        String pathStopWords = "C:\\Users\\luis\\Downloads\\stopWords.txt";
        String pathDirectorio ="C:\\Users\\luis\\Downloads\\prueba";
        GestorIndexacion gestor = new GestorIndexacion();

        gestor.cargarStopWords(pathStopWords);
        gestor.cargarVocabularioDirectorio(pathDirectorio);
        //gestor.cargarVocabularioArchivo(pathArchivo);

        System.out.println(gestor.mostrarVocabulario());
        System.out.println(gestor.mostrarCantidadTerminosVocabulario());
        //System.out.println(gestor.mostrarOrdenPosteo());
    }
}
