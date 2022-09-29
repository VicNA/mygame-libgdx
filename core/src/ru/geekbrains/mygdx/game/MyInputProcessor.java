package ru.geekbrains.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class MyInputProcessor implements InputProcessor {
    private MyAnimation hero;

    public MyInputProcessor(MyAnimation hero) {
        this.hero = hero;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Keys.LEFT:
                hero.setLeftMove(true);
                break;
            case Keys.RIGHT:
                hero.setRightMove(true);
                break;
            case Keys.UP:
                hero.setUpMove(true);
                break;
            case Keys.DOWN:
                hero.setDownMove(true);
                break;
        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Keys.LEFT:
                hero.setLeftMove(false);
                break;
            case Keys.RIGHT:
                hero.setRightMove(false);
                break;
            case Keys.UP:
                hero.setUpMove(false);
                break;
            case Keys.DOWN:
                hero.setDownMove(false);
                break;
        }

        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
