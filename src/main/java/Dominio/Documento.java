package Dominio;

public class Documento {
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
}
