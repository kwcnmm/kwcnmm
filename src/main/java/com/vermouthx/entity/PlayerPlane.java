package com.vermouthx.entity;

import com.vermouthx.config.GameConfig;
import com.vermouthx.util.ResourceUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class PlayerPlane extends BasePlane {

    private int direction;
    private int speed;

    public PlayerPlane() {
        direction = Direction.STILL;
        speed = GameConfig.getPlayerPlaneSpeed();
        Image image;
        try {
            image = ImageIO.read(ResourceUtil.getResource(GameConfig.getPlayerImgPath()));
            setImage(image);
            setWidth(GameConfig.getPlayerPlaneStillEndX() - GameConfig.getPlayerPlaneStillStartX());
            setHeight(image.getHeight(null));
            setX((GameConfig.getWindowWidth() - getWidth()) / 2);
            setY(GameConfig.getWindowHeight() - getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void drawLeft(Graphics g, Image image) {
        g.drawImage(image, getX(), getY(), getX() + getWidth(), getY() + getHeight(), GameConfig.getPlayerPlaneLeftStartX(), 0, GameConfig.getPlayerPlaneLeftEndX(), getHeight(), null);
    }

    private void drawRight(Graphics g, Image image) {
        g.drawImage(image, getX(), getY(), getX() + getWidth(), getY() + getHeight(), GameConfig.getPlayerPlaneRightStartX(), 0, GameConfig.getPlayerPlaneRightEndX(), getHeight(), null);
    }

    private void drawLeftEdge(Graphics g, Image image) {
        g.drawImage(image, getX(), getY(), getX() + getWidth(), getY() + getHeight(), GameConfig.getPlayerPlaneLeftEdgeStartX(), 0, GameConfig.getPlayerPlaneLeftEdgeEndX(), getHeight(), null);
    }

    private void drawRightEdge(Graphics g, Image image) {
        g.drawImage(image, getX(), getY(), getX() + getWidth(), getY() + getHeight(), GameConfig.getPlayerPlaneRightEdgeStartX(), 0, GameConfig.getPlayerPlaneRightEdgeEndX(), getHeight(), null);
    }

    private void drawStill(Graphics g, Image image) {
        g.drawImage(image, getX(), getY(), getX() + getWidth(), getY() + getHeight(), GameConfig.getPlayerPlaneStillStartX(), 0, GameConfig.getPlayerPlaneStillEndX(), getHeight(), null);
    }

    @Override
    public void draw(Graphics g) {
        Image image = getImage();
        switch (direction) {
            case Direction.LEFT:
                if (getX() != 0)
                    drawLeft(g, image);
                else
                    drawLeftEdge(g, image);
                break;
            case Direction.RIGHT:
                if (getX() != GameConfig.getWindowWidth() - getWidth())
                    drawRight(g, image);
                else
                    drawRightEdge(g, image);
                break;
            default:
                if (getX() == 0)
                    drawLeftEdge(g, image);
                else if (getX() == GameConfig.getWindowWidth() - getWidth())
                    drawRightEdge(g, image);
                else
                    drawStill(g, image);
                break;
        }
    }

    @Override
    public void move(int direction) {
        switch (direction) {
            case Direction.UP:
                this.direction = Direction.UP;
                setY(getY() - speed);
                break;
            case Direction.DOWN:
                this.direction = Direction.DOWN;
                setY(getY() + speed);
                break;
            case Direction.LEFT:
                this.direction = Direction.LEFT;
                setX(getX() - speed);
                break;
            case Direction.RIGHT:
                this.direction = Direction.RIGHT;
                setX(getX() + speed);
                break;
            case Direction.STILL:
                this.direction = Direction.STILL;
                break;
        }
    }
}
