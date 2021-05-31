
package com.example.AplicacionWeb2.service.impl;

import com.example.AplicacionWeb2.entity.Persona;
import com.example.AplicacionWeb2.repository.PersonaRepository;
import com.example.AplicacionWeb2.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("personaservice")
public class PersonaServiceImpl implements PersonaService{

    
    @Autowired
    @Qualifier("personarepository")
    PersonaRepository personaRepository;
    
    @Override
    public Persona addPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public List<Persona> listAllPersonas() {
        
        return personaRepository.findAll();
    }

    @Override
    public Persona findPersonaById(int id) {
        return personaRepository.findById(id);
    }

    @Override
    public void RemovePersona(int id) {
        
        Persona persona = findPersonaById(id);
        
        if (persona != null) {
            
            personaRepository.delete(persona);
        }
    }
    
}
