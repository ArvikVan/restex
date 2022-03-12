package rest.exception;

/**
 * @author ArvikV
 * @version 1.0
 * @since 12.03.2022
 */
public class NoEmployeeException extends RuntimeException {
    public NoEmployeeException(String message) {
        super(message);
    }
}
