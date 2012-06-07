﻿using OGUR.Creatures;
using OGUR.Skills;
using SPX.Entities;
using SPX.Paths;
using SPX.Core;
using System;

namespace OGUR.Strategies
{
    [Serializable]
    public class TestBotStrategy : IStrategy
    {
        public TestBotStrategy(ICreature parent)
            : base(parent,Strategy.TestBot)
        {
            _targets.AddTargetTypes(ActorType.NONPLAYER);
        }

        private Entity _stairsTarget;
        public override void Act()
        {
            if (RNG.Rand.Next(0, 1000) == 2)
            {
                _parent.CycleActiveSkill(1);
            }
            if (RNG.Rand.Next(0, 100) <= 1)
            {
                _parent.UseActiveSkill();
            }
            if (AbleToMove())
            {
                if (SkillFactory.IsSkill(_parent.GetActiveSkillName(), AnimationType.RANGED))
                {
                    if (opponent != null)
                    {
                        _parent.SetSkillVector(CalculateTargetVector(_parent.GetLocation(), opponent.GetLocation()));
                    }
                    if (_parent.GetSkillVector().GridX != 0 || _parent.GetSkillVector().GridY != 0)
                    {
                        _parent.UseActiveSkill();
                    }
                }
                if (targetPath.HasMoves())
                {
                    nextMove.Copy(targetPath.GetNextMove());
                    _parent.MoveTo(nextMove);
                    if (_stairsTarget != null && HitTest.IsTouching(_parent, _stairsTarget))
                    {
                        _parent.SetInteracting(true);
                    }
                    else
                    {
                        _parent.SetInteracting(false);
                    }
                }
            }
            else
            {
                if ((targetPath == null || !targetPath.HasMoves()) && EntityManager.GetObjects(EntityType.ACTOR).Count == 1)
                {
                    _stairsTarget = EntityManager.GetObject(EntityType.DOWNSTAIRS);
                    if (_stairsTarget != null)
                    {
                        targetPath.Copy(PathFinder.FindNextMove(_parent.GetLocation(), _stairsTarget.GetLocation()));
                    }
                }
            }
        }
    }
}