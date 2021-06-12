package Controller;

import Model.Client;
import Model.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignUpCon {
    @FXML
    private BorderPane mainPane;

    @FXML
    private JFXPasswordField rePassField;

    @FXML
    private JFXTextField usernameField;

    @FXML
    private JFXPasswordField passField;

    @FXML
    private JFXButton signUpButton;

    @FXML
    private Hyperlink loginLink;

    @FXML
    protected void actionHandler(ActionEvent event) throws Exception{
        if (event.getSource () == signUpButton) {
            Client client = connect();
            Thread.sleep(1000);
            User user = client.getResult();
            if (user != null) {
                Stage stage;
                stage = (Stage) usernameField.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../View/chat.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    Logger.getLogger(ChatCon.class.getName()).log(Level.SEVERE, null, e);
                }

                ChatCon chatController = loader.getController();
                chatController.setCurrentUser(user);

                Parent root = loader.getRoot();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else
            {
                System.out.println("--------------");
                // warning visible
            }

        }
        else if (event.getSource () == loginLink){

            Stage stage;
            Parent root;

            stage = (Stage) loginLink.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/login.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    private Client connect ()
    {
        Client client = new Client("127.0.0.1", usernameField.getText(), passField.getText (),"SignUp");
        new Thread(client).start();
        return client;
    }
}
