import javax.swing.*;

class ElementsPanel extends JPanel
{
  public ElementsPanel(MainFrame frame)
  {
    ElementsList list = new ElementsList();
    this.add(list);
    frame.getContentPane().add(this);
  }
}