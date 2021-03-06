
package ch.hearc.p2.Items.experimental;

import java.util.concurrent.atomic.AtomicBoolean;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;

import ch.hearc.p2.tools.Tools;

public class Turret extends Circle implements Runnable
	{
	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Turret(float centerPointX, float centerPointY, float radius)
		{
		super(centerPointX, centerPointY, radius);
		power = 1;
		speed = 1;
		rateFire = 1;
		direction = 0;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void run()
		{
		//TODO
		getRateFire();
		}

	public Projectile shoot()
		{
		return new Projectile(this.getCenterX(), this.getCenterY(), 1, power, speed, getDirection());
		}

	public void draw(Graphics g)
		{
		g.rotate(this.getCenterX(), this.getCenterY(), 180 + (float)Math.toDegrees(getDirection()));
		g.drawImage(image, this.getCenterX() - (image.getWidth() / 2), this.getCenterY());
		g.drawImage(imageHat, this.getCenterX() - (imageHat.getWidth() / 2), this.getCenterY() - imageHat.getHeight() / 2);
		g.resetTransform();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	public synchronized void setDirection(float value)
		{
		direction = value;
		}

	public synchronized void setRateFire(float value)
		{
		rateFire = value;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	public synchronized float getDirection()
		{
		return direction;
		}

	public synchronized float getRateFire()
		{
		return rateFire;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private int power;
	private int speed;
	private AtomicBoolean fire;
	private float rateFire;
	private float direction; // that an angle in radian
	public static final Image image = Tools.loadImage("res/Parts/gun00.png");
	public static final Image imageHat = Tools.loadImage("res/Parts/turretBase_small.png");
	//private Thread fireSquance;
	}
