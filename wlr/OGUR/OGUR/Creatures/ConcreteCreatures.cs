﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using OGUR.Skills;
using OGUR.Strategies;
using OGUR.Classes;
using OGUR.Sprites;
using Microsoft.Xna.Framework;
using OGUR.GameObjects;

namespace OGUR.Creatures
{
    public class Player : AbstractCreature
    {
        private static readonly List<Color> s_colors = new List<Color>() { Color.Red,Color.Green,Color.Blue,Color.White};
        public Player(int playerIndex): base(CreatureType.PLAYER, SpriteType.PLAYER_STAND, new SlothAcolyte())
        {
            m_playerIndex = playerIndex;
            m_graphic.SetColor(s_colors[m_playerIndex]);
            m_strategy = new ControlledByPlayer(this);
            m_baseStats = new Stats(100f, 100f, 1f, 10f, 10f, 10f, 35f, 50f, 6.0f, 6);
            m_maxStats = new Stats(100f, 100f, 1f, 10f, 10f, 10f, 35f, 50f, 6.0f, 6);
        }
    }
    class Peon : AbstractCreature
    {
        public Peon(): base(CreatureType.PEON)
        {
            Strengths(StatType.MOVE_COOL_DOWN);
            Weaknesses(StatType.STRENGTH, StatType.HEALTH);
            Compose(Elements.EARTH);
        }
    }
    class Zorb : AbstractCreature
    {
        public Zorb(): base(CreatureType.ZORB)
        {
            Compose(Elements.PHYSICAL, Elements.FIRE);
            Strengths(StatType.DEFENSE, StatType.MANA,StatType.HEALTH);
            Weaknesses(StatType.WISDOM);
            Add(SkillId.FIREBALL);
        }
    }
}
