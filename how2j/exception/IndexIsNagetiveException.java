package exception;

public class IndexIsNagetiveException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public IndexIsNagetiveException() {
    }

    public IndexIsNagetiveException(String msg){
        super(msg);
    }
}