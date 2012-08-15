package com.aigilas.strategies;

public abstract class Strategy
{
    // max = 15
    public static final int Null = -1;
    public static final int Attack = 0;
    public static final int ControlledByPlayer = 1;
    public static final int Confused = 2;
    public static final int ConfusedAndDying = 15;
    public static final int MinionRotate = 3;
    public static final int MinionFire = 4;
    public static final int MinionExplode = 5;
    public static final int MinionCloud = 6;
    public static final int Mutiny = 7;
    public static final int Flee = 8;
    public static final int AttackSelf = 9;
    public static final int MinionOneUse = 10;
    public static final int StraightLineRotate = 11;
    public static final int StraightLine = 12;
    public static final int TestBot = 13;
}