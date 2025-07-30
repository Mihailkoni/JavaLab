package Main;

import DB.DAO.ApplianceDAO;
import DTO.Appliance;

public class Main {
    public static void main(String[] args) {
        ApplianceDAO applianceDAO = new ApplianceDAO();
        applianceDAO.add(new Appliance("Смартфон OnePlus", "Электроника",50_000));
        applianceDAO.print();
    }
}
