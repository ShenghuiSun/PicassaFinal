package model.util;

import model.RGBColor;


/**
 * Combine two colors by combining their components.
 * 
 * This is a separate class from color since it is just one set of
 * ways to combine colors, many may exist and we do not want to keep
 * modifying the RGBColor class.
 * 
 * @author Robert C. Duvall
 */
public class ColorCombinations
{
    /**
     * Combine two colors by adding their components.
     */
    public static RGBColor add (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() + right.getRed(), 
                            left.getGreen() + right.getGreen(),
                            left.getBlue() + right.getBlue());
    }

    /**
     * Combine two colors by subtracting their components.
     */
    public static RGBColor subtract (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() - right.getRed(), 
                            left.getGreen() - right.getGreen(),
                            left.getBlue() - right.getBlue());
    }

    /**
     * Combine two colors by multiplying their components.
     */
    public static RGBColor multiply (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() * right.getRed(), 
                            left.getGreen() * right.getGreen(),
                            left.getBlue() * right.getBlue());
    }

    /**
     * Combine two colors by dividing their components.
     */
    public static RGBColor divide (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() / right.getRed(), 
                            left.getGreen() / right.getGreen(),
                            left.getBlue() / right.getBlue());
    }
    
    /**
     * Combine two colors by modulating their components.
     */
    public static RGBColor modulus (RGBColor left, RGBColor right)
    {
        return new RGBColor(left.getRed() % right.getRed(), 
                            left.getGreen() % right.getGreen(),
                            left.getBlue() % right.getBlue());
    }
    
    /**
     * Combine two colors by exponentially computing their components.  
     */
    public static RGBColor exponent (RGBColor left, RGBColor right)
    {
        return new RGBColor(Math.pow(left.getRed(), right.getRed()), 
        					Math.pow(left.getGreen(), right.getGreen()),
        					Math.pow(left.getBlue(), right.getBlue())); 
    }
    
    /**
     * Combine two colors by exponentially computing their components.  
     */
    public static RGBColor negate (RGBColor left)
    {
        return new RGBColor(-left.getRed(),  
        					-left.getGreen(),
        					-left.getBlue()); 
    } 
    
    public static RGBColor floor (RGBColor left)
    {
        return new RGBColor(Math.floor(left.getRed()),  
        					Math.floor(left.getGreen()),
        					Math.floor(left.getBlue())); 
    } 
    
    public static RGBColor ceil (RGBColor left)
    {
        return new RGBColor(Math.ceil(left.getRed()),  
        					Math.ceil(left.getGreen()),
        					Math.ceil(left.getBlue())); 
    } 
    
    public static RGBColor abs (RGBColor left)
    {
        return new RGBColor(Math.abs(left.getRed()),  
        					Math.abs(left.getGreen()),
        					Math.abs(left.getBlue())); 
    } 
    
    public static RGBColor clamp (RGBColor left)
    {
        return new RGBColor(RGBColor.clamp(left.getRed()),   
        					RGBColor.clamp(left.getGreen()),
        					RGBColor.clamp(left.getBlue())); 
    } 
    
    public static RGBColor wrap (RGBColor left)
    {
        return new RGBColor(RGBColor.wrap(left.getRed()),   
        					RGBColor.wrap(left.getGreen()),
        					RGBColor.wrap(left.getBlue())); 
    } 
    
    public static RGBColor sine (RGBColor left)
    {
        return new RGBColor(Math.sin(left.getRed()),   
        					Math.sin(left.getGreen()),
        					Math.sin(left.getBlue())); 
    } 
    
    public static RGBColor cosine (RGBColor left)
    {
        return new RGBColor(Math.cos(left.getRed()),   
        					Math.cos(left.getGreen()),
        					Math.cos(left.getBlue())); 
    } 
    
    public static RGBColor tangent (RGBColor left)
    {
        return new RGBColor(Math.tan(left.getRed()),   
        					Math.tan(left.getGreen()),
        					Math.tan(left.getBlue())); 
    } 
    
    public static RGBColor atangent (RGBColor left)
    {
        return new RGBColor(Math.atan(left.getRed()),   
        					Math.atan(left.getGreen()),
        					Math.atan(left.getBlue())); 
    } 
    
    public static RGBColor log (RGBColor left)
    {
        return new RGBColor(Math.log(left.getRed()),   
        					Math.log(left.getGreen()),
        					Math.log(left.getBlue())); 
    } 
    public static RGBColor logten (RGBColor left)
    {
        return new RGBColor(Math.log10(left.getRed()),   
        					Math.log10(left.getGreen()),
        					Math.log10(left.getBlue())); 
    } 
    
    public static RGBColor random (double r, double g, double b)
    {
        return new RGBColor(r, g, b); 
    } 
    
    public static RGBColor color (RGBColor red, RGBColor green, RGBColor blue) 
    {	
        return new RGBColor(red.getRed(),   
        					green.getGreen(),
        					blue.getBlue()); 
    }

	public static RGBColor rbg(RGBColor rgbColor) {
    	double R = rgbColor.getRed(); 
    	double G = rgbColor.getGreen(); 
    	double B = rgbColor.getBlue(); 
    	double Y =  0.299*R + 0.587*G + 0.114*B; 
    	double U = -0.147*R - 0.289*G + 0.436*B; 
    	double V =  0.615*R - 0.515*G - 0.100*B;
        return new RGBColor(Y, U, V); 
	}
    
	public static RGBColor yuv(RGBColor rgbColor) {
    	double Y = rgbColor.getRed(); 
    	double U = rgbColor.getGreen(); 
    	double V = rgbColor.getBlue(); 
    	double R = Y + 1.140*V;
    	double G = Y - 0.395*U - 0.581*V;
    	double B = Y + 2.032*U;
        return new RGBColor(R, G, B); 
	}
}
