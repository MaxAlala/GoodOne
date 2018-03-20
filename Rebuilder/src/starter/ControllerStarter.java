package starter;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javafx.scene.Node;

public class ControllerStarter implements Initializable {

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXTextField email;

    @FXML Label badPassword;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {

//            Parent page = FXMLLoader.load(getClass().getResource("../mainMenu/sampleMenu.fxml"));
//            Scene tableScene = new Scene(page);
//            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//            window.setScene(tableScene);
//            window.show();
    }

    @FXML
    private void requestDB(ActionEvent event) throws IOException {
    DateBaseRequest db = new DateBaseRequest();
    boolean isThere = db.isThere(email.getText(), password.getText());

    if(isThere){
        Parent page = FXMLLoader.load(getClass().getResource("../mainMenu/sampleMenu.fxml"));
        Scene tableScene = new Scene(page);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableScene);
        window.show();
    }else badPassword.setText("something is not right");
    }

    public void initialize(URL url, ResourceBundle rb) {
    }
}
