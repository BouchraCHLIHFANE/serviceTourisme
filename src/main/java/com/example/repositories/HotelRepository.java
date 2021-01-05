package com.example.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.models.Hotel;

public interface HotelRepository extends CrudRepository<Hotel, Long>{

}
