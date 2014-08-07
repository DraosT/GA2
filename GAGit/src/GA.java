public class GA
{
	static int size = 2000;
	static int items[] = {3, 121, 345, 34, 67, 380, 223, 169, 10, 12, 56, 22, 52, 499, 419, 442, 99, 7, 29, 30, 144, 26, 2, 676, 147, 8, 188, 16};
	//////////////////////0, 0--, 1--, 1-, 1-, 1--, 0--, 0--, 0-, 0-, 0-, 1-, 1-, 1--, 1--, 0--, 1-, 0, 1-, 1-, 0--, 0-, 0, 0--, 0--, 1, 0--. 1
	public static void main(String[] args)
	{
		// Create an initial population
		Population myPop = new Population(50, true);

		// Evolve our population until we reach an optimum solution
		int generationCount = 0;
		int times = 0;
		int last = -1;

		while (myPop.getFittest().getFitness() <= FitnessCalc.getMaxFitness())
		{
			if(last == myPop.getFittest().getFitness())
			{
				times++;
			}
			else
			{
				times = 0;
			}
			
			generationCount++;
			System.out.println("Generation: " + generationCount + " Fittest: "+ myPop.getFittest().getFitness());
			last = myPop.getFittest().getFitness();
			myPop = Algorithm.evolvePopulation(myPop);
			
			if(times == 25)
			{
				break;
			}
		}
		
		System.out.println("Solution found!");
		System.out.println("Generation: " + generationCount);
		System.out.println("Genes:");
		System.out.println(myPop.getFittest());

	}
}