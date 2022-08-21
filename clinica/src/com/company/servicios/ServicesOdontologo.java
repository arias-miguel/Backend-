package com.company.servicios;
import com.company.daos.IDao;
import com.company.model.Odontologo;
import java.util.List;


public class ServicesOdontologo {

    private  IDao<Odontologo> odontologoIDao;

    public IDao<Odontologo> getOdontologoIDao() {
        return odontologoIDao;
    }

    public void setOdontologoIDao(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo guardarOdontologo(Odontologo a){
        return odontologoIDao.guardar(a);
    }

    public void eliminarOdontolog(int numeroMatricula){
        odontologoIDao.eliminar(numeroMatricula);
    }

    public Odontologo buscarOdontologo(int numeroMatricula){
        return odontologoIDao.buscar(numeroMatricula);
    }

    public List<Odontologo> buscarTodos(){
        return odontologoIDao.buscarTodos();
    }
}
