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



        int p1 = (int)((float)pixelArray[0]*0.1);
        int p2 = (int)((float)pixelArray[1]*0.1);
        int p3 = (int)((float)pixelArray[2]*0.1);
        int p4 = (int)((float)pixelArray[3]*0.1);
        int p5 = (int)((float)pixelArray[4]*0.2);
        int p6 = (int)((float)pixelArray[5]*0.1);
        int p7 = (int)((float)pixelArray[6]*0.1);
        int p8 = (int)((float)pixelArray[7]*0.1);
        int p9 = (int)((float)pixelArray[8]*0.1);

        pixelArray[4] = p1+p2+p3+p4+p5+p6+p7+p8+p9;

        return pixelArray[4];

        /*int intensity = (Color.red(inPixel) + Color.green(inPixel) +
                Color.blue(inPixel)) / 3;
        return Color.argb(Color.alpha(inPixel), intensity,intensity,intensity);*/

    }

}
