package Infraestructura;

import Dominio.Documento;
import Dominio.DocumentoRepository;

import java.util.Map;

public class MySQLDocumentoRepository implements DocumentoRepository {

    @Override
    public Documento getDocumento() {
        return null;
    }

    @Override
    public Map<String, Documento> getDocumentos() {
        return null;
    }

    @Override
    public void saveDocumento(Documento documento) {

    }

    @Override
    public void saveDocumentos(Map<String, Documento> documentos) {

    }
}
