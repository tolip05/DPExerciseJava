package srcc;

import srcc.commands.Command;
import srcc.commands.CommandExecutor;
import srcc.commands.Executor;
import srcc.interfaces.Target;
import srcc.logger.CombatLogger;
import srcc.logger.ErrorLogger;
import srcc.logger.EventLogger;
import srcc.logger.Handler;
import srcc.mediator.AttackGroup;
import srcc.mediator.Group;
import srcc.mediator.GroupTargetCommand;
import srcc.models.Monster;
import srcc.models.Warrior;


public class Main {
    public static void main(String[] args) {
        Handler combatLogger = new CombatLogger();
        Handler errorLogger = new ErrorLogger();
        Handler eventLogger = new EventLogger();
        combatLogger.setSuccessor(errorLogger);
        errorLogger.setSuccessor(eventLogger);

//        Attacker warrior = new Warrior("Petko",10,combatLogger);
        Target target = new Monster("Gosho",100,10,eventLogger);
        Executor commandExecutor = new CommandExecutor();
//        commandExecutor.executeCommand(new TargetAndAttackCommand(warrior,target));
        AttackGroup group = new Group();
        group.addMember(new Warrior("Pesho",10,combatLogger));
        group.addMember(new Warrior("Stamat",15,combatLogger));
        Command groupTarget = new GroupTargetCommand(group,target);
        commandExecutor.executeCommand(groupTarget);

    }
}
