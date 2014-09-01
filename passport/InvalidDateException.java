public class InvalidDateException extends Exception {
    public String text;
    InvalidDateException(String text) {
        this.text = text;
    }
}