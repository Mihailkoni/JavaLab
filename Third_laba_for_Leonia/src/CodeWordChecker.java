public class CodeWordChecker implements StringChecker {
    int minLength;
    int maxLength;
    String badStr;

    public CodeWordChecker(int minLength,int maxLength,String badStr){
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.badStr = badStr;
    }

    public CodeWordChecker(String badStr){
        this.badStr = badStr;
        this.minLength = 6;
        this.maxLength = 20;
    }

    public boolean isValid(String str){
        return (str.length() >= minLength) && (str.length() <= maxLength) && (!str.contains(badStr));
    }

}
