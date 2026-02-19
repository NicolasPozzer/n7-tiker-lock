package com.example.n7_tiker_lock.services;

import com.example.n7_tiker_lock.model.Tiker;
import java.util.List;

public interface iTikerService {
    /*Traer Todos*/
    public List<Tiker> getTikers();

    /*Crear*/
    public void saveTiker(Tiker tiker);

    /*Eliminar*/
    public void deleteTiker(Integer id);

    /*Buscar uno*/
    public Tiker findTiker(Integer id);

    /*Editar/Modificar*/
    public void editTiker(Tiker tiker);
}
