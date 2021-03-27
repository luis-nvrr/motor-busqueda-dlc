package Dominio;

public class Documento implements Comparable<Documento>{
    private String path;
    private int frecuenciaTermino;

    public Documento(String path){
        this.path = path;
        this.frecuenciaTermino = 1;
    }

    public void sumarFrecuencia(){
        this.frecuenciaTermino++;
    }

    public int getFrecuenciaTermino(){
        return frecuenciaTermino;
    }

    public String getPath(){
        return this.path;
    }

    @Override
    public int compareTo(Documento o) {
        if(o == null) { throw new NullPointerException(); }
        Documento comparado = (Documento) o;

        return this.frecuenciaTermino - comparado.frecuenciaTermino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o instanceof Documento) return false;

        Documento documento = (Documento) o;

        if (frecuenciaTermino != documento.frecuenciaTermino) return false;
        return path.equals(documento.path);
    }

    @Override
    public int hashCode() {
        int result = path.hashCode();
        result = 31 * result + frecuenciaTermino;
        return result;
    }
}
