package sample;

import com.sun.scenario.effect.Color4f;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;
import java.util.Collection;

public class Main extends Application {

    public double dragDeltax;
    public double dragDeltay;
    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Scene scene=new Scene(root, 647.5,375);
        Stage stage=new Stage();
        root.setOnMousePressed(mouseEvent ->  {


            dragDeltax = stage.getX() - mouseEvent.getScreenX();
            dragDeltay = stage.getY() - mouseEvent.getScreenY();

        });
        root.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() + dragDeltax);
            stage.setY(mouseEvent.getScreenY() + dragDeltay);
        });
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.getIcons();
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
