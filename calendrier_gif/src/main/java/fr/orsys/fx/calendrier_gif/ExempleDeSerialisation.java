package fr.orsys.fx.calendrier_gif;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.orsys.fx.calendrier_gif.business.Theme;

public class ExempleDeSerialisation {

    public static void main(String[] args) {
        System.out.println("Exemples de sérialisation");
        
        // Sérialisation : on prend un objet Java et on l'exprime en JSON
        // Désérialisation : on reçoit un bloc de texte en JSON et on l'utilise pour hydrater un
        // objet métier Java
        
        // On déclare et on instancie un objet de type ObjectMapper qui est capable
        // de sérialiser n'importe quel objet Java
        ObjectMapper objectMapper = new ObjectMapper();
        
        Theme theme = new Theme("Light");
        System.out.println(theme);
        
        try {
            System.out.println(objectMapper.writeValueAsString(theme));
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}