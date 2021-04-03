package Infraestructura;

import Dominio.Termino;
import Dominio.TerminoRepository;

import java.util.Map;

public class MySQLTerminoRepository implements TerminoRepository {

    @Override
    public Termino getTermino(String termino) {
        return null;
    }

    @Override
    public Map<String, Termino> getTerminos() {
        return null;
    }

    @Override
    public void saveTermino(Termino termino) {

    }

    @Override
    public void saveTerminos(Map<String, Termino> terminos) {

    }
}
