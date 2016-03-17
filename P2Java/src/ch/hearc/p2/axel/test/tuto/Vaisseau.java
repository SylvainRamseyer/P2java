
package ch.hearc.p2.axel.test.tuto;

import org.newdawn.slick.geom.Circle;

public class Vaisseau extends Circle
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Vaisseau(float x, float y, float width, float height, float speedX, float speedY)
		{
		super(x, y, width);

		this.speedX = speedX;
		this.speedY = speedY;
		// TODO Auto-generated constructor stub
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	public float getSpeedX()
		{
		return this.speedX;
		}

	public void setSpeedX(float speedX)
		{
		this.speedX = speedX;
		}

	public float getSpeedY()
		{
		return this.speedY;
		}

	public void setSpeedY(float speedY)
		{
		this.speedY = speedY;
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		return "Vaisseau [speedX=" + this.speedX + ", speedY=" + this.speedY + "] Position = " + x + ";" + y;
		}

	private float speedX;
	private float speedY;
	}
