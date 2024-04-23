package EcommerceSystem;

public class CreateAccountException extends Exception {
    CreateAccountException() {
        super("This username has been already used before");
    }
}
