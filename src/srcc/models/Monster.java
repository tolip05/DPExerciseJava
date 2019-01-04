package srcc.models;

import srcc.constants.Constant;
import srcc.interfaces.Target;
import srcc.logger.Handler;
import srcc.logger.LogType;

public class Monster implements Target {

    private String name;
    private int hp;
    private int reward;
    private boolean eventTriggered;
    private Handler logger;

    public Monster(String name, int hp, int reward, Handler logger) {
        this.name = name;
        this.hp = hp;
        this.reward = reward;
        this.logger = logger;
    }

    @Override
    public void reciveDamage(int dmg) {
        if (!this.isDead()){
            this.hp -= dmg;
        }else if(this.isDead() && !eventTriggered){
            this.logger.handle(LogType.EVEN,String.format(Constant.THIS_DIED_EVENT,this));
        this.eventTriggered = true;
        }
    }

    @Override
    public boolean isDead() {
        return this.hp <= 0;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
