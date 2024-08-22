package LoggingSystem;

public class SingletonPattern1A {
    public static void main(String[] args) {
        
        Logger logger = Logger.getInstance();
        
        logger.log("First logIn.");
        logger.log("Second logIn.");
    }
}
