package sample.Arts;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class MainA extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    Controller myController = new Controller();
    public double dragDeltax;
    public  double dragDeltay;

    @Override
    public void start(Stage primaryStage) {
     //   myController.tload();

       // Parent root;


        try {
            Parent root = FXMLLoader.load(getClass().getResource("Arts.fxml"));

            Scene scene=new Scene(root, 1000,600);
            Stage stage=new Stage();
            stage.setScene(scene);
            root.setOnMousePressed(mouseEvent ->  {

                    // record a delta distance for the drag and drop operation.
                dragDeltax = stage.getX() - mouseEvent.getScreenX();
                dragDeltay = stage.getY() - mouseEvent.getScreenY();

            });
            root.setOnMouseDragged(mouseEvent -> {
                    stage.setX(mouseEvent.getScreenX() + dragDeltax);
                stage.setY(mouseEvent.getScreenY() + dragDeltay);
            });
            stage.setTitle("Arts");
            scene.setFill(Color.TRANSPARENT);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }








    }



}
