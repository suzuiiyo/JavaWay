package exception;

public class EnemyHeroIsDeadException extends Exception{
    /**
        default serial version number
     */
    private static final long serialVersionUID = 1L;;
    public EnemyHeroIsDeadException(){

    }
    public EnemyHeroIsDeadException(String msg){
        super(msg);
    }
}