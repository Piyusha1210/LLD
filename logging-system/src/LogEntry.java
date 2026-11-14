import java.time.Instant;
import java.util.Collections;
import java.util.Map;

public class LogEntry {
    private final Instant timestamp;
    private final String service;
    private final String level;
    private final String title;
    private final Map<String, String> arguments;

    public LogEntry(Instant timestamp, String service,
                    String level, String title,
                    Map<String, String> arguments) {
        this.timestamp = timestamp;
        this.service = service;
        this.level = level;
        this.title = title;
        this.arguments = arguments == null
                ? Collections.emptyMap()
                : Map.copyOf(arguments);
    }

    public Instant getTimestamp() { return timestamp; }
    public String getService() { return service; }
    public String getLevel() { return level; }
    public String getTitle() { return title; }
    public Map<String, String> getArguments() { return arguments; }
}