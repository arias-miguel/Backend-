package com.company.daos;

import com.company.model.Odontologo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGO VALUES (?,?,?)");
            preparedStatement.setLong(1,odontologo.getNumeroMatricula());
            preparedStatement.setString(2,odontologo.getNombre());
            preparedStatement.setString(3,odontologo.getApellido());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return odontologo;
    }

    @Override
    public void eliminar(int numeroMatricula) {

    }

    @Override
    public Odontologo buscar(int numeroMatricula) {
        return null;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        return null;
    }
}
