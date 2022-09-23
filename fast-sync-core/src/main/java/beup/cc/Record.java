package beup.cc;

public interface Record<T> {

    String rowKey();

    T value();

}
