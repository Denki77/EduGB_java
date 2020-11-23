package Level2.Lesson8;

public interface GBList extends GBIterable {
    void add(String val);
    boolean remove(String val);
    int size();
    String get(int index);
}
