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
public interface Entity {

    public Entity clone();

    public void setNextPosition(double start_x, double start_y,
            double end_x, double end_y);

    public Image getSprite();

    public double getPosition_x();

    public void setPosition_x(double x);

    public double getPosition_y();

    public void setPosition_y(double y);

    public boolean isActive();

}
