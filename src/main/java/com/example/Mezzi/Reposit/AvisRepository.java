
package com.example.Mezzi.Reposit;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.Mezzi.Classes.Avis;

public interface AvisRepository extends JpaRepository<Avis, Long> {
  
}
