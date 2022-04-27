package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{
	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
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
			//System.out.println(n);
		}
	}


	public void draw()
	{	
		nematodes.get(0).render(this);
	}
}
