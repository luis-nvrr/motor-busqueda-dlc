package Infraestructura;

import Dominio.Documento;
import Dominio.Posteo;
import Dominio.PosteoRepository;
import Dominio.Termino;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class MySQLPosteoRepository implements PosteoRepository {
    private Connection connection;

    @Override
    public Posteo getPosteo() {
        return null;
    }

    @Override
    public Map<String, Posteo> getAllPosteos() {
        return null;
    }

    @Override
    public void savePosteo(Posteo posteo) {

    }

    @Override
    public void savePosteos(Map<String, Termino> vocabulario) {
        try {
            connection = MySQLConnection.conectar();
            Statement statement = connection.createStatement();
            StringBuilder query =
                    new StringBuilder("INSERT INTO Posteos " +
                            "(nombre, termino, frecuenciaTermino) VALUES ");


            for (Map.Entry<String, Termino> entry : vocabulario.entrySet()) {
                String termino = entry.getKey();
                Map<Documento, Posteo> listaPosteos = entry.getValue().getPosteo();

                for (Map.Entry<Documento, Posteo> entryPosteo : listaPosteos.entrySet()) {
                    Posteo posteo = entryPosteo.getValue();
                    String nombre = posteo.obtenerNombre();
                    int frecuenciaTermino = posteo.getFrecuenciaTermino();

                    query.append("('").append(nombre).append("','")
                            .append(termino).append("',")
                            .append(frecuenciaTermino).append("),");
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
