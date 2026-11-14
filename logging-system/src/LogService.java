import java.util.*;

public class LogService {

    private final LogRepository repository;

    public LogService(LogRepository repository) {
        this.repository = repository;
    }

    public List<LogEntry> filterLogs(LogFilter filter) {

        // TODO: Implement filtering functionality.
        List<LogEntry> logEntries = repository.findAll();
        List<LogEntry> filterLogs = new ArrayList<>();

        for(LogEntry logEntry: logEntries) {
            if(!filter.getService().isEmpty() && !validateFilter("service", logEntry, filter)) {
                continue;
            }
            if(!filter.getLevel().isEmpty() && !validateFilter("level", logEntry, filter)) {
                continue;
            }
            if(filter.getFrom() != null && !validateFilter("from", logEntry, filter)) {
                continue;
            }
            if(filter.getTo() != null && !validateFilter("to", logEntry, filter)) {
                continue;
            }
            if(!filter.getTitleRegex().isEmpty() && !validateTitleRegex(logEntry.getTitle(), filter.getTitleRegex())) {
                continue;
            }
            if(filter.getArgumentFilters() != null && !filter.getArgumentFilters().isEmpty()) {
                if(checkArgumentParams(filter.getArgumentFilters(), logEntry.getArguments())) {
                    continue;
                }
            }
            filterLogs.add(logEntry);
            if(filter.getLimit() != null && filterLogs.size() >= filter.getLimit())
                return filterLogs;
        }
        return filterLogs;
    }

    private boolean validateFilter(String fieldName, LogEntry log, LogFilter filter) {
        if(Objects.equals(fieldName, "service") && !Objects.equals(filter.getService(), log.getService())) {
            return false;
        }
        if(Objects.equals(fieldName, "level") && !Objects.equals(filter.getLevel(), log.getLevel())) {
            return false;
        }
        if(Objects.equals(fieldName, "from") && Integer.getInteger(log.getTimestamp().toString()) < Integer.getInteger(filter.getFrom().toString())) {
            return false;
        }
        if(Objects.equals(fieldName, "to") && Integer.getInteger(log.getTimestamp().toString()) > Integer.getInteger(filter.getFrom().toString())) {
            return false;
        }
        return true;
    }

    private boolean checkArgumentParams(Map<String, String> argumentFilters, Map<String, String> logArgument) {
        for(String key: argumentFilters.keySet()) {
            if(!logArgument.containsKey(key) || !Objects.equals(logArgument.get(key), argumentFilters.get(key))) {
                return false;
            }
        }
        return true;
    }

    private boolean validateTitleRegex(String logTitle, String titleFilterRegex) {
        // TODO to implement for now not implementing this
        return true;
    }
}