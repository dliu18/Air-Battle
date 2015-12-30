   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
public class Instructions_Page extends JPanel
{
private JLabel play;
private JLabel label1;
private JLabel label2;
private JLabel label3;
private JLabel label4;
private JLabel label5;

public Instructions_Page()
{
setLayout(new GridLayout (7, 1, 0, 20));
addLabel(label1, "Air Battle is a very simple single player airplane");
addLabel(label2, "shooting game.  The objective of the game is to protect");
addLabel(label3, "your military base from incoming enemy planes.");
addLabel(label4, "and fire with the Space bar.");
addLabel(label5, "How many levels can you beat?");
}
private void addLabel(JLabel play, String s)
{
play = new JLabel();
play.setOpaque(false);
play.setHorizontalAlignment(SwingConstants.CENTER);
play.setText(s);
play.setForeground(Color.WHITE);
play.setFont(new Font ("SansSerif", Font.PLAIN, 30));
add(play);
}
}
