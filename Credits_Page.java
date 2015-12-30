   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
public class Credits_Page extends JPanel
{
private JLabel play;
private JLabel label1;
private JLabel label2;
private JLabel label3;
private JLabel label4;
private JLabel label5;
private JLabel label6;
public Credits_Page()
{
setLayout(new GridLayout ( 6, 1, 0, 30));
addLabel( label1, "This Game Was Brought To You By:");
addLabel( label2, "<html><br> David Chae</html>");
addLabel( label3, "David Liu");
addLabel( label4, "& Randy Yin");
addLabel( label5, "<html><br> Also A Special Thanks To:</html>");
addLabel( label6, "Ms. Luxenberg");

}
private void addLabel(JLabel play, String s)
{
play = new JLabel();
play.setOpaque(false);
play.setHorizontalAlignment(SwingConstants.CENTER);
play.setText(s);
play.setForeground(Color.WHITE);
play.setFont(new Font ("Arial", Font.ITALIC, 30));
add(play);
}
}