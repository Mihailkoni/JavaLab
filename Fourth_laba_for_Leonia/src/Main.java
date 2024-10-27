public class Main {
    //персональные данные (паспорт, регистрация, СНИЛС)
    //формат ввода: 1234 567890;Россия,Владивосток,Державина,21,801;123-456-789 12
    static boolean isCorrect(String str){
        String[] splitStr = str.split(";");

        if(splitStr.length != 3){
            return false;
        }

        String passport = splitStr[0].trim();
        String registration = splitStr[1].trim();
        String snils = splitStr[2].trim();

        String passportRegEx = "\\d{4} \\d{6}";
        String registrationRegEx = "[А-Яа-я]+,[А-Яа-я]+,[А-Яа-я]+,\\d{1,4},\\d{1,4}";
        String snilsRegEx = "\\d{3}-\\d{3}-\\d{3} \\d{2}";

        return passport.matches(passportRegEx) && registration.matches(registrationRegEx) && snils.matches(snilsRegEx);

    }

    public static void main(String[] args) {
        System.out.println(isCorrect("1234 567890;Россия,Владивосток,Державина,21,801;123-456-789 12"));
    }

}
