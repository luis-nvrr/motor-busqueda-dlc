package Dominio;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class Vocabulario {
    private Map<String, Termino> vocabulario;
    private Map<String, Documento> documentos;

    public Vocabulario(){
        this.vocabulario = new Hashtable<>();
        this.documentos = new Hashtable<>();
    }


    public void agregarTermino(String termino, String nombre){
        Termino recuperado = vocabulario.get(termino);
        Documento documento = documentos.get(nombre);

        if (recuperado == null) { agregarInexistente(termino, documento); }
        else{
            actualizarExistente(recuperado, documento);
        }
    }

    private void actualizarExistente(Termino termino, Documento documento){
        termino.agregarPosteo(documento);
        agregarAVocabulario(termino.getTermino(), termino);
    }
    private void agregarInexistente(String termino, Documento documento){
        Termino nuevo = new Termino(termino);
        nuevo.agregarPosteo(documento);
        agregarAVocabulario(termino, nuevo);
    }

    private void agregarAVocabulario(String key, Termino termino){
        this.vocabulario.put(key, termino);
    }

    public void saveTerminos(TerminoRepository terminoRepository){
        terminoRepository.saveTerminos(vocabulario);
    }

    public void savePosteos(PosteoRepository posteoRepository){
        posteoRepository.saveDocumentos(vocabulario);
    }

    public void saveDocumentos(DocumentoRepository documentoRepository){
        documentoRepository.saveDocumentos(this.documentos);
    }

    public String mostrarTerminos(){
        Iterator<Map.Entry<String, Termino>> it = vocabulario.entrySet().iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while(it.hasNext()) {
            Map.Entry<String, Termino> entry = it.next();
            stringBuilder.append("termino: ");
            stringBuilder.append(entry.getKey());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public int cantidadTerminos(){
        return vocabulario.size();
    }

    public String mostrarOrdenPosteo(){
        Iterator<Map.Entry<String, Termino>> it = vocabulario.entrySet().iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while(it.hasNext()) {
            Map.Entry<String, Termino> entry = it.next();
            stringBuilder.append("termino: ");
            stringBuilder.append(entry.getKey());
            stringBuilder.append(" posteo: ");
            stringBuilder.append(entry.getValue().mostrarOrdenPosteo());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private boolean tieneDocumento(String nombre){
        if(this.documentos.get(nombre) != null) {return true;}
        return false;
    }

    public void agregarDocumento(String nombre, String path){
        if(this.tieneDocumento(nombre)){ return; }

        Documento documento = new Documento(nombre, path); // TODO ver parametros
        this.documentos.put(nombre, documento);
    }

}
