import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.*;
import javax.swing.*;

class ODOTViewer {
  public static void main(String[] args) throws IOException {
    int x = 0, maxframes = 290, maxframesadded = maxframes + 10, updateinterval = 20, overallruns = 0;
    JPanel panel = new JPanel ();
    JFrame f = new JFrame("Intersection of I-44 & I-40 Facing North, East, South, and West (From Left to Right)");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLocation(100,100);
    f.setVisible(true);
    do {
      for ( x = 0; x <= maxframesadded; x += 10 ) {
        if ( x > maxframes ) {
          x = 0;
        }
        if (overallruns == maxframesadded*16) {
              x = 0;
              maxframes = 290;
              maxframesadded = maxframes + 10;
              updateinterval = 20;
              overallruns = 0;
    f.setVisible(true);
        } else {}
        f.setTitle("Intersection of I-44 & I-40 Facing North, East, South, and West (From Left to Right)  Frame " + x + " out of " + maxframes + "  Update Interval Speed : " + updateinterval + "  Stream Refreshes Every 5 Minutes");
        String north = "https://www.oktraffic.org/cameras/show_img.php?fname=10_55_30_17_6969_" + x +".jpg&valid=1&loop_dir=1&err_odot=0&rand=0.1354226107877039";
        String east = "https://www.oktraffic.org/cameras/show_img.php?fname=10_55_30_19_6969_" + x +".jpg&valid=1&loop_dir=1&err_odot=0&rand=0.4006195626249789";
        String south = "https://www.oktraffic.org/cameras/show_img.php?fname=10_55_30_18_6969_" + x +".jpg&valid=1&loop_dir=1&err_odot=0&rand=0.5605809663943402";
        String west = "https://www.oktraffic.org/cameras/show_img.php?fname=10_55_30_20_6969_" + x +".jpg&valid=1&loop_dir=1&err_odot=0&rand=0.5551518922406733";
        URL northurl = new URL(north); BufferedImage northimage = ImageIO.read(northurl); JLabel northicon = new JLabel(new ImageIcon(northimage));
        URL easturl = new URL(east); BufferedImage eastimage = ImageIO.read(easturl); JLabel easticon = new JLabel(new ImageIcon(eastimage));
        URL southurl = new URL(south); BufferedImage southimage = ImageIO.read(southurl); JLabel southicon = new JLabel(new ImageIcon(southimage));
        URL westurl = new URL(west); BufferedImage westimage = ImageIO.read(westurl); JLabel westicon = new JLabel(new ImageIcon(westimage));
        panel.add(northicon);
        panel.add(easticon);
        panel.add(southicon);
        panel.add(westicon);
        System.out.println("NORTH: "+x+" Of "+maxframes+". Recieving data from "+north);
        System.out.println("EAST: "+x+" Of "+maxframes+". Recieving data from "+east);
        System.out.println("SOUTH: "+x+" Of "+maxframes+". Recieving data from "+south);
        System.out.println("WEST: "+x+" Of "+maxframes+". Recieving data from " + west);
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------"); 
        f.getContentPane().add(panel);
        f.pack();
        try {
          Thread.sleep(updateinterval);
        } catch (InterruptedException e) {}
        panel.remove(northicon);
        panel.remove(easticon);
        panel.remove(southicon);
        panel.remove(westicon);
        f.getContentPane().add(panel);
        overallruns += 10;
        if (overallruns >= maxframesadded*16) {
      f.setVisible(false);
      f.dispose();
      overallruns = maxframesadded*16;
        } else {}
      } 
    }  while (overallruns < maxframesadded*16); 
  }
}
/**
 * Created by Nathan Cronic
 * Data Provided by Oklahoma Department of Transportation
 * If you have runtime errors (rare), please grab a updated server URL from https://goo.gl/4lClBr
 */