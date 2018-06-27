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
package cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.Scene;
import model.Bullet;
import model.Entity;
import model.Mob;
import model.Player;

/**
 *
 * @author gruber
 */
public class Cache {

    private static Scene scene;
    private static final Map<String, Entity> cache_entity = new HashMap<>();
    private static ArrayList<Mob> mobs = new ArrayList();
    private static ArrayList<Bullet> bullets = new ArrayList();
    private static Player player = new Player();

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        Cache.scene = scene;
    }

    public static Entity putEntity(String key, Entity entity) {
        cache_entity.put(key, entity);
        return entity;
    }

    public static Entity getEntity(String key) {
        return cache_entity.get(key);
    }

    public static ArrayList<Mob> getMobs() {
        return mobs;
    }

    public static void setMobs(ArrayList<Mob> mobs) {
        Cache.mobs = mobs;
    }

    public static ArrayList<Bullet> getBullets() {
        return bullets;
    }

    public static void setBullets(ArrayList<Bullet> bullets) {
        Cache.bullets = bullets;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Cache.player = player;
    }

}
