package com.example.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.models.Client;



public interface ClientRepository extends CrudRepository<Client, Long>{

}
