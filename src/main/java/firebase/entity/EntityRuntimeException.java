package firebase.entity;


public class EntityRuntimeException extends RuntimeException {
    private static final long serialVersionID = 1l;

    public EntityRuntimeException(){
    }

    public EntityRuntimeException (String message, Throwable cause){
        super(message,cause);
    }

    public EntityRuntimeException(String message){
        super(message);
    }

    public EntityRuntimeException(Throwable cause){
        super(cause);
    }
}
