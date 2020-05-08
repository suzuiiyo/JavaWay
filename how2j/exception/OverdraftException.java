package exception;

public class OverdraftException extends Exception {
    private double deficit;
    public OverdraftException(){
    }
    public OverdraftException(String msg, double bal){
        super(msg);
        double deficit = this.getDeficit(bal);
        System.out.println("͸֧���Ϊ" + deficit);
    }

    public double getDeficit(double bal){
        deficit = -bal;
        return deficit;
    }
}
