package exception;

public class IndexOutOfRangeException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public IndexOutOfRangeException() {

    };
    public IndexOutOfRangeException(String msg){
        super(msg);
    };
}