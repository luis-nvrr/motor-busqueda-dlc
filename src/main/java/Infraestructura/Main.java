package Infraestructura;

import Aplicacion.GestorIndexacion;
import Dominio.Archivo;
import Dominio.Indexador;
import Dominio.StopWord;
import Dominio.Vocabulario;

public class Main {

    public static void main(String[] args) {

        String pathVocabulario = "C:\\Users\\luis\\Downloads\\testCollection.pdf";
        String pathStopWords = "C:\\Users\\luis\\Downloads\\stopWords.pdf";

        GestorIndexacion gestor = new GestorIndexacion();

        gestor.cargarStopWords(pathStopWords);
        gestor.cargarVocabulario(pathVocabulario);

        System.out.println(gestor.mostrarVocabulario());
        System.out.println(gestor.mostrarCantidadTerminosVocabulario());
    }
}
