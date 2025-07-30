public class Main {
    public static void main(String[] args) {
        System.out.println("First example:");
        StringChecker stringChecker1 = new CodeWordChecker(5, 8, "$");
        System.out.println(stringChecker1.isValid("happy"));
        System.out.println(stringChecker1.isValid("happy$"));
        System.out.println(stringChecker1.isValid("Code"));
        System.out.println(stringChecker1.isValid("happyCode"));

        System.out.println("Second example:");
        StringChecker stringChecker2 = new CodeWordChecker("pass");
        System.out.println(stringChecker2.isValid("MyPass"));
        System.out.println(stringChecker2.isValid("Mypassport"));
        System.out.println(stringChecker2.isValid("happy"));
        System.out.println(stringChecker2.isValid("1,000,000,000,000,000"));
    }
}