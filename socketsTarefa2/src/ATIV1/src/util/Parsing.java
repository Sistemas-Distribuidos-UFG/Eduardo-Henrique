package util;

import util.Message;

import java.util.List;
import java.util.Arrays;


public class Parsing {
    public Message message = null;
    public String parsed = null;

    public Parsing(Message message) {
        this.UpdateMsg(message);
    }

    public Parsing(String parsed) {
        this.parsed = parsed;
        this.unmarshall();
    }

    public void UpdateMsg(Message message) {
        this.message = message;
        this.marshall();
    }

    private void marshall() {
        if (this.message == null) return;

        this.parsed = this.message.nome +"," + this.message.salario + "," +this.message.cargo;
    }

    private void unmarshall() {
        if (this.parsed == null) return;

        String[] messageAsList = this.parsed.split(",");
        this.message = new Message(messageAsList[0], Float.parseFloat(messageAsList[1]), messageAsList[2]);
    }

    public String GetParsedString() {
        return this.parsed;
    }

    public Message GetMessageObj() {
        return this.message;
    }
}

    