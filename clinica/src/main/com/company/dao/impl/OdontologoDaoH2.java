package main.com.company.dao.impl;

import main.com.company.dao.IDao;
import main.com.company.model.Odontologo;

import java.sql.*;
import java.util.ArrayList;
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
            preparedStatement.setLong(1, odontologo.getNumeroMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return odontologo;
    }

    @Override
    public void eliminar(int numeroMatricula) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("DELETE FROM ODONTOLOGO WHERE NUMEROMATRICULA=?");
            preparedStatement.setLong(1, numeroMatricula);

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public Odontologo buscar(int numeroMatricula) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Odontologo odontologo = null;

        try {

            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGO WHERE NUMEROMATRICULA=?");
            preparedStatement.setLong(1, numeroMatricula);


            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int numeromatricula = result.getInt("numeroMatricula");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                odontologo = new Odontologo();
                odontologo.setNumeroMatricula(numeromatricula);
                odontologo.setNombre(nombre);
                odontologo.setApellido(apellido);
            }
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        List<Odontologo> odontologos = new ArrayList();

        try {

            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGO");


            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int numeromatricula = result.getInt("numeroMatricula");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");

                Odontologo odontologo = new Odontologo();
                odontologo.setNumeroMatricula(numeromatricula);
                odontologo.setNombre(nombre);
                odontologo.setApellido(apellido);

                odontologos.add(odontologo);
            }
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return odontologos;
    }
}

