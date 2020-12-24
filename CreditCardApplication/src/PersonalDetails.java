import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

class PersonalDetails extends JFrame implements ActionListener
{
    JTable t1;
    JButton b1;
    String[] x = new String[]{"User Name", "Father's Name", "Email", "Address", "City", "Card Application Form No"};
    String[][] y = new String[1][6];
    int i = 0;
    int j = 0;

    PersonalDetails()
    {
        super("Personal Details");
        this.setSize(1535, 100);
        this.setLocation(0, 400);
        String Formno = JOptionPane.showInputDialog("Enter Form Number");

        try {
            Conn c1 = new Conn();

            for(ResultSet rs = c1.s.executeQuery("SELECT * FROM signup1 where formno = '" + Formno + "'"); rs.next(); this.j = 0) {
                this.y[this.i][this.j++] = rs.getString("Name");
                this.y[this.i][this.j++] = rs.getString("FName");
                this.y[this.i][this.j++] = rs.getString("Email");
                this.y[this.i][this.j++] = rs.getString("Address");
                this.y[this.i][this.j++] = rs.getString("City");
                this.y[this.i][this.j++] = rs.getString("FORMNO");
                ++this.i;
            }

            this.t1 = new JTable(this.y, this.x);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        ImageIcon imageIcon = new ImageIcon("secure-payment.jpg"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(1000, 1000,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        setIconImage(newimg);

        this.b1 = new JButton("Print");
        this.add(this.b1, "South");
        JScrollPane sp = new JScrollPane(this.t1);
        this.add(sp);
        this.b1.addActionListener(this);
        new Services().setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            this.t1.print();
        } catch (Exception var3) {
        }

    }

    public static void main(String[] args)
    {
        (new PersonalDetails()).setVisible(true);


    }
}
