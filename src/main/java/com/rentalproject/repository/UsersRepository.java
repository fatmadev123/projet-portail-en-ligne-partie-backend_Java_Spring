package com.rentalproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rentalproject.models.Users;

@Repository
public interface UsersRepository  extends CrudRepository<Users, Long> {

}
