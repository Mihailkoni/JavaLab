package WorkWithDataBase;

import java.sql.*;

// как я понял из задания, мы реализуем паттерн DAO(Data Access Object), но только с добавлением и просмотром. Но я сделаю полный паттерн (с удалением и обновлением информации)
public class WorkWithDataBase {
    // для соединения с БД
    private Connection connection;

    public WorkWithDataBase() {
        try{
            // установка соединения с базой и если нет соединения, то исключение
            connection = DriverManager.getConnection(DataBaseConfig.url,DataBaseConfig.user,DataBaseConfig.password);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    // добавление в БД
    public void addProduct(String name,String category, double price){
        // SQL-запрос с параметрами
        String sqlRequest = "INSERT INTO products (name, category, price) VALUES (?, ?, ?)";
        // использую PreparedStatement
        try(PreparedStatement statement = connection.prepareStatement(sqlRequest)){
            // установка параметров
            statement.setString(1,name);
            statement.setString(2,category);
            statement.setDouble(3,price);
            // выполнение запроса
            statement.executeUpdate();
            System.out.println("Продукт добавлен");
        }catch (SQLException e){
            System.err.printf("Ошибка при добавлении продукта с Name: %s | Category: %s | Price: %.02f%n",name,category,price);
            e.printStackTrace();
        }
    }
    // вывод всей БД
    public void printProducts() {
        // SQL-запрос для получения всех записей из таблицы
        String sqlRequest = "SELECT * FROM products";
        try(Statement statement = connection.createStatement();
            // Выполнение запроса и получение результата.
            ResultSet resultSet = statement.executeQuery(sqlRequest)){
            while(resultSet.next()){
                System.out.printf("ID: %d | Name: %s | Category: %s | Price: %.02f%n",
                        resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("category"),resultSet.getDouble("price"));
            }
        }catch (SQLException e){
            System.err.println("Ошибка при выводе таблицы");
            e.printStackTrace();
        }
    }
    // удаление по полям: имя, категория, цена
    public void deleteProduct(String name, String category, double price){
        // SQL-запрос с параметрами
        String sqlRequest = "DELETE FROM products WHERE (name = ? AND category = ? AND price = ?)";
        // использую PreparedStatement
        try(PreparedStatement statement = connection.prepareStatement(sqlRequest)){
            // установка параметров
            statement.setString(1,name);
            statement.setString(2,category);
            statement.setDouble(3,price);
            // выполнение запроса
            int checker = statement.executeUpdate();
            // проверка на удаление
            if(checker > 0){
                System.out.printf("Продукт Name: %s | Category: %s | Price: %.02f был удалён%n",name,category,price);
            }else{
                System.out.printf("Продукт Name: %s | Category: %s | Price: %.02f не найден%n",name,category,price);
            }
        }catch (SQLException e){
            System.err.printf("Ошибка при удалении продукта с Name: %s | Category: %s | Price: %.02f%n",name,category,price);
            e.printStackTrace();
        }
    }
    // удаление по id
    public void deleteProduct(int id){
        // SQL-запрос с параметрами
        String sqlRequest = "DELETE FROM products WHERE id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sqlRequest)){
            // установка параметра
            statement.setInt(1,id);
            // выполнение запроса
            int checker = statement.executeUpdate();
            // проверка на удаление
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
    //удаление по name
    public void deleteProduct(String name){
        // SQL-запрос с параметрами
        String sqlRequest = "DELETE FROM products WHERE name = ?";
        try(PreparedStatement statement = connection.prepareStatement(sqlRequest)){
            // установка параметра
            statement.setString(1,name);
            // выполнение запроса
            int checker = statement.executeUpdate();
            // проверка на удаление
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
    // очистка таблицы
    public void cleanTable(){
        // SQL-запрос
        String sqlRequest = "DELETE FROM products";
        try(PreparedStatement statement = connection.prepareStatement(sqlRequest)){
            // выполнение запроса
            int checker = statement.executeUpdate();
            // проверка на удаление
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
    // обновление информации
    public void updateProduct(int id, String newName, String newCategory, double newPrice) {
        // SQL-запрос для обновления записи по ID
        String sqlRequest = "UPDATE products SET name = ?, category = ?, price = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlRequest)) {
            // Установка параметров
            statement.setString(1, newName);
            statement.setString(2, newCategory);
            statement.setDouble(3, newPrice);
            statement.setInt(4, id);

            // проверка на обновление
            int checker = statement.executeUpdate();

            // проверка результата
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

}
