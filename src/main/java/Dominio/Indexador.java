package Dominio;

import java.util.Locale;

public class Indexador {
    private Vocabulario vocabulario;
    private StopWord stopWord;

    public Indexador(){
        this.vocabulario = new Vocabulario();
        this.stopWord = new StopWord();
    }

    public void cargarVocabularioArchivo(Archivo archivo){
        String linea;

        archivo.openReader();
        while( (linea = archivo.obtenerSiguienteLinea()) != null){
        String[] terminos = linea.split("\\P{L}+");

            for (String term: terminos) {
                String termino = minuscula(term);
                if(stopWord.esStopWord(termino)) { continue; }
                vocabulario.agregarTermino(termino, archivo.obtenerPath());
            }
        }
        archivo.closeReader();
    }

    public void cargarStopWords(Archivo archivo){
        String linea;

        archivo.openReader();
        while((linea = archivo.obtenerSiguienteLinea()) != null) {
            String[] terminos = linea.split("\\P{L}+");

            for(String termino: terminos){
                stopWord.agregarStopWord(termino);
            }
        }
    }

    public void cargarVocabularioDirectorio(Directorio directorio){
        for (Archivo archivo: directorio.getArchivos()) {
            cargarVocabularioArchivo(archivo);
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
