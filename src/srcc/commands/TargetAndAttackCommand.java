package srcc.commands;

import srcc.interfaces.Attacker;
import srcc.interfaces.Target;

public class TargetAndAttackCommand implements Command {

    private Attacker attacker;
    private Target target;

    public TargetAndAttackCommand(Attacker attacker, Target target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attacker.setTarget(this.target);
        this.attacker.attack();
    }
}
