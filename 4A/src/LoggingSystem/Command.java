package LoggingSystem;

public interface Command {
    void execute(String message, LogLevel level);

}
