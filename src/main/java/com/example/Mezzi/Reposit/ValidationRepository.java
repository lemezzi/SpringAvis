package com.example.Mezzi.Reposit;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Mezzi.Classes.Validation;

@Repository
public interface ValidationRepository extends JpaRepository<Validation, Long> {

    @Query("SELECT v FROM Validation v WHERE v.code = :code")
    Optional<Validation> findByCode(@Param("code") String code);
    
}
