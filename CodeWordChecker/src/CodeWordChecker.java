public class CodeWordChecker implements StringChecker {
    private final int minLength;
    private final int maxLength;
    private final String badStr;

    public CodeWordChecker(int minLength, int maxLength, String badStr) {
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.badStr = badStr;
    }

    public CodeWordChecker(String badStr) {
        this(6, 20, badStr);
    }

    public boolean isValid(String str) {
        return (str.length() >= minLength) && (str.length() <= maxLength) && (!str.toLowerCase().contains(badStr));
    }
}
