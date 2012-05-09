class PowerSupply extends Element
{
  public PowerSupply()
  {
    String str = JOptionPane.showInputDialog("Enter maximum voltage");
    NumberFormat fmt = NumberFormat.getInstance();
    Number num = fmt.parse(str);
    double voltage_max = num.doubleValue();
    String str = JOptionPane.showInputDialog("Enter frequency");
    NumberFormat fmt = NumberFormat.getInstance();
    Number num = fmt.parse(str);
    double frequency = num.doubleValue();
  }

  private double voltage_max;
  private double frequency;
}