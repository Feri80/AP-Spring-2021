package Controller;

import Model.Message;
import Model.MessageClient;
import Model.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChatCon implements Initializable {


    private User currUser;
    private ArrayList<Message> messages;
    private ObservableList<String> messageCollection = FXCollections.observableArrayList();

    @FXML
    private JFXTextField textField;

    @FXML
    private JFXButton sendButton;

    @FXML
    private JFXListView<String> messageList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        messages = new ArrayList<>();

        Thread thread = (new Thread(() -> {
            while (true) {
                try {
                    MessageClient client = connect("rec", "");
                    Thread.sleep(1000);
                    messages = client.getResult();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                Platform.runLater(() -> {
                    messageCollection.clear();
                    for (Message message : messages) {
                        messageCollection.add(message.getWriter() + ": " + message.getText());
                    }
                    messageList.setItems(messageCollection);
                });
            }
        }));
        thread.setDaemon(true);
        thread.start();
    }

    public void setCurrentUser(User user){
        this.currUser = user;
    }

    private MessageClient connect (String request, String data) {
        MessageClient client = new MessageClient(request, data);
        new Thread(client).start();
        return client;
    }

    @FXML
    void sendMessage() {
        String data = textField.getText() + "*" + currUser.getUsername() + "*" + LocalDate.now().toString();
        connect("send", data);
        textField.setText("");
    }
}
