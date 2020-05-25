package com.god;

import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

import java.io.File;

public class part1 {
    //Convert pixels
    public static ImageResource convertingGray(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());

        for (Pixel pixel : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int average = ((inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen()) / 3);

            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
        }

        return outImage;
    }

    public static ImageResource convertingNeg(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());

        for (Pixel pixel : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int negativeRed = 255 - inPixel.getRed();
            int negativeBlue = 255 - inPixel.getBlue();
            int negativeGreen = 255 - inPixel.getGreen();

            pixel.setRed(negativeRed);
            pixel.setGreen(negativeGreen);
            pixel.setBlue(negativeBlue);
        }

        return outImage;
    }

    public static void getFilesAndConvert(String typeConvert){
        DirectoryResource dr = new DirectoryResource();
        String greyString = "Grey";
        String negString = "Negative";
        String outNameFile = "";

        ImageResource newImage = null;
        //Search for files
        for (File f : dr.selectedFiles()) {
            ImageResource imgFile = new ImageResource(f);
            String inFileName = imgFile.getFileName();
            if (typeConvert.contains(negString)) {
                newImage = convertingNeg(imgFile);
                outNameFile = "neg - " + inFileName;
            } else if (typeConvert.contains(greyString)){
                newImage = convertingGray(imgFile);
                outNameFile = "gray - " + inFileName;
            }else{
                System.out.print("there´s no converting order to match");
            }

            newImage.draw();
            newImage.setFileName(outNameFile);
            newImage.save();
        }
    }
}
