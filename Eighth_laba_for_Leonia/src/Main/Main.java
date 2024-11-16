package Main;

import WorkWithDataBase.WorkWithDataBase;

public class Main {
    public static void main(String[] args) {
        WorkWithDataBase dataBase = new WorkWithDataBase();
        dataBase.addProduct("Смартфон","Электроника",50_000);

        dataBase.printProducts();
    }
}
