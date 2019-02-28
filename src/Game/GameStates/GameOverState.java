package Game.GameStates;

import java.awt.Color;
import java.awt.Graphics;

import Display.DisplayScreen;
import Main.Handler;
import Resources.Images;
import UI.UIImageButton;
import UI.UIManager;

public class GameOverState extends State {

    private UIManager uiManager;

    public GameOverState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);

        uiManager.addObjects(new UIImageButton(33, handler.getGame().getHeight() - 150, 128, 64, Images.Yes, () -> {
        	handler.getWorld().player.checkScore();
        	handler.getGame().musicHandler.play();
			handler.getGame().getDisplay().setBackgroundColor(Color.gray);
			State.setState(handler.getGame().menuState);
			DisplayScreen.setMessage("It's Frogger Time!");
        }));

        uiManager.addObjects(new UIImageButton(33 + 192*2, handler.getGame().getHeight() - 150, 128, 64, Images.No, () -> {
            handler.getMouseManager().setUimanager(null);
            handler.getWorld().player.checkScore();
        }));
    }

    @Override
    public void tick() {
        handler.getMouseManager().setUimanager(uiManager);
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Images.gameOver,0,0,576,768,null);
        uiManager.Render(g);
    }
}