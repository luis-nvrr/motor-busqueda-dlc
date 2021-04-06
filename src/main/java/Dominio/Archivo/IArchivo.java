package Dominio;

public interface IArchivo {

    void openReader();
    String obtenerSiguienteLinea();
    void closeReader();
    String obtenerPath();
}
