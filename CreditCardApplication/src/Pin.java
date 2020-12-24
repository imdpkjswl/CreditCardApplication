import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Objects;
import javax.swing.*;

public class Pin extends JFrame implements ActionListener
{
    JPasswordField t1;
    JPasswordField t2;
    JPasswordField t3;
    JButton b1;
    JButton b2;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;

    Pin() {
        this.setFont(new Font("System", 1, 22));
        Font f = this.getFont();
        FontMetrics fm = this.getFontMetrics(f);
        int x = fm.stringWidth("PIN CHANGE");
        int y = fm.stringWidth(" ");
        int z = this.getWidth() - 4 * x - 50;
        int w = z / y;
        String pad = "";
        pad = String.format("%" + w + "s", pad);
        this.setTitle(pad + "PIN CHANGE");

        this.l1 = new JLabel("CHANGE YOUR PIN");
        this.l1.setFont(new Font("System", 1, 38));
        this.l1.setForeground(Color.WHITE);


        this.l2 = new JLabel("Current PIN:");
        this.l2.setFont(new Font("System", 1, 22));
        this.l2.setForeground(Color.WHITE);


        this.l3 = new JLabel("New PIN:");
        this.l3.setFont(new Font("System", 1, 22));
        this.l3.setForeground(Color.WHITE);


        this.l4 = new JLabel("Re-Enter New PIN:");
        this.l4.setFont(new Font("System", 1, 22));
        this.l4.setForeground(Color.WHITE);


        this.t1 = new JPasswordField();
        this.t1.setFont(new Font("System", 1, 22));
        this.t2 = new JPasswordField();
        this.t2.setFont(new Font("System", 1, 22));
        this.t3 = new JPasswordField();
        this.t3.setFont(new Font("System", 1, 22));
        this.b1 = new JButton("SAVE");
        this.b1.setFont(new Font("System", 1, 18));
        this.b1.setBackground(Color.WHITE);
        this.b1.setForeground(Color.BLACK);
        this.b2 = new JButton("BACK");
        this.b2.setFont(new Font("System", 1, 18));
        this.b2.setBackground(Color.WHITE);
        this.b2.setForeground(Color.BLACK);
        this.b1.addActionListener(this);
        this.b2.addActionListener(this);

        try {
            final Image backgroundImage = javax.imageio.ImageIO.read(new File("C:\\Users\\DEEPAK JAISWAL\\Desktop\\MiniProject\\CreditCardApplication\\3.jpg"));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, null);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        this.setLayout((LayoutManager)null);
        this.l1.setBounds(350, 40, 800, 30);
        this.add(this.l1);
        this.l2.setBounds(90, 120, 150, 30);
        this.add(this.l2);
        this.l3.setBounds(90, 180, 180, 30);
        this.add(this.l3);
        this.l4.setBounds(90, 240, 250, 30);
        this.add(this.l4);
        this.t1.setBounds(350, 120, 360, 30);
        this.add(this.t1);
        this.t2.setBounds(350, 180, 360, 30);
        this.add(this.t2);
        this.t3.setBounds(350, 240, 360, 30);
        this.add(this.t3);
        this.b1.setBounds(350, 300, 160, 30);
        this.add(this.b1);
        this.b2.setBounds(550, 300, 160, 30);
        this.add(this.b2);
        //this.getContentPane().setBackground(Color.ORANGE);

        ImageIcon imageIcon = new ImageIcon("secure-payment.jpg"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(1000, 1000,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        setIconImage(newimg);

        this.setSize(800, 500);
        this.setLocation(400, 40);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String temp = " ";
            String a = this.t1.getText();
            String b = this.t2.getText();
            String c = this.t3.getText();
            if (ae.getSource() == this.b1) {
                if (this.t1.getText().equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "Please Enter Current PIN");
                }

                if (this.t2.getText().equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "Enter New PIN");
                }

                if (this.t3.getText().equals("")) {
                    JOptionPane.showMessageDialog((Component)null, "Re-Enter New PIN");
                }

                if (this.t2.getText().equals(this.t3.getText())) {
                    Conn c1 = new Conn();

                    String q3 = "SELECT * FROM signup3 where pin = '"+a+"' ";
                    ResultSet resultSet = c1.s.executeQuery(q3);

                    while(resultSet.next())
                    {
                        temp = resultSet.getString("pin");
                    }

                    if(temp.equals(a))
                    {
                        String q1 = "update login set pin = '" + b + "' where pin = '" + a + "' ";
                        String q2 = "update signup3 set pin = '" + b + "' where pin = '" + a + "' ";
                        c1.s.executeUpdate(q1);
                        c1.s.executeUpdate(q2);
                        JOptionPane.showMessageDialog((Component)null, "PIN Changed Successfully");
                        (new Services()).setVisible(true);
                        this.setVisible(false);
                    }

                    else {
                        JOptionPane.showMessageDialog((Component)null, "PIN Entered Doesn't Match");
                    }
                }
            } else if (ae.getSource() == this.b2) {
                (new Services()).setVisible(true);
                this.setVisible(false);
            }
        } catch (Exception var9) {
            var9.printStackTrace();
            System.out.println("Error: " + var9);
        }

    }

    public static void main(String[] args) {
        (new Pin()).setVisible(true);
    }
}
