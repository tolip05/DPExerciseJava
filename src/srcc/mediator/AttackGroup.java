package srcc.mediator;

import srcc.interfaces.Attacker;
import srcc.interfaces.Target;

public interface AttackGroup {
    void addMember(Attacker attacker);
    void groupTarget(Target target);
    void groupAttack();
}
