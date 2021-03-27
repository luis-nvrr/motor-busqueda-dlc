package Aplicacion;

import Dominio.Vocabulario;

public class GestorVisualizacion {
    Vocabulario vocabulario;

    public GestorVisualizacion(Vocabulario vocabulario){
        this.vocabulario = vocabulario;
    }

    public String mostrarVocabulario(){
        return vocabulario.mostrarTerminos();
    }

    public int mostrarCantidadTerminosVocabulario(){
        return vocabulario.cantidadTerminos();
    }

    public String mostrarOrdenPosteo(){
        return vocabulario.mostrarOrdenPosteo();
    }
}
