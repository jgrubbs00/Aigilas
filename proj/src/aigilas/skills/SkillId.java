package aigilas.skills;

public enum SkillId {

	FIREBALL("Fireball"),
	NO_SKILL("No Skill"),
	// = Sloth Acolyte
	FLOOR_SPIKES("Floor Spikes"),
	DART("Dart"),
	DART_TRAP("Dart Trap"),
	ACID_DRIP("Acid Drip"),
	ACID_NOZZLE("Acid Nozzle"),
	REMOTE_MINE("Remote Mine"),
	VAPOR_IMPLANT("Vapor Implant"),
	// = Envy Acolyte
	CONFUSION("Confusion"),
	WEAK_KNEEES("Weak Knees"),
	VENOM_FIST("Venom Fist"),
	ABSORB("Absorb"),
	MUTINY("Mutiny"),
	// = Greed Acolyte
	SOUL_REINFORCEMENT("Soul Reinforcement"),
	HORDER("Horder"),
	SPAWN_ITEM("Drop Rate (+)"),
	THROW_ITEM("Throw Item"),
	STEAL_ITEM("Steal Item"),
	// = Wrath Acolyte
	FLAME_HAMMER("Flame Hammer"),
	GUSH("Gush"),
	SOUL_CRUSH("Soul Crush"),
	COMBUST("Combust"),
	HORRIFY("Horrify"),
	// = Gluttony Acolyte
	FORGET_SKILL("Forget Skill"),

	// = Lust Acolyte
	REGEN_ALL("Regen All"),
	SPEED_UP("Speed (+) All"),
	ENVENOM("Envenom"),
	MAGIC_MAP("Magic Map"),
	COLD_SHOULDER("Cold Shoulder"),
	CAVALRY("Cavalry"),
	// = Pride Acolyte
	STRENGTH_UP("Strength (+)"),
	MANA_UP("Mana (+)"),
	ELECTRIFY("Electrify"),
	WALL_PUNCH("Wall Punch"),
	MIMIC("Mimic"),
	VALEDICTORIAN("Valedictorian"),

	EXPLODE("Explode"),
	VAPOR_CLOUD("Vapor Cloud"),

	// = Wrath
	DISMEMBERMENT("Dismemberment",true),
	// = Envy
	HYPOTHERMIA("Hypothermia",true),
	ICE_SHARD("Ice Shard"),
	// = Gluttony
	PLAGUE("Plague"),
	POISON_CLOUD("Poison Cloud",true),
	// = Sloth
	SERPENT_SUPPER("Serpent Supper",true),
	// = Pride
	BREAKING_WHEEL("Breaking Wheel",true),
	// = Greed
	BOIL("Boil",true),
	// = Lust
	BRIMSTONE("Brimstone",true);

	public final String Name;
    public final boolean Restrict;

    private SkillId(String text, boolean restrict){
        Restrict = restrict;
        Name = text;
    }

	private SkillId(String text) {
		this(text,false);
	}
}