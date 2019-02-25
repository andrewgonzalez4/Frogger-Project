package Display;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Created by AlexVR on 7/1/2018.
 */

public class DisplayScreen {

    private JFrame frame;
    private Canvas canvas;
    

    private URL iconURL;

    private String title;
    private int width, height;
    private Font messageFont;
    private static JLabel message;

    public DisplayScreen(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }

    public void setBackgroundColor(Color backgroundColor) {
		canvas.setBackground(backgroundColor);
    }
    
    private void createDisplay() {
    	try {
			messageFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("res/Fonts/aerial.ttf"))).deriveFont(Font.PLAIN, 14);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	message = new JLabel("It's Frogger Time!");
    	message.setFont(messageFont);
    	
    	
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setBackground(Color.black);
        frame.add(message, BorderLayout.SOUTH);

        try {
            frame.setIconImage(ImageIO.read(new File("res/Sheets/froggy.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);
        canvas.setBackground(Color.black);

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas(){
        return canvas;
    }

    public JFrame getFrame(){
        return frame;
    }

    public static void setMessage(String text) {
		message.setText(text);
	}
    public static void enableMessage() {
    	message.setVisible(true);
    }
    public static void disableMessage() {
    	message.setVisible(false);;
    }
}
