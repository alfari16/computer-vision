/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conv;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alfari
 */
public class Convolution {

    public static void main(String[] args) {
        BufferedImage bi = null;
        JLabel jLabel1 = new JLabel(), jLabel2 = new JLabel();
        JFrame panel = new JFrame("title");
        try {
            Image image = new ImageIcon("/home/alfari/Downloads/WhatsApp Image 2018-10-07 at 16.07.18.jpeg").getImage();
            Dimension size = new Dimension();
            size.width = image.getWidth(null);
            size.height = image.getHeight(null);
            panel.setSize(size);
            BufferedImage prossesImage = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);
            BufferedImage prosesimage3 = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);
            Graphics g = prossesImage.createGraphics();
            g.drawImage(image, 0, 0, null);
            jLabel1.setIcon(new ImageIcon(prossesImage));
            bi = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_BYTE_GRAY);
            Graphics2D g2 = bi.createGraphics();
            g2.drawImage(image, null, null);
            float[] edgeKernel = {-1, 0, 1,
                -1, 0, 1,
                -1, 0, 1};
            BufferedImageOp edgeop = new ConvolveOp(new Kernel(3, 3, edgeKernel), ConvolveOp.EDGE_NO_OP, null);
            BufferedImage image3 = edgeop.filter(bi, null);
            jLabel2.setIcon(new ImageIcon(image3));
            panel.getContentPane().add(jLabel1);
            panel.getContentPane().add(jLabel2);
            
            panel.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

