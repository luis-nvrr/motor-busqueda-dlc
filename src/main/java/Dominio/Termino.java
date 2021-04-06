package Dominio;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class Termino {

    private Map<String, Documento> posteo;
    private String termino;
    private int cantidadDocumentos;
    private int maximaFrecuenciaTermino;


    public Termino(String termino){
        this.posteo = new Hashtable<>();
        this.cantidadDocumentos = 1;
        this.maximaFrecuenciaTermino = 1;
        this.termino = termino;
    }

    public Map<String, Documento> getPosteo(){
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

    public void agregarDocumento(String path){
        cantidadDocumentos++;
        Documento recuperado = posteo.get(path);

        if(recuperado == null){ agregarInexistente(path);}
        else{
            actualizarDocumentoExistente(recuperado);
        }
    }

    private void agregarInexistente(String path){
        Documento documento = new Documento(path);
        agregarAPosteo(path, documento);
    }

    private void actualizarDocumentoExistente(Documento documento){
        documento.sumarFrecuencia();
        actualizarFrecuenciaMaxima(documento);
        agregarAPosteo(documento.getPath(), documento);
    }

    private void actualizarFrecuenciaMaxima(Documento documento){
        if (documento.getFrecuenciaTermino() > maximaFrecuenciaTermino){
            maximaFrecuenciaTermino = documento.getFrecuenciaTermino();
        }
    }

    private void agregarAPosteo(String path, Documento documento){
        this.posteo.put(path, documento);
    }

    public String mostrarOrdenPosteo(){
        posteo = Ordenador.sortByValue(posteo);

        Iterator<Map.Entry<String, Documento>> it = posteo.entrySet().iterator();
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
