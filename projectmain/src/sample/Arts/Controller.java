package sample.Arts;


import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.*;
import javafx.animation.RotateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.print.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.swing.*;
import javax.xml.transform.Result;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import net.sf.jasperreports.engine.JRException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.BaseFont;
import  com.itextpdf.text.Font;
import sample.Main;

public class Controller {

    public Button studententry;
    public StackPane stackc;
    public Button winnerentry;
    public ImageView closegreen;
    public ImageView closered;
    public Button printBU;
    public Pane printPane;
    public Pane panel;
    public Label d2;
    public Label d1;
    public Button studviewd;
    public Button studentryd;
    public Button winnviewd;
    public Button winentryd;
    public StackPane stackc2;
    public StackPane stackc3;
    public ComboBox cbevrnt1;
    public ComboBox cbevrnt2;
    public ComboBox cbevrnt3;
    public Connection con;
    public Statement pst;
    public Result rs;
    public TextField reg;
    public TextField name;
    public TextField depaet;
    public Button Badderstud;
    public TableView<ModelTable> Tablestud;
    public TableColumn<ModelTable, String> col_che;
    public TableColumn<ModelTable, String> col_ren;
    public TableColumn<ModelTable, String> col_name;
    public TableColumn<ModelTable, String> col_dep;
    public TableColumn<ModelTable, String> col_ev1;
    public TableColumn<ModelTable, String> col_ev2;
    public TableColumn<ModelTable, String> col_ev3;
    public Button printbb;
    public TextField searcherfeld;
    public Button refesher;
    public Label addingfalied;
    public Label addingscusss;
    public ImageView refresher;
    public ComboBox bysearch;
    public TextField regno;
    public TextField nme;
    public TextField depar;
    public ComboBox ev1;
    public ComboBox ev2;
    public ComboBox ev3;
    public Button bediter1;
    public String che, ev;
    public Button deleter1;
    public Button bforclear;
    public TextField win1st;
    public ComboBox winevent;
    public Button Baddwinner;
    public TextField win2st;
    public TextField win3st;
    public TableColumn<ModelTabelW, String> wcol_ches;
    public TableColumn<ModelTabelW, String> wcol_na;
    public TableColumn<ModelTabelW, String> wcol_dep;
    public TableColumn<ModelTabelW, String> wcol_eve;
    public TableColumn<ModelTabelW, String> wcol_ran;
    public TableView<ModelTabelW> wintable;
    public ImageView refresher2;
    public ComboBox serchcombo2;
    public TextField sercher2;
    public int falgs = 0;
    public Pane tablewin;
    public Button printer2;
    public TextField chesttext;
    public TextField nametext;
    public TextField departtex;
    public TextField ranktext;
    public Button editer25;
    public Button delete25;
    public ComboBox eventtext;
    public TableView<ModelTabelW> tableforprint;
    public TableColumn<ModelTabelW, String> printpchest;
    public TableColumn<ModelTabelW, String> printpname;
    public TableColumn<ModelTabelW, String> printpdep;
    public TableColumn<ModelTabelW, String> printpevent;
    public TableColumn<ModelTabelW, String> printprank;
    public ImageView refresher3;
    public TableView<ModelTabelW> tableforprint1;
    public TableColumn<ModelTabelW, String> printpchest1;
    public TableColumn<ModelTabelW, String> printpname1;
    public TableColumn<ModelTabelW, String> printpdep1;
    public TableColumn<ModelTabelW, String> printpevent1;
    public TableColumn<ModelTabelW, String> printprank1;
    public ImageView passtable;
    public Pane printpanel;
    public Label namelable;
    public Label dipartmentlable;
    public Label Eventlabel;
    public Button printercert;
    public ImageView rankimg;
    public ImageView tabledeleter;
    public ImageView closeb2;
    public Pane artpaen;

