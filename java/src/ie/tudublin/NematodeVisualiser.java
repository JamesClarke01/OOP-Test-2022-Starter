package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{
	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();

	int currentNematode;

	public void keyPressed()
	{		
		if (keyCode == RIGHT)
		{
			currentNematode +=  1;
		}
		if (keyCode == LEFT)
		{
			currentNematode -=  1;
		}

		if (currentNematode < 0)
		{
			currentNematode = nematodes.size() -1;
		}
		else if (currentNematode > nematodes.size()-1)
		{
			currentNematode = 0;
		}
		

	}


	public void settings()
	{
		size(1200, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();
		
		loadNematodes();
	}
	

	public void loadNematodes()
	{
		Table table = loadTable("nematodes.csv", "header");

		for(TableRow r:table.rows())
		{
			Nematode n = new Nematode(r);
			nematodes.add(n);
		}
	}


	public void draw()
	{	
		background(0);
		nematodes.get(currentNematode).render(this, map(currentNematode, 0,  nematodes.size()-1, 0, 255));
	}
}
