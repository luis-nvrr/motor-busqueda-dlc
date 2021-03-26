import java.util.Locale;

public class Indexador {
    private Vocabulario vocabulario;
    private StopWord stopWord;

    public Indexador(Vocabulario vocabulario, StopWord stopWord){
        this.vocabulario = vocabulario;
        this.stopWord = stopWord;
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

}
