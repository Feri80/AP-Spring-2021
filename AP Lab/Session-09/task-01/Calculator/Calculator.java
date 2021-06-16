import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class is the main class that launchs the Application
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class Calculator extends Application
{
    @Override
    public void start(Stage stage) throws Exception 
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Calculator.fxml"));
        loader.setController(new CalculatorController());
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Calculator");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}
