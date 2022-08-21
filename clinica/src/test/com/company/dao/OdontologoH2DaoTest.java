package test.com.company.dao;

import main.com.company.dao.IDao;
import main.com.company.dao.impl.OdontologoDaoH2;
import main.com.company.model.Odontologo;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
@RunWith(JUnit4.class)

public class OdontologoH2DaoTest {
    private  static IDao<Odontologo> odontologoDao = new OdontologoDaoH2();

    @BeforeClass
    public static void cargarOdontologo() {
        odontologoDao.guardar(new Odontologo(1, "OdontologoUno", "ApellidoUno"));
        odontologoDao.guardar(new Odontologo(2, "OdontologoDos", "ApellidoDos"));
        odontologoDao.guardar(new Odontologo(3, "OdontologoTres", "ApellidoTres"));
        odontologoDao.guardar(new Odontologo(4, "OdontologoCuatro", "ApellidoCuatro"));
    }

    @Test
    public  void guardarYBuscarOdontologosTest() {
        odontologoDao.guardar(new Odontologo(5, "juan", "Perez"));
        Odontologo estudiante = odontologoDao.buscar(5);
        Assert.assertNotNull(estudiante);
        Assert.assertEquals(estudiante.getNombre(), "juan");

    }

    @Test
    public  void traerTodosLosEstudiantesTest() {
        List<Odontologo> estudiantes = odontologoDao.buscarTodos();
        Assert.assertTrue(estudiantes.size() > 0);
    }

    @Test
    public void eliminarEstudiantesTest() {
        odontologoDao.eliminar(1);
        Assert.assertEquals(odontologoDao.buscar(1),null);
        odontologoDao.eliminar(2);
        Assert.assertEquals(odontologoDao.buscar(2),null);
        odontologoDao.eliminar(3);
        Assert.assertEquals(odontologoDao.buscar(3),null);
        odontologoDao.eliminar(4);
        Assert.assertEquals(odontologoDao.buscar(4),null);
        odontologoDao.eliminar(5);
        Assert.assertEquals(odontologoDao.buscar(5),null);


    }
}
