package aigilas.reactions.impl;

import aigilas.creatures.ICreature;
import aigilas.creatures.StatType;
import aigilas.reactions.IReaction;

public class MindBlownReaction implements IReaction {
	@Override
	public void Affect(ICreature target)

	{
		target.ApplyDamage(10, null, true, StatType.MANA);
	}
}