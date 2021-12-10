package Controllers;

import java.util.ArrayList;

import GUI.ButtonObserver;
import Main.Application;
import Models.Email;
import Models.Inbox;
import Views.InboxView;

public class InboxController extends DatabaseController implements ButtonObserver {
    private InboxView view;
    private Inbox model;

    String userType;

    public InboxController(String username, String type) {
        this.model = new Inbox(username, recvEmail(username));
        this.view = new InboxView(this, this.model.getEmails(), type);

        this.userType = type;
        Application.mainPanel.add(this.view, "email");
    }

    public void send() {
        String sendusername;
        String recvusername;
        String content;

        // renter sending email (has to read email from textbox)
        if (this.userType.compareTo("renter") == 0) {
            if (this.view.findTextField("contactnameTF").getText().compareTo("") != 0 &&
                    this.view.findTextField("contactidTF").getText().compareTo("") != 0) {
                sendusername = this.view.findTextField("contactnameTF").getText();
                this.model.setUsername(sendusername);
                recvusername = selectLandlordByID(this.view.findTextField("contactidTF").getInt());
                content = this.view.findTextArea("contactcontentTA").getText();
            } else {
                return; // if the name and id tf were not filled in
            }

        } else {
            // If username is filled in
            if (this.view.findTextField("sendusernameTF").getText().compareTo("") != 0) {
                sendusername = this.model.getUsername();
                recvusername = this.view.findTextField("sendusernameTF").getText();
                content = this.view.findTextArea("sendcontentTA").getText();
            } else {
                return; // if the username tf wasn't filled in
            }
        }

        Email newemail = new Email(sendusername, recvusername, content);
        sendEmail(newemail);
    }

    public void buttonPressed(String text) {
        if (text.compareTo(this.view.findButton("LogoutBtn").getButtonText()) == 0) {
            if (this.userType.compareTo("landlord") == 0) {
                this.view.reset();
                Application.cardLayout.show(Application.mainPanel, "landlord");
            } else if (this.userType.compareTo("manager") == 0) {
                this.view.reset();
                Application.cardLayout.show(Application.mainPanel, "manager");
            } else if (this.userType.compareTo("renter") == 0) {
                this.view.reset();
                Application.cardLayout.show(Application.mainPanel, "renter");
            }
        } else if (text.compareTo(this.view.findButton("sendBtn").getButtonText()) == 0) {
            send();
        }
    }
}
