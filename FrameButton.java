import java.awt.event.*;
import javax.swing.*;

class FrameButton extends JButton
{
  public FrameButton(String title)
  {
    this.setText(title);
    this.addActionListener(frame);
  }
}