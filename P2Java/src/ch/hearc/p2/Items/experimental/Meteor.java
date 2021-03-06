
package ch.hearc.p2.Items.experimental;

import java.util.Random;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;

import ch.hearc.p2.tools.Tools;

public class Meteor extends Circle
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Meteor(float x, float y, float width, float height, float speedX, float speedY)
		{
		super(x, y, width);

		this.speedX = speedX;
		this.speedY = speedY;
		this.angleAlpha = new Random().nextFloat() * 360;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	public void draw(Graphics g)
		{
		g.rotate(this.getCenterX(), this.getCenterY(), this.updateAngle());
		g.drawImage(image, this.getCenterX() - (image.getWidth() / 2), this.getCenterY() - image.getHeight() / 2);
		g.resetTransform();
		}

	@Override
	public String toString()
		{
		return "Meteor [speedX=" + this.speedX + ", speedY=" + this.speedY + "] Position = " + x + ";" + y;
		}

	public float updateAngle()
		{
		angleAlpha += 0.1;
		return angleAlpha % 360;
		}



	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	public void setSpeedX(float speedX)
		{
		this.speedX = speedX;
		}

	public void setSpeedY(float speedY)
		{
		this.speedY = speedY;
		}
	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	public float getSpeedX()
		{
		return this.speedX;
		}

	public float getSpeedY()
		{
		return this.speedY;
		}

	//TODO rétrocompatiblité a supprimer quand tout le monde est ŕ jour
	public Image getImage()
		{
		return Meteor.image;
		}


	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private float speedX;
	private float speedY;
	public static final Image image = Tools.loadImage("res/Meteors/meteorBrown_big1.png");
	private float angleAlpha;
	}
