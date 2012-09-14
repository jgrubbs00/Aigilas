package aigilas.creatures;

import spx.bridge.ActorType;
import aigilas.entities.Elements;
import aigilas.skills.SkillId;
import aigilas.strategies.Strategy;
import aigilas.strategies.StrategyFactory;

public class DartTrap extends Minion {
	public DartTrap() {
		super(ActorType.MINION);
		_strategy = StrategyFactory.Create(Strategy.MinionFire, this);
		Add(SkillId.DART);
		_composition.add(Elements.DARK);
	}
}