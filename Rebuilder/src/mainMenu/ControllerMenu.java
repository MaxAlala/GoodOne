package mainMenu;

import flappybird.FlappyBird;
import games.Game1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerMenu {



    @FXML
    private void BAction(ActionEvent event) throws IOException {

        Parent page = FXMLLoader.load(getClass().getResource("../table/fxml/sampleTable.fxml"));
        Scene tableScene = new Scene(page);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableScene);
        window.show();
    }

    @FXML
    private void FlappyAction(ActionEvent event) throws Exception {

//        Parent page = FXMLLoader.load(getClass().getResource("../table/fxml/sampleTable.fxml"));
//        Scene tableScene = new Scene(page);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        FlappyBird game = new FlappyBird();
        game.start(window);
//        window.setScene(tableScene);
//        window.show();
    }
    @FXML
    private void GAction(ActionEvent event) throws Exception {

//        Parent page = FXMLLoader.load(getClass().getResource("../table/fxml/sampleTable.fxml"));
//        Scene tableScene = new Scene(page);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Game1 game = new Game1();
        game.start(window);
//        window.setScene(tableScene);
//        window.show();
    }

}
