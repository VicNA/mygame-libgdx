package ru.geekbrains.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private MyAnimation stand, run, tmpA;
	private MyAnimation animation;
	private Music music;
	private Sound sound;
	MyInputProcessor myInputProcessor;

	private float x,y;
	int dir = 0, step =1;

	@Override
	public void create() {
//		myInputProcessor = new MyInputProcessor();
//		Gdx.input.setInputProcessor(myInputProcessor);

		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setVolume(0.05f);
		music.setLooping(true);
		music.play();

		sound = Gdx.audio.newSound(Gdx.files.internal("sound.mp3"));

		batch = new SpriteBatch();
//		stand = new MyAnimation("images/unnamed.atlas", "stand", 20, Animation.PlayMode.LOOP);
//		run = new MyAnimation("images/unnamed.atlas", "run", 5, Animation.PlayMode.LOOP);
//		tmpA = stand;
		animation = new MyAnimation("images/unnamed.atlas");
	}

	@Override
	public void render() {
		ScreenUtils.clear(1, 1, 1, 1);

		tmpA = stand;
		dir = 0;

		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			sound.play(1, 1, 0);
		}


//		animation.setTime(Gdx.graphics.getDeltaTime());

		batch.begin();
		batch.draw(animation.draw(Gdx.graphics.getDeltaTime()), animation.getX(), animation.getY());
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
//		stand.dispose();
//		run.dispose();
		animation.dispose();
		music.dispose();
		sound.dispose();
	}
}
