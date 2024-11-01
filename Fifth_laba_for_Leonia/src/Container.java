import java.util.ArrayList;
import java.util.List;

public class Container<T> {
    private int maxSize;
    private List<T> stack;

    public Container(int maxSize){
        this.maxSize = maxSize;
        this.stack = new ArrayList<>(maxSize);
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public boolean isFull(){
        return stack.size() == maxSize;
    }

    public int size(){
        return stack.size();
    }

    public void add(T item) throws OverflowContainerException{
        if(stack.size() >= maxSize){
            throw new OverflowContainerException("Контейнер переполнен");
        }
        stack.add(item);
    }

    public T delete() throws EmptyContainerException{
        if(stack.isEmpty()){
            throw new EmptyContainerException("Контейнер пустой");
        }
        return stack.remove(stack.size() - 1); // удаление последнего
    }

    public boolean contains(T item) throws EmptyContainerException{
        if(stack.isEmpty()){
            throw new EmptyContainerException("Контейнер пустой");
        }
        return stack.contains(item);
    }
}
