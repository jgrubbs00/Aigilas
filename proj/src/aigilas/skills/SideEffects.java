package aigilas.skills;

import java.util.ArrayList;
import java.util.List;

import spx.core.Point2;
import spx.entities.EntityManager;
import aigilas.creatures.ICreature;
import aigilas.entities.SkillEffect;
import aigilas.management.SpriteType;

public class SideEffects {
	protected ISkill _parent;

	protected AnimationType _animation;
	protected List<SkillEffect> _effectGraphics = new ArrayList<SkillEffect>();
	protected SpriteType _effectSprite = SpriteType.SKILL_EFFECT;
	protected float _effectStrength;
	protected boolean _isPersistent = false;

	public SideEffects(SpriteType effectGraphic, AnimationType animation, ISkill parent) {
		_parent = parent;
		_effectStrength = parent.GetStrength();
		_effectSprite = effectGraphic;
		_animation = animation;
	}

	public void Generate(Point2 gridLocation, Point2 velocity, ICreature source) {
		SkillEffect effect = new SkillEffect(gridLocation, velocity, source, _parent);
		_effectGraphics.add(effect);
		EntityManager.addObject(effect);
	}

	public SkillEffect GetFirstGraphic() {
		if (_effectGraphics.size() > 0)
			return _effectGraphics.get(0);
		return null;
	}

	public SpriteType GetSpriteType() {
		return _effectSprite;
	}

	public AnimationType GetAnimationType() {
		return _animation;
	}
}