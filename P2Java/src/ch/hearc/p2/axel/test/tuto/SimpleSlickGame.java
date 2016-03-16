
package ch.hearc.p2.axel.test.tuto;

import java.util.LinkedList;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class SimpleSlickGame extends BasicGame
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public SimpleSlickGame(String gamename)
		{
		super(gamename);
		}

	@Override
	public void init(GameContainer gc) throws SlickException
		{
		rectangle1 = new Rectangle(10, 10, 50, 50);
		rectangle2 = new Rectangle(200, 10, 50, 50);

		for(int i = 1; i <= 50; i++)
			{
			listFormes.add(new Rectangle(20, i * 50, 50, 50));
			}
		}

	@Override
	public void update(GameContainer gc, int deltaTime) throws SlickException
		{
		boolean intersect;

		for(Rectangle forme:listFormes)
			{
			intersect = true;
			for(Rectangle formeCollision:listFormes)
				{
				intersect = (forme.intersects(formeCollision)) && (forme.contains(formeCollision));
				}
			if (!intersect)
				{
				forme.setCenterX(forme.getCenterX() + SPEED * deltaTime);
				}
			}

		if (!rectangle1.intersects(rectangle2))
			{
			rectangle1.setCenterX(rectangle1.getCenterX() + SPEED * deltaTime);
			}
		}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
		{
		g.drawString("Howdy!", 100, 100);
		g.drawRect(rectangle1.getX(), rectangle1.getY(), rectangle1.getWidth(), rectangle1.getHeight());
		g.drawRect(rectangle2.getX(), rectangle2.getY(), rectangle2.getWidth(), rectangle2.getHeight());

		for(Rectangle forme:listFormes)
			{
			g.drawRect(forme.getX(), forme.getY(), forme.getWidth(), forme.getHeight());
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
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	//Tools
	private GameContainer container;
	private Rectangle rectangle1;
	private Rectangle rectangle2;
	private LinkedList<Rectangle> listFormes = new LinkedList<Rectangle>();

	private static final float SPEED = (float)0.1;
	}
