package com.example.Mezzi.Reposit;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.Mezzi.Classes.User;

public interface UserRepository extends JpaRepository<User, Long> {
     
}
