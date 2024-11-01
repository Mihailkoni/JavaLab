public class Main {
    //персональные данные (паспорт, регистрация, СНИЛС)
    //формат ввода: 1234 567890;Россия,г.Санкт-петербург,ул.Державина,д.21,кв.801;123-456-789 12
    /*
        "^" - начало строки
        "$" - конец строки
        "\\s" - пробел
        "?" - может встретиться либо один раз, либо вовсе отсутствовать
        "*" - может встретиться 0 или более раз
        "[-–\\s]" - чтобы между словами могло быть тире или пробел
        "\\d" - цифра или число
    */
    static boolean isCorrect(String str){
        //создаем массив и разделяем строку
        String[] splitStr = str.split(";");

        //проверяем наличия нужных данных в строке(персональные данные (паспорт, регистрация, СНИЛС))
        if(splitStr.length != 3){
            return false;
        }

        //cоздаём переменные для хранения переменных паспорта и СНИЛС и убираем пробелы слева и справа
        String passport = splitStr[0].trim();
        String snils = splitStr[2].trim();

        //регулярные выражения для паспорта и СНИЛС
        String passportRegEx = "\\d{4} \\d{6}";
        String snilsRegEx = "\\d{3}-\\d{3}-\\d{3} \\d{2}";

        //убираем пробелы слева и справа для регистрации
        String registration = splitStr[1].trim();

        // создаём массив и разделяем строку регистрации
        String[] splitRegistration = registration.split(",");

        //проверяем наличия нужных данных в регистрации(страна,город,улица,дом,квартира)
        if(splitRegistration.length != 5){
            return false;
        }

        //создаём переменные для хранения данных регистрации (страна,город,улица,дом,квартира) и удаляем пробелы слева и справа
        String country = splitRegistration[0].trim();
        String city = splitRegistration[1].trim();
        String street = splitRegistration[2].trim();
        String house = splitRegistration[3].trim();
        String apartment = splitRegistration[4].trim();

        //регулярные выражения для регистрации(страна,город,улица,дом,квартира)
        String countryRegEx = "^[А-ЯЁа-яё]+$";
        String cityRegEx = "^г\\.\\s?[А-ЯЁа-яё]+([-–\\s]?[А-ЯЁа-яё]+)*$";
        String streetRegEx = "^ул\\.\\s?[А-ЯЁа-яё\\s]+$";
        String houseRegEx = "^д\\.\\s?\\d{1,4}$";
        String apartmentRegEx = "^кв\\.\\s?\\d{1,4}$";

        return passport.matches(passportRegEx) && snils.matches(snilsRegEx) &&
                (country.matches(countryRegEx) && city.matches(cityRegEx) && street.matches(streetRegEx) && house.matches(houseRegEx) && apartment.matches(apartmentRegEx));
    }

    public static void main(String[] args) {
        System.out.println(isCorrect("1234 567890;Россия,г.Санкт-петербург,ул.Державина,д.21,кв.801;123-456-789 12"));
    }
}
