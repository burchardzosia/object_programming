package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import static java.lang.String.valueOf;

public class App extends Application {
    private AbstractWorldMap map;
    @Override
    public void init() throws Exception {
        try{
            String[] args=getParameters().getRaw().toArray(new String[0]);
            MoveDirection[] directions = new OptionsParser().parser(args);
            map=new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            System.out.println(map.toString());



        }
        catch(IllegalArgumentException ex){
            System.out.println("EROR");

        }

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        int startX = map.mapBoundary.lowerLeft().x;
        int startY = map.mapBoundary.lowerLeft().y;
        int endX = map.mapBoundary.upperRight().x;
        int endY = map.mapBoundary.upperRight().y;
        int width = 30;
        int height = 30;

        int Width = 30;
        int Height =30;
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);


        Label label = new Label("x/y");
        gridPane.add(label, 0 , 0);
        gridPane.setHalignment(label, HPos.CENTER);

        for(int i = startX; i <= endX; i++){
            Label label2 = new Label(String.valueOf(i));
            gridPane.add(label2, i-startX+1 , 0);
            gridPane.setHalignment(label2, HPos.CENTER);
        }

        for(int i = endY; i >= startY; i--){
            Label label2 = new Label(String.valueOf(i));
            gridPane.add(label2, 0 , endY - i + 1);
            gridPane.setHalignment(label2, HPos.CENTER);
        }

        gridPane.getRowConstraints().add(new RowConstraints(height));
        gridPane.getColumnConstraints().add(new ColumnConstraints(width));

        for (int iY = endY; iY >= startY; iY--) {
            gridPane.getRowConstraints().add(new RowConstraints(height));
            for (int iX = startX; iX <= endX; iX++) {
                if (iY==endY)
                    gridPane.getColumnConstraints().add(new ColumnConstraints(width));
                String result = null;
                Vector2d position= new Vector2d(iX,iY);
                if (this.map.isOccupied(position)){
                    Object object = this.map.objectAt(position);
                    if (object != null) {
                        result = object.toString();
                    } else {
                        result = " ";
                    }
                } else {
                    result = " ";
                }
                Label label2 = new Label(result);

                gridPane.add(label2, iX-startX+1,endY - iY+1);
                gridPane.setHalignment(label2, HPos.CENTER);
            }}


        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
