package com.spx.sprites;
    {
        public static AnimatedTexture Create(int type, int x, int y)
        {
            AnimatedTexture sprite = new AnimatedTexture();
            sprite.LoadContent(type);
            sprite.SetPosition(x, y);
            return sprite;
        }
    }