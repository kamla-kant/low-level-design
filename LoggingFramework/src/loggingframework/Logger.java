package loggingframework;

import logappender.ConsoleAppender;

public class Logger {
    private static final Logger instance = new Logger();
    private LoggerConfig config;

    private Logger() {
        config = new LoggerConfig(LogLevel.INFO, new ConsoleAppender(new DefaultFormatter()));
    }

    public static Logger getInstance() {
        return instance;
    }

    public void setConfig(LoggerConfig config) {
        this.config = config;
    }

    public void log(LogLevel level, String message){
        if(level.ordinal() >= config.getLogLevel().ordinal()) {
            LogMessage logMessage = new LogMessage(level, message);
            config.getLogAppender().append(logMessage);
        }
    }

    public void debug(String msg){
        log(LogLevel.DEBUG, msg);
    }

    public void info(String msg){
        log(LogLevel.INFO, msg);
    }

    public void warn(String msg){
        log(LogLevel.WARN, msg);
    }

    public void error(String msg){
        log(LogLevel.ERROR, msg);
    }

    public void fatal(String msg){
        log(LogLevel.FATAL, msg);
    }
}
