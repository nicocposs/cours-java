package fr.orsys.fx.calendrier_gif.exception;

public class JourExistantException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public JourExistantException(String message) {
        super(message);
    }

}