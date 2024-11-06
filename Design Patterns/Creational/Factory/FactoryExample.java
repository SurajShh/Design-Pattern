interface Notification {
    void notifyUser();
}

class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending email notification");
    }
}

class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending SMS notification");
    }
}

class NotificationFactory {
    public static Notification createNotification(String type) {
        if (type.equalsIgnoreCase("email")) {
            return new EmailNotification();
        } else if (type.equalsIgnoreCase("sms")) {
            return new SMSNotification();
        }
        return null;
    }
}

public class FactoryExample {
    public static void main(String[] args) {
        Notification notification = NotificationFactory.createNotification("email");
        notification.notifyUser();
    }
}
