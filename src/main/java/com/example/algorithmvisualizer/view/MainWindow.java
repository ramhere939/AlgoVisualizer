package com.example.algorithmvisualizer.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class MainWindow extends BorderPane {
    public static ChartPane chartPane;
    public static DescriptionBox descriptionBox;

    public MainWindow(Scene algorithmVisualizerMenuScene, FXMLLoader loader, String stylesheetPath) {
        this.getStyleClass().add("pane");

        if (this.getTop() instanceof FieldBox) {
            this.setTop(null);
        }
        if (chartPane != null) {
            this.setCenter(null);
        }
        if (this.getBottom() instanceof ButtonBox) {
            this.setBottom(null);
        }
        if (this.getLeft() instanceof AlgorithmBox) {
            this.setLeft(null);
        }
        if (this.getRight() instanceof DescriptionBox) {
            this.setRight(null);
        }
        FieldBox fieldBox = new FieldBox();
        chartPane = new ChartPane();
        descriptionBox = new DescriptionBox();
        this.setTop(fieldBox);
        this.setCenter(chartPane);
        this.setBottom(new ButtonBox(fieldBox, loader, algorithmVisualizerMenuScene, stylesheetPath));
        this.setLeft(new AlgorithmBox(fieldBox, descriptionBox));
        this.setRight(descriptionBox);
    }
}

