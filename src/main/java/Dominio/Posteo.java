package Dominio;

public class Posteo implements Comparable<Posteo>{
    private int frecuenciaTermino;
    private Documento documento;

    public Posteo(Documento documento){
        this.documento = documento;
        this.frecuenciaTermino = 1;
    }

    public void sumarFrecuencia(){
        this.frecuenciaTermino++;
    }

    public int getFrecuenciaTermino(){
        return frecuenciaTermino;
    }

    public String obtenerNombre(){
        return this.documento.getNombre();
    }

    public String obtenerLink(){
        return this.documento.getLink();
    }


    @Override
    public int compareTo(Posteo o) {
        if(o == null) { throw new NullPointerException(); }
        Posteo comparado = o;

        return this.frecuenciaTermino - comparado.frecuenciaTermino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o instanceof Posteo) return false;

        Posteo posteo = (Posteo) o;

        if (frecuenciaTermino != posteo.frecuenciaTermino) return false;
        return documento.equals(posteo.documento);
    }

    @Override
    public int hashCode() {
        int result = documento.hashCode();
        result = 31 * result + frecuenciaTermino;
        return result;
    }
}
