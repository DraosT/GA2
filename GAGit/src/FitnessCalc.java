public class FitnessCalc
{
	// Calculate inidividuals fittness by comparing it to our candidate solution
	static int getFitness(Individual individual)
	{
		int fitness = 0;
		// Loop through our individuals genes and compare them to our cadidates
		for (int i = 0; i < individual.size(); i++)
		{
			if (individual.getGene(i) == 1)
			{
				fitness+=GA.items[i];
			}
		}
		return fitness;
	}

	// Get optimum fitness
	static int getMaxFitness()
	{
		return GA.size;
	}
}
