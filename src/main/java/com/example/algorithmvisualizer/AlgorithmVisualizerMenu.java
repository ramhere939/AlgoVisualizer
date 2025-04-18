package com.example.algorithmvisualizer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AlgorithmVisualizerMenu extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        Parent root = loader.load();
        AlgorithmVisualizerMenuController controller = loader.getController();
        Scene scene = new Scene(root, 900, 600);
        controller.setPrimaryScene(scene);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("AlgoVis");
        stage.show();
    }
}
