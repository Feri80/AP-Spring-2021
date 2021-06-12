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
import javafx.stage.Stage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginCon {

    @FXML
    private JFXTextField usernameField;

    @FXML
    private JFXPasswordField passField;

    @FXML
    private JFXButton loginButton;

    @FXML
    private Hyperlink signUpLink;

    @FXML
    protected void actionHandler(ActionEvent event) throws Exception{
        if (event.getSource () == loginButton) {
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
                // warning visible
            }

        }
        else if (event.getSource () == signUpLink){

            Stage stage;
            Parent root;

            stage = (Stage) signUpLink.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/signUp.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    private Client connect ()
    {
        Client client = new Client ("127.0.0.1", usernameField.getText(), passField.getText(),"Login");
        new Thread(client).start();
        return client;
    }
}
