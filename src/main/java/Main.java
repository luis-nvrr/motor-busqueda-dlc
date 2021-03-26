public class Main {

    public static void main(String[] args) {

        Vocabulario vocabulario = new Vocabulario();
        StopWord stopWord = new StopWord();

        Indexador indexador = new Indexador(vocabulario, stopWord);
        Archivo archivoPrueba = new Archivo("C:\\Users\\luis\\Downloads\\testCollection.pdf");
        Archivo archivoStopWords = new Archivo("C:\\Users\\luis\\Downloads\\stopWords.pdf");

        indexador.cargarStopWords(archivoStopWords);
        indexador.cargarVocabulario(archivoPrueba);

        System.out.println(vocabulario.mostrar());
        System.out.println(vocabulario.cantidadTerminos());
    }
}
