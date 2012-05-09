class Capacity extends Element
{
  public Capacity()
  {
    String str = JOptionPane.showInputDialog("Enter capacity value");
    NumberFormat fmt = NumberFormat.getInstance();
    Number num = fmt.parse(str);
    double capacity = num.doubleValue();
  }

  private double capacity;
}