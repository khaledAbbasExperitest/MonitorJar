import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class InitLogger {
    private final static Logger logger = Logger.getLogger(InitLogger.class.getName());
    private static FileHandler fh = null;

    public static void init(){
            try {
                File theDir = new File("logs");

                // if the directory does not exist, create it
                if (!theDir.exists()) {
                    System.out.println("creating directory: " + theDir.getName());
                    boolean result = false;
                    try{
                        theDir.mkdir();
                        result = true;
                    }
                    catch(SecurityException se){
                        se.printStackTrace();
                    }
                    if(result) {
                        System.out.println("DIR created");
                    }
                }
                fh = new FileHandler("logs/Main.log", false);
            } catch (SecurityException | IOException e) {
                e.printStackTrace();
            }

        Logger l = Logger.getLogger("");
        fh.setFormatter(new SimpleFormatter());
        l.addHandler(fh);
        l.setLevel(Level.FINE);
        logger.log(Level.INFO, "Enabled logging with level " + logger.getLevel());
    }


}