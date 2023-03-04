package oop7_hw.model.repository;

import java.io.IOException;
import java.util.List;

public interface Repository<T> {
    /**
     * содержит функционал для работы с репозиторием
     **/
//    1. можно прочитать все записки
    List<T> getAll();

    //2. создать одну записку
    void add(T t) throws IOException;

    //3. отредактировать записку
    boolean edit(int id, T item) throws IOException;

    //4. удалить
    boolean delete(int id) throws IOException;

    //5. прочитать одну записку по ID
    T readOfId(int id);
}
