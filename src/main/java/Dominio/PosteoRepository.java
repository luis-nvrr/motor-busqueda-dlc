package Dominio;

import java.util.Map;

public interface PosteoRepository {

    Posteo getPosteo();
    Map<String, Posteo> getAllPosteos();
    void savePosteo(Posteo posteo);
    void savePosteos(Map<String, Termino> vocabulario);
}
