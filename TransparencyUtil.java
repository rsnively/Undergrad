package undergrad;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;

/*
 * Used to make an image transparent
 */
public class TransparencyUtil 
{
  public static Image makeColorTransparent(Image im, final Color color)
	{
		ImageFilter filter = new RGBImageFilter() {
			public int markerRGB = color.getRGB() | 0xFF000000;
			public final int filterRGB(int x, int y, int rgb) {
				if (( rgb | 0xFF000000 ) == markerRGB )
				{
					// Mark desired bits as 0 (transparent)
					return 0x00FFFFFF & rgb;
				}
				else 
				{
					return rgb;
				}
			}
		};

		ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
		return Toolkit.getDefaultToolkit().createImage(ip);
	}
}
