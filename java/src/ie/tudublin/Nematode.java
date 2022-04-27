package ie.tudublin;

public class Nematode
{
    private String name;
    private int length;
    private boolean limbs;
    private char gender;
    private boolean eyes;

    //constructor
    public Nematode(String name, int length, boolean limbs, char gender, boolean eyes)
    {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }

    @Override
    public String toString()
    {
        return "Nematode - Name: " + name + ", Length: " + length + ", Limbs: " + limbs + ", Gender: " + gender + ", Eyes: " + eyes;
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

    public char getGender() {
        return this.gender;
    }

    public void setGender(char gender) {
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
