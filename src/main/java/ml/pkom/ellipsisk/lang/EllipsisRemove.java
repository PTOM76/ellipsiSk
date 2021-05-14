package ml.pkom.ellipsisk.lang;

import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.Skript;
import ch.njol.skript.classes.Changer.ChangeMode;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

public class EllipsisRemove extends Effect {

    static {
        Skript.registerEffect(EllipsisRemove.class, "[(e|ellipsisk)] --(%~numbers%)");
    }

    private Expression<?> out_object;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expressions, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.out_object = (Expression<?>) expressions[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return "remove 1 from " + out_object.toString(event, debug);
    }

    @Override
    protected void execute(Event event) {
        Expression<?> object = this.out_object;

        Object[] delta = { 1 };

        object.change(event, delta, ChangeMode.REMOVE);
    }
}
