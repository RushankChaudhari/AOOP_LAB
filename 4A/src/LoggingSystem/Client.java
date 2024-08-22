package LoggingSystem;

public class Client {
    public static void main(String[] args) {

    	LogHandler infoHandler = new InfoHandler();
        LogHandler debugHandler = new DebugHandler();
        LogHandler errorHandler = new ErrorHandler();

        infoHandler.setNextHandler(debugHandler);
        debugHandler.setNextHandler(errorHandler);

        Command logCommand = new LogCommand(infoHandler);

        Logger logger = new Logger();
        logger.addCommand(logCommand);

        logger.processCommands();

        logCommand.execute("This is an info message", LogLevel.INFO);
        logCommand.execute("This is a debug message", LogLevel.DEBUG);
        logCommand.execute("This is an error message", LogLevel.ERROR);
    }
}

