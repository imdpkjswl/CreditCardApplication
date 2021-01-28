import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class FileOpenBrowser implements ActionListener
{
    FileOpenBrowser()
    {
        try {
            File urlDesktop = new File("D:\\#CODE SECTION\\CreditCardApplication\\CreditCardApplication\\FAQs.pdf");
            Desktop.getDesktop().open(urlDesktop);
            new Services().setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
    }
}
