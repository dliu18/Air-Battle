   import javax.swing.JOptionPane;
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.BufferedImage;

public class GameOverScreen extends JPanel
{
      private BufferedImage myImage;
      private Graphics myBuffer;
		private ImageIcon Background;
public GameOverScreen()
{
 myImage =  new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.getGraphics();
         Background = new ImageIcon("images/GameOver.jpg");
         myBuffer.drawImage(Background.getImage(), 0, 0, 800, 600, null);

}

public void paintComponent(Graphics g)
      {
         g.drawImage(myImage, 0, 0, 800, 600, null);
      }

}