package com.aigilas.creatures;
    public class BreakingWheel  extends  AbstractCreature
    {
        public BreakingWheel()
            {
            _composition.add(Elements.DARK);
            Strengths(StatType.MOVE_COOL_DOWN, StatType.MOVE_COOL_DOWN);
        }
    }