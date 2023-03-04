package oop7_hw.model.repository;

import oop7_hw.model.Storage.Storage;
import oop7_hw.model.mapper.Mapper;
import oop7_hw.model.mapper.NoteMapper;
import oop7_hw.model.data.Note;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * класс реализует функционал для работы с репозиторием
 **/
public class NoteRepository implements Repository<Note> {
    private final Mapper<Note> mapper = new NoteMapper();
    private final Storage storage;

    /**
     * В конструкторе только Storage и нет маппера.
     * Так как используем тип данных Note,
     * берем соответствующий интерфейс Mapper с джинериком <T> = Note,
     * он уже типизирован в классе NoteMapper.
     * Для других типов данных следует создать новый класс c интерфейсом Repository
     * и новый класс с интерфейсом Mapper.
     **/
    public NoteRepository(Storage storage) {
        this.storage = storage;
    }

    @Override
    public List<Note> getAll() {
        List<Note> notes = new ArrayList<>();

        for (String line : storage.readAll()) {
            notes.add(mapper.map(line));
        }
        return notes;
    }

    @Override
    public void add(Note note) {
        note.setId(getNextId());
        storage.append(mapper.map(note));
    }

    public int getNextId() {
        List<Note> notes = getAll();
        int id = -1;

        for (Note item : notes) {
            id = Math.max(id, item.getId());
        }

        ++id;
        return id;
    }

    @Override
    public boolean edit(int id, Note note) throws IOException {
        List<Note> notes = getAll();

        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId() == id) {
                notes.get(i).setHeader(note.getHeader());
                notes.get(i).setText(note.getText());
                notes.get(i).setTimeStamp(note.getTimeStamp());
                storage.saveAll(mapper.map(notes));
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean delete(int id) throws IOException {
        List<Note> notes = getAll();

        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId() == id) {
                notes.remove(i);
                storage.saveAll(mapper.map(notes));
                return true;
            }
        }

        return false;
    }

    @Override
    public Note readOfId(int id) {
        List<Note> notes = getAll();

        for (Note note : notes) {
            if (note.getId() == id) {
                return note;
            }
        }

        return null;
    }
}
