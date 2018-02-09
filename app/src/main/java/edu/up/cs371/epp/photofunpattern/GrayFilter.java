package edu.up.cs371.epp.photofunpattern;

import android.graphics.Color;

/**
 *  class GrayFilter changes the image manipulation behavior of its parent
 *  PhotoFilter to convert the image to gray scale.
 *
 *  @author Edward C. Epp
 *  @version November 2017
 *  https://github.com/edcepp/PhotoFunPattern
 */

public class GrayFilter extends PhotoFilter {

    /*
    * tranformPixel This method overrides the transformPixel in the parent
    * class. It transforms a color pixel to gray by averaging its three RGB
    * components.
    *
    * @param inPixel is a 32 bit pixel that contains RGB color values
    * @return a new Pixel in which each of the RGB components is their averaged
    * value
    */
    public int transformPixel(int[] pixelArray) {

        int redP1 = constrain(Color.red(pixelArray[0]))/10;
        int redP2 = constrain(Color.red(pixelArray[1]))/10;
        int redP3 = constrain(Color.red(pixelArray[2]))/10;
        int redP4 = constrain(Color.red(pixelArray[3]))/10;
        int redP5 = constrain(Color.red(pixelArray[4]))/5;
        int redP6 = constrain(Color.red(pixelArray[5]))/10;
        int redP7 = constrain(Color.red(pixelArray[6]))/10;
        int redP8 = constrain(Color.red(pixelArray[7]))/10;
        int redP9 = constrain(Color.red(pixelArray[8]))/10;

        int greenP1 = constrain(Color.green(pixelArray[0]))/10;
        int greenP2 = constrain(Color.green(pixelArray[1]))/10;
        int greenP3 = constrain(Color.green(pixelArray[2]))/10;
        int greenP4 = constrain(Color.green(pixelArray[3]))/10;
        int greenP5 = constrain(Color.green(pixelArray[4]))/5;
        int greenP6 = constrain(Color.green(pixelArray[5]))/10;
        int greenP7 = constrain(Color.green(pixelArray[6]))/10;
        int greenP8 = constrain(Color.green(pixelArray[7]))/10;
        int greenP9 = constrain(Color.green(pixelArray[8]))/10;

        int blueP1 = constrain(Color.blue(pixelArray[0]))/10;
        int blueP2 = constrain(Color.blue(pixelArray[1]))/10;
        int blueP3 = constrain(Color.blue(pixelArray[2]))/10;
        int blueP4 = constrain(Color.blue(pixelArray[3]))/10;
        int blueP5 = constrain(Color.blue(pixelArray[4]))/5;
        int blueP6 = constrain(Color.blue(pixelArray[5]))/10;
        int blueP7 = constrain(Color.blue(pixelArray[6]))/10;
        int blueP8 = constrain(Color.blue(pixelArray[7]))/10;
        int blueP9 = constrain(Color.blue(pixelArray[8]))/10;

        int red = redP1+redP2+redP3+redP4+redP5+redP6+redP7+redP8+redP9;
        int green = greenP1+greenP2+greenP3+greenP4+greenP5+greenP6+greenP7+greenP8+greenP9;
        int blue = blueP1+blueP2+blueP3+blueP4+blueP5+blueP6+blueP7+blueP8+blueP9;

        pixelArray[4] = Color.argb(Color.alpha(pixelArray[4]), red, green, blue);

        return pixelArray[4];

        /*int intensity = (Color.red(inPixel) + Color.green(inPixel) +
                Color.blue(inPixel)) / 3;
        return Color.argb(Color.alpha(inPixel), intensity,intensity,intensity);*/

    }

}
