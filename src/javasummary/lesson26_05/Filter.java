package javasummary.lesson26_05;

@FunctionalInterface
public interface Filter<T> {
       boolean apply(T o);
}
