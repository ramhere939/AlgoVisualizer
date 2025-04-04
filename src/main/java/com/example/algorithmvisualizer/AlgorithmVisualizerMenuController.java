package com.example.algorithmvisualizer;

import com.example.algorithmvisualizer.view.MainWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Objects;

public class AlgorithmVisualizerMenuController {
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private AnchorPane mainAnchorPane;
    private Scene primaryScene;

    public void setPrimaryScene(Scene scene) {
        this.primaryScene = scene;
        System.out.println("Primary Scene set: " + scene);
    }

    @FXML
    private void initialize() {
        this.label1.setStyle("-fx-text-fill: white");
        this.label2.setStyle("-fx-text-fill: white");
        this.label3.setStyle("-fx-text-fill: white");
        this.label4.setStyle("-fx-text-fill: white");
        String imageFilePath = Objects.requireNonNull(getClass().getResource("/images/mainMenuBackground.jpg")).toString();
        Image image = new Image(imageFilePath);
        ImageView imageView = new ImageView(image);

        mainAnchorPane.getChildren().add(imageView);
        imageView.toBack();
    }

    @FXML
    private void handleSortingButtonClick() {
        if (mainAnchorPane == null) {
            System.err.println("Main anchor pane is null.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
            Scene currentScene = mainAnchorPane.getScene();
            System.out.println("Passing Primary Scene to MainWindow: " + primaryScene);
            String stylesheetPath = Objects.requireNonNull(getClass().getResource("generalStyle.css")).toExternalForm();
            MainWindow mainWindow = new MainWindow(primaryScene, loader, stylesheetPath);
            currentScene.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("generalStyle.css")).toExternalForm());
            currentScene.setRoot(mainWindow);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSearchingButtonClick() {
        if (mainAnchorPane == null) {
            System.err.println("Main anchor pane is null.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PathfindingVisualizer.fxml"));
            Parent pathfindingRoot = loader.load();
            Scene currentScene = mainAnchorPane.getScene();
            currentScene.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("pathStyle.css")).toExternalForm());
            currentScene.setRoot(pathfindingRoot);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void handleCloseButtonClick(ActionEvent event) {
        Stage stage = (Stage) mainAnchorPane.getScene().getWindow();
        stage.close();
    }
}
