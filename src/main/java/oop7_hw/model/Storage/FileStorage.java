package oop7_hw.model.Storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStorage implements Storage {
    private String fileName = "default.txt";

    public FileStorage() {
    }

    public FileStorage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<String> readAll() {
        List<String> lines = new ArrayList<>();
        try (//создаем объект FileReader для объекта File
             FileReader fr = new FileReader(getFile());
             //создаем BufferedReader с существующего FileReader для построчного считывания
             BufferedReader reader = new BufferedReader(fr)) {

            // считаем сначала первую строку
            String line = reader.readLine();
            if (line != null) {
                lines.add(line);
            }
            while (line != null) {
                // считываем остальные строки в цикле
                line = reader.readLine();
                if (line != null) {
                    lines.add(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private File getFile() throws IOException {
        File file = new File(fileName);
        // проверяем наличие файла
        file.createNewFile();
        return file;
    }

    @Override
    public void saveAll(List<String> lines) {
        try (FileWriter writer = new FileWriter(getFile(), false)) {
            for (String line : lines) {
                // запись всей строки
                writer.write(line);
                // запись по символам
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void append(String line) {
        try (FileWriter writer = new FileWriter(getFile(), true)) {
            writer.write(line);
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
