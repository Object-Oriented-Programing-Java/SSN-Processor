package socsecexception;
/**
 * The SocSecException class extends the exception class.
 */
public class SocSecException extends Exception {

    /**
     * The constructor calls the super constructor.
     * @param error the type of error message.
     */
    public SocSecException(String error){
      
        super("Invalid social security number,"+ error);
    }
    
}
