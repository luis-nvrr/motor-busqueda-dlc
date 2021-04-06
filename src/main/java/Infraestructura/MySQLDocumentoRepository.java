package Infraestructura;

import Dominio.DocumentoRepository;
import Dominio.Documento;
import Dominio.Termino;

import javax.print.Doc;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class MySQLDocumentoRepository implements DocumentoRepository {

    private Connection connection;

    @Override
    public void saveDocumentos(Map<String, Documento> documentos) {
        try {
            connection = MySQLConnection.conectar();
            Statement statement = connection.createStatement();
            StringBuilder query =
                    new StringBuilder("INSERT INTO Documentos " +
                            "(nombre, path, link) VALUES ");

            for (Map.Entry<String, Documento> entry : documentos.entrySet()) {
                Documento documento = entry.getValue();
                String nombre = documento.getNombre();
                String path = documento.getPath();
                String link = documento.getLink();

                query.append("('").append(nombre).append("','")
                        .append(path).append("','")
                        .append(link).append("'),");
            }
            query.setCharAt(query.length()-1, ';');

            statement.execute(query.toString());
            connection.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
