   import javax.swing.JFrame;
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
	             
	//David Liu, Randy yin & David Chae
    public class DriverGame 
   {
      private static GamePanel panel;
      private static JFrame frame; 
      private static boolean instantiate = false;
   
       public static void main(String[] args) throws Exception
      { 
         frame = new JFrame("Air Battle - The Game");
         frame.setSize(800, 600);
         frame.setLocation(5, 50);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new GamePanel());
         frame.setVisible(true);
      
      
      }
   
   }