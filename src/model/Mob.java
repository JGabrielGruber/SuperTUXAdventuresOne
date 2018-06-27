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
package model;

import javafx.scene.image.Image;

/**
 *
 * @author gruber
 */
public class Mob implements Entity {

    private boolean active, up = true;
    private Image sprite;
    private double position_x, position_y;

    public Mob() {
    }

    public Mob(boolean active, Image sprite, double position_x, double position_y) {
        this.active = active;
        this.sprite = sprite;
        this.position_x = position_x;
        this.position_y = position_y;
    }

    public Mob(Mob target) {
        if (target != null) {
            this.active = target.active;
            this.up = target.up;
            this.sprite = target.sprite;
            this.position_x = target.position_x;
            this.position_y = target.position_y;
        }
    }

    @Override
    public void setNextPosition(double start_x, double start_y,
            double end_x, double end_y) {
        if (position_x >= start_x) {
            position_x--;
        } else {
            position_x = end_x;
        }

        if (up) {
            position_y--;
        } else {
            position_y++;
        }

        if (position_y == start_y) {
            up = false;
        } else if (position_y == end_y) {
            up = true;
        }

    }

    @Override
    public Image getSprite() {
        return sprite;
    }

    @Override
    public double getPosition_x() {
        return position_x;
    }

    @Override
    public double getPosition_y() {
        return position_y;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setPosition_x(double x) {
        this.position_x = x;
    }

    @Override
    public void setPosition_y(double y) {
        this.position_y = y;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    @Override
    public Mob clone() {
        return new Mob(this);
    }
}
