public class Individual
{
	static int defaultGeneLength = GA.size;
	private byte[] genes = new byte[defaultGeneLength];

	private int fitness = 0;

	// Create a random individual
	public void generateIndividual()
	{
		for (int i = 0; i < GA.items.length; i++)
		{
			byte gene = (byte) Math.round(Math.random());
			
			if(gene == 1 && getFitness() + GA.items[i] > 2000)
			{
				gene = 0;
			}
			
			genes[i] = gene;
		}
	}

	/* Getters and setters */
	// Use this if you want to create individuals with different gene lengths
	public static void setDefaultGeneLength(int length)
	{
		defaultGeneLength = length;
	}

	public byte getGene(int index)
	{
		return genes[index];
	}

	public void setGene(int index, byte value)
	{
		genes[index] = value;
		fitness = 0;
	}

	/* Public methods */
	public int size()
	{
		return GA.items.length;
	}

	public int getFitness()
	{
		if (fitness == 0)
		{
			fitness = FitnessCalc.getFitness(this);
		}
		return fitness;
	}

	@Override
	public String toString()
	{
		String geneString = "";
		for (int i = 0; i < size(); i++)
		{
			geneString += getGene(i);
		}
		return geneString;
	}
}