package com.example.n7_tiker_lock.services;

import com.example.n7_tiker_lock.model.Tiker;
import com.example.n7_tiker_lock.repository.iTikerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TikerService implements iTikerService{

    @Autowired
    private iTikerRepository repoTic;

    @Override
    public List<Tiker> getTikers() {
        List<Tiker> listaTikers = repoTic.findAll();
        return listaTikers;
    }

    @Override
    public void saveTiker(Tiker tiker) {
        repoTic.save(tiker);
    }

    @Override
    public void deleteTiker(Integer id) {
        repoTic.deleteById(id);
    }

    @Override
    public Tiker findTiker(Integer id) {
        Tiker tiker = repoTic.findById(id).orElse(null);
        return tiker;
    }

    @Override
    public void editTiker(Tiker tiker) {
        this.saveTiker(tiker);
    }
}
