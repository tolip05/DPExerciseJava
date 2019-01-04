package srcc.mediator;

import srcc.commands.Command;
import srcc.interfaces.Target;


public class GroupTargetCommand implements Command {
    private Target target;
    private AttackGroup attackGroup;

    public GroupTargetCommand(AttackGroup attackGroup, Target target) {
        this.target = target;
        this.attackGroup = attackGroup;
    }

    @Override
    public void execute() {
        attackGroup.groupTarget(this.target);
    }
}
