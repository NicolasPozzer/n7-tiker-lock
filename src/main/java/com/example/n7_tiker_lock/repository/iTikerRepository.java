package com.example.n7_tiker_lock.repository;

import com.example.n7_tiker_lock.model.Tiker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iTikerRepository extends JpaRepository<Tiker, Integer> {
}
