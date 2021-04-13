package Dominio;

import java.util.List;
import java.util.Map;

public interface PosteoRepository {

    Posteo getPosteo();
    void getAllPosteos(Map<String, Termino> terminos, Map<String, Documento> documentos);
    void savePosteo(Posteo posteo);
    void savePosteos(Map<String, Termino> terminos);
}
