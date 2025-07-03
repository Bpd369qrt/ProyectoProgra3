package model;

public class DocumentJob {
    private String sourceFilePath;
    private String outputFormat;
    private String watermarkText;
    private boolean highPriority;
    private String userEmail;
    private User requestingUser;

    public DocumentJob(String source, String format, String watermark, boolean priority, User user, String email) {
        this.sourceFilePath = source;
        this.outputFormat = format;
        this.watermarkText = watermark;
        this.highPriority = priority;
        this.requestingUser = user;
        this.userEmail = email;
    }

    public String getSourceFilePath() { return sourceFilePath; }
    public String getOutputFormat() { return outputFormat; }
    public boolean isHighPriority() { return highPriority; }
    public String getUserEmail() { return userEmail; }
    public User getRequestingUser() { return requestingUser; }
}