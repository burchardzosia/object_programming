package agh.ics.oop.gui;


import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import agh.ics.oop.IMapElement;
public class GuiElementBox {
    VBox box = new VBox();
    Label label;

    public GuiElementBox(IMapElement element)  {

        Image image = null;
        try {
            image = new Image(new FileInputStream(element.getImageSrc()));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(20);
            imageView.setFitHeight(20);
            if (element instanceof Animal) {
                this.label = new Label(element.getPosition().toString());
            } else
                this.label = new Label("Grass");
            this.box.getChildren().addAll(imageView, label);
            this.box.setAlignment(Pos.CENTER);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found");
        }
        System.out.println(image);








    }




}
