package exception;

public class NullPointerException extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = 6018434167784732630L;

    public NullPointerException() {

    }
    public NullPointerException(String msg){
        super(msg);
    }
}