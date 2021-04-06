package Infraestructura;

import Dominio.Documento;
import Dominio.DocumentoRepository;
import Dominio.Termino;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class MySQLDocumentoRepository implements DocumentoRepository {
    private final Connection connection = MySQLConnection.conectar();

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
        try {
            Statement statement = connection.createStatement();
            StringBuilder query =
                    new StringBuilder("INSERT INTO Documentos " +
                            "(path, frecuenciaTermino, link) VALUES ");

            for (Map.Entry<String, Documento> entry : documentos.entrySet()) {

                String path = entry.getValue().getPath();
                int frecuenciaTermino = entry.getValue().getFrecuenciaTermino();
                String link = entry.getValue().getLink();

                query.append("('").append(path).append("',")
                        .append(frecuenciaTermino).append(",'")
                        .append(link).append("'),");
            }
            query.setCharAt(query.length()-1, ';');

            statement.execute(query.toString());

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
