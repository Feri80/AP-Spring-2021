public class Main
{
	public static void delay()
	{
		for(int i=0;i<100000;i++)
		{
			for(int j=0;j<50000;j++)
			{
				for(int k=0;k<10;k++);
			}
		}
	}

	public static void main(String args[])
	{
		Simulator s = new Simulator();
		while(true)
		{
			s.simulateOneStep();
			delay();
		}
	}

}
