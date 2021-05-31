
package com.example.AplicacionWeb2.repository;

import com.example.AplicacionWeb2.entity.Persona;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("personarepository")
public interface PersonaRepository extends JpaRepository<Persona, Serializable>{
    
    
    public Persona findById(int id); 
}
