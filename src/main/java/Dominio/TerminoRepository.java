package Dominio;

import java.util.Map;

public interface TerminoRepository {

    Termino getTermino(String termino);
    Map<String, Termino> getTerminos();
    void saveTermino(Termino termino);
    void saveTerminos(Map<String, Termino> terminos);
}
