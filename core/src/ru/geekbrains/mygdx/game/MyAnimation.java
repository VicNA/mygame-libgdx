package ru.geekbrains.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyAnimation {

    static final int RUN = 1;
    static final int JUMP = 2;
    static final int STAND = 3;

    static final int LEFT = -1;
    static final int RIGHT = 1;

    private int state = STAND;
    private int dir = LEFT;

    private float x;
    private float y;

    private TextureAtlas atlas;
    private Animation<TextureAtlas.AtlasRegion> animRun;
    private Animation<TextureAtlas.AtlasRegion> animStand;
    private Animation<TextureAtlas.AtlasRegion> currentAnim;
    private MyInputProcessor inputProcessor;
    private float time;

    public MyAnimation(String fileAtlas) {
        time = 0;

        inputProcessor = new MyInputProcessor(this);
        Gdx.input.setInputProcessor(inputProcessor);

        atlas = new TextureAtlas(Gdx.files.internal(fileAtlas));
        animRun = new Animation<>(5, atlas.findRegion("run"));
        animStand = new Animation<>(20, atlas.findRegion("stand"));

        animRun.setPlayMode(Animation.PlayMode.LOOP);
        animStand.setPlayMode(Animation.PlayMode.LOOP);
    }

    public void setLeftMove(boolean bool ) {
        if (state != JUMP && bool) state = RUN;
        dir = LEFT;
    }

    public void setRightMove(boolean bool) {
        if (state != JUMP && bool) state = RUN;
        dir = RIGHT;
    }

    public void setUpMove(boolean bool ) {
        if (state == JUMP && bool) state = STAND;
    }

    public void setDownMove(boolean bool) {
        if (state == JUMP && bool) state = STAND;
    }

    private void updateMotion() {
        currentAnim = state == RUN ? animRun : animStand;
        x = dir;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }


    public void setTime(float deltaTime) {
        time++;
    }

    public TextureRegion draw(float deltaTime) {
        updateMotion();

        return currentAnim.getKeyFrame(deltaTime);
    }

    public void dispose() {
        atlas.dispose();
    }
}
