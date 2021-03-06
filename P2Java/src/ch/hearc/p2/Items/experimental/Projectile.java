
package ch.hearc.p2.Items.experimental;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;

import ch.hearc.p2.tools.Tools;

public class Projectile extends Circle
{

/*------------------------------------------------------------------*\
|*							Constructeurs							*|
\*------------------------------------------------------------------*/

/**
 * @param x position initial
 * @param y position initial
 * @param radius taille du projectile
 * @param dammage
 * @param speed
 * @param direction en radian
 */
public Projectile(float x, float y, float radius,int dammage, float speed, float direction)
	{
	super(x, y, radius);
	this.direction = direction;
	this.speedX = Tools.getXFromAngle(direction)*speed;
	this.speedY = -1*Tools.getYFromAngle(direction)*speed;
	this.dammage = dammage;
	}

/*------------------------------------------------------------------*\
|*							Methodes Public							*|
\*------------------------------------------------------------------*/
public void draw(Graphics g)
	{
	g.rotate(this.getCenterX() - (image.getWidth() / 2), this.getCenterY() - (image.getHeight() / 2), (float)Math.toDegrees(direction));
	g.drawImage(image, this.getCenterX() - (image.getWidth() / 2), this.getCenterY() - image.getHeight() / 2);
	g.resetTransform();
	}

@Override
public String toString()
	{
	return "Meteor [speedX=" + this.speedX + ", speedY=" + this.speedY + "] Position = " + x + ";" + y;
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


/*------------------------------------------------------------------*\
|*							Methodes Private						*|
\*------------------------------------------------------------------*/

/*------------------------------------------------------------------*\
|*							Attributs Private						*|
\*------------------------------------------------------------------*/

private float dammage;
private float speedX;
private float speedY;
private float direction;
public static final Image image = Tools.loadImage("res/Lasers/LaserBlue07.png");
}

