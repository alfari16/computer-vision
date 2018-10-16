/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtering;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import javax.imageio.ImageIO;

/**
 *
 * @author biobii
 */
public class Filter extends Ketetanggaan {

    private String context;
    private BufferedImage image, newImg;
    private int width, height;
    
    public Filter(String filter, File file){
        this.context = filter;
        filter(file);
    }

    public void filter(File file) {
        try {
            newImg = image = ImageIO.read(file);
            width = image.getWidth();
            height = image.getHeight();

            for (int row = 0; row < width; row++) {
                for (int col = 0; col < height; col++) {
                    int red = this.redProcess(context, image, row, col, width, height);
                    int green = this.greenProcess(context, image, row, col, width, height);
                    int blue = this.blueProcess(context, image, row, col, width, height);
                    newImg.setRGB(row, col, new Color(red, green, blue).getRGB());
                }
            }

            this.output();
        } catch (Exception e) {
            System.out.println("Error:\t" + e.getMessage());
        }
    }

    public void output() {
        try {
            File output = new File("/home/alfari/Documents/kuliah/computer-vision/assets/"+context+".jpg");
            ImageIO.write(newImg, "jpg", output);

            System.out.println("Filter Batas outputed!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
