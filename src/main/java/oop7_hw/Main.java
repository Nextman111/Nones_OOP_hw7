package oop7_hw;


import oop7_hw.model.Storage.FileStorage;
import oop7_hw.model.Storage.Storage;
import oop7_hw.model.Validaror.NoteValidator;
import oop7_hw.model.Validaror.Validator;
import oop7_hw.model.data.Note;
import oop7_hw.model.repository.NoteRepository;
import oop7_hw.model.repository.Repository;
import oop7_hw.presenter.Presenter;
import oop7_hw.view.console.ConsoleView;
import oop7_hw.view.View;

public class Main {
    public static void main(String[] args) {
        noteInit().view();
    }

    public static View noteInit(){
        Storage storage = new FileStorage();
        Repository<Note> repository = new NoteRepository(storage);
        Validator<Note> validator = new NoteValidator();
        Presenter<Note> presenter = new Presenter<>(repository, validator);
        return new ConsoleView(presenter);
    }
}
