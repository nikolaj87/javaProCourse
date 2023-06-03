package javatask.adds.generics.queue;

public interface IGenQ<T> {
    void put(T ch) throws QueueFullException;
    T get() throws QueueEmptyException;
}
