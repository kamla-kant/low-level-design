package logappender;

import loggingframework.LogMessage;

public interface LogAppender {
    void append(LogMessage message);
}
