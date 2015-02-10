import java.util.Random;
import java.awt.*;

public class Startup
{

    private final int GRAD = 20; 

    private int[] clicks = new int[(GRAD+1)];

    public void upstart()
    {
        
        Random rnd = new Random();

        for (int i = 0; i <= GRAD; i++)
        {
            int k = rnd.nextInt(16);
            clicks[i] = k;
            BrainWindow.knapp[k].doClick();
        }

    }

    public void solve()
    {
        try
        {
            Robot robot = new Robot();

            for (int i = GRAD; i >= 0; i--)
            {
                //robot.delay(1000);
                BrainWindow.knapp[clicks[i]].doClick();
            }
        }

        catch (AWTException e)
        {
        }

    }

}
