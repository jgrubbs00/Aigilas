package aigilas.statuses.impl;

import aigilas.creatures.ICreature;
import aigilas.creatures.StatBuff;
import aigilas.creatures.StatType;
import aigilas.statuses.IStatus;

public class SlowDownStatus extends IStatus {
	public SlowDownStatus(ICreature target)

	{
		super(target);

		_buff = new StatBuff(StatType.MOVE_COOL_DOWN, 10);
		_buffMax = true;
		Setup();
	}
}