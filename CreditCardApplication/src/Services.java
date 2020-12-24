import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Services extends JFrame implements ActionListener{

    JLabel l1;
    JButton b4,b5,b6,b7,b8;

    Services(){

        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("SERVICES AVAILABLE");
        int y = fm.stringWidth(" ");
        int z = getWidth() - 2*x - 100 ;
        int w = z/y;
        String pad ="";
        //for (int i=0; i!=w; i++) pad +=" ";
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"SERVICES AVAILABLE");

        l1 = new JLabel("Please Select Your Desired Service Option");
        l1.setFont(new Font("System", Font.BOLD, 34));
        l1.setForeground(Color.WHITE);

        b4 = new JButton("CARD TYPE");
        b4.setFont(new Font("System", Font.BOLD, 14));
        b4.setBackground(Color.WHITE);
        b4.setForeground(Color.BLACK);


        b5 = new JButton("PIN CHANGE");
        b5.setFont(new Font("System", Font.BOLD, 14));
        b5.setBackground(Color.WHITE);
        b5.setForeground(Color.BLACK);

        b6 = new JButton("VIEW PERSONAL DETAILS");
        b6.setFont(new Font("System", Font.BOLD, 14));
        b6.setBackground(Color.WHITE);
        b6.setForeground(Color.BLACK);

        b7 = new JButton("EXIT");
        b7.setFont(new Font("System", Font.BOLD, 14));
        b7.setBackground(Color.WHITE);
        b7.setForeground(Color.BLACK);

        b8 = new JButton("FAQs");
        b8.setFont(new Font("System", Font.BOLD, 14));
        b8.setBackground(Color.WHITE);
        b8.setForeground(Color.BLACK);

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

        setLayout(null);

        l1.setBounds(40,130,700,40);
        add(l1);

        b4.setBounds(40, 230, 300, 30);
        add(b4);

        b5.setBounds(40,180,300,30);
        add(b5);

        b6.setBounds(440,180,300,30);
        add(b6);

        b8.setBounds(440,230,300,30);
        add(b8);

        b7.setBounds(240,280,300,30);
        add(b7);

        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);

        ImageIcon imageIcon = new ImageIcon("secure-payment.jpg"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(1000, 1000,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        setIconImage(newimg);

        //getContentPane().setBackground(Color.ORANGE);

        setSize(800,475);
        setLocation(400,40);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b5)
        {
            new Pin().setVisible(true);
            setVisible(false);
        }

        else if(ae.getSource()==b4)
        {
            new CardType().setVisible(true);
            setVisible(false);
        }

        else if(ae.getSource()==b6)
        {
            new PersonalDetails().setVisible(true);
            setVisible(false);
        }

        else if(ae.getSource()==b8)
        {
            new FileOpenBrowser();
            setVisible(false);
        }

        else if(ae.getSource()==b7)
        {
            System.exit(0);
        }
    }

    public static void main(String[] args)
    {
        new Services().setVisible(true);
    }
}