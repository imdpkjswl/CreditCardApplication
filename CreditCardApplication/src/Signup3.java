import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener{

    JLabel l1,l2,l3,l4,l10,l11,l13;
    JButton b1,b2;
    JRadioButton r1, r2, r3, r4, r5, r6;
    JCheckBox c1,c2,c3,c4,c7;
    JTextField t3, t4;
    String email1id;

    long fno;


    Signup3(Long formno, String email_id)
    {
        fno = formno;
        email1id = email_id;

        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("NEW CARD APPLICATION FORM - PAGE 3");
        int y = fm.stringWidth(" ");
        int z = getWidth() - x;
        int w = z/y;
        String pad ="";
        //for (int i=0; i!=w; i++) pad +=" ";
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"NEW CARD APPLICATION FORM - PAGE 3");


        l1 = new JLabel("NEW CARD APPLICATION FORM - PAGE 3");
        l1.setFont(new Font("System", Font.BOLD, 31));
        l1.setForeground(Color.WHITE);

        l2 = new JLabel("Desired Credit Limit: ");
        l2.setFont(new Font("System", Font.BOLD, 18));
        l2.setForeground(Color.WHITE);

        l13 = new JLabel("Desired Cash Withdrawal Limit: ");
        l13.setFont(new Font("System", Font.BOLD, 18));
        l13.setForeground(Color.WHITE);


        l3 = new JLabel("Allow International Usage?");
        l3.setFont(new Font("System", Font.BOLD, 18));
        l3.setForeground(Color.WHITE);


        l4 = new JLabel("Please Select Your Monthly Cycle: ");
        l4.setFont(new Font("System", Font.BOLD, 18));
        l4.setForeground(Color.WHITE);


        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("System", Font.BOLD, 17));
        r1.setBackground(Color.WHITE);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("System", Font.BOLD, 17));
        r2.setBackground(Color.WHITE);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        r3 = new JRadioButton("2nd Of Current Month To 1st Of Next Month");
        r3.setFont(new Font("System", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);

        r4 = new JRadioButton("10th Of Current Month To 9th Of Next Month");
        r4.setFont(new Font("System", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);

        r5 = new JRadioButton("15th Of Current Month To 14th Of Next Month");
        r5.setFont(new Font("System", Font.BOLD, 16));
        r5.setBackground(Color.WHITE);

        r6 = new JRadioButton("25th Of Current Month To 24th Of Next Month");
        r6.setFont(new Font("System", Font.BOLD, 16));
        r6.setBackground(Color.WHITE);

        ButtonGroup newbuttonGroup = new ButtonGroup();
        newbuttonGroup.add(r3);
        newbuttonGroup.add(r4);
        newbuttonGroup.add(r5);
        newbuttonGroup.add(r6);


        l10 = new JLabel("Services Required:");
        l10.setFont(new Font("System", Font.BOLD, 18));
        l10.setForeground(Color.WHITE);


        l11 = new JLabel("Form No: "+fno);
        l11.setFont(new Font("System", Font.BOLD, 18));
        l11.setForeground(Color.WHITE);



        b1 = new JButton("Submit");
        b1.setFont(new Font("System", Font.BOLD, 14));
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);

        b2 = new JButton("Cancel");
        b2.setFont(new Font("System", Font.BOLD, 14));
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);


        c1 = new JCheckBox("SECURITY ALERTS");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("System", Font.BOLD, 16));

        c2 = new JCheckBox("OFFER ALERTS");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("System", Font.BOLD, 16));

        c3 = new JCheckBox("EMAIL ALERTS");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("System", Font.BOLD, 16));

        c4 = new JCheckBox("SMS ALERTS");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("System", Font.BOLD, 16));


        c7 = new JCheckBox("I PERMIT BANK PERSONNEL'S TO CONTACT ME FOR ANY FURTHER COMMUNICATION",true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("System", Font.BOLD, 16));


        t3 = new JTextField();
        t3.setFont(new Font("System", Font.BOLD, 12));

        t4 = new JTextField();
        t4.setFont(new Font("System", Font.BOLD, 12));


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

        l11.setBounds(750,10,150,30);
        add(l11);

        l13.setBounds(100,90,700,40);
        add(l13);

        t4.setBounds(400, 95,330,30);           // Cash Withdrawal Text
        add(t4);


        t3.setBounds(400, 150,330,30);          //Credit Limit Text
        add(t3);

        l1.setBounds(100,35,700,40);
        add(l1);

        l2.setBounds(100,150,350,30);
        add(l2);

        l3.setBounds(100,210,500,30);       // International Usage
        add(l3);

        r1.setBounds(400,210,80,30);        //Yes Button
        add(r1);

        r2.setBounds(500,210,80,30);        // No Button
        add(r2);

        l4.setBounds(100,260,400,30);
        add(l4);

        r3.setBounds(100,295,380,30);        // 2-1 Button
        add(r3);

        r4.setBounds(500,295,380,30);        // 10-9 Button
        add(r4);

        r5.setBounds(100,340,380,30);        // 15-14 Button
        add(r5);

        r6.setBounds(500,340,380,30);        // 25-24 Button
        add(r6);

        l10.setBounds(100,380,200,30);
        add(l10);

        c1.setBounds(100,410,180,30);
        add(c1);

        c2.setBounds(300,410,180,30);
        add(c2);

        c3.setBounds(100,455,180,30);
        add(c3);

        c4.setBounds(300,455,180,30);
        add(c4);

        c7.setBounds(100,500,780,30);
        add(c7);

        b1.setBounds(380,545,100,30);
        add(b1);

        b2.setBounds(500,545,100,30);
        add(b2);

        ImageIcon imageIcon = new ImageIcon("secure-payment.jpg"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(1000, 1000,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        setIconImage(newimg);

        setSize(985,650);
        setLocation(400,20);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        b1.addActionListener(this);
        b2.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae){

        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        long first8 = Math.abs(first7);

        long first3 = (ran.nextLong() % 9000L) + 1000L;
        long first4 = Math.abs(first3);

        String b = "";
        if(c1.isSelected()){
            b = b+" Security Alerts";
        }
        if(c2.isSelected()){
            b = b+" Offer Alerts";
        }
        if(c3.isSelected()){
            b = b+" Email Alerts";
        }
        if(c4.isSelected()){
            b = b+" SMS Alerts";
        }

        String I = null;
        if(r1.isSelected()){
            I = "Yes";
        } else if(r2.isSelected()){
            I = "No";
        }

        String cycle = null;
        if(r3.isSelected()){
            cycle = "2nd Of Current Month To 1st Of Next Month";
        } else if(r4.isSelected()){
            cycle = "10th Of Current Month To 9th Of Next Month";
        }else if(r5.isSelected()){
            cycle = "15th Of Current Month To 14th Of Next Month";
        }else if(r6.isSelected()){
            cycle = "25th Of Current Month To 24th Of Next Month";
        }

        long c = fno;

        String cashLimit = t4.getText();
        String creditLimit = t3.getText();

        try{

            if(ae.getSource()==b1){

                if(b.equals("")){

                    JOptionPane.showMessageDialog(null, "***Please Fill All The Required Fields***");

                }else
                {


                    Conn c1 = new Conn();
                    String q1 = "insert into signup3 values('"+c+"','"+first8+"','"+first4+"','"+b+"','"+cashLimit+"','"+creditLimit+"','"+I+"','"+cycle+"')";
                    String q2 = "insert into login values('"+first8+"','"+first4+"')";
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Your Login Credentials Have Been Sent To Your Registered Email Id!");

                    SendingMail sendingMail = new SendingMail(email1id, first4, first8, fno);
                    sendingMail.email();

                    new Login().setVisible(true);
                    setVisible(false);
                }

            }else if(ae.getSource()==b2){
                System.exit(0);
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args){
        new Signup3((long) 0, "").setVisible(true);
    }
}


