package firebase;

public class PushNotificationException extends RuntimeException{

    private static final long serialVersionUID = 1l;

    private Integer retryAfter;

    public Integer getRetryAfter(){
        return retryAfter;
    }

    public PushNotificationException(){
        super();
    }

    public PushNotificationException(String message, Throwable cause){
        super(message, cause);
    }

    public PushNotificationException(String message){
        super(message);
    }

    public PushNotificationException(Throwable cause){
        super(cause);
    }

    public PushNotificationException(Throwable cause, Integer retryAfter){
        super(cause);
        this.retryAfter = retryAfter;
    }

    public PushNotificationException(String failMessage, Integer retryAfter){
        super(failMessage);
        this.retryAfter =retryAfter;
    }
}
