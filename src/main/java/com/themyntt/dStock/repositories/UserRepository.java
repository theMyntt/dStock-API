package com.themyntt.dStock.repositories;

import com.themyntt.dStock.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    UserModel findByAccess(int id, String password);
}
