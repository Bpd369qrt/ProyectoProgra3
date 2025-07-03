package observer;

public class SlackNotifier implements Observer {
    @Override
    public void update(String message) {
        System.out.println("[Slack] Notificación: " + message);
    }
}