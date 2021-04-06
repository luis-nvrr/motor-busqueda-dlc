package Infraestructura;

import Dominio.Documento;
import Dominio.DocumentoRepository;
import Dominio.Termino;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class MySQLDocumentoRepository implements DocumentoRepository {
    private Connection connection;

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
    public void saveDocumentos(Map<String, Termino> vocabulario) {
        try {
            connection = MySQLConnection.conectar();
            Statement statement = connection.createStatement();
            StringBuilder query =
                    new StringBuilder("INSERT INTO Documentos " +
                            "(nombre, frecuenciaTermino, link, termino) VALUES ");


            for (Map.Entry<String, Termino> entry : vocabulario.entrySet()) {
                String termino = entry.getKey();
                Map<String, Documento> posteo = entry.getValue().getPosteo();

                for (Map.Entry<String, Documento> entryPosteo : posteo.entrySet()) {

                    String nombre = entryPosteo.getValue().getNombre();
                    int frecuenciaTermino = entryPosteo.getValue().getFrecuenciaTermino();
                    String link = entryPosteo.getValue().getLink();

                    query.append("('").append(nombre).append("',")
                            .append(frecuenciaTermino).append(",'")
                            .append(link).append("','")
                            .append(termino).append("'),");
                }
            }

            query.setCharAt(query.length()-1, ';');

            statement.execute(query.toString());
            connection.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
