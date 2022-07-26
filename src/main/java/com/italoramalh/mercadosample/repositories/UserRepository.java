package com.italoramalh.mercadosample.repositories;

import com.italoramalh.mercadosample.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

}
