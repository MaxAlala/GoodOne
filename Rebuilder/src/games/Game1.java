package games;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.beans.EventHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game1 {

    private AnimationTimer timer;

    private Pane root;
    static Scanner sc = new Scanner(System.in);
    private static double lvl_numbers = 0.075;
    private static int lvl_speed = 10;
    private static int score = 0;
    private static int hp = 5;
    private List<Node> cars = new ArrayList<>();
    private Node frog;
    Rectangle badCar = new Rectangle(40, 40, Color.WHITE);

    private Parent createContent() {
        root = new Pane();
        root.setPrefSize(800, 600);

        frog = initFrog();

        root.getChildren().add(frog);
        root.getChildren().add(badCar);
        HBox hbox = new HBox();
        Button toMenu = new Button("Menu");



        toMenu.setOnAction(e -> {
            Parent page1 = null;
            try {
                page1 = FXMLLoader.load(getClass().getResource("../mainMenu/sampleMenu.fxml"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            Scene tableScene = new Scene(page1);
            Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
            window.setScene(tableScene);
            window.show();
        });


        Button closeTheApllication = new Button("closeApp");
        closeTheApllication.setOnAction(e ->{
            System.exit(1);
        });


        hbox.getChildren().addAll(toMenu, closeTheApllication);
        root.getChildren().add(hbox);
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };
        timer.start();

        return root;
    }

    public void hundler(EventHandler event){

    }

    private Node initFrog() {
        Rectangle rect = new Rectangle(38, 38, Color.GREEN);
        rect.setTranslateY(600 - 39);

        return rect;
    }

    private Node spawnCar() {
        Rectangle rect = new Rectangle(40, 40, Color.RED);
        rect.setTranslateY((int)(Math.random() * 14) * 40);  //

        root.getChildren().add(rect);
        return rect;
    }

    private void onUpdate() {
        for (Node car : cars)
            car.setTranslateX(car.getTranslateX() + Math.random() * lvl_speed); // speed of the cars

        if (Math.random() < lvl_numbers) { // 0.075 number of the cars
            cars.add(spawnCar());
        }

        checkState();
    }

    private void checkState() {
        for (Node car : cars) {
            if (car.getBoundsInParent().intersects(frog.getBoundsInParent()) || badCar.getBoundsInParent().intersects(frog.getBoundsInParent())) {
                frog.setTranslateX(0);
                frog.setTranslateY(600 - 39);
                hp--;
                if(hp == 0){
//                    youLost();
                    timer.stop();
                    Label lab = new Label( "You score is: " + score);
                                                       //score saving
//                    int k = 0;
                    root.getChildren().add(lab);
//                if (choice.equals("Y")) {
//                    score = 0;
//                    lvl_speed = 10;
//                    lvl_numbers = 0.075;
//                    root.getChildren().remove(lab);
//                } else if (choice.equals("M")) {
//
//                } else if (choice.equals("C")) {
//                    System.exit(1);
//                } else System.out.println("smth wrong");

//                    root.getChildren().remove(lab);
                }
                return;
            }
        }

        if (frog.getTranslateY() <= 0) {
//            timer.stop();
//            String win = "YOU WIN";
             score++;
             lvl_numbers += 0.010;
             lvl_speed += 1;
            frog.setTranslateX(0);
            frog.setTranslateY(600 - 39);
//            HBox hBox = new HBox();
//            hBox.setTranslateX(300);
//            hBox.setTranslateY(250);
//            root.getChildren().add(hBox);

//            for (int i = 0; i < win.toCharArray().length; i++) {
//                char letter = win.charAt(i);
//
//                Text text = new Text(String.valueOf(letter));
//                text.setFont(Font.font(48));
//                text.setOpacity(0);
//
//                hBox.getChildren().add(text);
//
//                FadeTransition ft = new FadeTransition(Duration.seconds(0.66), text);
//                ft.setToValue(1);
//                ft.setDelay(Duration.seconds(i * 0.15));
//                ft.play();
//            }
        }
    }

    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));

        stage.getScene().setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W:
                    frog.setTranslateY(frog.getTranslateY() - 40);
                    break;
                case S:
                    frog.setTranslateY(frog.getTranslateY() + 40);
                    break;
                case A:
                    frog.setTranslateX(frog.getTranslateX() - 40);
                    break;
                case D:
                    frog.setTranslateX(frog.getTranslateX() + 40);
                    break;
                default:
                    break;
            }
        });

        stage.show();
    }

}
