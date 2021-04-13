package Aplicacion;

import Dominio.DocumentoRepository;
import Dominio.PosteoRepository;
import Dominio.TerminoRepository;
import Dominio.Vocabulario;
import Infraestructura.MySQLDocumentoRepository;
import Infraestructura.MySQLPosteoRepository;
import Infraestructura.MySQLTerminoRepository;

public class GestorBusqueda {
    DocumentoRepository documentoRepository;
    PosteoRepository posteoRepository;
    TerminoRepository terminoRepository;
    Vocabulario vocabulario;

    public GestorBusqueda(){
        documentoRepository = new MySQLDocumentoRepository();
        posteoRepository = new MySQLPosteoRepository();
        terminoRepository = new MySQLTerminoRepository();
        vocabulario = new Vocabulario();
    }

    public void recuperarVocabulario(){
        vocabulario.getAllDocumentos(documentoRepository);
        vocabulario.getAllTerminos(terminoRepository);
        vocabulario.getAllPosteos(posteoRepository);
    }

    public String mostrarDocumentos(){
        return vocabulario.mostrarDocumentos();
    }
}
