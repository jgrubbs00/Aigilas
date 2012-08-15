package com.aigilas.entities;
    public class EntityFactory
    {
        public static Entity Create(int type, Point2 location)
        {
            switch (type)
            {
                case com.aigilas.EntityType.FLOOR:
                    return new Floor(location);
                case com.aigilas.EntityType.WALL:
                    return new Wall(location);
                case com.aigilas.EntityType.DOWNSTAIRS:
                    return new Downstairs(location);
                case com.aigilas.EntityType.UPSTAIRS:
                    return new Upstairs(location);
                default:
				try {
            }
        }
    }