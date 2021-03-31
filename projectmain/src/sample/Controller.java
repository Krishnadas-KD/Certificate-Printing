package sample;



import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import sample.Arts.MainA;
import sample.Sports.MainS;

import java.io.IOException;
import java.sql.*;
import java.util.concurrent.atomic.AtomicReference;

public class Controller {

    public TextField userfeild;
    public Button LogineB;
    public ImageView useric;
    public ImageView CloseB2;
    public TextField passfeild;
    public ImageView passic;
    public ImageView closeB1;
    public ImageView loginesic;
    public Label warning;
    public Pane pane2;

    public StackPane stack1;
    public StackPane stack2;

    public ImageView slider1;
    public ImageView image2;
    public ImageView Bu2;
    public ImageView Bu1;

    public Button GOpage1;
    public Button GOpage2;
    public ImageView image1;
    public Button Aaddevent;
    public Button Seventadd;
    public ComboBox comboevent1;
    public TextField Eventtext1;
    public Button adder1;
    public Button DeleteEvent1;
    public ComboBox comboevent2;
    public TextField Eventtext2;
    public Button adder2;
    public Button DeleteEvent2;


    public void checkuser(MouseEvent mouseEvent) {
        warning.setVisible(false);
        if(userfeild.getText().equals("Admin")){

            ColorAdjust col=new ColorAdjust();
            col.setHue(.70);
            useric.setEffect(col);
            userfeild.setStyle("-fx-background-color: #222222; -fx-background-radius: 30; -fx-border-color: #00ff00; -fx-border-radius: 27; -fx-border-width: 3;");

        }
        else
        {
            ColorAdjust col=new ColorAdjust();
            col.setHue(0);
            useric.setEffect(col);
            userfeild.setStyle("-fx-background-color: #222222; -fx-background-radius: 30; -fx-border-color: #ff0000; -fx-border-radius: 27; -fx-border-width: 3;");

        }
        if(userfeild.getText().equals("Admin")&&passfeild.getText().equals("Admin")){

            Image image = new Image(getClass().getResourceAsStream("/img/unclock.png"));
            loginesic.setImage(image);

            LogineB.setStyle("-fx-background-color: #222222; -fx-background-radius: 30; -fx-border-color: #00ff00; -fx-border-width: 2; -fx-border-radius: 30;");
        }
        else {
            Image image = new Image(getClass().getResourceAsStream("/img/locked.png"));
            loginesic.setImage(image);
            LogineB.setStyle("-fx-background-color: #222222; -fx-background-radius: 30; -fx-border-color: #ff0000; -fx-border-width: 2; -fx-border-radius: 30;");

        }


    }

    public void closeclick(MouseEvent mouseEvent) {
        System.exit(0);
    }

    public void closeenter(MouseEvent mouseEvent) {
        CloseB2.setVisible(false);
        closeB1.setVisible(true);
    }

    public void closeexit(MouseEvent mouseEvent) {
        CloseB2.setVisible(true);
        closeB1.setVisible(false);
    }

    public void checkpass(MouseEvent mouseEvent) {
        warning.setVisible(false);
        if (passfeild.getText().equals("Admin")) {
            ColorAdjust col = new ColorAdjust();
            col.setHue(.70);
            passic.setEffect(col);
            passfeild.setStyle("-fx-background-color: #222222; -fx-background-radius: 30; -fx-border-color: #00ff00; -fx-border-radius: 27; -fx-border-width: 3;");

        }
        else{
            ColorAdjust col=new ColorAdjust();
            col.setHue(0);
            passic.setEffect(col);
            passfeild.setStyle("-fx-background-color: #222222; -fx-background-radius: 30; -fx-border-color: #ff0000; -fx-border-radius: 27; -fx-border-width: 3;");

        }
        if(userfeild.getText().equals("Admin")&&passfeild.getText().equals("Admin")){

            Image image = new Image(getClass().getResourceAsStream("/img/unclock.png"));
            loginesic.setImage(image);
            LogineB.setStyle("-fx-background-color: #222222; -fx-background-radius: 30; -fx-border-color: #00ff00; -fx-border-width: 2; -fx-border-radius: 30;");
        }
        else {
            Image image = new Image(getClass().getResourceAsStream("/img/locked.png"));
            loginesic.setImage(image);
            LogineB.setStyle("-fx-background-color: #222222; -fx-background-radius: 30; -fx-border-color: #ff0000; -fx-border-width: 2; -fx-border-radius: 30;");

        }
    }
    public void logmouseenter(MouseEvent mouseEvent) {
        if(userfeild.getText().equals("Admin")&&passfeild.getText().equals("Admin")) {
            ColorAdjust ss = new ColorAdjust();
            ss.setBrightness(-1.0);
            loginesic.setEffect(ss);
            LogineB.setStyle("-fx-background-color: #00ff00; -fx-background-radius: 30; -fx-border-color: #ffffff; -fx-border-width: 2; -fx-border-radius: 30;");
        }
    }

    public void logmouseexit(MouseEvent mouseEvent) {
        if(userfeild.getText().equals("Admin")&&passfeild.getText().equals("Admin")) {
            ColorAdjust ss = new ColorAdjust();
            ss.setBrightness(0);
            loginesic.setEffect(ss);
            LogineB.setStyle("-fx-background-color: #222222; -fx-background-radius: 30; -fx-border-color: #00ff00; -fx-border-width: 2; -fx-border-radius: 30;");
        }
    }

