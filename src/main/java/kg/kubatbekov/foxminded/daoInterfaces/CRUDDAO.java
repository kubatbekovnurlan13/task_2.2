package kg.kubatbekov.foxminded.daoInterfaces;

import java.util.List;

public interface CRUDDAO<T> {
    void save(T t);

    boolean update(T t);

    T getByName(String name);

    List<T> getAll();

    boolean deleteById(int id);
}
