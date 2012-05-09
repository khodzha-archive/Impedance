import javax.swing.*;
import java.awt.*;

class MainFrame extends JFrame
{
  public MainFrame()
  {
    super("Impedance Calculator");
    FrameButton CalculateButton = new FrameButton("Calculate");
    ElementsPanel elementPanel = new ElementsPanel(/*this*/);

    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);

    JPanel buttonsPanel = new JPanel(new FlowLayout());
    buttonsPanel.add(CalculateButton);
    add(buttonsPanel, BorderLayout.SOUTH);

    CalculateButton.setVerticalTextPosition(AbstractButton.CENTER);
    CalculateButton.setHorizontalTextPosition(AbstractButton.LEADING);
    CalculateButton.setActionCommand("calculate");

    add(elementPanel, BorderLayout.EAST);
  }
 
  static final int DEFAULT_WIDTH = 640;
  static final int DEFAULT_HEIGHT = 480;
}