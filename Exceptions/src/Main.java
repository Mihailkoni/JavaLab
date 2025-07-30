//Контейнер подобие стэка. Поиск элементов. Метод генерирует исключение, если контейнер пуст и если контейнер переполнен.

public class Main {
    public static void main(String[] args) {
        Container<Integer> container = new Container<>(5);

        try {

            container.push(1);
            container.push(2);
            container.push(3);
            container.push(4);
            container.push(5);
            //container.add(6) если попробовать добавить ещё один то вызовет исключение

            // проверяем контейнер на полноту
            System.out.println("Контейнер переполнен? " + container.isFull());
            System.out.println("Текущий размер контейнера: " + container.size()); // 5

            // проверка наличия элемента
            System.out.println("Содержит ли контейнер 2? " + container.contains(2)); // true
            System.out.println("Содержит ли контейнер 7? " + container.contains(7)); // false

            // удаляем элемент
            System.out.println("Удаляем элемент: " + container.pop()); // 5
            System.out.println("Текущий размер контейнера: " + container.size()); // 4

            // удаляем элемент
            System.out.println("Удаляем элемент: " + container.pop()); // 4
            System.out.println("Текущий размер контейнера: " + container.size()); // 3

            // удаляем элемент
            System.out.println("Удаляем элемент: " + container.pop()); // 3
            System.out.println("Текущий размер контейнера: " + container.size()); // 2

            // удаляем элемент
            System.out.println("Удаляем элемент: " + container.pop()); // 2
            System.out.println("Текущий размер контейнера: " + container.size()); // 1

            // удаляем последний элемент
            System.out.println("Удаляем элемент: " + container.pop()); // 1
            System.out.println("Текущий размер контейнера: " + container.size()); // 0

            // удаляем из пустого контейнера
            System.out.println("Попробуем удалить элемент из пустого контейнера...");
            System.out.println("Удаляем элемент: " + container.pop()); // вызовет исключение
        } catch (OverflowContainerException | EmptyContainerException e) {
            System.err.println(e.getMessage());
        }
    }
}