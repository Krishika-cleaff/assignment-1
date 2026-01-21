package Assignment1.model;

public record Email(String value) {

    public Email {
        if (value == null || !value.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
