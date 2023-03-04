package oop7_hw.model.data;
import java.util.Date;
public class Note {
    /**
     * Класс реализует заметку
     **/
    private int id = -1;
    private String header;
    private String text;
    private long timeStamp;

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Note(int id, String header, String text) {
        this.id = id;
        this.header = header;
        this.text = text;
        this.timeStamp = new Date().getTime();
    }

    public Note(int id, String header, String text, long timeStamp) {
        this.id = id;
        this.header = header;
        this.text = text;
        this.timeStamp = timeStamp;
    }

    public Note(String header, String text) {
        this.header = header;
        this.text = text;
        this.timeStamp = new Date().getTime();
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id +
                ". " + header +
                "\n " + text +
                "\n Изменено: " + getDate();
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public Date getDate() {
        return new Date(timeStamp);
    }
}
