package Dominio.Archivo;

public interface IArchivo {

    void openReader();
    String obtenerSiguienteLinea();
    void closeReader();
    String obtenerPath();
    String obtenerNombre();
}
