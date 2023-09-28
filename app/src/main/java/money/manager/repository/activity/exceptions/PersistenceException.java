package money.manager.repository.activity.exceptions;

public class PersistenceException extends RuntimeException {
    public PersistenceException(final String aMessage) {
        super(aMessage);
    }
}