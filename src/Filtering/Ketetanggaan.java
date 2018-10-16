/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtering;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;

/**
 *
 * @author biobii
 */
public class Ketetanggaan {

    private int top, right, bottom, left;
    private int current, mid;

    private Color c;

    public int redProcess(String context, BufferedImage image, int row, int col, int width, int height) {
        c = new Color(image.getRGB(row, col));
        current = c.getRed();

        // tetangga atas
        if (row - 1 < 0) {
            top = 0;
        } else {
            c = new Color(image.getRGB(row - 1, col));
            top = c.getRed();
        }

        // tetangga kanan
        if (col + 1 >= height) {
            right = 0;
        } else {
            c = new Color(image.getRGB(row, col + 1));
            right = c.getRed();
        }

        // tetangga bawah
        if (row + 1 >= width) {
            bottom = 0;
        } else {
            c = new Color(image.getRGB(row + 1, col));
            bottom = c.getRed();
        }

        // tetangga kiri
        if (col - 1 < 0) {
            left = 0;
        } else {
            c = new Color(image.getRGB(row, col - 1));
            left = c.getRed();
        }

        int value = 0;
        int[] values = {current, top, right, bottom, left};

        switch (context) {
            case "median":
                Arrays.sort(values);
                value = values[values.length / 2];
                break;
            case "mean":
                value = Arrays.stream(values).sum() / values.length;
                break;
            case "batas":
                Arrays.sort(values);
                
                if (current < values[0]) {
                    current = values[0];
                    break;
                }
                
                if (current > values[values.length-1]) {
                    current = values[values.length-1];
                    break;
                }
                
                value = current;
                break;
        }

        return value;
    }

    public int greenProcess(String context, BufferedImage image, int row, int col, int width, int height) {
        c = new Color(image.getRGB(row, col));
        current = c.getGreen();

        // tetangga atas
        if (row - 1 < 0) {
            top = 0;
        } else {
            c = new Color(image.getRGB(row - 1, col));
            top = c.getGreen();
        }

        // tetangga kanan
        if (col + 1 >= height) {
            right = 0;
        } else {
            c = new Color(image.getRGB(row, col + 1));
            right = c.getGreen();;
        }

        // tetangga bawah
        if (row + 1 >= width) {
            bottom = 0;
        } else {
            c = new Color(image.getRGB(row + 1, col));
            bottom = c.getGreen();
        }

        // tetangga kiri
        if (col - 1 < 0) {
            left = 0;
        } else {
            c = new Color(image.getRGB(row, col - 1));
            left = c.getGreen();
        }

        int value = 0;
        int[] values = {current, top, right, bottom, left};

        switch (context) {
            case "median":
                Arrays.sort(values);
                value = values[values.length / 2];
                break;
            case "mean":
                value = Arrays.stream(values).sum() / values.length;
                break;
            case "batas":
                Arrays.sort(values);
                
                if (current < values[0]) {
                    current = values[0];
                    break;
                }
                
                if (current > values[values.length-1]) {
                    current = values[values.length-1];
                    break;
                }
                
                value = current;
                break;
        }

        return value;
    }

    public int blueProcess(String context, BufferedImage image, int row, int col, int width, int height) {
        c = new Color(image.getRGB(row, col));
        current = c.getGreen();

        // tetangga atas
        if (row - 1 < 0) {
            top = 0;
        } else {
            c = new Color(image.getRGB(row - 1, col));
            top = c.getBlue();
        }

        // tetangga kanan
        if (col + 1 >= height) {
            right = 0;
        } else {
            c = new Color(image.getRGB(row, col + 1));
            right = c.getBlue();
        }

        // tetangga bawah
        if (row + 1 >= width) {
            bottom = 0;
        } else {
            c = new Color(image.getRGB(row + 1, col));
            bottom = c.getBlue();
        }

        // tetangga kiri
        if (col - 1 < 0) {
            left = 0;
        } else {
            c = new Color(image.getRGB(row, col - 1));
            left = c.getBlue();
        }

        int value = 0;
        int[] values = {current, top, right, bottom, left};

        switch (context) {
            case "median":
                Arrays.sort(values);
                value = values[values.length / 2];
                break;
            case "mean":
                value = Arrays.stream(values).sum() / values.length;
                break;
            case "batas":
                Arrays.sort(values);
                
                if (current < values[0]) {
                    current = values[0];
                    break;
                }
                
                if (current > values[values.length-1]) {
                    current = values[values.length-1];
                    break;
                }
                
                value = current;
                break;
        }

        return value;
    }
}
