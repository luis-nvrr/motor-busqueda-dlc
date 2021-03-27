package Infraestructura;

import Aplicacion.GestorIndexacion;
import Dominio.IArchivo;
import Dominio.IDirectorio;

public class Main {

    public static void main(String[] args) {

        //String pathArchivo = "C:\\Users\\luis\\Downloads\\prueba\\00ws110.txt";
        IArchivo stopWwords = new Archivo("C:\\Users\\luis\\Downloads\\stopWords.txt");
        IDirectorio directorio = new Directorio("C:\\Users\\luis\\Downloads\\prueba");
        GestorIndexacion gestor = new GestorIndexacion();

        gestor.cargarStopWords(stopWwords);
        gestor.cargarVocabularioDirectorio(directorio);
        //gestor.cargarVocabularioArchivo(pathArchivo);

        System.out.println(gestor.mostrarVocabulario());
        System.out.println(gestor.mostrarCantidadTerminosVocabulario());
        //System.out.println(gestor.mostrarOrdenPosteo());
    }
}
