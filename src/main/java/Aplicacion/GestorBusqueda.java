package Aplicacion;

import Dominio.*;
import Infraestructura.MySQLDocumentoRepository;
import Infraestructura.MySQLPosteoRepository;
import Infraestructura.MySQLTerminoRepository;

public class GestorBusqueda {
    DocumentoRepository documentoRepository;
    PosteoRepository posteoRepository;
    TerminoRepository terminoRepository;
    Vocabulario vocabulario;
    Buscador buscador;

    public GestorBusqueda(){
        this.documentoRepository = new MySQLDocumentoRepository();
        this.posteoRepository = new MySQLPosteoRepository();
        this.terminoRepository = new MySQLTerminoRepository();
        this.vocabulario = new Vocabulario();
        this.buscador = new Buscador(vocabulario, posteoRepository);
    }

    public void recuperarVocabulario(){
        this.vocabulario.getAllDocumentos(documentoRepository);
        this.vocabulario.getAllTerminos(terminoRepository);
    }

    public void buscar(String terminos){
        this.buscador.buscar(terminos);
    }

    public String mostrarDocumentosRecuperados() {
        return buscador.mostrarDocumentosRecuperados();
    }

    public String mostrarDocumentos(){
        return vocabulario.mostrarDocumentos();
    }

    public int mostrarCantidadTerminosVocabulario(){
        return vocabulario.cantidadTerminos();
    }
}
