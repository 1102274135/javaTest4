package bai.javatest4.exception;

public class CustomerNotFoundException extends Exception {
    private String message;

    public CustomerNotFoundException() {
    }

    public CustomerNotFoundException(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
