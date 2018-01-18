/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiediaproject;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

/**
 *
 * @author nhan-kute
 */
public class LosslessCompressionAlgorithms {
    private BufferedImage img;
    
    public LosslessCompressionAlgorithms(BufferedImage imge){
        img = imge;
    }

    public BufferedImage Compress() {
        int height = img.getHeight();
        int width = img.getWidth();
        int Result[][] = new int[width][height];
        Result[0][0] = img.getRGB(0, 0);
        BufferedImage Compress = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        for(int i=1; i<width; i++){
            Result[i][0] = img.getRGB(i, 0) - Result[i-1][0];
        }
        for(int i=1; i<height; i++){
            Result[0][i] = img.getRGB(0, i) - Result[0][i-1];
        }
        
        //Get pixels from image
        for(int i=1; i<width; i++){
            for(int j=1; j<height; j++){
                Result[i][j] = img.getRGB(i, j) - (img.getRGB(i-1, j) + img.getRGB(i, j-1) - img.getRGB(i-1, j-1));
            }
        }
        
        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                Compress.setRGB(i, j, Result[i][j]);
            }
        }
        
        return Compress;
    }
    
    
    
}
