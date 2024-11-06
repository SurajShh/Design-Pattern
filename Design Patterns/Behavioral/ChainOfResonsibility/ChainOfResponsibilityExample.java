abstract class SupportHandler {
    protected SupportHandler next;

    public void setNext(SupportHandler next) {
        this.next = next;
    }

    public abstract void handleRequest(String issue);
}

class MinorIssueHandler extends SupportHandler {
    @Override
    public void handleRequest(String issue) {
        if (issue.equals("minor")) {
            System.out.println("Handled by MinorIssueHandler");
        } else if (next != null) {
            next.handleRequest(issue);
        }
    }
}

public class ChainOfResponsibilityExample {
    public static void main(String[] args) {
        SupportHandler minorHandler = new MinorIssueHandler();
        SupportHandler escalationHandler = new EscalationHandler();
        minorHandler.setNext(escalationHandler);
        
        minorHandler.handleRequest("minor");
        minorHandler.handleRequest("escalation");
    }
}
