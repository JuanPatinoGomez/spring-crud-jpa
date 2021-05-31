
package com.example.AplicacionWeb2.controller;

import com.example.AplicacionWeb2.entity.Persona;
import com.example.AplicacionWeb2.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonaController {
    
    
    @Autowired
    @Qualifier("personaservice")
    private PersonaService personaService;
    
    @RequestMapping("/")
    public String redirectListadoPersonas(){
        
        return "redirect:/listpersonas";
    }
    
    @RequestMapping("/listpersonas")
    public ModelAndView listadoPersonas(){
        
        ModelAndView mav = new ModelAndView("personas");
        mav.addObject("listPersonas", personaService.listAllPersonas());
        return mav;
    }
    
    @RequestMapping("/formulario")
    public String personaForm(Model model, @RequestParam(name = "id", required = true)int id){
        
        Persona person = new Persona();
        
        if (id != 0) { 
        //Si es diferente de 0 significa que le dia a la opción editar y se va a enviar la persona con ese id
            person = personaService.findPersonaById(id);
        }
        
        model.addAttribute("persona", person);
        
        return "personasform";
    }
    
    @PostMapping("/addpersona")
    public String addPersona(@ModelAttribute(name = "persona") Persona persona){
        
        personaService.addPersona(persona);
        return "redirect:/listpersonas";
    }
    
    @RequestMapping("/removepersona")
    public ModelAndView removerPersona(@RequestParam(name = "id", required = true)int id){
    
        personaService.RemovePersona(id);
        
        return listadoPersonas();
    }
    
}
