package pf2ecs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;                                                                                                                                                                                                                                                                                                                                                                                                   
 
public class Main extends Application{
    @Override
    public void start(Stage stage) throws Exception{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pf2ecs/view/Blank.fxml"));
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            stage.setTitle("Pathfinder 2e Character Sheet");
            stage.setResizable(false);
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
