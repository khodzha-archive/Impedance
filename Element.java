import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Element implements MouseListener
{
  
  public Element()
  {
    this.first_contact_connections = new ArrayList<Element>();
    this.second_contact_connections = new ArrayList<Element>();
  }
  public void Draw(Graphics g)
  {
  }
  
  public void mousePressed(MouseEvent e)
  {
    if(first_x == 0 && first_y == 0)
    {
      this.first_x = e.getX();
      this.first_y = e.getY();
    }
    else
    {
        this.second_x = e.getX();
        this.second_y = e.getY();
    }
  }
  
  public int getfirstX() { return this.first_x; }
  public int getfirstY() { return this.first_y; }
  public int getsecondX() { return this.second_x; }
  public int getsecondY() { return this.second_y; }
  
  public void swapContacts()
  {
    int t = this.first_x;
    this.first_x = this.second_x;
    this.second_x = t;
    t = this.first_y;
    this.first_y = this.second_y;
    this.second_y = t;
    
    ArrayList<Element> tmpList = new ArrayList<Element>(first_contact_connections);
    first_contact_connections.clear();
    first_contact_connections.addAll(second_contact_connections);
    second_contact_connections.clear();
    second_contact_connections.addAll(tmpList);
  }
  
  public void setfirstX(int c) { this.first_x = c; }
  public void setfirstY(int c) { this.first_y = c; }
  public void setsecondX(int c) { this.second_x = c; }
  public void setsecondY(int c) { this.second_y = c; }
  
  public boolean getfirstContact() { return first_contact_connected; }
  public boolean getsecondContact() { return second_contact_connected; }
  public void setfirstContact(boolean flag) { first_contact_connected = flag;}
  public void setsecondContact(boolean flag) { second_contact_connected = flag;}
  
  public void setImpedance(Complex num) { this.impedance = num;}
  public Complex getImpedance() { return this.impedance; }
  
  public void addNewConnection(Element elem, String contact)
  {
    if(contact.equals("first"))
    {
      first_contact_connections.add(elem);
    }
    else if(contact.equals("second"))
    {
      second_contact_connections.add(elem);
    }
  }
  
  public ArrayList<Element> getConnections(String side)
  {
    if(side.equals("first"))
    {
      return this.first_contact_connections;
    }
    else
    {
       return this.second_contact_connections;
    }
  }
  
  public void copyConnections(Element source)
  {
    this.getConnections("right").clear();
    this.getConnections("right").addAll(source.getConnections("right"));
  }
  
  public void mouseExited(MouseEvent e) {}
  public void mouseClicked(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}

  public boolean isPlaced()
  {
    if (this.first_x != 0 && this.first_y !=0 && this.second_x !=0 && this.second_y !=0 )
      return true;
    else return false;
  }
  
  private int first_x, first_y;
  private int second_x, second_y;
  private boolean first_contact_connected = false;
  private boolean second_contact_connected = false;
  protected Complex impedance;
  private ArrayList<Element> first_contact_connections;
  private ArrayList<Element> second_contact_connections;
}