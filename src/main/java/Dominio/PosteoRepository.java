package Dominio;

import java.util.Map;

public interface PosteoRepository {

    Posteo getDocumento();
    Map<String, Posteo> getDocumentos();
    void saveDocumento(Posteo posteo);
    void saveDocumentos(Map<String, Termino> vocabulario);
}
