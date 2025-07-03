package model;

public class User {
    private String username;
    private String plan;

    public User(String username, String plan) {
        this.username = username;
        this.plan = plan;
    }

    public String getUsername() {
        return username; }
    public String getPlan() {
        return plan; }
}