
package ch.hearc.p2.sylvain.test.slick;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class UseSimleSlickGame
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		try
			{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SimpleSlickGame("Simple Slick Game"));
			appgc.setDisplayMode(1900, 1000,false);
			appgc.setTargetFrameRate(60);
			appgc.start();
			}
		catch (SlickException ex)
			{
			Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
