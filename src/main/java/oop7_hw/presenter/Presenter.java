package oop7_hw.presenter;

import oop7_hw.model.Validaror.Validator;
import oop7_hw.model.repository.Repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * класс - маршрутизатор между пользователем, данными, и бизнес-логикой
 **/
public class Presenter<T> {
    static Logger LOGGER;

    static {
        try (FileInputStream ins = new FileInputStream(
                "src/main/resources/log.config"
        )) {
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Presenter.class.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final Repository<T> repository;
    private final Validator<T> validator;

    public Presenter(Repository<T> repository, Validator<T> validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public void add(T item) throws IOException {
        LOGGER.log(Level.INFO, "add");
        if (validator.isValid(item)) {
            repository.add(item);
        }
    }

    public List<T> readAll() {
        LOGGER.log(Level.INFO, "readAll");
        return repository.getAll();
    }

    public T readOfId(int id) {
        LOGGER.log(Level.INFO, "readOfId");
        return repository.readOfId(id);
    }

    public boolean delete(int id) throws IOException {
        LOGGER.log(Level.INFO, "delete");
        return repository.delete(id);
    }

    public boolean edit(int id, T item) throws IOException {
        LOGGER.log(Level.INFO, "edit");
        return repository.edit(id, item);
    }
}
