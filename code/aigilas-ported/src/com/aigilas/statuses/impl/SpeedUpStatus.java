package com.aigilas.statuses.impl;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.aigilas.statuses.*;;import com.xna.wrapper.*;import java.util.*;import com.aigilas.creatures.*;import com.aigilas.strategies.*;import com.aigilas.entities.*;import com.aigilas.skills.*;import com.spx.core.*;    public class SpeedUpStatus extends  IStatus    {        public SpeedUpStatus(ICreature target){        	super(target);            _buff = new StatBuff(StatType.MOVE_COOL_DOWN, 5f);            Setup();        }    }