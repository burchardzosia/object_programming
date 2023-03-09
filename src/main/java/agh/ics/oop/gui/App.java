package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import static java.lang.String.valueOf;

public class App extends Application {
    GridPane gridPane = new GridPane();
    private AbstractWorldMap map;
    private SimulationEngine simulationEngine;



    public void actualizeMap() {
        Platform.runLater(() -> {
            makeMap();
        });

    }

    public void makeMap() {
        gridPane.setGridLinesVisible(false);
        gridPane.getColumnConstraints().clear();
        gridPane.getRowConstraints().clear();
        gridPane.getChildren().clear();
        gridPane.setGridLinesVisible(true);
        int startX = map.mapBoundary.lowerLeft().x;
        int startY = map.mapBoundary.lowerLeft().y;
        int endX = map.mapBoundary.upperRight().x;
        int endY = map.mapBoundary.upperRight().y;
        int width = 60;
        int height = 60;

        gridPane.setGridLinesVisible(true);
        Label label = new Label("x/y");
        gridPane.add(label, 0, 0);
        gridPane.setHalignment(label, HPos.CENTER);

        for (int i = startX; i <= endX; i++) {
            Label label2 = new Label(String.valueOf(i));
            gridPane.add(label2, i - startX + 1, 0);
            GridPane.setHalignment(label2, HPos.CENTER);
            gridPane.getColumnConstraints().add(new ColumnConstraints(width));
        }

        for (int i = endY; i >= startY; i--) {
            Label label2 = new Label(String.valueOf(i));
            gridPane.add(label2, 0, endY - i + 1);
            gridPane.setHalignment(label2, HPos.CENTER);
            gridPane.getRowConstraints().add(new RowConstraints(height));
        }


        for (int iY = endY; iY >= startY; iY--) {
            for (int iX = startX; iX <= endX; iX++) {
                Vector2d position = new Vector2d(iX, iY);
                if (this.map.isOccupied(position)) {
                    Object object = this.map.objectAt(position);
                    if (object != null) {
                        GuiElementBox vBox = new GuiElementBox((IMapElement) this.map.objectAt(position));
                        gridPane.add(vBox.box, iX - startX + 1, endY - iY + 1);
                    }
                }


            }
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField textField = new TextField();
        Button startButton = new Button();
        startButton.setText("Start");
        startButton.setOnAction((action) -> {
            String text = textField.getText();
            MoveDirection[] directions = OptionsParser.parser(text.split(" "));
            simulationEngine.addDirections(directions);
            Thread thread = new Thread(this.simulationEngine);
            thread.start();

        });
        MoveDirection[] directions =null;
        map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        simulationEngine = new SimulationEngine(directions, map, positions, 1000, this);
        HBox hBox = new HBox(this.gridPane, textField, startButton);
        makeMap();
        Scene scene = new Scene(hBox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();


    }



}