    public void loginescuss(ActionEvent actionEvent) throws IOException {

        if(userfeild.getText().equals("Admin")&&passfeild.getText().equals("Admin")){
            Stage stage = (Stage) LogineB.getScene().getWindow();
            Parent root1 = FXMLLoader.load(getClass().getResource("page1.fxml"));
            Scene scene=new Scene(root1, 647.5,375);
            Stage stage1=new Stage();
            stage1.setScene(scene);
            stage1.setTitle("Choose");
            scene.setFill(Color.TRANSPARENT);
            stage1.initStyle(StageStyle.TRANSPARENT);
            stage1.show();
            stage.close();


        }
        else {
             warning.setVisible(true);

                }
            }

    public void change2(MouseEvent mouseEvent) throws IOException {



            Parent root = FXMLLoader.load(getClass().getResource("page1.fxml"));
            Scene scene = Bu2.getScene();
            root.translateXProperty().set(-1*scene.getWidth());
            stack2.getChildren().add(root);
            System.out.println("1");
            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root.translateXProperty(),0, Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(1),kv);
            timeline.getKeyFrames().add(kf);
            timeline.play();



        }


    public void imcolorchange1(MouseEvent mouseEvent) {
        ColorAdjust ss = new ColorAdjust();
        ss.setBrightness(.5);
        Bu1.setEffect(ss);
    }

    public void chnage1(MouseEvent mouseEvent) throws IOException {



        Parent root = FXMLLoader.load(getClass().getResource("page2.fxml"));
        Scene scene = Bu1.getScene();
        root.translateXProperty().set(scene.getWidth());
        stack1.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(),0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1),kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();

    }

    public void imcolorchange2(MouseEvent mouseEvent) {
        ColorAdjust ss = new ColorAdjust();
        ss.setBrightness(.5);
        Bu2.setEffect(ss);
    }

    public void imcolorchange15(MouseEvent mouseEvent) {
        ColorAdjust ss = new ColorAdjust();
        ss.setBrightness(0);
        Bu1.setEffect(ss);
    }

    public void imcolorchange25(MouseEvent mouseEvent) {
        ColorAdjust ss = new ColorAdjust();
        ss.setBrightness(0);
        Bu2.setEffect(ss);
    }

    public void gotoArts(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) GOpage1.getScene().getWindow();
        Stage stage1=new Stage();
        MainA ss=new MainA();
        ss.start(stage1);
        stage.close();

    }

    public void gotoSports(ActionEvent actionEvent) throws Exception {
        Stage stage = (Stage) GOpage2.getScene().getWindow();
        Stage stage1=new Stage();
        MainS ss=new MainS();
        ss.start(stage1);
        stage.close();
    }

    public void addEvent1(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("event1.fxml"));
        Scene scene=new Scene(root, 300,400);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("Arts Event adder");
        stage.getIcons();
        stage.show();
    }

    public void addevent2(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("event2.fxml"));
        Scene scene=new Scene(root, 300,400);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("Sports Event adder");
        stage.getIcons();
        stage.show();
    }
//=====================================
    public void aadingaction(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        evtentaddloder();
        comboloder();
        Eventtext1.setText(null);

    }
    public  void  evtentaddloder() throws ClassNotFoundException, SQLException {
        String s=Eventtext1.getText();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/aands","root","");
        String sqlQ2 = "insert into arts_event VALUES('"+s+"')";
        PreparedStatement ps2 = con.prepareStatement(sqlQ2);
        ps2.executeUpdate();
        comboloder();
    }
    public void comboloder() throws ClassNotFoundException, SQLException {
        ObservableList list = FXCollections.observableArrayList();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/aands","root","");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from arts_event");
        while (rs.next()) {
            list.add(rs.getString(1));
        }
        comboevent1.setItems(list);
    }

    public void enterpress1(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
        if (keyEvent.getCode() == KeyCode.ENTER) {
        evtentaddloder();
        comboloder();
        Eventtext1.setText(null);

        }
    }

    public void eventdelete1(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        combbodelete();
        comboloder();

    }
    public void combbodelete() throws ClassNotFoundException, SQLException {
        String s= (String) comboevent1.getValue();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/aands","root","");
        String sqlQ2 = "DELETE FROM arts_event WHERE event='"+s+"'";
        PreparedStatement ps2 = con.prepareStatement(sqlQ2);
        ps2.executeUpdate();
        comboloder();
    }
//====================
    public void deletepreserd1(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
        if (keyEvent.getCode() == KeyCode.DELETE) {
            combbodelete1();
            comboloder1();
        }
        }

    public void enterpress2(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            evtentaddloder1();
            comboloder1();
            Eventtext1.setText(null);

        }
    }

    public void deletepreserd2(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
        if (keyEvent.getCode() == KeyCode.DELETE) {
            combbodelete1();
            comboloder1();
        }
    }

    public void aadingaction2(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        evtentaddloder1();
        comboloder1();
        Eventtext2.setText(null);

    }

    public void eventdelete2(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        combbodelete1();
        comboloder1();
    }
    public  void  evtentaddloder1() throws ClassNotFoundException, SQLException {
        String s=Eventtext2.getText();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/aands","root","");
        String sqlQ2 = "insert into sport_event VALUES('"+s+"')";
        PreparedStatement ps2 = con.prepareStatement(sqlQ2);
        ps2.executeUpdate();
        comboloder1();
    }
    public void comboloder1() throws ClassNotFoundException, SQLException {
        ObservableList list = FXCollections.observableArrayList();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/aands","root","");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from sport_event");
        while (rs.next()) {
            list.add(rs.getString(1));
        }
        comboevent2.setItems(list);
    }
    public void combbodelete1() throws ClassNotFoundException, SQLException {
        String s= (String) comboevent2.getValue();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/aands","root","");
        String sqlQ2 = "DELETE FROM sport_event WHERE event='"+s+"'";
        PreparedStatement ps2 = con.prepareStatement(sqlQ2);
        ps2.executeUpdate();
        comboloder1();
    }
}



