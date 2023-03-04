package oop7_hw.model.Storage;

import java.io.IOException;
import java.util.List;

public interface Storage {
    List<String> readAll();
    void saveAll(List<String> lines) throws IOException;
    void append(String line);
}
