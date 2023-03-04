package oop7_hw.model.Validaror;

import oop7_hw.model.data.Note;

import java.util.regex.Pattern;

public class NoteValidator implements Validator<Note> {
    private final Pattern reHeader = Pattern.compile("^*$");
    private final Pattern reText = Pattern.compile("^*$");
    @Override
    public boolean isValid(Note note) {
        return isValidHeader(note.getHeader()) && isValidText(note.getText());
    }

    public boolean isValidHeader(String header){
        return reHeader.matcher(header).find();
    }
    public boolean isValidText(String text){
        return reText.matcher(text).find();
    }
}
