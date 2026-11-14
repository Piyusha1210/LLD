import java.util.List;

public interface LogRepository {
    List<LogEntry> findAll();
}