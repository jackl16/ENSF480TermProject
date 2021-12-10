package Models;

public class Email {
    String sendusername;
    String recvusername;
    String content;

    public Email(String sendusername, String recvusername, String content) {
        this.sendusername = sendusername;
        this.recvusername = recvusername;
        this.content = content;
    }

    public String getSendUsername() {
        return this.sendusername;
    }

    public String getRecvUsername() {
        return this.recvusername;
    }

    public String getContent() {
        return this.content;
    }
}
