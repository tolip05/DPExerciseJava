package srcc.models;

import srcc.abstracts.AbstractHero;
import srcc.constants.Constant;
import srcc.interfaces.Target;
import srcc.logger.Handler;
import srcc.logger.LogType;

public class Warrior extends AbstractHero {
    public Warrior(String name, int dmg, Handler handler) {
        super(name, dmg, handler);
    }

    @Override
    protected void executeClassSpecificAttack(Target target, int dmg, Handler logger) {
        logger.handle(LogType.ATTACK,String.format(Constant.ATTACK_MESSAGE,this,target,dmg));
    }
}
