package Dominio;

import Dominio.Archivo.IArchivo;
import Dominio.Archivo.IDirectorio;

public class Indexador {
    private Vocabulario vocabulario;
    private StopWord stopWord;

    public Indexador(Vocabulario vocabulario, StopWord stopWord){
        this.vocabulario = vocabulario;
        this.stopWord = stopWord;
    }

    public void cargarVocabularioArchivo(IArchivo archivo){
        String linea;

        archivo.openReader();
        while( (linea = archivo.obtenerSiguienteLinea()) != null){
            String[] terminos = FormatedorEntrada.formatear(linea);

            for (String termino: terminos) {
                if(termino.equals("")) { continue; }
                if(stopWord.esStopWord(termino)) { continue; }
                vocabulario.agregarTermino(termino, archivo.obtenerPath());
            }
        }
        archivo.closeReader();
    }

    public void cargarStopWords(IArchivo archivo){
        String linea;

        archivo.openReader();
        while((linea = archivo.obtenerSiguienteLinea()) != null) {
            String[] terminos = FormatedorEntrada.formatear(linea);

            for(String termino: terminos){
                stopWord.agregarStopWord(termino);
            }
        }
    }

    public void cargarVocabularioDirectorio(IDirectorio directorio){
        for (IArchivo archivo: directorio.getArchivos()) {
            cargarVocabularioArchivo(archivo);
        }
    }
}
