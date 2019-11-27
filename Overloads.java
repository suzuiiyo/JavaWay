public class Overloads{
    String uniqueID;
    public int addNums(int a, int b){
        return a + b;
    }
    public double addNum(double a, double b){
        return a + b;
    }
    public void setUniqueID(String theID){
        //lots of validation code, adn then:
        uniqueID = theID;
    }
    public void setUniqueID(int ssNumber){
        String numString = "" + ssNumber;
        setUniqueID(numString);
    }
    public static void main(String[] args){
        System.out.println("uniqueID");
    }
}


