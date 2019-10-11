package StudentGrades;

public enum Subject {
    MATH("Matematyka", "math"),
    POLISH("Polski", "polish"),
    ENGLISH("Angielski", "english");

    private String displayName;
    private String sessionKey;

    Subject(String displayName, String sessionKey) {
        this.displayName = displayName;
        this.sessionKey = sessionKey;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getSessionKey() {
        return sessionKey;
    }
}
