package ie.tudublin;

import processing.data.TableRow;

public class Nematode
{
    private String name;
    private int length;
    private boolean limbs;
    private String gender;
    private boolean eyes;


    @Override
    public String toString()
    {
        return "Nematode - Name: " + name + ", Length: " + length + ", Limbs: " + limbs + ", Gender: " + gender + ", Eyes: " + eyes;
    }

    public Nematode(TableRow tr)
    {
        this(
            tr.getString("name"),
            tr.getInt("length"),
            tr.getInt("limbs") == 1,
            tr.getString("gender"),
            tr.getInt("eyes") == 1
        );
    }

    //constructor
    public Nematode(String name, int length, boolean limbs, String gender, boolean eyes)
    {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }

    

    public void render(NematodeVisualiser pa, float c)
    {
        final float CIRCLE_WIDTH = pa.width/22;
        final float LINE_WIDTH = CIRCLE_WIDTH / 10;

        final float CIRCLE_X = pa.width/2;
        
        
        
        float circleY;

        float eyeX, eyeY;

        pa.colorMode(pa.HSB);
        
        pa.fill(c, 255, 255);
        
        //write name
        pa.textAlign(pa.CENTER);
        pa.textSize(40);
        pa.text(name, CIRCLE_X, pa.height/4);

        pa.noStroke();
        
        //draw circles top to bottom
        for(int i = 0; i < length; i++)
        {
            pa.fill(c, 255, 255);
            
            circleY = pa.height/2 + (i * (CIRCLE_WIDTH/2 + (CIRCLE_WIDTH- LINE_WIDTH)/2));

            //draw limbs
            if(limbs == true)
            {
                pa.stroke(c, 255, 255);
                pa.strokeWeight(LINE_WIDTH);

                pa.line(CIRCLE_X - CIRCLE_WIDTH, circleY, CIRCLE_X + CIRCLE_WIDTH, circleY);
            }
            pa.noStroke();

            //draw eyes
            if(eyes == true && i == 0)
            {
                pa.stroke(c, 255, 255);

                //eye one
                eyeX = CIRCLE_X - (CIRCLE_WIDTH * 0.75f);
                eyeY = circleY - (CIRCLE_WIDTH * 0.75f);

                pa.line(CIRCLE_X, circleY, eyeX, eyeY);

                
                pa.fill(0);
                pa.circle(eyeX, eyeY, LINE_WIDTH*2);


                //eye two
                eyeX = CIRCLE_X + (CIRCLE_WIDTH * 0.75f);
                eyeY = circleY - (CIRCLE_WIDTH * 0.75f);

                pa.line(CIRCLE_X, circleY, eyeX, eyeY);

                pa.fill(0);
                pa.circle(eyeX, eyeY, LINE_WIDTH*2);

            }
            pa.noStroke();

            
            //draw gender
            if(i == length-1 && gender == "m")  
            {
                eyeX = CIRCLE_X;
                eyeY = circleY + CIRCLE_WIDTH;

                pa.stroke(c, 255, 255);
                pa.strokeWeight(LINE_WIDTH);
                pa.line(CIRCLE_X, circleY, eyeX, eyeY);

            }
            pa.noStroke();

            //draw circle
            pa.fill(c, 255, 255);
            pa.circle(CIRCLE_X, circleY, CIRCLE_WIDTH);
            pa.fill(0);
            pa.circle(CIRCLE_X, circleY, CIRCLE_WIDTH - (LINE_WIDTH*2));

            

        }

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isLimbs() {
        return this.limbs;
    }

    public boolean getLimbs() {
        return this.limbs;
    }

    public void setLimbs(boolean limbs) {
        this.limbs = limbs;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isEyes() {
        return this.eyes;
    }

    public boolean getEyes() {
        return this.eyes;
    }

    public void setEyes(boolean eyes) {
        this.eyes = eyes;
    }


}
