import Aplicacion.GestorBusqueda;

public class MainBuscar {

    public static void main(String[] args) {
        GestorBusqueda gestorBusqueda = new GestorBusqueda();
        gestorBusqueda.recuperarVocabulario();
        System.out.println(gestorBusqueda.mostrarDocumentos());
    }
}
