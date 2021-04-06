package Dominio;

public class Documento implements Comparable<Documento>{
    private String nombre;
    private int frecuenciaTermino;
    private String link;

    public Documento(String nombre){
        this.nombre = nombre;
        this.frecuenciaTermino = 1;
    }

    public String getLink() {
        return link;
    }

    public void sumarFrecuencia(){
        this.frecuenciaTermino++;
    }

    public int getFrecuenciaTermino(){
        return frecuenciaTermino;
    }

    public String getNombre(){
        return this.nombre;
    }

    @Override
    public int compareTo(Documento o) {
        if(o == null) { throw new NullPointerException(); }
        Documento comparado = o;

        return this.frecuenciaTermino - comparado.frecuenciaTermino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o instanceof Documento) return false;

        Documento documento = (Documento) o;

        if (frecuenciaTermino != documento.frecuenciaTermino) return false;
        return nombre.equals(documento.nombre);
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + frecuenciaTermino;
        return result;
    }
}
