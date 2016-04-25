
package ch.hearc.p2.structure.ennemies;

public class productAndConsumeThread implements Runnable
	{


	public productAndConsumeThread(ObjectsStructure structure)
		{
		this.structure = structure;
		}

	public void run()
		{
		for(int j = 0; j < 10; j++)
			{
			System.out.println(Thread.currentThread().getName());
			System.out.println("Ajout :" + structure.add(new Integer(12)));
			System.out.println("Ajout :" + structure.add(new Integer(12)));
			System.out.println("Ajout :" + structure.add(new Integer(14)));
			System.out.println("Ajout :" + structure.add(new Integer(16)));
			System.out.println("Ajout :" + structure.add(new Integer(18)));
			System.out.println("Ajout :" + structure.add(new Integer(12)));
			System.out.println("Ajout :" + structure.add(new Integer(14)));
			System.out.println("Ajout :" + structure.add(new Integer(16)));
			System.out.println("Ajout :" + structure.add(new Integer(18)));

			for(int i = 0; i < structure.getSize(); i++)
				{
				System.out.println("Index : " + i + " Valeur :" + structure.getAtIndex(i));
				}

			System.out.println("Suppression :" + structure.remove(structure.getAtIndex(12)));

			System.out.println(Thread.currentThread().getName());

			try
				{
				Thread.sleep(50);
				}
			catch (InterruptedException e)
				{
				e.printStackTrace();
				}
			}
		}

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

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
	private ObjectsStructure structure;

	}
