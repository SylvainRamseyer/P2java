
package ch.hearc.p2.sylvain.test.slick;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import ch.hearc.p2.Items.experimental.Meteor;
import ch.hearc.p2.Items.experimental.Projectile;
import ch.hearc.p2.Items.experimental.Station;
import ch.hearc.p2.tools.Tools;

public class SimpleSlickGame extends BasicGame
	{


	public SimpleSlickGame(String gamename)
		{
		super(gamename);
		semProjectiles = new Semaphore(1);
		}

	@Override
	public void init(GameContainer gc) throws SlickException
		{
		border = new Rectangle(-50, -50, gc.getWidth() + 50, gc.getHeight() + 50);
		listeFormes = new LinkedList<Meteor>();
		listeProjectile = new LinkedList<Projectile>();

		station = new Station(950, 500, 100);

		placeItems(listeFormes);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void placeItems(List<Meteor> listeFormes2)
		{
		Random rnd = new Random();
		float vitesseX;
		float vitesseY;

		int pos = 0;
		for(int i = 0; i < NBRECT / 2; i++)
			{
			pos += 80;
			vitesseX = rnd.nextFloat() - 0.5f;
			vitesseY = rnd.nextFloat() - 0.5f;
			listeFormes2.add(new Meteor(300, i * 92, 35, 45, vitesseX, vitesseY));
			}

		pos = 0;
		for(int i = NBRECT / 2; i < NBRECT; i++)
			{
			pos += 92;
			vitesseX = rnd.nextFloat() - 0.5f;
			vitesseY = rnd.nextFloat() - 0.5f;
			listeFormes2.add(new Meteor(1600, pos, 35, 45, vitesseX, vitesseY));
			}
		}

	/*------------------------------------------------------------------*\
	|*							Controls Methodes						*|
	\*------------------------------------------------------------------*/
	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy)
		{
		//TODO taille dynamique
		station.setTurretDirection(Tools.getAngle(newx - 1900 / 2, -1 * (newy - 1000 / 2)));
		}

	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy)
		{
		//TODO taille dynamique
		station.setTurretDirection(Tools.getAngle(newx - 1900 / 2, -1 * (newy - 1000 / 2)));
		}

	@Override
	public void mouseReleased(int button, int x, int y)
		{
		station.ceaseFireMainTurret();
		}

	@Override
	public void mousePressed(int button, int x, int y)
		{
		try
			{
			semProjectiles.acquire();
			station.openFireMainTurret(listeProjectile);
			semProjectiles.release();
			}
		catch (InterruptedException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void update(GameContainer gc, int deltaTime) throws SlickException
		{
		try
			{
			semProjectiles.acquire();
			collide(deltaTime);
			borderguard();
			semProjectiles.release();
			}
		catch (InterruptedException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}

	private void borderguard()
		{
		boolean endOfList = false;
		int i = 0;

		while(!endOfList)
			{
			if (!border.intersects(listeFormes.get(i)))
				{
				listeFormes.remove(i);
				//i--;
				}
			else
				{
				i++;
				}
			endOfList = i >= listeFormes.size();
			}
		//System.out.println("Nombre de formes dedans la frontiere : " + listeFormes.size());
		}

	private void collide(int deltaTime)
		{
		Meteor forme;
		Meteor formeCollision;

		for(int i = 0; i < listeFormes.size(); i++)
			{
			forme = listeFormes.get(i);

			int j = 0;
			boolean intersect = false;

			while((!intersect) && (j < listeFormes.size() - 1))
				{
				if (i != j)
					{
					formeCollision = listeFormes.get(j);
					intersect = (forme.intersects(formeCollision));
					if (!intersect)
						{
						j++;
						}
					}
				else
					{
					j++;
					}
				}

			if (!intersect)
				{
				forme.setCenterX(forme.getCenterX() + forme.getSpeedX() * deltaTime);
				forme.setCenterY(forme.getCenterY() + forme.getSpeedY() * deltaTime);
				}
			}

		for(Projectile p:listeProjectile)
			{
			p.setCenterX(p.getCenterX() + p.getSpeedX() * deltaTime);
			p.setCenterY(p.getCenterY() + p.getSpeedY() * deltaTime);
			}
		}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
		{
		try
			{
			semProjectiles.acquire();
			draw(g);
			semProjectiles.release();
			}
		catch (InterruptedException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		g.resetTransform();
		}

	private void draw(Graphics g)
		{
		station.draw(g);

		for(Meteor forme:listeFormes)
			{
			forme.draw(g);
			}

		for(Projectile p:listeProjectile)
			{
			p.draw(g);
			}
		}

	@Override
	public void keyReleased(int key, char c)
		{
		if (Input.KEY_ESCAPE == key)
			{
			container.exit();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private GameContainer container;
	private Station station;
	private List<Meteor> listeFormes;
	private List<Projectile> listeProjectile;
	private Rectangle border;
	private static final int NBRECT = 200;
	private Semaphore semProjectiles;
	}
