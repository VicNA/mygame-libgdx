package ru.geekbrains.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.stream.Stream;

public class MyAnimation {

    private Texture img;
    private Animation<TextureRegion> animation;
    private float time;

    public MyAnimation(String name, int row, int col, float frameDuration, Animation.PlayMode playMode) {
        time = 0;
        img = new Texture(name);
        TextureRegion[][] regions = new TextureRegion(img).split(
                img.getWidth() / col,
                img.getHeight() / row);

        TextureRegion[] frames = new TextureRegion[row * col];
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                frames[index++] = regions[i][j];
            }
        }
        animation = new Animation<>(frameDuration, frames);
        animation.setPlayMode(playMode);
    }

    public void setTime(float deltaTime) {
        time++;
    }

    public TextureRegion draw() {
        return animation.getKeyFrame(time);
    }

    public void dispose() {
        img.dispose();
    }
}
