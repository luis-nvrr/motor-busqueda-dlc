import Aplicacion.GestorBusqueda;

public class MainBuscar {

    public static void main(String[] args) {
        GestorBusqueda gestorBusqueda = new GestorBusqueda();
        gestorBusqueda.recuperarVocabulario();

        String terminos = "prueba";

        gestorBusqueda.buscar(terminos);

        System.out.println(gestorBusqueda.mostrarDocumentos());
        System.out.println(gestorBusqueda.mostrarCantidadTerminosVocabulario());
    }
}
