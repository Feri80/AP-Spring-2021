package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Message implements Serializable {
    private String text;
    private String writer;
    private String time;

    public Message(String text, String writer, String time) {
        this.text = text;
        this.writer = writer;
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public String getWriter() {
        return writer;
    }

    public String getTime() {
        return time;
    }
}
