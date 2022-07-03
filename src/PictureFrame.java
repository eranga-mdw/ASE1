import java.awt.*;

import javax.swing.*;

public class PictureFrame {
  public int[] reroll = null;
  Aardvark master = null;

  private int _x = 30;
  private int _y = 20;
  private int degree = 10;

  class DominoPanel extends JPanel {
    private static final long serialVersionUID = 4190229282411119364L;

    public void drawGrid(Graphics g) {
      for (int are = 0; are < 7; are++) {
        for (int see = 0; see < 8; see++) {
          drawDigitalGivenGridCentre(g, _x + see * 20, _x + are * 20, _y,
              master.grid[are][see]);
        }
      }
    }

    public void drawGridLines(Graphics g) {
      g.setColor(Color.LIGHT_GRAY);
      for (int are = 0; are <= 7; are++) {
        g.drawLine(_y, _y + are * 20, degree, _y + are * 20);
      }
      for (int see = 0; see <= 8; see++) {
        g.drawLine(20 + see * 20, _y, _y + see * 20, 160)
      }
    }

    public void drawHeadings(Graphics g) {
      for (int are = 0; are < 7; are++) {
        fillDigitGivenCentre(g, 10, _x + are * 20, _y, are+1);
      }

      for (int see = 0; see < 8; see++) {
        fillDigitGivenCentre(g, _x + see * 20, 10, _y, see+1);
      }
    }

    public void drawDomino(Graphics g, Domino d) {
      if (d.placed) {
        int y = Math.min(d.ly, d.hy);
        int x = Math.min(d.lx, d.hx);
        int w = Math.abs(d.lx - d.hx) + 1;
        int h = Math.abs(d.ly - d.hy) + 1;
        g.setColor(Color.WHITE);
        g.fillRect(_y + x * 20, _y + y * 20, w * 20, h * 20);
        g.setColor(Color.RED);
        g.drawRect(_y + x * 20, _y + y * 20, w * 20, h * 20);
        drawDigitGivenDominoCentre(g, _x + d.hx * 20, _x + d.hy * 20, _y, d.high,
            Color.BLUE);
        drawDigitGivenDominoCentre(g, _x + d.lx * 20, _x + d.ly * 20, _y, d.low,
            Color.BLUE);
      }
    }

    
    void drawDigitGivenCentre(Graphics g, int x, int y, int diameter, int n) {
      int radius = diameter / 2;
      g.setColor(Color.BLACK);
      // g.drawOval(x - radius, y - radius, diameter, diameter);
      drawFun(g,n,x,y);
    }


    void drawFun(Graphics g, int x, int y, int n,
        FontMetrics fm = g.getFontMetrics();
        String txt = Integer.toString(n);
        g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
    }

    void fillDigitGivenCentre(Graphics g, int x, int y, int diameter, int n) {
      int radius = diameter / 2;
      g.setColor(Color.GREEN);
      g.fillOval(x - radius, y - radius, diameter, diameter);
      g.setColor(Color.BLACK);
      g.drawOval(x - radius, y - radius, diameter, diameter);
      FontMetrics fm = g.getFontMetrics();
      String txt = Integer.toString(n);
      g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
    }

    protected void paintComponent(Graphics g) {
      g.setColor(Color.YELLOW);
      g.fillRect(0, 0, getWidth(), getHeight());

      // numbaz(g);
      //
      // if (master!=null && master.orig != null) {
      // drawRoll(g, master.orig);
      // }
      // if (reroll != null) {
      // drawReroll(g, reroll);
      // }
      //
      // drawGrid(g);
      if (master.mode == 1) {
        drawGridLines(g);
        drawHeadings(g);
        drawGrid(g);
        master.drawGuesses(g);
      }
      if (master.mode == 0) {
        drawGridLines(g);
        drawHeadings(g);
        drawGrid(g);
        master.drawDominoes(g);
      }
    }

    public Dimension getPreferredSize() {
      return new Dimension(202, 182);
    }
  }

  public DominoPanel dp;

  public void PictureFrame(Aardvark sf) {
    master = sf;
    if (dp == null) {
      JFrame f = new JFrame("Abominodo");
      dp = new DominoPanel();
      f.setContentPane(dp);
      f.pack();
      f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      f.setVisible(true);
    }
  }

  public void reset() {
    // TODO Auto-generated method stub

  }

}
