package aigilas.reactions;

import aigilas.reactions.impl.AtrophyReaction;
import aigilas.reactions.impl.BlankReaction;
import aigilas.reactions.impl.BlindReaction;
import aigilas.reactions.impl.ConfuseReaction;
import aigilas.reactions.impl.CraftsmanReaction;
import aigilas.reactions.impl.DrenchReaction;
import aigilas.reactions.impl.DrownReaction;
import aigilas.reactions.impl.EclipseReaction;
import aigilas.reactions.impl.EnlightenReaction;
import aigilas.reactions.impl.ExplosionReaction;
import aigilas.reactions.impl.ExposeReaction;
import aigilas.reactions.impl.FastForwardReaction;
import aigilas.reactions.impl.FlashReaction;
import aigilas.reactions.impl.LacticAcidReaction;
import aigilas.reactions.impl.LobotomyReaction;
import aigilas.reactions.impl.MagmaReaction;
import aigilas.reactions.impl.MetabolismReaction;
import aigilas.reactions.impl.MindBlownReaction;
import aigilas.reactions.impl.NeurosisReaction;
import aigilas.reactions.impl.PneumoniaReaction;
import aigilas.reactions.impl.PurifyReaction;
import aigilas.reactions.impl.ReflectReaction;
import aigilas.reactions.impl.RespectReaction;
import aigilas.reactions.impl.RustReaction;
import aigilas.reactions.impl.ScorchReaction;
import aigilas.reactions.impl.SweatReaction;
import aigilas.reactions.impl.VentReaction;
import aigilas.reactions.impl.YinYangReaction;

public class ReactionFactory {
	public static IReaction Create(ReactionId id) {
		switch (id) {
			case SWEAT:
				return new SweatReaction();
			case MAGMA:
				return new MagmaReaction();
			case EXPLOSION:
				return new ExplosionReaction();
			case SCORCH:
				return new ScorchReaction();
			case BLIND:
				return new BlindReaction();
			case LACTIC_ACID:
				return new LacticAcidReaction();
			case MIND_BLOWN:
				return new MindBlownReaction();
			case VENT:
				return new VentReaction();
			case DROWN:
				return new DrownReaction();
			case REFLECT:
				return new ReflectReaction();
			case DRENCH:
				return new DrenchReaction();
			case PNEUMONIA:
				return new PneumoniaReaction();
			case LOBOTOMY:
				return new LobotomyReaction();
			case RUST:
				return new RustReaction();
			case PURIFY:
				return new PurifyReaction();
			case ECLIPSE:
				return new EclipseReaction();
			case RESPECT:
				return new RespectReaction();
			case CRAFTSMAN:
				return new CraftsmanReaction();
			case FLASH:
				return new FlashReaction();
			case METABOLISM:
				return new MetabolismReaction();
			case FAST_FORWARD:
				return new FastForwardReaction();
			case BLANK:
				return new BlankReaction();
			case YIN_YANG:
				return new YinYangReaction();
			case EXPOSE:
				return new ExposeReaction();
			case ENLIGHTEN:
				return new EnlightenReaction();
			case ATROPHY:
				return new AtrophyReaction();
			case NEUROSIS:
				return new NeurosisReaction();
			case CONFUSE:
				return new ConfuseReaction();
			default:
				return null;
		}
	}
}