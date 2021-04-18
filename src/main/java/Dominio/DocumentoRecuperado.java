package Dominio;

public class DocumentoRecuperado implements Comparable<DocumentoRecuperado> {
    private String path;
    private String nombre;
    private int indiceRelevancia;

    public DocumentoRecuperado(String path, String nombre){
        this.path = path;
        this.nombre = nombre;
        this.indiceRelevancia = 0;
    }

    public void sumarRelevancia(int relevancia){
        this.indiceRelevancia += relevancia;
    }

    @Override
    public int compareTo(DocumentoRecuperado o) {
        return this.indiceRelevancia - o.indiceRelevancia;
    }

    public String getPath() {
        return path;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIndiceRelevancia() {
        return indiceRelevancia;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("path: ").append(path).append("\n")
                .append("nombre: ").append(nombre).append("\n")
                .append("indice de relevancia: ").append(indiceRelevancia).append("\n");

        return stringBuilder.toString();
    }
}
