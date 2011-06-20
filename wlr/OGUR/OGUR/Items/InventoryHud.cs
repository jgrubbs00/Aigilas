﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using OGUR.Creatures;
using OGUR.Items;
using OGUR.Management;
using OGUR.Text;

namespace OGUR.Storage
{
    public class InventoryHud
    {
        private ICreature m_parent;
        private static Texture2D m_menuBase;
        private bool m_isVisible = false;
        private ItemClass m_currentClass = (ItemClass) 1;
        private int currentItem = 0;
        private Inventory m_inventory;
        private int m_endingItem = 4, m_startingItem = 0;
        private Dictionary<GenericItem, int> m_currentClassItems;
        private TextHandler m_textHandler = new TextHandler();

        public InventoryHud(ICreature owner)
        {
            m_parent = owner;
            m_inventory = owner.GetInventory();
            if (m_menuBase == null)
            {
                m_menuBase = XnaManager.GetContentManager().Load<Texture2D>("MenuBase");
            }
        }

        public void Toggle()
        {
            m_isVisible = !m_isVisible;
        }

        public void LoadContent()
        {
            m_menuBase = XnaManager.GetContentManager().Load<Texture2D>("MenuBase");
        }

        public void Draw()
        {
            var items = m_parent.GetInventory().GetItems(m_currentClass);
            if (m_isVisible)
            {
                SpriteBatch target = XnaManager.GetRenderTarget();
                //target.Begin();
                target.Begin(SpriteSortMode.BackToFront,
                             BlendState.AlphaBlend,
                             null,
                             null,
                             null,
                             null,
                             XnaManager.GetCamera().GetTransformation(XnaManager.GetGraphicsDevice().GraphicsDevice));
                var tempPosition = new Vector2(0, 0);
                target.Draw(m_menuBase, tempPosition, new Rectangle(0, 0, 1, 1), Color.White, 0f, new Vector2(0, 0), new Vector2(XnaManager.WindowWidth / 2, XnaManager.WindowHeight / 2), SpriteEffects.None, 0f);
                target.End();
                m_textHandler.Draw();
            }
        }

        private void HandleInput()
        {
            if (InputManager.IsPressed(InputManager.Commands.InventoryLeft, m_parent.GetPlayerIndex()))
            {
                m_currentClass--;
                if (m_currentClass <= (ItemClass)0)
                {
                    m_currentClass = (ItemClass)Enum.GetValues(typeof(ItemClass)).Length - 2;
                }
                m_startingItem = 0;
                m_endingItem = 4;
            }

            if (InputManager.IsPressed(InputManager.Commands.InventoryRight, m_parent.GetPlayerIndex()))
            {
                m_currentClass++;
                if (m_currentClass >= ItemClass.LAST)
                {
                    m_currentClass = (ItemClass)1;
                }
                m_startingItem = 0;
                m_endingItem = 4;
            }

            if (InputManager.IsPressed(InputManager.Commands.InventoryDown, m_parent.GetPlayerIndex()))
            {
                if (m_startingItem < m_currentClassItems.Count() - 1)
                {
                    m_startingItem++;
                    m_endingItem++;
                }
            }

            if (InputManager.IsPressed(InputManager.Commands.InventoryUp, m_parent.GetPlayerIndex()))
            {
                if (m_startingItem > 0)
                {
                    m_startingItem--;
                    m_endingItem--;
                }
            }
        }
        public void Update()
        {
            m_textHandler.Update();
            m_textHandler.Clear();
            if(m_isVisible)
            {
                HandleInput();
                m_textHandler.Add(new InventoryItemsText(m_currentClass.ToString().Replace("_", " "), 140, 30,
                                                       m_parent.GetPlayerIndex()));
                m_currentClassItems = m_inventory.GetItems(m_currentClass);
                if (m_currentClassItems.Count > 0)
                {
                    var currentKey = m_currentClassItems.ElementAt(m_startingItem).Key;

                    if (InputManager.IsPressed(InputManager.Commands.Confirm, m_parent.GetPlayerIndex()))
                    {
                        m_parent.Equip(currentKey);
                    }

                    for (var ii = m_startingItem; ii < m_endingItem && ii < m_currentClassItems.Count(); ii++)
                    {
                        string displayText = ((m_parent.IsEquipped(m_currentClassItems.ElementAt(ii).Key))?"~":"")+m_currentClassItems.ElementAt(ii).Key.Name;
                        m_textHandler.Add(new InventoryItemsText(displayText, 50,
                                                               60 + 25*(ii - m_startingItem), m_parent.GetPlayerIndex()));
                    }
                }
            }
        }
    }
}
