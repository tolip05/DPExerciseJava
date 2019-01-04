package srcc.abstracts;

import srcc.constants.Constant;
import srcc.interfaces.Attacker;
import srcc.interfaces.Target;
import srcc.logger.Handler;
import srcc.logger.LogType;

public abstract class AbstractHero implements Attacker {
    private String name;
    private int dmg;
    private Handler handler;
    private Target target;

    public AbstractHero(String name, int dmg,Handler handler) {
        this.name = name;
        this.dmg = dmg;
        this.handler = handler;
    }

    @Override
    public void setTarget(Target target) {
        if (target == null){
            this.handler.handle(LogType.ERROR,Constant.TARGET_NULL_MESSAGE);
        }else{
            this.target = target;
            this.handler.handle(LogType.TARGET,String.format(Constant.SET_TARGET_MESSAGE,this,target));
        }
    }

    @Override
    public void attack() {
       if (this.target == null){
           this.handler.handle(LogType.ERROR,String.format(Constant.NO_TARGET_MESSAGE,this));
       }else if (this.target.isDead()){
           this.handler.handle(LogType.ERROR,String.format(Constant.TARGET_DEAD_MESSAGE,target));
       }else{
           this.executeClassSpecificAttack(this.target,this.dmg,this.handler);
        }
    }

    @Override
    public String toString() {
        return this.name;
    }

    protected abstract void executeClassSpecificAttack(Target target, int dmg, Handler logger);
}
