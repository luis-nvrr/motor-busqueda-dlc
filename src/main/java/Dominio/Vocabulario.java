package Dominio;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class Vocabulario {
    private Map<String, Termino> vocabulario;

    public Vocabulario(){
        this.vocabulario = new Hashtable<>();
    }

    public void agregarTermino(String termino, String path){
        Termino recuperado = vocabulario.get(termino);

        if (recuperado == null) { agregarInexistente(termino, path); }
        else{
            recuperado.agregarDocumento(path);
            agregarAVocabulario(termino, recuperado);
        }
    }

    private void agregarInexistente(String termino, String path){
        Termino nuevo = new Termino(termino);
        nuevo.agregarDocumento(path);
        agregarAVocabulario(termino, nuevo);
    }



    private void agregarAVocabulario(String key, Termino termino){
        this.vocabulario.put(key, termino);
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

}
