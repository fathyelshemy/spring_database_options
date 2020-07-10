package com.database.demo.demo.jpa.springjpa;

import com.database.demo.demo.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<Client, Long> {

}
