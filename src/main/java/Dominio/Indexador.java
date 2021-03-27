package Dominio;

import Dominio.Archivo;

import java.util.Locale;

public class Indexador {
    private Vocabulario vocabulario;
    private StopWord stopWord;

    public Indexador(){
        this.vocabulario = new Vocabulario();
        this.stopWord = new StopWord();
    }

    public void cargarVocabulario(Archivo archivo){
        String texto = archivo.obtenerTexto();
        String[] terminos = texto.split("\\P{L}+");

        for (String term: terminos) {
            String termino = minuscula(term);
            if(stopWord.esStopWord(termino)) { continue; }
            vocabulario.agregarTermino(termino, archivo.obtenerPath());
        }
    }

    public void cargarStopWords(Archivo archivo){
        String texto = archivo.obtenerTexto();
        String[] terminos = texto.split("\\P{L}+");

        for(String termino: terminos){
            stopWord.agregarStopWord(termino);
        }
    }

    private String minuscula(String termino){
        return termino.toLowerCase(Locale.ROOT);
    }

    public String mostrarVocabulario(){
        return vocabulario.mostrar();
    }

    public int mostrarCantidadTerminosVocabulario(){
        return vocabulario.cantidadTerminos();
    }

}
