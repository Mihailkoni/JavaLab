package DB.DAO;

import DTO.Appliance;
import DB.Config.DBConfig;

import java.sql.*;
import java.util.ArrayList;

/* Как я понял из задания, мы реализуем паттерн DAO(Data Access Object), но только с добавлением и просмотром.*/

public class ApplianceDAO {

    private Connection connection;

    public ApplianceDAO() {
        try{
            connection = DriverManager.getConnection(DBConfig.url, DBConfig.user, DBConfig.password);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void add(Appliance appliance){
        String sqlRequest = "INSERT INTO products (name, category, price) VALUES (?, ?, ?)";
        try(PreparedStatement statement = connection.prepareStatement(sqlRequest)){
            statement.setString(1,appliance.name());
            statement.setString(2,appliance.category());
            statement.setDouble(3,appliance.price());
            statement.executeUpdate();
            System.out.println("Продукт добавлен");
        }catch (SQLException e){
            System.err.printf("Ошибка при добавлении продукта с Name: %s | Category: %s | Price: %.02f%n",
                    appliance.name(),
                    appliance.category(),
                    appliance.price());
            e.printStackTrace();
        }
    }

    public void delete(Appliance appliance){
        String sqlRequest = "DELETE FROM products WHERE (name = ? AND category = ? AND price = ?)";
        try(PreparedStatement statement = connection.prepareStatement(sqlRequest)){
            statement.setString(1,appliance.name());
            statement.setString(2,appliance.category());
            statement.setDouble(3,appliance.price());
            int checker = statement.executeUpdate();
            if(checker > 0){
                System.out.printf("Продукт Name: %s | Category: %s | Price: %.02f был удалён%n",
                        appliance.name(),
                        appliance.category(),
                        appliance.price());
            }else{
                System.out.printf("Продукт Name: %s | Category: %s | Price: %.02f не найден%n",
                        appliance.name(),
                        appliance.category(),
                        appliance.price());
            }
        }catch (SQLException e){
            System.err.printf("Ошибка при удалении продукта с Name: %s | Category: %s | Price: %.02f%n",
                    appliance.name(),
                    appliance.category(),
                    appliance.price());
            e.printStackTrace();
        }
    }

    public void deleteById(int id){
        String sqlRequest = "DELETE FROM products WHERE id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sqlRequest)){
            statement.setInt(1,id);
            int checker = statement.executeUpdate();
            if(checker > 0){
                System.out.printf("Продукт c ID: %d удалён%n",id);
            }else{
                System.out.printf("Продукт c ID: %d не найден%n",id);
            }
        }catch (SQLException e){
            System.err.printf("Ошибка при удалении продукта с ID: %d%n",id);
            e.printStackTrace();
        }
    }

    public void update(int id, String newName, String newCategory, double newPrice) {
        String sqlRequest = "UPDATE products SET name = ?, category = ?, price = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlRequest)) {
            statement.setString(1, newName);
            statement.setString(2, newCategory);
            statement.setDouble(3, newPrice);
            statement.setInt(4, id);
            int checker = statement.executeUpdate();
            if (checker > 0) {
                System.out.printf("Продукт с ID: %d успешно обновлён%n",id);
            } else {
                System.out.printf("Продукт с ID: %d не найден%n",id);
            }
        } catch (SQLException e) {
            System.err.printf("Ошибка при обновлении продукта с ID: %d%n",id);
            e.printStackTrace();
        }
    }

    public void deleteByName(String name){
        String sqlRequest = "DELETE FROM products WHERE name = ?";
        try(PreparedStatement statement = connection.prepareStatement(sqlRequest)){
            statement.setString(1,name);
            int checker = statement.executeUpdate();
            if(checker > 0){
                System.out.printf("Продукт c Name: %s удалён%n",name);
            }else{
                System.out.printf("Продукт c Name: %s не найден%n",name);
            }
        }catch (SQLException e){
            System.err.printf("Ошибка при удалении продукта с Name: %s%n",name);
            e.printStackTrace();
        }
    }

    public void cleanTable(){
        String sqlRequest = "DELETE FROM products";
        try(PreparedStatement statement = connection.prepareStatement(sqlRequest)){
            int checker = statement.executeUpdate();
            if(checker > 0){
                System.out.println("Таблица очищена");
            }else{
                System.out.println("Таблица пуста");
            }
        }catch (SQLException e){
            System.err.println("Ошибка при очистке таблицы");
            e.printStackTrace();
        }
    }

    public void print() {
        String sqlRequest = "SELECT * FROM products";
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlRequest)){
            ArrayList<Appliance> applianceArrayList = new ArrayList<>();
            while(resultSet.next()){
                Appliance appliance = new Appliance(
                        resultSet.getString("name"),
                        resultSet.getString("category"),
                        resultSet.getDouble("price"));
                System.out.println(appliance);
            }
        }catch (SQLException e){
            System.err.println("Ошибка при выводе таблицы");
            e.printStackTrace();
        }
    }
}
