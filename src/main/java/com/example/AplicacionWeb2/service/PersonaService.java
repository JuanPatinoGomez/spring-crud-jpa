
package com.example.AplicacionWeb2.service;

import com.example.AplicacionWeb2.entity.Persona;
import java.util.List;


public interface PersonaService {
    
    public Persona addPersona(Persona persona);
    
    public List<Persona> listAllPersonas();
    
    public Persona findPersonaById(int id);
    
    public void RemovePersona(int id);
    
}
