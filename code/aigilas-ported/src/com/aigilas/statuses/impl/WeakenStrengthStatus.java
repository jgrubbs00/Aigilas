package com.aigilas.statuses.impl;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.xna.wrapper.*;import java.util.*;import com.aigilas.creatures.*;import com.aigilas.strategies.*;import com.aigilas.entities.*;import com.aigilas.skills.*;import com.spx.core.*;    public class WeakenStrengthStatus  extends  IStatus    {        public WeakenStrengthStatus(ICreature target)            { super(target);            _buff = new StatBuff(StatType.STRENGTH, -10);            Setup();        }    }