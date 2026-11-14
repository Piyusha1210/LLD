import lombok.Getter;

import java.time.Instant;
import java.util.Map;

@Getter
public class LogFilter {
    private String service;
    private String level;
    private String titleRegex;
    private Instant from;
    private Instant to;
    private Map<String, String> argumentFilters;
    private Integer limit;

    // Constructors, getters and setters are already implemented.
}