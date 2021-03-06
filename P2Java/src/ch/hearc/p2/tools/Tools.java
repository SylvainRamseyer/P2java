
package ch.hearc.p2.tools;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Tools
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static double getAngle(double x, double y)
		{
		double angle = 0;

		// angle par d�faut pour (0,0)
		if ((x == 0) && (y == 0)) {
			return angle;
			}

		//1er quart
		if(x>=0 && y>0)
			{
			angle = Math.atan(Math.abs(x / y));
			}
		//2eme quart
		else if (x > 0 && y <= 0)
			{
			angle = Math.PI / 2 + Math.atan(Math.abs(y / x));
			}

		//3eme quart
		else if (x <= 0 && y < 0)
			{
			angle = Math.PI + Math.atan(Math.abs(x / y));
			}

		//4eme quart
		else if (x < 0 && y >= 0)
			{
			angle = Math.PI * 1.5 + Math.atan(Math.abs(y / x));
			}

		return angle;
		}

	public static float getAngle(float x, float y)
		{
		return (float)getAngle((double)x, (double)y);
		}

	/**
	 * get x from a radian
	 * @return
	 */
	public static float getXFromAngle(float angle)
		{
			return (float) Math.sin(angle);
		}

	public static float getYFromAngle(float angle)
		{
			return (float) Math.cos(angle);
		}

	public static Image loadImage(String path)
		{
			Image image = null;
			try
				{
				image = new Image(path);
				}
			catch (SlickException e)
				{
				e.printStackTrace();
				}
			return image;
		}
	}
