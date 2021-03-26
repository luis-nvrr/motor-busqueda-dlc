public class Indexador {
    private Vocabulario vocabulario;

    public Indexador(Vocabulario vocabulario){
        this.vocabulario = vocabulario;
    }

    public void cargarVocabulario(Archivo archivo){
        String texto = archivo.obtenerTexto();
        String[] terminos = texto.split("\\P{L}+");

        for (String termino: terminos) {
            vocabulario.agregarTermino(termino, archivo.obtenerPath());
        }
    }

}
