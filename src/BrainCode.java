public class BrainCode
{

    public static void main(String[] args)
    {
        BrainWindow GUI = new BrainWindow("BrainCode v1.0");
        GUI.setResizable(false);
        GUI.setVisible(true);
        Startup stp = new Startup();
        stp.upstart();
        //stp.solve();
    }

}