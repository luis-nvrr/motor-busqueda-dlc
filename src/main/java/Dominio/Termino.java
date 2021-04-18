package Dominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Termino {

    private final List<Posteo> posteos;
    private final String termino;
    private int cantidadDocumentos;
    private int maximaFrecuenciaTermino;


    public Termino(String termino){
        this(termino, 1, 1);
    }

    public Termino(String termino, int cantidadDocumentos, int maximaFrecuenciaTermino){
        this.posteos = new ArrayList<>();
        this.termino = termino;
        this.cantidadDocumentos = cantidadDocumentos;
        this.maximaFrecuenciaTermino = maximaFrecuenciaTermino;
    }

    public List<Posteo> getPosteos(){
        return posteos;
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

    public void sumarPosteo(Documento documento){
        cantidadDocumentos++;
        Posteo recuperado = buscarPosteo(documento);

        if(recuperado == null){ agregarNuevoPosteo(documento);}
        else{
            actualizarPosteoExistente(recuperado);
        }
    }

    private void agregarNuevoPosteo(Documento documento){
        Posteo posteo = new Posteo(documento);
        agregarAListaPosteos(posteo);
    }

    private Posteo buscarPosteo(Documento documento){
        Iterator<Posteo> it = posteos.iterator();

        while(it.hasNext()){
            Posteo posteo = it.next();
            if(posteo.tieneDocumento(documento)){
                it.remove();
                return posteo;
            }
        }
        return null;
    }

    private void actualizarPosteoExistente(Posteo posteo){
        posteo.sumarFrecuencia();
        actualizarFrecuenciaMaxima(posteo);
        agregarAListaPosteos(posteo);
    }

    private void actualizarFrecuenciaMaxima(Posteo posteo){
        if (posteo.getFrecuenciaTermino() > maximaFrecuenciaTermino){
            maximaFrecuenciaTermino = posteo.getFrecuenciaTermino();
        }
    }

    public void agregarAListaPosteos(Posteo posteo){
        this.posteos.add(posteo);
    }

    public String mostrarOrdenPosteo(){
        Iterator<Posteo> it = posteos.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("termino: ").append(termino).append("\n\t");

        while(it.hasNext()) {
            stringBuilder.append("frecuencia: ")
                    .append(it.next().getFrecuenciaTermino())
                    .append(" ");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
