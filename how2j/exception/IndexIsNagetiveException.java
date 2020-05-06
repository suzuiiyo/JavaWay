package exception;

public class IndexIsNagetiveException extends Exception {
    public IndexIsNagetiveException(){
    }

    public IndexIsNagetiveException(int pos){
        super(pos);
    }
}