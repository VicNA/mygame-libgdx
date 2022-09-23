package ru.geekbrains.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	MyAnimation anim;
//	Texture coinImg;

	@Override
	public void create() {
		batch = new SpriteBatch();
//        img = new Texture("badlogic.jpg");
//		coinImg = new Texture("Full Coinss.png");
		anim = new MyAnimation("explosion.png", 4, 8, 1f, Animation.PlayMode.LOOP);

	}

	@Override
	public void render() {
		ScreenUtils.clear(1, 1, 1, 1);

		anim.setTime(Gdx.graphics.getDeltaTime());

		float x = Gdx.input.getX() - anim.draw().getRegionWidth() / 2;
		float y = Gdx.graphics.getHeight() - (Gdx.input.getY() + anim.draw().getRegionHeight() / 2);

		batch.begin();
		batch.draw(anim.draw(), x, y);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
//        img.dispose();
//		coinImg.dispose();
		anim.dispose();
	}
}
