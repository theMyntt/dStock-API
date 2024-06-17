package com.themyntt.dStock.repositories;

import com.themyntt.dStock.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    @Query("SELECT u FROM UserModel u WHERE id = :id AND password = :senha")
    UserModel findByAccess(
            @Param("id") int id,
            @Param("senha") String senha
    );
}
