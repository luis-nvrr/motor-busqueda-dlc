package Aplicacion;

import Dominio.*;
import Infraestructura.MySQLDocumentoRepository;
import Infraestructura.MySQLPosteoRepository;
import Infraestructura.MySQLTerminoRepository;

import java.util.List;

public class GestorBusqueda {
    DocumentoRepository documentoRepository;
    PosteoRepository posteoRepository;
    TerminoRepository terminoRepository;
    Vocabulario vocabulario;
    List<DocumentoRecuperado> recuperados;

    public GestorBusqueda(){
        documentoRepository = new MySQLDocumentoRepository();
        posteoRepository = new MySQLPosteoRepository();
        terminoRepository = new MySQLTerminoRepository();
        vocabulario = new Vocabulario();
    }

    public void recuperarVocabulario(){
        vocabulario.getAllDocumentos(documentoRepository);
        vocabulario.getAllTerminos(terminoRepository);
        //vocabulario.getAllPosteos(posteoRepository);
    }

    public void buscar(String terminos){

    }

    public String mostrarDocumentos(){
        return vocabulario.mostrarDocumentos();
    }

    public int mostrarCantidadTerminosVocabulario(){
        return vocabulario.cantidadTerminos();
    }
}
