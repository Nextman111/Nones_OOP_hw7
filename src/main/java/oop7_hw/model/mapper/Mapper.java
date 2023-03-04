package oop7_hw.model.mapper;

import java.util.List;

public interface Mapper<T> {
    /** из строки в объект **/
    T map(String str);
    /** из объекта в строку **/
    String map(T t);
    List<String> map(List<T> t);
}
