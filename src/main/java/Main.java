public class Main {

    public static void main(String[] args) {

        Vocabulario vocabulario = new Vocabulario();
        Indexador indexador = new Indexador(vocabulario);
        Archivo archivo = new Archivo("C:\\Users\\luis\\Downloads\\lorem-ipsum.pdf");

        indexador.cargarVocabulario(archivo);

        System.out.println(vocabulario.mostrar());
        System.out.println(vocabulario.cantidadTerminos());
    }
}
