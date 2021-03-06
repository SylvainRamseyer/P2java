
package ch.hearc.p2.axel.test.tuto;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import ch.hearc.p2.Items.experimental.Meteor;
import ch.hearc.p2.Items.experimental.Projectile;

public class SimpleSlickGame extends BasicGame
	{


	public SimpleSlickGame(String gamename)
		{
		super(gamename);
		}

	@Override
	public void init(GameContainer gc) throws SlickException
		{
		border = new Rectangle(-50, -50, gc.getWidth() + 50, gc.getHeight() + 50);
		listeFormes = new LinkedList<Meteor>();
		listeProjectile = new LinkedList<Projectile>();

		station = new Meteor(950, 500, 100, 100, 0f, 0f);
		listeFormes.add(station);

		placeVaisseaux(listeFormes);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void placeVaisseaux(List<Meteor> listeFormes2)
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
			listeFormes2.add(new Meteor(300, i * 60, 20, 20, vitesseX, vitesseY));
			}

		pos = 0;
		for(int i = NBRECT / 2; i < NBRECT; i++)
			{
			pos += 80;
			vitesseX = rnd.nextFloat() - 0.5f;
			vitesseY = rnd.nextFloat() - 0.5f;
			listeFormes2.add(new Meteor(1600, pos, 12, 25, vitesseX, vitesseY));
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void update(GameContainer gc, int deltaTime) throws SlickException
		{
		collide(deltaTime);
		borderguard();
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
		}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
		{
		draw(g);
		g.resetTransform();
		}

	private void draw(Graphics g)
		{
		Image image = listeFormes.get(0).getImage();
		for(Meteor forme:listeFormes)
			{
			g.rotate(forme.getCenterX(), forme.getCenterY(), forme.updateAngle());
			g.drawOval(forme.getX(), forme.getY(), forme.getWidth(), forme.getHeight());
			g.drawImage(image, forme.getCenterX() - (image.getWidth() / 2), forme.getCenterY() - image.getHeight() / 2);
			g.resetTransform();
			}
		}


	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {

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
	private Meteor station;
	private List<Meteor> listeFormes;
	private List<Projectile> listeProjectile;
	private Rectangle border;
	private static final int NBRECT = 200;
	}
