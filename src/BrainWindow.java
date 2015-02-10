import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BrainWindow extends JFrame implements ActionListener, KeyListener
{
    long startTid, sluttTid;
    double tid;

    public static JButton[] knapp = new JButton[16];

    public BrainWindow(String tittel)
    {
        resetTime();

        setTitle(tittel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(600, 600));

        setLayout(new GridLayout(4, 4, 2, 2));

        for(int i = 0; i < 16; i++)
        {
            knapp[i] = new JButton();
            add(knapp[i]);
            knapp[i].addActionListener(this);
            knapp[i].addKeyListener(this);
            knapp[i].setBackground(Color.RED);
        }



    }

    public void actionPerformed(ActionEvent ae)
    {

            JButton valgtKnapp = (JButton) ae.getSource();

        if (valgtKnapp == knapp[0])
        {
            endreFarge(0);
            endreFarge(1);
            endreFarge(4);
        }

        else if (valgtKnapp == knapp[1])
        {
            endreFarge(0);
            endreFarge(1);
            endreFarge(2);
            endreFarge(5);
        }

        else if (valgtKnapp == knapp[2])
        {
            endreFarge(1);
            endreFarge(2);
            endreFarge(3);
            endreFarge(6);
        }

        else if (valgtKnapp == knapp[3])
        {
            endreFarge(2);
            endreFarge(3);
            endreFarge(7);
        }

        else if (valgtKnapp == knapp[4])
        {
            endreFarge(0);
            endreFarge(4);
            endreFarge(5);
            endreFarge(8);
        }

        else if (valgtKnapp == knapp[5])
        {
            endreFarge(1);
            endreFarge(4);
            endreFarge(5);
            endreFarge(6);
            endreFarge(9);
        }

        else if (valgtKnapp == knapp[6])
        {
            endreFarge(2);
            endreFarge(5);
            endreFarge(6);
            endreFarge(7);
            endreFarge(10);
        }


        else if (valgtKnapp == knapp[7])
        {
            endreFarge(3);
            endreFarge(6);
            endreFarge(7);
            endreFarge(11);
        }

        else if (valgtKnapp == knapp[8])
        {
            endreFarge(4);
            endreFarge(8);
            endreFarge(9);
            endreFarge(12);
        }

        else if (valgtKnapp == knapp[9])
        {
            endreFarge(5);
            endreFarge(8);
            endreFarge(9);
            endreFarge(10);
            endreFarge(13);
        }

        else if (valgtKnapp == knapp[10])
        {
            endreFarge(6);
            endreFarge(9);
            endreFarge(10);
            endreFarge(11);
            endreFarge(14);
        }

        else if (valgtKnapp == knapp[11])
        {
            endreFarge(7);
            endreFarge(10);
            endreFarge(11);
            endreFarge(15);
        }

        else if (valgtKnapp == knapp[12])
        {
            endreFarge(8);
            endreFarge(12);
            endreFarge(13);
        }

        else if (valgtKnapp == knapp[13])
        {
            endreFarge(9);
            endreFarge(12);
            endreFarge(13);
            endreFarge(14);
        }

        else if (valgtKnapp == knapp[14])
        {
            endreFarge(10);
            endreFarge(13);
            endreFarge(14);
            endreFarge(15);
        }

        else if (valgtKnapp == knapp[15])
        {
            endreFarge(11);
            endreFarge(14);
            endreFarge(15);
        }


        done();

    }

    public void endreFarge(int bryter)
    {
        
        Color farge = knapp[bryter].getBackground();

        if (farge == Color.RED)
            knapp[bryter].setBackground(Color.BLUE);

        else
            knapp[bryter].setBackground(Color.RED);

    }

    public void done()
    {
        int rt = 0, bt = 0;

        for (int i = 0; i < 16; i++)
        {
            if (knapp[i].getBackground() == Color.RED) rt++;
            if (knapp[i].getBackground() == Color.BLUE) bt++;
        }

        if (rt == 16 || bt == 16)
        {

            sluttTid = 	System.currentTimeMillis();

            tid = (sluttTid - startTid) / 1000.0;

            int omstart = JOptionPane.showConfirmDialog(
                    null,
                    "Du har klart det umulige på " + tid + " sekunder \n Vil du spille på nytt?",
                    "Gratulerer!",
                    JOptionPane.YES_NO_OPTION);

            if (omstart == 0)
            {
                Startup stp = new Startup();
                stp.upstart();
                resetTime();
            }
            else
                System.exit(0);
        }
    }
    
    public void resetTime()
    {
        startTid = 	System.currentTimeMillis();
    }

    public void keyPressed(KeyEvent e)
    {
		// Prints the key code to the console.
		System.out.println(e.getKeyCode());
         Startup stp = new Startup();
        stp.solve();
	}

    public void keyReleased(KeyEvent e)
    {
		// Do stuff.
	}

    public void keyTyped(KeyEvent e)
    {
		// Do stuff.
	}

}