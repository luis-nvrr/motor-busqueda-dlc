package Dominio;

import Dominio.Posteo;

public class Termino {

    private String termino;
    private Posteo posteo;


    public Termino(String termino){
        this.posteo = new Posteo();
        this.termino = termino;
    }

    public void agregarDocumento(String path){
        this.posteo.agregarDocumento(path);
    }
}