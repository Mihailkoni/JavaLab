//СТЭК. Поиск элементов. Метод генерирует исключение, если контейнер пуст и если контейнер переполнен.

public class Main {
    public static void main(String[] args) {
        Container<Integer> container = new Container<>(5); // создаем контейнер

        try {
            // Добавляем элементы
            container.add(1);
            container.add(2);
            container.add(3);
            container.add(4);
            container.add(5);
            //container.add(6) если попробовать добавить ещё один то вызовет исключение

            //проверяем контейнер на полноту
            System.out.println("Контейнер переполнен? " + container.isFull());
            System.out.println("Текущий размер контейнера: " + container.size()); // 5

            //проверка наличия элемента
            System.out.println("Содержит ли контейнер 2? " + container.contains(2)); // true
            System.out.println("Содержит ли контейнер 7? " + container.contains(7)); // false

            //удаляем элемент
            System.out.println("Удаляем элемент: " + container.delete()); // 5
            System.out.println("Текущий размер контейнера: " + container.size()); // 4

            //удаляем элемент
            System.out.println("Удаляем элемент: " + container.delete()); // 4
            System.out.println("Текущий размер контейнера: " + container.size()); // 3

            //удаляем элемент
            System.out.println("Удаляем элемент: " + container.delete()); // 3
            System.out.println("Текущий размер контейнера: " + container.size()); // 2

            //удаляем элемент
            System.out.println("Удаляем элемент: " + container.delete()); // 2
            System.out.println("Текущий размер контейнера: " + container.size()); // 1

            //удаляем последний элемент
            System.out.println("Удаляем элемент: " + container.delete()); // 1
            System.out.println("Текущий размер контейнера: " + container.size()); // 0

            //удаляем из пустого контейнера
            System.out.println("Попробуем удалить элемент из пустого контейнера...");
            System.out.println("Удаляем элемент: " + container.delete()); // вызовет исключение
        } catch (OverflowContainerException | EmptyContainerException e) {
            System.err.println(e.getMessage());
        }
    }
}