package Dominio;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class Termino {

    private Map<Documento, Posteo> posteo;
    private String termino;
    private int cantidadDocumentos;
    private int maximaFrecuenciaTermino;


    public Termino(String termino){
        this.posteo = new Hashtable<>();
        this.cantidadDocumentos = 1;
        this.maximaFrecuenciaTermino = 1;
        this.termino = termino;
    }

    public Map<Documento, Posteo> getPosteo(){
        return posteo;
    }

    public String getTermino() {
        return termino;
    }

    public int getCantidadDocumentos() {
        return cantidadDocumentos;
    }

    public int getMaximaFrecuenciaTermino() {
        return maximaFrecuenciaTermino;
    }

    public void agregarPosteo(Documento documento){
        cantidadDocumentos++;
        Posteo recuperado = posteo.get(documento);

        if(recuperado == null){ agregarNuevoPosteo(documento);}
        else{
            actualizarPosteoExistente(documento, recuperado);
        }
    }

    private void agregarNuevoPosteo(Documento documento){
        Posteo posteo = new Posteo(documento);
        agregarAPosteo(documento, posteo);
    }

    private void actualizarPosteoExistente(Documento documento, Posteo posteo){
        posteo.sumarFrecuencia();
        actualizarFrecuenciaMaxima(posteo);
        agregarAPosteo(documento, posteo);
    }

    private void actualizarFrecuenciaMaxima(Posteo posteo){
        if (posteo.getFrecuenciaTermino() > maximaFrecuenciaTermino){
            maximaFrecuenciaTermino = posteo.getFrecuenciaTermino();
        }
    }

    private void agregarAPosteo(Documento documento, Posteo posteo){
        this.posteo.put(documento, posteo);
    }

    public String mostrarOrdenPosteo(){
        posteo = Ordenador.sortByValue(posteo);

        Iterator<Map.Entry<Documento, Posteo>> it = posteo.entrySet().iterator();
        StringBuilder stringBuilder = new StringBuilder();

        while(it.hasNext()) {
            stringBuilder.append("documento: ");
            stringBuilder.append(it.next().getValue().getFrecuenciaTermino());
            stringBuilder.append(" ");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

}
