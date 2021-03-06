
package ch.hearc.p2.Items.experimental;

import java.util.List;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;

import ch.hearc.p2.tools.Tools;

public class Station extends Circle
	{


	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public Station(float centerPointX, float centerPointY, float radius)
		{
		super(centerPointX, centerPointY, radius);
		turret = new Turret(centerPointX, centerPointY, radius / 3);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	public void draw(Graphics g)
		{
		g.drawImage(Station.image, this.getCenterX() - (Station.image.getWidth() / 2), this.getCenterY() - Station.image.getHeight() / 2);
		turret.draw(g);
		g.resetTransform();
		}

	public void openFireMainTurret(List<Projectile> listeProjectile)
		{
		listeProjectile.add(turret.shoot());
		}

	public void ceaseFireMainTurret()
		{
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	public void setTurretDirection(float angle)
		{
		turret.setDirection(angle);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	public float getTurretDirection()
		{
		return turret.getDirection();
		}

	//TODO � supprimer quand les test sont a jour /retrocompatibiliter)
	public Image getTurretImage()
		{
		return Turret.image;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private Turret turret;
	public static final Image image = Tools.loadImage("res/ufoRed.png");

	}
