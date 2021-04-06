package Dominio;

public class Documento {
    private String nombre;
    private String path;
    private String link;


    public Documento(String nombre, String path){
        this.nombre = nombre;
        this.path = path;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPath() {
        return path;
    }

    public String getLink() {
        return link;
    }
}

