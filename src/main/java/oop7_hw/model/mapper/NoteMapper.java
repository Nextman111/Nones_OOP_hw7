package oop7_hw.model.mapper;
import oop7_hw.model.data.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteMapper implements Mapper<Note> {
    /** класс преобразует строки в объект и обратно **/
    @Override
    public Note map(String str) {
        String[] lines = str.split(delimiter);
        return new Note(Integer.parseInt(lines[0]),lines[1],lines[2], Long.parseLong(lines[3]));
    }
    private final String delimiter = ",";

    @Override
    public String map(Note note) {
        return String.format(
                "%s%s%s%s%s%s%s",
                note.getId(), delimiter,
                note.getHeader(), delimiter,
                note.getText(), delimiter,
                note.getTimeStamp());
    }

    @Override
    public List<String> map(List<Note> notes) {
        List<String> lines = new ArrayList<>();

        for (Note note : notes){
            lines.add(map(note));
        }

        return lines;
    }

}
