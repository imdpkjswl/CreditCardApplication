import com.sun.mail.iap.Response;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Random;

public class Login extends JFrame implements ActionListener
{
    JLabel l1, l2, l3, l4;
    JTextField tf1, tf2;
    JPasswordField pf2;
    JButton b1, b2, b3, b4;
    static String xz;

    static Random ran = new Random();
    static long first4;// = (ran.nextLong() % 9000L) + 1000L;
    static long first;;// = Math.abs(first4);

    static long gen_random()
    {
        first4 = (ran.nextLong() % 9000L) + 1000L;
        first = Math.abs(first4);
        return first;
    }

    Login()
    {
        setFont(new Font("System",Font.BOLD, 25));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("CARD APPLICATION FORM");
        int y = fm.stringWidth(" ");
        int z = getWidth() - x - 200;
        int w = z/y;
        String pad = "";
        pad = String.format("%"+ w+ "s", pad);
        setTitle(pad + "CARD APPLICATION FORM");

        l1 = new JLabel("WELCOME TO CARD APPLICATION FORM");
        l1.setFont(new Font("System", Font.BOLD, 33));
        l1.setForeground(Color.WHITE);


        l2 = new JLabel("CARD Number: ");
        l2.setFont(new Font("System", Font.BOLD, 18));
        l2.setForeground(Color.WHITE);

        l3 = new JLabel("PIN Number: ");
        l3.setFont(new Font("System", Font.BOLD, 18));
        l3.setForeground(Color.WHITE);

        l4 = new JLabel("Enter CAPTCHA: ");
        l4.setFont(new Font("System", Font.BOLD, 18));
        l4.setForeground(Color.WHITE);

        tf1 = new JTextField(100);
        tf2 = new JTextField(100);
        pf2 = new JPasswordField(100);

        b1 = new JButton("Sign In");
        b1.setBackground(Color.white);
        b1.setForeground(Color.BLACK);

        b2 = new JButton("Clear");
        b2.setBackground(Color.white);
        b2.setForeground(Color.BLACK);

        b3 = new JButton("New User?");
        b3.setBackground(Color.white);
        b3.setForeground(Color.BLACK);

        xz = String.valueOf(gen_random());
        b4 = new JButton(xz);
        b4.setBackground(Color.white);
        b4.setForeground(Color.BLACK);

        try {
            final Image backgroundImage = javax.imageio.ImageIO.read(new File("D:\\#CODE SECTION\\CreditCardApplication\\CreditCardApplication\\3.jpg"));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, null);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        setLayout(null);

        l1.setBounds(15,20,700,200);
        add(l1);

        l2.setBounds(125,100,375,200);
        add(l2);

        l3.setBounds(125,150,375,200);
        add(l3);

        l4.setBounds(125,200,375,200);
        add(l4);

        tf2.setFont(new Font("System", Font.BOLD, 15));
        tf2.setBounds(300,285,100,30);
        add(tf2);

        b4.setFont(new Font("System", Font.BOLD, 15));
        b4.setBounds(430,285,100,30);
        add(b4);

        pf2.setFont(new Font("System", Font.BOLD, 15));
        pf2.setBounds(300,235,230,30);
        add(pf2);

        tf1.setFont(new Font("System", Font.BOLD, 15));
        tf1.setBounds(300,185,230,30);
        add(tf1);

        b1.setFont(new Font("System", Font.BOLD, 15));
        b1.setBounds(300,340,100,30);
        add(b1);

        b2.setFont(new Font("System", Font.BOLD, 15));
        b2.setBounds(430,340,100,30);
        add(b2);

        b3.setFont(new Font("System", Font.BOLD, 15));
        b3.setBounds(300,390,230,30);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        ImageIcon imageIcon = new ImageIcon("secure-payment.jpg"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(1000, 1000,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        setIconImage(newimg);

        setSize(700, 550);
        setLocation(400,40);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            String input_captcha = tf2.getText();
            Conn c1 = new Conn();
            String a = tf1.getText();
            String b = pf2.getText();
            String q = "select * from login where cardno = '"+a+"' and pin = '" +b+"'";
            ResultSet rs = c1.s.executeQuery(q);

            /**if(ae.getSource()== b4)
             {
             z = String.valueOf(gen_random());
             b4.setText(z);
             b4.setBackground(Color.white);
             b4.setForeground(Color.BLACK);
             }*/

            if(ae.getSource() == b1)
            {
                if(xz.equals(input_captcha))
                {
                    if(rs.next())
                    {
                        JOptionPane.showMessageDialog((Component)null, "Login Successful!");
                        new Services().setVisible(true);
                        setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Incorrect Card Number Or Password Entered. Please Try Again");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Captcha Entered. Please Try Again");
                    xz = String.valueOf(gen_random());
                    b4.setText(xz);
                    b4.setBackground(Color.white);
                    b4.setForeground(Color.BLACK);
                    tf2.setText("");
                }
            }

            else if(ae.getSource() == b2)
            {
                tf1.setText("");
                pf2.setText("");
                tf2.setText("");
            }

            else if (ae.getSource() == b3)
            {
                new Signup1().setVisible(true);
                setVisible(false);
            }



        }catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Error: " + e);
        }
    }

    public static void main(String[] args)
    {
        new Login().setVisible(true);
    }
}
