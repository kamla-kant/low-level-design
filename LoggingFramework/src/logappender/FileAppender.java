package logappender;

import loggingframework.LogFormatter;
import loggingframework.LogMessage;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender{
    private final LogFormatter logFormatter;
    private FileWriter writer;


    public FileAppender(String filePath, LogFormatter logFormatter){
        this.logFormatter = logFormatter;
        try {
            this.writer = new FileWriter(filePath, true);
        } catch (IOException e) {
            System.out.println("Failed to create writer for file logs, exception: " + e.getMessage());
        }
    }
    @Override
    public void append(LogMessage message) {
        try {
            writer.write(logFormatter.format(message) + "\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println("Failed to write logs to file, exception: " + e.getMessage());
        }
    }
}
