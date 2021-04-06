package Dominio;

import java.util.Map;

public interface DocumentoRepository {

    Documento getDocumento();
    Map<String, Documento> getDocumentos();
    void saveDocumento(Documento documento);
    void saveDocumentos(Map<String, Termino> vocabulario);
}
