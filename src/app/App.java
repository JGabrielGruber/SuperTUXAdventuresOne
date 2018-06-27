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
package app;

import cache.Cache;
import controller.Controller_Main;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author gruber
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Super TUX Adventures");
        stage.setScene(Cache.getScene());
        stage.setWidth(1260);
        stage.setHeight(700);
        stage.getIcons().add(new Image("https://orig05.deviantart.net/0488/f/2010/236/2/c/supertux_dock_icon_by_sarrel.png"));
        stage.show();
    }

    public static void main(String... args) {

        Thread thread = new Thread(() -> {
            Controller_Main controller_Main = new Controller_Main();
            Controller_Main.main(args);
        });
        Cache.setScene(new Scene(new GridPane()));

        thread.start();

        launch(args);
    }

}
