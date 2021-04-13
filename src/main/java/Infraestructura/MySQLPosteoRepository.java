package Infraestructura;

import Dominio.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class MySQLPosteoRepository implements PosteoRepository {
    private Connection connection;

    @Override
    public Posteo getPosteo() {
        return null;
    }

    @Override
    public void savePosteo(Posteo posteo) {
    }

    @Override
    public void getAllPosteos(Map<String, Termino> terminos, Map<String, Documento> documentos) {
        try{
            connection = MySQLConnection.conectar();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM Posteos";
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                String terminoString = resultSet.getString("termino");
                String documentoString = resultSet.getString("nombre"); // TODO cambiar nombre por documento
                int frecuenciaTermino = resultSet.getInt("frecuenciaTermino");

                Documento documento = documentos.get(documentoString);
                Posteo posteo = new Posteo(documento, frecuenciaTermino);

                Termino termino = terminos.get(terminoString);
                termino.agregarAListaPosteos(posteo);
            }
            connection.close();
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void savePosteos(Map<String, Termino> terminos) {
        try {
            connection = MySQLConnection.conectar();
            Statement statement = connection.createStatement();
            StringBuilder query =
                    new StringBuilder("INSERT INTO Posteos " +
                            "(nombre, termino, frecuenciaTermino) VALUES "); // TODO cambiar nombre por documento


            for (Map.Entry<String, Termino> entry : terminos.entrySet()) {
                String palabra = entry.getKey();
                Termino termino = entry.getValue();
                List<Posteo> listaPosteos = termino.getPosteos();

                for (Posteo posteo : listaPosteos) {
                    String documento = posteo.obtenerNombre(); // TODO cambiar obtenerNombre por documento
                    int frecuenciaTermino = posteo.getFrecuenciaTermino();

                    query.append("('").append(documento).append("','")
                            .append(palabra).append("',")
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
