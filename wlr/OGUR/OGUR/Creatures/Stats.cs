﻿using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

namespace OGUR.Creatures
{
    public class Stats
    {
        public const float DefaultMoveSpeed = Sprites.SpriteInfo.Height;
        public const float DefaultCoolDown = 18;
        private readonly Dictionary<StatType, float> m_stats = new Dictionary<StatType, float>();
        private readonly List<StatBuff> m_buffs = new List<StatBuff>(); 

        public Stats(Stats target)
        {
            m_stats = new Dictionary<StatType, float>(target.m_stats);
        }
        public Stats
            (
                float health,
                float mana,
                float strength,
                float wisdom,
                float defense,
                float luck,
                float age,
                float weightInLbs,
                float heightInFeet,
                float moveCoolDown = DefaultCoolDown
            )
        {
            Setup(new List<float>{health, mana, strength, wisdom, defense,luck, age,weightInLbs, heightInFeet, moveCoolDown,0});
        }

        private void Setup(List<float> stats )
        {
            for (var ii = 0; ii < stats.Count; ii++)
            {
                m_stats.Add((StatType)OGUR.Util.EnumUtil.GetValues(typeof(StatType))[ii], stats[ii]);
            }
        }
        private float statSum = 0;
        public float Get(StatType stat)
        {
            if (m_buffs != null)
            {
                if (!m_buffs.Contains(null))
                {
                    statSum = 0;
                    for (int ii = 0; ii < m_buffs.Count(); ii++)
                    {
                        if (m_buffs[ii].Stat == stat)
                        {
                            statSum += m_buffs[ii].Amount;
                        }
                    }
                    return GetRaw(stat) + statSum;
                }
            }
            return GetRaw(stat);
        }

        public float GetRaw(StatType stat)
        {
            return m_stats[stat];
        }

        public float Set(StatType stat, float value)
        {
            return m_stats[stat] = value;
        }

        public void AddBuff(StatBuff buff)
        {
            if(m_buffs.Contains(buff))
            {
                m_buffs.Remove(buff);
                return;
            }
            m_buffs.Add(buff);
        }

        public IEnumerable GetDeltas(Stats stats)
        {
            return m_stats.Select((t, ii) => m_stats[(StatType) ii] - stats.m_stats[(StatType) ii]);
        }

        public Stats GetLevelBonuses(int level)
        {
            var result = new Stats(this);
            foreach(var stat in result.m_stats.Keys)
            {
                result.m_stats[stat] += result.m_stats[stat]*level;
            }
            return result;
        }

        public float GetBonus(int level, StatType stat)
        {
            return m_stats[stat]*level;
        }

        public float GetSum()
        {
            return m_stats.Keys.Where(o=>o!=StatType.HEALTH&&o!=StatType.MOVE_COOL_DOWN).Sum(stat => m_stats[stat]);
        }

        float hash = 0;
        public override int GetHashCode()
        {
            hash = 0;
            foreach(var key in m_stats.Keys)
            {
                hash += m_stats[key];
            }
            return hash.GetHashCode();
        }
    }
}
