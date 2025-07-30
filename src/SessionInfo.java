import java.time.LocalDateTime;

public class SessionInfo {

    enum SessionStatus {
        IN_PROGRESS,
        PAUSED,
        COMPLETED
    }

    // Session durations
    private LocalDateTime time;
    private int sessionLengthInMinutes;

    // Text fields
    private String goalForSession;
    private String reflectionForSession;
    private String nextSteps;
}
