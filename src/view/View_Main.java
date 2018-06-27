/*
 * Copyright (C) 2018 José Gabriel Gruber
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

import component.AnimationTimer_improved;
import javafx.scene.paint.Paint;

/**
 *
 * @author gruber
 */
public class View_Main {

    private GridPane grid, grid_title;
    private Button button_fire, button_add_RA, button_add_BW, button_startStop;
    private Text title, subtitle, fires, enemies;
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private AnimationTimer_improved animationTimer;

    public int total_enemies, total_bullets;

    //private Image background;
    public View_Main() {
    }

    public Parent getContent() {

        /*background = new Image("https://opengameart.org/sites/default/files/background0.png", 1270, 700, false, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);*/
        String style
                = "-fx-background-color: #515151;"
                + "-fx-border-color: #E1E1E1;"
                + "-fx-cursor: hand;"
                + "-fx-font-size: 13;"
                + "-fx-font-style: normal;"
                + "-fx-font-family: Noto Sans;"
                + "-fx-font-weight: bold;"
                + "-fx-text-fill: #F1F1F1;";
        
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setBackground(new Background(new BackgroundFill(Paint.valueOf("#212121"), CornerRadii.EMPTY, Insets.EMPTY)));

        grid_title = new GridPane();

        title = new Text(" Super TUX Adventures");
        title.setFont(Font.font("Ani", FontWeight.BOLD, 60));
        title.setFill(Paint.valueOf("#E1E1E1"));

        fires = new Text(" Total fires: " + total_bullets);
        fires.setFont(Font.font("DejaVu", FontWeight.BOLD, 20));
        fires.setFill(Paint.valueOf("#A1F1A1"));

        button_fire = new Button("Fire");
        button_fire.setStyle(style);
        button_startStop = new Button("Start/Stop");
        button_startStop.setStyle(style);

        grid_title.add(title, 0, 0);
        grid_title.add(fires, 1, 0);
        grid_title.add(new Text("     "), 3, 0);
        grid_title.add(button_fire, 4, 0);
        grid_title.add(button_startStop, 6, 0);

        subtitle = new Text("  The Rotten Apple and the Broken Windows");
        subtitle.setFont(Font.font("Ani", FontWeight.BOLD, 40));
        subtitle.setFill(Paint.valueOf("#A1E1E1"));

        enemies = new Text(" Total enemies: " + total_enemies);
        enemies.setFont(Font.font("DejaVu", FontWeight.BOLD, 20));
        enemies.setFill(Paint.valueOf("#F1A1A1"));

        button_add_RA = new Button("Add Roten Apple");
        button_add_RA.setStyle(style);
        button_add_BW = new Button("Add Broken Windows");
        button_add_BW.setStyle(style);
        
        grid_title.add(subtitle, 0, 1);
        grid_title.add(enemies, 1, 1);
        grid_title.add(new Text("     "), 3, 1);
        grid_title.add(button_add_RA, 4, 1);
        grid_title.add(new Text("     "), 5, 1);
        grid_title.add(button_add_BW, 6, 1);

        grid.add(grid_title, 0, 1);

        canvas = new Canvas(1270, 500);
        grid.add(canvas, 0, 3);

        graphicsContext = canvas.getGraphicsContext2D();

        return grid;
    }

    public GridPane getGrid() {
        return grid;
    }

    public void setGrid(GridPane grid) {
        this.grid = grid;
    }

    public GridPane getGrid_title() {
        return grid_title;
    }

    public void setGrid_title(GridPane grid_title) {
        this.grid_title = grid_title;
    }

    public Button getButton_fire() {
        return button_fire;
    }

    public void setButton_fire(Button button_fire) {
        this.button_fire = button_fire;
    }

    public Button getButton_add_RA() {
        return button_add_RA;
    }

    public void setButton_add_RA(Button button_add_RA) {
        this.button_add_RA = button_add_RA;
    }

    public Button getButton_add_BW() {
        return button_add_BW;
    }

    public void setButton_add_BW(Button button_add_BW) {
        this.button_add_BW = button_add_BW;
    }

    public Text getTitle() {
        return title;
    }

    public void setTitle(Text title) {
        this.title = title;
    }

    public Text getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(Text subtitle) {
        this.subtitle = subtitle;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    public AnimationTimer_improved getAnimationTimer() {
        return animationTimer;
    }

    public void setAnimationTimer(AnimationTimer_improved animationTimer) {
        this.animationTimer = animationTimer;
    }

    public Button getButton_startStop() {
        return button_startStop;
    }

    public void setButton_startStop(Button button_startStop) {
        this.button_startStop = button_startStop;
    }

    public Text getFires() {
        return fires;
    }

    public void setFires(Text fires) {
        this.fires = fires;
    }

    public Text getEnemies() {
        return enemies;
    }

    public void setEnemies(Text enemies) {
        this.enemies = enemies;
    }

}
