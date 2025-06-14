package loggingframework;

public class LogMessage {
    private final String message;
    private final String threadName;
    private final LogLevel logLevel;
    private final long timestamp;


    public LogMessage(LogLevel logLevel, String message) {
        this.message = message;
        this.threadName = Thread.currentThread().getName();
        this.logLevel = logLevel;
        this.timestamp = System.currentTimeMillis();;
    }

    public String getMessage() {
        return message;
    }

    public String getThreadName() {
        return threadName;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "[" + logLevel + "] " +timestamp+" - "+ message;
    }
}
