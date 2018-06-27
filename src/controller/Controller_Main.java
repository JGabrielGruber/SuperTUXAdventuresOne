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
package controller;

import cache.Cache;
import component.AnimationTimer_improved;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import model.Bullet;
import model.Mob;
import model.Player;
import view.View_Main;

/**
 *
 * @author gruber
 */
public class Controller_Main {

    public Controller_Main() {
    }

    public static void main(String[] args) {

        View_Main view_Main = new View_Main();
        Cache cache = new Cache();

        Cache.putEntity("Player", new Player(
                true,
                new Image("https://img.webme.com/pic/m/mybakuman/1-tux-7.png",
                        80, 80, true, true, true),
                100,
                350)
        );

        Cache.putEntity("Rotten Apple", new Mob(
                true,
                new Image(
                        "https://vignette2.wikia.nocookie.net/play-rust/images/b/bf/"
                        + "Rotten_Apple_icon.png/revision/latest?cb=20151106060901",
                        80, 80, true, true, true),
                1271,
                350
        ));

        Cache.putEntity("Broken Windows", new Mob(
                true,
                new Image("https://sites.google.com/site/"
                        + "sketchupsage/_/rsrc/1431242036735/problems/pc-install/"
                        + "broken-window.png?height=331&width=420",
                        80, 80, true, true, true),
                1271,
                350
        ));

        Cache.putEntity("Free", new Bullet(
                true,
                new Image("https://cdn0.iconfinder.com/data/icons/"
                        + "seo-smart-pack/128/grey_new_seo2-49-512.png",
                        80, 80, true, true, true),
                100,
                350
        ));

        Cache.setPlayer((Player) Cache.getEntity("Player").clone());

        Cache.getScene().setRoot(view_Main.getContent());

        view_Main.getButton_add_BW().setOnAction((event) -> {
            Cache.getMobs().add((Mob) Cache.getEntity("Broken Windows").clone());
        });

        view_Main.getButton_add_RA().setOnAction((event) -> {
            Cache.getMobs().add((Mob) Cache.getEntity("Rotten Apple").clone());
        });

        view_Main.getButton_startStop().setOnAction((event) -> {
            boolean status = view_Main.getAnimationTimer().isActive();
            if (status) {
                view_Main.getAnimationTimer().stop();
            } else {
                view_Main.getAnimationTimer().start();
            }
        });

        view_Main.getButton_fire().setOnAction((event) -> {
            if (Cache.getBullets().size() > 0
                    && !Cache.getBullets().get(Cache.getBullets().size() - 1).isActive()) {
                Bullet bullet = (Bullet) Cache.getEntity("Free");
                Cache.getPlayer().shoot(bullet);
                Cache.getBullets().add(bullet.clone());
            } else if (Cache.getBullets().isEmpty()) {
                Bullet bullet = (Bullet) Cache.getEntity("Free");
                Cache.getPlayer().shoot(bullet);
                Cache.getBullets().add(bullet.clone());
            }
        });

        view_Main.setAnimationTimer(new AnimationTimer_improved() {

            @Override
            public void handle(long currentNanoTime) {

                view_Main.total_enemies = 0;
                view_Main.total_bullets = 0;

                view_Main.getGraphicsContext().setFill(Color.LIGHTSTEELBLUE);
                view_Main.getGraphicsContext().fillRect(0, 0, 1270, 430);
                view_Main.getGraphicsContext().setFill(Color.TAN);
                view_Main.getGraphicsContext().fillRect(0, 420, 1270, 500);

                Cache.getBullets().forEach((bullet) -> {
                    view_Main.total_bullets++;
                    if (bullet.isActive()) {
                        view_Main.getGraphicsContext().drawImage(
                                bullet.getSprite(),
                                bullet.getPosition_x(),
                                bullet.getPosition_y()
                        );
                        bullet.setNextPosition(0, 0, 1275, 0);
                    }
                });

                view_Main.getFires().setText(" Total fires: " + view_Main.total_bullets);

                Cache.getMobs().forEach((mob) -> {
                    if (!Cache.getBullets().isEmpty()) {
                        Bullet bullet = Cache.getBullets().get(Cache.getBullets().size() - 1);
                        if (bullet.isActive() && mob.isActive()
                                && mob.getPosition_y() >= 270
                                && mob.getPosition_x() == bullet.getPosition_x()) {
                            mob.setActive(false);
                            bullet.setActive(false);
                        }
                    }
                    if (mob.isActive()) {
                        view_Main.total_enemies++;

                        view_Main.getGraphicsContext().drawImage(
                                mob.getSprite(),
                                mob.getPosition_x(),
                                mob.getPosition_y()
                        );

                        mob.setNextPosition(-10, 250, 1275, 350);
                    }
                });

                view_Main.getEnemies().setText(" Total enemies: " + view_Main.total_enemies);

                view_Main.getGraphicsContext().drawImage(
                        Cache.getPlayer().getSprite(),
                        Cache.getPlayer().getPosition_x(),
                        Cache.getPlayer().getPosition_y()
                );

            }
        });
    }

}
