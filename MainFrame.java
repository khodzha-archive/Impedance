import javax.swing.*;
import java.awt.*;

class MainFrame extends JFrame
{
  public MainFrame()
  {
    super("Impedance Calculator");
    FrameButton CalculateButton = new FrameButton("Calculate");
    ElementsPanel elementPanel = new ElementsPanel();

    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);

    JPanel buttonsPanel = new JPanel(new FlowLayout());
    buttonsPanel.add(CalculateButton);
    add(buttonsPanel, BorderLayout.SOUTH);

    CalculateButton.setVerticalTextPosition(AbstractButton.CENTER);
    CalculateButton.setHorizontalTextPosition(AbstractButton.LEADING);
    CalculateButton.setActionCommand("calculate");

    add(elementPanel, BorderLayout.NORTH);

    DrawPanel drawPanel = new DrawPanel();
    add(drawPanel, BorderLayout.CENTER);
  }

  public static void DisableButtons()
  {
    CalculateButton.setText("Click where to place contacts of the element");
    PowerSupplyButton.setEnabled(false);
    ResistanceButton.setEnabled(false);
    CapacityButton.setEnabled(false);
    CalculateButton.setEnabled(false);
    InductanceButton.setEnabled(false);
  }
  static final int DEFAULT_WIDTH = 640;
  static final int DEFAULT_HEIGHT = 480;
}