   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.BufferedImage;
    public class PanelBackground extends JPanel
   {
      private Timer r;
      private Timer s;
      private Graphics myBuffer;
      private BufferedImage myImage;
   
       public PanelBackground()
      {
         myImage =  new BufferedImage(800, 6000, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.getGraphics();
      
      //background
         myBuffer.setColor(new Color(91, 147, 36));
         myBuffer.fillRect(0, 0, 800, 6000);
      //dirt field
         myBuffer.setColor(new Color(139, 41, 24));
         myBuffer.fillRect(0, 0, 120, 6000);
      //wheat field
         myBuffer.setColor(new Color(234, 193, 53));
         myBuffer.fillRect(550, 0, 300, 6000);
      //dirt for wheat field
         myBuffer.setColor(new Color(132, 71, 51));
         myBuffer.fillRect(540, 0, 10, 6000);
      //fence on left
         for(int a = 0; a <= 6000; a += 10)
         {
            myBuffer.setColor(new Color(163, 49, 29));
            myBuffer.fillRect(123, a, 5, 5);
         }
         myBuffer.setColor(new Color(163, 49, 29));
         myBuffer.drawLine(125, 0, 125, 6000);
      //fence on right
         for(int a = 0; a <= 6000; a += 10)
         {
            myBuffer.setColor(new Color(163, 49, 29));
            myBuffer.fillRect(530, a, 5, 5);
         }
         myBuffer.setColor(new Color(163, 49, 29));
         myBuffer.drawLine(532, 0, 532, 6000);
      //fence in middle, top for cows
         for(int a = 130; a <= 530; a += 10)
         {
            myBuffer.setColor(new Color(163, 49, 29));
            myBuffer.fillRect(a, 4000, 5, 5);
         }
         myBuffer.setColor(new Color(163, 49, 29));
         myBuffer.drawLine(123, 4002, 533, 4002);
      //fence in middle, bottom for cows
         for(int a = 130; a <= 530; a += 10)
         {
            myBuffer.setColor(new Color(163, 49, 29));
            myBuffer.fillRect(a, 2000, 5, 5);
         }
         myBuffer.setColor(new Color(163, 49, 29));
         myBuffer.drawLine(123, 2002, 533, 2002);
      //field rows(lines)
         for(int c = 0; c <= 119; c += 20)
         {
            myBuffer.setColor(Color.BLACK);
            myBuffer.drawLine(c, 0, c, 6000);
         }
      //crops on left
         for(int d = 0; d <= 6000; d += 20)
         {
            for(int e = 5; e <= 115; e +=20)
            {
               myBuffer.setColor(new Color(0, 164, 37));
               myBuffer.fillOval(e, d, 10, 10);
            }
         }
      //crops on right
         for(int f = 550; f <= 800; f += 8)
         {
            for(int i = 0; i <= 6000; i += 10)
            {
               myBuffer.setColor(Color.BLACK);
               myBuffer.drawRect(f, i, 5, 10);
            
               myBuffer.setColor(Color.GREEN.darker());
               myBuffer.fillRect(f, i+7, 5, 3);
            }
         }
         for(int x = 1; x <= 320; x++)
         {
            ImageIcon Background = new ImageIcon("images/cow1.png"); 
            myBuffer.drawImage(Background.getImage(), (int)( Math.random()*401 + 130), (int)(Math.random() * 18001 + 200), 25, 25, null);
         
         }
         for(int x = 1; x <= 320; x++)
         {
            ImageIcon Background = new ImageIcon("images/cow2.png"); 
            myBuffer.drawImage(Background.getImage(), (int)(Math.random()*401 + 130), (int)( Math.random() * 18001 + 2200), 25, 25, null);
         
         }
         for(int x = 1; x <= 320; x++)
         {
            ImageIcon Background = new ImageIcon("images/cow3.png"); 
            myBuffer.drawImage(Background.getImage(),(int)( Math.random()*401 + 130),(int)( Math.random() * 18001 + 4200), 25, 25, null);
         
         }
      }
      public void draw(int count, Graphics g)
   	{
   	g.drawImage(myImage, 0, (int)(-5200 + (.25 * count)), 800, 6000, null);
   	}
   }