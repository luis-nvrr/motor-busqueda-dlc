package Dominio;

import java.util.Map;

public interface DocumentoRepository {
    void saveDocumentos(Map<String, Documento> documentos);
    Map<String, Documento> getAllDocumentos();
}
