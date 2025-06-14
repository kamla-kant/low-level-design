package loggingframework;

import logappender.FileAppender;

public class LoggingFrameworkMain {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        // Logging with default configuration
        logger.info("This is an information message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");

        // Changing log level and appender
        LoggerConfig config = new LoggerConfig(LogLevel.DEBUG, new FileAppender("app.log", new DefaultFormatter()));
        logger.setConfig(config);

        logger.debug("This is a debug message");
        logger.info("This is an information message");
    }
}