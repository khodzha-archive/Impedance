import javax.swing.*;

class ElementsList extends JList
{
  public ElementsList()
  {
    FrameButton PowerSupplyButton = new FrameButton("Power Supply");
    PowerSupplyButton.setActionCommand("power");
    this.add(PowerSupplyButton);
    FrameButton InductanceButton = new FrameButton("Inductance");
    InductanceButton.setActionCommand("inductance");
    this.add(InductanceButton);
    FrameButton CapacityButton = new FrameButton("Capacity");
    CapacityButton.setActionCommand("capacity");
    this.add(CapacityButton);
  }
}