package ml.pkom.ellipsisk.lang;

import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.Skript;
import ch.njol.skript.classes.Changer.ChangeMode;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

public class EllipsisSet extends Effect {

    static {
        Skript.registerEffect(EllipsisSet.class,
                "(e|ellipsisk) %~objects% = %objects%");
    }

    private Expression<?> out_object;
    private Expression<?> in_object;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expressions, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.out_object = (Expression<?>) expressions[0];
        this.in_object = (Expression<?>) expressions[1];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return "ellipsis effect with expression out-object: " + out_object.toString(event, debug)
                + " and expression in-object: " + in_object.toString(event, debug);
    }

    @Override
    protected void execute(Event event) {
		Expression<?> changer = this.in_object;
		Expression<?> changed = this.out_object;
    
		Object[] delta = changer == null ? null : changer.getArray(event);
		delta = changer == null ? delta : changer.beforeChange(changed, delta);

		if (delta == null || delta.length == 0) {
			if (changed.acceptChange(ChangeMode.DELETE) != null)
				changed.change(event, null, ChangeMode.DELETE);
			return;
		}
		changed.change(event, delta, ChangeMode.SET);
    }
}
