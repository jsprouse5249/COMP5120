package com.example.demo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;


import java.io.IOException;
import javafx.scene.control.Button;

public class HelloApplication extends Application {
    HBox hbox;
    VBox vbox;

    TextArea textArea;
    Button button;
    Label label;

    @Override
    public void start(Stage stage) throws IOException {
        // hbox and vbox setup
        hbox = new HBox(40);
        hbox.setPrefHeight(200);
        hbox.setPrefWidth(200);

        vbox = new VBox(16);
        vbox.setPrefHeight(200);
        vbox.setPrefWidth(200);

        // setup views to go inside of boxes
        textArea = new TextArea();
        label = new Label("table\nbuttons go\nhere");
        button = new Button("SQL Query");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(textArea.getText());
            }
        });

        // add views to boxes
        vbox.getChildren().addAll(textArea, button);
        hbox.getChildren().addAll(label, vbox);

        // setup pane and scene
        BorderPane root = new BorderPane();
        root.setCenter(hbox);
        Scene scene = new Scene(root, 300,300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}