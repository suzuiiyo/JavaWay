package multithreading;

import charactor.Hero;
import exception.EnemyHeroIsDeadException;

public class KillThread extends Thread {
    private Hero h1;
    private Hero h2;

    public KillThread(Hero h1, Hero h2) {
        this.h1 = h1;
        this.h2 = h2;
    }

    public void run() {
        while (!h2.isDead()) {
            try {
                h1.attackHero(h2);
            } catch (EnemyHeroIsDeadException e) {
                e.printStackTrace();
            }
        }
    }
}