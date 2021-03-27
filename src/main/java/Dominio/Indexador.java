package Dominio;

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
            String[] terminos = FormatedorEntrada.formatear(linea);

            for (String termino: terminos) {
                if(termino.equals("")) { continue; }
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
            String[] terminos = FormatedorEntrada.formatear(linea);

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

    public String mostrarVocabulario(){
        return vocabulario.mostrarTerminos();
    }

    public int mostrarCantidadTerminosVocabulario(){
        return vocabulario.cantidadTerminos();
    }

    public String mostrarOrdenPosteo() {
        return vocabulario.mostrarOrdenPosteo();
    }

}
