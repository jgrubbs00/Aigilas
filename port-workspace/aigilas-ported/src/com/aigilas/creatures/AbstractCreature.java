package com.aigilas.creatures;
    public class AbstractCreature extends ICreature
    {
        public AbstractCreature(int actorType,int spriteType,CreatureClass cClass) 
        {
           Construct(actorType,spriteType,cClass);
        }
        public void Setup(Point2 position)
        {
            Setup(position, _actorType, _baseStats, _class);
            if (_strategy == null)
            {
                _strategy = StrategyFactory.Create(Strategy.Attack,this,AigilasActorType.PLAYER);
            }
        }
        protected void Add(String skillId)
        {
            if (_skills == null)
            {
                _skills = new SkillPool(this);
            }
            _skills.Add(skillId);
        }
        float multiplier = 0f;        
        protected void Strengths(String...stats)
        {
            for (String stat:stats)
            {
                multiplier = (stat == StatType.MOVE_COOL_DOWN) ? .5f : 2;
                InitStat(stat, Get(stat) * multiplier);
            }
        }
        protected void Weaknesses(String...stats)
        {
            for (String stat:stats)
            {
                multiplier = (stat == StatType.MOVE_COOL_DOWN) ? 2 : .5f;
                InitStat(stat, Get(stat) * multiplier);
            }
        }
        protected void Compose(Integer...elems)
        {
            _composition.addAll(Arrays.asList(elems));
        }
    }