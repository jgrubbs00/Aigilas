﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using OGUR.Sprites;
using OGUR.Management;
using OGUR.Dungeons;
using OGUR.Creatures;

namespace OGUR.GameObjects
{
    public class Upstairs : GameplayObject
    {
        public Upstairs(int x, int y)
        {
            Initialize(x, y, SpriteType.UPSTAIRS, GameObjectType.UPSTAIRS);
        }
        public Location GetTargetLocation()
        {
            return Location.Depths;
        }

        public override void  Update()
        {
            var player = GameplayObjectManager.GetTouchingPlayer(this);
            if(player!=null)
            {
                if (player.IsInteracting())
                {
                    player.PerformInteraction();
                    DungeonFactory.GetPreviousFloor(GetTargetLocation());
                }    
            }
        }
    }
}