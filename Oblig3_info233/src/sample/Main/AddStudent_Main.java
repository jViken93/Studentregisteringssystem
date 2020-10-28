package sample.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*Klasse som main metode for AddStudent.fxml filen. Denne vil displaye det vinduet når du kjører den*/
import static javafx.application.Application.launch;

public class AddStudent_Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/AddStudent.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 700, 450));
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }

}
