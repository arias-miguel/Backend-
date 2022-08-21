package main.com.company.dao;

import java.util.List;

public interface IDao<T> {

    public T guardar(T t);
    public void eliminar(int numeroMatricula);
    public T buscar(int numeroMatricula);
    public List<T> buscarTodos();
}