    public void actionit(ActionEvent actionEvent) throws IOException, JRException, DocumentException, SQLException, ClassNotFoundException {
        sqlconnection consql = new sqlconnection();
        Connection con = consql.getcon();
        PreparedStatement pst = con.prepareStatement("select * from arts_student");
        ResultSet rs = pst.executeQuery();
        BaseFont bf = BaseFont.createFont(     //column font
                BaseFont.TIMES_ROMAN,
                BaseFont.CP1252,
                BaseFont.EMBEDDED);
        BaseFont bf2 = BaseFont.createFont(  //header font
                BaseFont.COURIER_BOLD,
                BaseFont.CP1252
                , BaseFont.EMBEDDED);
        Font fonthead = new Font(bf2, 10);
        Font font = new Font(bf, 10);
        Stage primaryStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF", "*.pdf"));
        File file = fileChooser.showSaveDialog(primaryStage);
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();

        PdfPTable table = new PdfPTable(7);//7 is cell number

        table.setTotalWidth(500);
// Set Each Column Width - Make Sure Array is the same number specified in constructor
        table.setWidths(new int[]{46, 60, 110, 110, 58, 58, 58});
// columnWidths = {column1, column2, column3...}
        //column header
        table.addCell(new PdfPCell(new Phrase("Chest no", fonthead)));
        table.addCell(new PdfPCell(new Phrase("Reg No", fonthead)));
        table.addCell(new PdfPCell(new Phrase("Name", fonthead)));
        table.addCell(new PdfPCell(new Phrase("Department", fonthead)));
        table.addCell(new PdfPCell(new Phrase("Event 1", fonthead)));
        table.addCell(new PdfPCell(new Phrase("Event 2", fonthead)));
        table.addCell(new PdfPCell(new Phrase("Event 3", fonthead)));
        //adding cellvalues
        while (rs.next()) {
            table.addCell(new PdfPCell(new Phrase(rs.getString(1), font)));
            table.addCell(new PdfPCell(new Phrase(rs.getString("rehno"), font)));
            table.addCell(new PdfPCell(new Phrase(rs.getString("Name"), font)));
            table.addCell(new PdfPCell(new Phrase(rs.getString("deparment"), font)));
            table.addCell(new PdfPCell(new Phrase(rs.getString("event1"), font)));
            table.addCell(new PdfPCell(new Phrase(rs.getString("event2"), font)));
            table.addCell(new PdfPCell(new Phrase(rs.getString("event3"), font)));
        }
        document.add(table);
        document.close();
    }
    public int tload() { //loading table in view
        ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
        try {
            sqlconnection consql = new sqlconnection();
            Connection con = consql.getcon();
            PreparedStatement pst = con.prepareStatement("select * from arts_student");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                oblist.add(new ModelTable(rs.getString(1), rs.getString("rehno"),
                        rs.getString("Name"), rs.getString("deparment"),
                        rs.getString("event1"), rs.getString("event2"), rs.getString("event3")));

            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        col_che.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("Chestno"));
        col_ren.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("reno"));
        col_name.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("name"));
        col_dep.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("depart"));
        col_ev1.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("evnt1"));
        col_ev2.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("evnt2"));
        col_ev3.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("evnt3"));
        Tablestud.setItems(oblist);
        return 0;
    }


    public void gostudententry(ActionEvent actionEvent) throws IOException {
        d1.setVisible(false);
        d2.setVisible(false);
        Parent root = FXMLLoader.load(getClass().getResource("page1.fxml"));
        stackc.getChildren().add(root);
    }
    public void gowinnerentry(ActionEvent actionEvent) throws IOException {
        d1.setVisible(false);
        d2.setVisible(false);
        Parent root = FXMLLoader.load(getClass().getResource("page2.fxml"));
        stackc.getChildren().add(root);
    }
    public void gotoprinter(ActionEvent actionEvent) throws IOException {
        d1.setVisible(false);
        d2.setVisible(false);
        Parent root = FXMLLoader.load(getClass().getResource("page3.fxml"));
        stackc.getChildren().add(root);
    }
    public void closeprogram(MouseEvent mouseEvent) throws Exception {

        resettloder();
        Stage stage = (Stage) closered.getScene().getWindow();
        Stage stage1=new Stage();
        Main ss=new Main();
        ss.start(stage1);
        stage.close();

    }
    public void closeentry(MouseEvent mouseEvent) {
        closered.setVisible(true);
        closegreen.setVisible(false);
    }
    public void closeecite(MouseEvent mouseEvent) {
        closered.setVisible(false);
        closegreen.setVisible(true);

    }
    public void nextp2(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        Parent root1 = FXMLLoader.load(getClass().getResource("page15.fxml"));
        stackc2.getChildren().add(root1);
        studviewd.setStyle("-fx-background-color: #6666ff; -fx-background-radius: 20; -fx-border-radius: 30; -fx-border-color: #0000ff; -fx-border-width: 2.5;");
        studentryd.setStyle("-fx-background-color: #222; -fx-background-radius: 20; -fx-border-radius: 30; -fx-border-color: #0000ff; -fx-border-width: 2.5;");

    }
    public void nextp1(ActionEvent actionEvent) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("page1.fxml"));
        stackc2.getChildren().add(root1);
        studentryd.setStyle("-fx-background-color: #6666ff; -fx-background-radius: 20; -fx-border-radius: 30; -fx-border-color: #0000ff; -fx-border-width: 2.5;");
        studviewd.setStyle("-fx-background-color: #222; -fx-background-radius: 20; -fx-border-radius: 30; -fx-border-color: #0000ff; -fx-border-width: 2.5;");
    }


    public void next4(ActionEvent actionEvent) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("page25.fxml"));
        stackc3.getChildren().add(root1);
        winnviewd.setStyle("-fx-background-color: #6666ff; -fx-background-radius: 20; -fx-border-radius: 30; -fx-border-color: #0000ff; -fx-border-width: 2.5;");
        winentryd.setStyle("-fx-background-color: #222; -fx-background-radius: 20; -fx-border-radius: 30; -fx-border-color: #0000ff; -fx-border-width: 2.5;");
    }

    public void next3(ActionEvent actionEvent) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("page2.fxml"));
        stackc3.getChildren().add(root1);
        winnviewd.setStyle("-fx-background-color: #222; -fx-background-radius: 20; -fx-border-radius: 30; -fx-border-color: #0000ff; -fx-border-width: 2.5;");
        winentryd.setStyle("-fx-background-color: #6666ff; -fx-background-radius: 20; -fx-border-radius: 30; -fx-border-color: #0000ff; -fx-border-width: 2.5;");
    }

    public void coboboxmouse(MouseEvent mouseEvent) {
        ObservableList list = FXCollections.observableArrayList();
        try {
            list.add("null");
            sqlconnection consql = new sqlconnection();
            Connection con = consql.getcon();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from arts_event");
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            cbevrnt2.setItems(list);
            cbevrnt3.setItems(list);
            cbevrnt1.setItems(list);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void adder1(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String s1 = reg.getText();
        sqlconnection consql = new sqlconnection();
        String s2 = name.getText();
        String s3 = depaet.getText();
        String s4 = (String) cbevrnt1.getValue();
        String s5 = (String) cbevrnt2.getValue();
        String s6 = (String) cbevrnt3.getValue();
        if (reg.getText().trim().isEmpty() || name.getText().trim().isEmpty() || depaet.getText().trim().isEmpty() || (cbevrnt1.getValue() == "null" && cbevrnt2.getValue() == "null" && cbevrnt3.getValue() == "null")) {
            JOptionPane.showMessageDialog(null, "Specify all details");
        } else {
            String sql1 = "select * from arts_student where name='" + s2 + "' and deparment='" + s3 + "'";
            String sql2 = "select * from arts_student where rehno=" + s1;
            Connection con = consql.getcon();
            PreparedStatement pst = con.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                falgs = 1;
            }
            pst = con.prepareStatement(sql2);
            ResultSet rs2 = pst.executeQuery();
            while (rs2.next()) {
                falgs = 2;
            }
            if (falgs == 1) {
                JOptionPane.showMessageDialog(null, "Name & department same content exiting on another row ");
            } else if (falgs == 2) {
                JOptionPane.showMessageDialog(null, "Existing Reg no");
            } else if (falgs == 2 && falgs == 1) {
                JOptionPane.showMessageDialog(null, "Already Registered Student");
            } else {
                try {
                    String sqlQ2 = "insert into arts_student(rehno,name,deparment,event1,event2,event3) VALUES(" + s1 + ",'" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "')";

                    Connection con2 = consql.getcon();
                    PreparedStatement ps2 = con2.prepareStatement(sqlQ2);
                    ps2.executeUpdate();
                    reg.setText(null);
                    name.setText(null);
                    depaet.setText(null);
                    cbevrnt1.setItems(null);
                    cbevrnt2.setItems(null);
                    cbevrnt3.setItems(null);
                    addingscusss.setVisible(true);
                } catch (SQLException throwables) {
                    addingfalied.setVisible(true);
                    throwables.printStackTrace();
                }
            }
        }
    }
    public void wordcome(KeyEvent keyEvent) {
        ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
        String s = "name";
        if (bysearch.getValue() == "Chest no") {
            s = "Chestno";
        } else if (bysearch.getValue() == "Name") {
            s = "name";
        } else if (bysearch.getValue() == "Reg No") {
            s = "rehno";
        } else if (bysearch.getValue() == "Department") {
            s = "deparment";
        } else if (bysearch.getValue() == "Event 1") {
            s = "event1";
        } else if (bysearch.getValue() == "Event 2") {
            s = "event2";
        } else if (bysearch.getValue() == "Event 3") {
            s = "event3";
        }
        try {
            sqlconnection consql = new sqlconnection();
            Connection con = consql.getcon();
            PreparedStatement pst = con.prepareStatement("select * from arts_student Where " + s + " like '" + searcherfeld.getText() + "%'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                oblist.add(new ModelTable(rs.getString(1), rs.getString("rehno"),
                        rs.getString("Name"), rs.getString("deparment"),
                        rs.getString("event1"), rs.getString("event2"), rs.getString("event3")));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        col_che.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("Chestno"));
        col_ren.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("reno"));
        col_name.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("name"));
        col_dep.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("depart"));
        col_ev1.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("evnt1"));
        col_ev2.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("evnt2"));
        col_ev3.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("evnt3"));
        Tablestud.setItems(oblist);
    }
    public void refrsher(ActionEvent actionEvent) {
        rotater(refresher, 180, .35);
        searcherfeld.setText(null);
        tload();
    }
    public void disaplingmassage(MouseEvent mouseEvent) {
        addingscusss.setVisible(false);
        addingfalied.setVisible(false);
    }
    public void rotater(ImageView im, int ang, double dur) {
        RotateTransition newrotate = new RotateTransition(Duration.seconds(dur), im);
        newrotate.setAutoReverse(true);
        newrotate.setByAngle(ang);
        newrotate.setDelay(Duration.seconds(.1));
        newrotate.setCycleCount(2);
        newrotate.play();

    }
    public void showlist(MouseEvent mouseEvent) {
        ObservableList list = FXCollections.observableArrayList();
        list.add("Chest no");
        list.add("Reg No");
        list.add("Name");
        list.add("Department");
        list.add("Event 1");
        list.add("Event 2");
        list.add("Event 3");
        bysearch.setItems(list);
    }
    public void tabmclick(MouseEvent mouseEvent) {
        ModelTable q = Tablestud.getSelectionModel().getSelectedItem();
        regno.setText(q.getReno());
        nme.setText(q.getName());
        depar.setText(q.getDepart());
        ev1.setValue(q.getEvnt1());
        ev2.setValue(q.getEvnt2());
        ev3.setValue(q.getEvnt3());
        che = q.getChestno();
    }
    public void comboboxmouseclick2(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        ObservableList list = FXCollections.observableArrayList();
        list.add("null");
        sqlconnection consql = new sqlconnection();
        Connection con = consql.getcon();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from arts_event");
        while (rs.next()) {
            list.add(rs.getString(1));
        }
        ev1.setItems(list);
        ev2.setItems(list);
        ev3.setItems(list);
    }
    public void onediter(ActionEvent actionEvent) {
        String s1 = regno.getText();
        String s2 = nme.getText();
        String s3 = depar.getText();
        String s4 = (String) ev1.getValue();
        String s5 = (String) ev2.getValue();
        String s6 = (String) ev3.getValue();
        if (regno.getText().trim().isEmpty() || nme.getText().trim().isEmpty() || depar.getText().trim().isEmpty() || (ev1.getValue() == "null" && ev2.getValue() == "null" && ev3.getValue() == "null")) {
            JOptionPane.showMessageDialog(null, "Specify all details");

        } else {
            try {
                String sqlQ2 = "UPDATE arts_student SET rehno=" + s1 + ", name='" + s2 + "', deparment='" + s3 + "', event1='" + s4 + "', event2='" + s5 + "', event3='" + s6 + "' WHERE Chestno= " + che;
                sqlconnection consql = new sqlconnection();
                Connection con = consql.getcon();
                PreparedStatement ps2 = con.prepareStatement(sqlQ2);
                ps2.executeUpdate();
                regno.setText(null);
                nme.setText(null);
                depar.setText(null);
                ev1.setItems(null);
                ev2.setItems(null);
                ev3.setItems(null);
                ev1.setValue("");
                ev2.setValue("");
                ev3.setValue("");
                tload();
                che = " ";

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void ondelecte1(ActionEvent actionEvent) {
        try {
            String sqlQ2 = "DELETE FROM arts_student WHERE Chestno=" + che;
            sqlconnection consql = new sqlconnection();
            Connection con = consql.getcon();
            PreparedStatement ps2 = con.prepareStatement(sqlQ2);
            ps2.executeUpdate();
            regno.setText(null);
            nme.setText(null);
            depar.setText(null);
            ev1.setValue("");
            ev2.setValue("");
            ev3.setValue("");
            tload();
            che = null;
            JOptionPane.showMessageDialog(null, "Row Delete Sucessfully");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    public void clearingaction(ActionEvent actionEvent) {
        reg.setText(null);
        name.setText(null);
        depaet.setText(null);
        cbevrnt1.setValue("null");
        cbevrnt2.setValue("null");
        cbevrnt3.setValue("null");
    }

    public void wineventclick(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        ObservableList list = FXCollections.observableArrayList();

        sqlconnection consql = new sqlconnection();
        Connection con = consql.getcon();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from arts_event");
        while (rs.next()) {
            list.add(rs.getString(1));
        }
        winevent.setItems(list);

    }
    public void foraddwinner(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String sqlQ1 = "select * from arts_student where Chestno=" + win1st.getText();
        String sqlQ2 = "select * from arts_student where Chestno=" + win2st.getText();
        String sqlQ3 = "select * from arts_student where Chestno=" + win3st.getText();
        String sqlu1 = null, sqlu2 = null, sqlu3 = null;
        String event = (String) winevent.getValue();
        String chesql1 = "select * from arts_winners where Chestno=" + win1st.getText() + " and Event='" + event + "'";
        String chesql2 = "select * from arts_winners where Chestno=" + win2st.getText() + " and Event='" + event + "'";
        String chesql3 = "select * from arts_winners where Chestno=" + win3st.getText() + " and Event='" + event + "'";
        sqlconnection consql3 = new sqlconnection();
        Connection con4 = consql3.getcon();
        int chestflage1 = 0, chestflage2 = 0, chestflage3 = 0;
        PreparedStatement pstc1 = con4.prepareStatement(chesql1);
        PreparedStatement pstc2 = con4.prepareStatement(chesql2);
        PreparedStatement pstc3 = con4.prepareStatement(chesql3);
        ResultSet rs;
        rs = pstc1.executeQuery();
        while (rs.next()) {
            chestflage1 = 1;
        }
        rs = pstc2.executeQuery();
        while (rs.next()) {
            chestflage2 = 1;
        }
        rs = pstc3.executeQuery();
        while (rs.next()) {
            chestflage3 = 1;
        }
        if (chestflage1 == 1 && chestflage2 == 1 && chestflage3 == 1) {
            JOptionPane.showMessageDialog(null, "These 3 chest number already ennterd in this Event");
        } else if (chestflage1 == 1 && chestflage2 == 1) {
            JOptionPane.showMessageDialog(null, "1st and 2nd chest number already ennterd in this Event");

        } else if (chestflage2 == 1 && chestflage3 == 1) {
            JOptionPane.showMessageDialog(null, "2nd and 3rd chest number already ennterd in this Event");

        } else if (chestflage1 == 1 && chestflage3 == 1) {
            JOptionPane.showMessageDialog(null, "1st and 3rd chest number already ennterd in this Event");

        } else if (chestflage1 == 1) {
            JOptionPane.showMessageDialog(null, "1st chest number already ennterd in this Event");

        } else if (chestflage2 == 1) {
            JOptionPane.showMessageDialog(null, "2nd chest number already ennterd in this Event");

        } else if (chestflage3 == 1) {
            JOptionPane.showMessageDialog(null, "3rd chest number already ennterd in this Event");

        } else if (chestflage1 == 0 && chestflage2 == 0 && chestflage3 == 0) {
            try {
                sqlconnection consql = new sqlconnection();
                Connection con = consql.getcon();

                PreparedStatement ps1 = con.prepareStatement(sqlQ1);
                ResultSet rs1 = ps1.executeQuery();
                PreparedStatement ps2 = con.prepareStatement(sqlQ2);
                ResultSet rs2 = ps2.executeQuery();
                PreparedStatement ps3 = con.prepareStatement(sqlQ3);
                ResultSet rs3 = ps3.executeQuery();
                String s11 = null, s12 = null, s13 = null, s21 = null, s22 = null, s23 = null, s31 = null, s32 = null, s33 = null;
                while (rs1.next() && rs2.next() && rs3.next()) {
                    sqlu1 = "insert into arts_winners VALUES(" + win1st.getText() + ",'" + rs1.getString(3) + "','" + rs1.getString(4) + "','" + event + "',1)";
                    sqlu2 = "insert into arts_winners VALUES(" + win2st.getText() + ",'" + rs2.getString(3) + "','" + rs2.getString(4) + "','" + event + "',2)";
                    sqlu3 = "insert into arts_winners VALUES(" + win3st.getText() + ",'" + rs3.getString(3) + "','" + rs3.getString(4) + "','" + event + "',3)";
                    s11 = rs1.getString(5);
                    s12 = rs1.getString(6);
                    s13 = rs1.getString(7);
                    s21 = rs2.getString(5);
                    s22 = rs2.getString(6);
                    s23 = rs2.getString(7);
                    s31 = rs3.getString(5);
                    s32 = rs3.getString(6);
                    s33 = rs3.getString(7);
                }
                if (!s11.equals(event) && !s12.equals(event) && !s13.equals(event)) {
                    JOptionPane.showMessageDialog(null, "1st chest nummber didi not register in this event");
                } else if (!s21.equals(event) && !s22.equals(event) && !s23.equals(event)) {
                    JOptionPane.showMessageDialog(null, "2nd chest nummber didi not register in this event");
                } else if (!s31.equals(event) && !s32.equals(event) && !s33.equals(event)) {
                    JOptionPane.showMessageDialog(null, "3rd chest nummber didi not register in this event");
                } else {
                    ps1 = con.prepareStatement(sqlu1);
                    ps1.executeUpdate();
                    ps2 = con.prepareStatement(sqlu2);
                    ps2.executeUpdate();
                    ps3 = con.prepareStatement(sqlu3);
                    ps3.executeUpdate();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public void onclickrefresh(MouseEvent mouseEvent) {
        rotater(refresher2, 180, .35);
        tload2();
        sercher2.setText("");
    }

    public void tload2() {
        ObservableList<ModelTabelW> oblist = FXCollections.observableArrayList();
        try {
            sqlconnection consql = new sqlconnection();
            Connection con = consql.getcon();
            PreparedStatement pst = con.prepareStatement("select * from arts_winners");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                oblist.add(new ModelTabelW(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        wcol_ches.setCellValueFactory(new PropertyValueFactory<ModelTabelW, String>("chest"));
        wcol_na.setCellValueFactory(new PropertyValueFactory<ModelTabelW, String>("name"));
        wcol_dep.setCellValueFactory(new PropertyValueFactory<ModelTabelW, String>("depart"));
        wcol_eve.setCellValueFactory(new PropertyValueFactory<ModelTabelW, String>("event"));
        wcol_ran.setCellValueFactory(new PropertyValueFactory<ModelTabelW, String>("rank"));
        wintable.setItems(oblist);
    }
    public void serchcomboclick(MouseEvent mouseEvent) {
        ObservableList list = FXCollections.observableArrayList();
        list.add("Chest no");
        list.add("Name");
        list.add("Department");
        list.add("Event");
        list.add("Rank");
        serchcombo2.setItems(list);
    }
    public void searchkeyon(KeyEvent keyEvent) {
        ObservableList<ModelTabelW> oblist = FXCollections.observableArrayList();
        String s = "name";
        if (serchcombo2.getValue() == "Chest no") {
            s = "Chestno";
        } else if (serchcombo2.getValue() == "Name") {
            s = "Name";
        } else if (serchcombo2.getValue() == "Department") {
            s = "Department";
        } else if (serchcombo2.getValue() == "Event") {
            s = "Event";
        } else if (serchcombo2.getValue() == "Rank") {
            s = "Rank";
        }
        try {
            sqlconnection consql = new sqlconnection();
            Connection con = consql.getcon();
            PreparedStatement pst = con.prepareStatement("select * from arts_winners Where " + s + " like '" + sercher2.getText() + "%'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                oblist.add(new ModelTabelW(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        wcol_ches.setCellValueFactory(new PropertyValueFactory<ModelTabelW, String>("chest"));
        wcol_na.setCellValueFactory(new PropertyValueFactory<ModelTabelW, String>("name"));
        wcol_dep.setCellValueFactory(new PropertyValueFactory<ModelTabelW, String>("depart"));
        wcol_eve.setCellValueFactory(new PropertyValueFactory<ModelTabelW, String>("event"));
        wcol_ran.setCellValueFactory(new PropertyValueFactory<ModelTabelW, String>("rank"));
        wintable.setItems(oblist);
    }
    public void printeraction2(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException, DocumentException {
        sqlconnection consql = new sqlconnection();
        Connection con = consql.getcon();
        PreparedStatement pst = con.prepareStatement("select * from arts_winners");
        ResultSet rs = pst.executeQuery();
        BaseFont bf = BaseFont.createFont(     //column font
                BaseFont.TIMES_ROMAN,
                BaseFont.CP1252,
                BaseFont.EMBEDDED);
        BaseFont bf2 = BaseFont.createFont(  //header font
                BaseFont.COURIER_BOLD,
                BaseFont.CP1252
                , BaseFont.EMBEDDED);
        Font fonthead = new Font(bf2, 10);
        Font font = new Font(bf, 10);
        Stage primaryStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF", "*.pdf"));
        File file = fileChooser.showSaveDialog(primaryStage);
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();
        PdfPTable table = new PdfPTable(5);//7 is cell number
        table.setTotalWidth(500);
// Set Each Column Width - Make Sure Array is the same number specified in constructor
        table.setWidths(new int[]{50, 110, 110, 80, 40});
// columnWidths = {column1, column2, column3...}
        //column header
        table.addCell(new PdfPCell(new Phrase("Chest no", fonthead)));
        table.addCell(new PdfPCell(new Phrase("Name", fonthead)));
        table.addCell(new PdfPCell(new Phrase("Department", fonthead)));
        table.addCell(new PdfPCell(new Phrase("Event", fonthead)));
        table.addCell(new PdfPCell(new Phrase("Rank", fonthead)));
        //adding cellvalues
        while (rs.next()) {
            table.addCell(new PdfPCell(new Phrase(rs.getString(1), font)));
            table.addCell(new PdfPCell(new Phrase(rs.getString(2), font)));
            table.addCell(new PdfPCell(new Phrase(rs.getString(3), font)));
            table.addCell(new PdfPCell(new Phrase(rs.getString(4), font)));
            table.addCell(new PdfPCell(new Phrase(rs.getString(5), font)));
        }
        document.add(table);
        document.close();
    }

    public void edieteraction2(ActionEvent actionEvent) {
        String s1 = chesttext.getText();
        String s2 = nametext.getText();
        String s3 = departtex.getText();
        String s4 = (String) eventtext.getValue();
        String s5 = ranktext.getText();
        if (chesttext.getText().trim().isEmpty() || nametext.getText().trim().isEmpty() || departtex.getText().trim().isEmpty() || eventtext.getValue() == "null" && ranktext.getText() == "null") {

            JOptionPane.showMessageDialog(null, "Specify all details");

        } else {

            try {
                String sqlQ2 = "UPDATE arts_winners SET Chestno=" + s1 + ", Name='" + s2 + "', Department='" + s3 + "', Event='" + s4 + "', Rank=" + s5 + " WHERE Chestno= " + che + " and Event='" + ev + "'";
                sqlconnection consql = new sqlconnection();
                Connection con = consql.getcon();
                PreparedStatement ps2 = con.prepareStatement(sqlQ2);
                ps2.executeUpdate();
                tload2();
                chesttext.setText(null);
                nametext.setText(null);
                departtex.setText(null);
                eventtext.setValue(null);
                ranktext.setText(null);
                ev = "";
                che = " ";
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public void deleteracction2(ActionEvent actionEvent) {
        try {
            String sqlQ2 = "DELETE FROM arts_winners WHERE Chestno= " + che + " and Event='" + ev + "'";
            sqlconnection consql = new sqlconnection();
            Connection con = consql.getcon();
            PreparedStatement ps2 = con.prepareStatement(sqlQ2);
            ps2.executeUpdate();
            tload2();
            chesttext.setText(null);
            nametext.setText(null);
            departtex.setText(null);
            eventtext.setValue(null);
            ranktext.setText(null);
            ev = "";
            che = " ";
            JOptionPane.showMessageDialog(null, "Row Delete Sucessfully");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void tableclick2(MouseEvent mouseEvent) {
        ModelTabelW q = wintable.getSelectionModel().getSelectedItem();
        chesttext.setText(q.getChest());
        nametext.setText(q.getName());
        departtex.setText(q.getDepart());
        eventtext.setValue(q.getEvent());
        ranktext.setText(q.getRank());
        che = q.getChest();
        ev = q.getEvent();
    }

    public void readingarts_event(MouseEvent mouseEvent) {
        ObservableList list = FXCollections.observableArrayList();
        try {
            sqlconnection consql = new sqlconnection();
            Connection con = consql.getcon();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from arts_event");
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            eventtext.setItems(list);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void refreshaction3(MouseEvent mouseEvent) {
        rotater(refresher3, 180, .35);
        tloader3();
    }
    public void tloader3() {
        ObservableList<ModelTabelW> oblist = FXCollections.observableArrayList();
        try {
            sqlconnection consql = new sqlconnection();
            Connection con = consql.getcon();
            PreparedStatement pst = con.prepareStatement("select * from arts_winners");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                oblist.add(new ModelTabelW(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        printpchest.setCellValueFactory(new PropertyValueFactory<ModelTabelW, String>("chest"));
        printpname.setCellValueFactory(new PropertyValueFactory<ModelTabelW, String>("name"));
        printpdep.setCellValueFactory(new PropertyValueFactory<ModelTabelW, String>("depart"));
        printpevent.setCellValueFactory(new PropertyValueFactory<ModelTabelW, String>("event"));
        printprank.setCellValueFactory(new PropertyValueFactory<ModelTabelW, String>("rank"));
        tableforprint.setItems(oblist);
    }

    public void dubleclickrowpass(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        if (mouseEvent.getClickCount() == 2) {
            ModelTabelW adder;
            adder = tableforprint.getSelectionModel().getSelectedItem();
            sqlconnection consql = new sqlconnection();
            Connection con2 = consql.getcon();
            PreparedStatement pst2 =con2.prepareStatement("select * from arts_printning where Name='"+ adder.getName()+"' and Event='"+adder.getEvent()+"'");
            ResultSet rs2=pst2.executeQuery();
            int i=0;
            while(rs2.next())
            {
                i++;
            }

            if(i<1) {
                ObservableList<ModelTabelW> printrows = FXCollections.observableArrayList();
                Connection con = consql.getcon();
                PreparedStatement pst = con.prepareStatement("insert into arts_printning VALUES(" + adder.getChest() + ",'" + adder.getName() + "','" + adder.getDepart() + "','" + adder.getEvent() + "'," + adder.getRank() + ") ");
                pst.executeUpdate();
                tloder4();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Already selected");
            }
        }
    }
    public void actionforpassingtable(MouseEvent mouseEvent) {
        ColorAdjust ss = new ColorAdjust();
        ss.setBrightness(.3);
        passtable.setEffect(ss);
        try {
            sqlconnection consql = new sqlconnection();
            Connection con = consql.getcon();
            PreparedStatement pst = con.prepareStatement("INSERT INTO arts_printning SELECT * FROM arts_winners");
            pst.executeUpdate();
            tloder4();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }
    public void deletekeypress(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
        if (keyEvent.getCode() == KeyCode.DELETE) {
            ModelTabelW q = tableforprint1.getSelectionModel().getSelectedItem();
            tableforprint1.getItems().remove(q);
            sqlconnection consql = new sqlconnection();
            Connection con = consql.getcon();

            PreparedStatement pst = con.prepareStatement("DELETE FROM arts_printning WHERE Chestno= " + q.getChest()+ " and Event='" + q.getEvent() + "'");
            pst.executeUpdate();
        }
    }

    public void actionforprintercer(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("printerpage.fxml"));
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("page3.fxml"));
            PrinterJob job = PrinterJob.createPrinterJob();
            Printer printer = Printer.getDefaultPrinter().getDefaultPrinter();
            PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.PORTRAIT, 0,0,0,0);
            JobSettings jobSettings = job.getJobSettings();
            jobSettings.setPageLayout(pageLayout);
            sqlconnection consql = new sqlconnection();
            Connection con = consql.getcon();
            PreparedStatement pst = con.prepareStatement("select * from arts_printning");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                namelable.setText(rs.getString(2));
                dipartmentlable.setText(rs.getString(3));
                Eventlabel.setText(rs.getString(4));
                if(rs.getInt(5)==1)
                {
                    rankimg.setImage(new Image("img/gold.png.png"));
                }
                if(rs.getInt(5)==2)
                {
                    rankimg.setImage(new Image("img/silver.png"));
                }
                if(rs.getInt(5)==3)
                {
                    rankimg.setImage(new Image("img/browns.png"));
                }
               if (!job.showPrintDialog(null)) {
                    System.out.println("2");
                }
                if (!job.printPage(printpanel)) {
                    System.out.println("3");
                }
            }
            job.endJob();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void printit(ActionEvent actionEvent) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("printerpage.fxml"));
        Scene scene = new Scene(root1);
        Stage stage1 = new Stage();
        stage1.setScene(scene);
        stage1.setTitle("Arts");
        scene.setFill(Color.TRANSPARENT);
        stage1.initStyle(StageStyle.TRANSPARENT);
        stage1.show();
    }
    public void   tloder4() throws SQLException, ClassNotFoundException {
        ObservableList<ModelTabelW> printrows = FXCollections.observableArrayList();
        sqlconnection consql = new sqlconnection();
        Connection con = consql.getcon();
        PreparedStatement pst = con.prepareStatement("select * from arts_printning");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            printrows.add(new ModelTabelW(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
        }
        printpchest1.setCellValueFactory(new PropertyValueFactory<ModelTabelW, String>("chest"));
        printpname1.setCellValueFactory(new PropertyValueFactory<ModelTabelW, String>("name"));
        printpdep1.setCellValueFactory(new PropertyValueFactory<ModelTabelW, String>("depart"));
        printpevent1.setCellValueFactory(new PropertyValueFactory<ModelTabelW, String>("event"));
        printprank1.setCellValueFactory(new PropertyValueFactory<ModelTabelW, String>("rank"));
        tableforprint1.setItems(printrows);
    }
    public  void resettloder() throws SQLException, ClassNotFoundException {
        sqlconnection consql = new sqlconnection();
        Connection con = consql.getcon();
        PreparedStatement pst = con.prepareStatement("DELETE FROM arts_printning");
        pst.executeUpdate();

    }
    public void emptythetable(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        resettloder();
        ColorAdjust ss = new ColorAdjust();
        ss.setBrightness(.2);
        tabledeleter.setEffect(ss);
        tloder4();
    }

    public void emptythetable2(MouseEvent mouseEvent){
        ColorAdjust ss = new ColorAdjust();
        ss.setBrightness(0);
        tabledeleter.setEffect(ss);
    }
    public void actionforpassingtable2(MouseEvent mouseEvent) {
        ColorAdjust ss = new ColorAdjust();
        ss.setBrightness(0);
        passtable.setEffect(ss);
    }

    public void closeb2press(MouseEvent mouseEvent) {
        Stage stage = (Stage) closeb2.getScene().getWindow();
        stage.close();
    }

    public void closeb2enter(MouseEvent mouseEvent) {
        ColorAdjust ss = new ColorAdjust();
        ss.setBrightness(0);
        closeb2.setEffect(ss);
    }

    public void clopseb2exite(MouseEvent mouseEvent) {
        ColorAdjust ss = new ColorAdjust();
        ss.setBrightness(1);
        closeb2.setEffect(ss);
    }


    public void readingeventlist(MouseEvent mouseEvent) {
    }
}