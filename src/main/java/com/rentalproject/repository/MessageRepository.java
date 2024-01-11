package com.rentalproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rentalproject.models.Messages;

@Repository
public interface MessageRepository extends CrudRepository<Messages, Long>  {

}
