package command;

import model.User;

public class BillingCommand implements Command {
    private User user;
    private String format;

    public BillingCommand(User user, String format) {
        this.user = user;
        this.format = format;
    }

    @Override
    public void execute() {
        System.out.println("Facturando a " + user.getUsername() + " por conversión a " + format);
    }
}