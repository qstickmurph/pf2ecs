package pf2ecs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;                                                                                                                                                                                                                                                                                                                                                                                                   

import pf2ecs.model.Feat;
import pf2ecs.model.Action;
 
public class Main extends Application{
    @Override
    public void start(Stage stage) throws Exception{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("view/Character_Sheet.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("view/character_create/Ancestry.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Pathfinder 2e Character Sheet");
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
     
    public static void main(String[] args) {
        launch(args);
    }
}
