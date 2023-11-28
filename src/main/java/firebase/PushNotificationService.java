package firebase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PushNotificationService {
    public static final Logger logger = LoggerFactory.getLogger(PushNotificationService.class);

    private static int LIMIT_CALL_API_HMS_OAUTH= 3;

    private static Object entityManager = new Object();

    public static void send() throws PushNotificationException, IOException{

    }

    public static List<Map<String,String>> broadCast(){
        return null;
    }

    public static void sendToPushNotificationService() throws PushNotificationException{

    }

    private static boolean isFCM(){
        return false;
    }

//    private static void broadCastWebPushMessage(Entit)

}
