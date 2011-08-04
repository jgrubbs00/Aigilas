﻿using System.Collections.Generic;
using Microsoft.Xna.Framework;
using OGUR.Items;
using OGUR.Sprites;
using OGUR.Management;
using OGUR.Dungeons;
using OGUR.Creatures;
using OGUR.Text;
using OGUR.Gods;
using System.Linq;

namespace OGUR.GameObjects
{
    public class Altar : GameplayObject
    {
        private readonly God m_god;

        public Altar(int x, int y, God.Name godName)
        {
            m_god = God.Get(godName);
            m_graphic.SetColor(m_god.GetColor());
            Initialize(x, y, SpriteType.ALTAR, GameObjectType.ALTAR);
        }

        public override void Update()
        {
            var offerings = GameplayObjectManager.GetObjects(GameObjectType.ITEM).Where(o => Collision.HitTest.IsTouching(this, o)).Cast<GenericItem>().ToList();
            var player = GameplayObjectManager.GetTouchingPlayer(this);
            if (player != null)
            {
                if (player.IsInteracting())
                {
                    player.Pray(m_god);
                }
                foreach (var offering in offerings)
                {
                    player.Sacrifice(m_god, offering);
                }
                TextManager.Add(new ActionText(m_god.ToString(), 1, (int) this.GetPosition().X, (int) this.GetPosition().Y));
            }
        }

        public God GetGod()
        {
            return m_god;
        }
    }
}