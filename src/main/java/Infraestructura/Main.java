package Infraestructura;

import Aplicacion.GestorIndexacion;
import Dominio.IArchivo;
import Dominio.IDirectorio;
import Dominio.Indexador;

public class Main {

    public static void main(String[] args) {

        Indexador indexador = new Indexador();
        GestorIndexacion gestor = new GestorIndexacion(indexador);

        //String pathArchivo = "C:\\Users\\luis\\Downloads\\prueba\\00ws110.txt";
        IArchivo stopWwords = new Archivo("C:\\Users\\luis\\Downloads\\stopWords.txt");
        IDirectorio directorio = new Directorio("C:\\Users\\luis\\Downloads\\prueba");


        gestor.cargarStopWords(stopWwords);
        gestor.cargarVocabularioDirectorio(directorio);
        //gestor.cargarVocabularioArchivo(pathArchivo);

        System.out.println(gestor.mostrarVocabulario());
        System.out.println(gestor.mostrarCantidadTerminosVocabulario());
        //System.out.println(gestor.mostrarOrdenPosteo());
    }
}
