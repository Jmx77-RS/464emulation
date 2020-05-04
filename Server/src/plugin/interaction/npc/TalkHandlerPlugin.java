package plugin.interaction.npc;

import org.hyperion.plugin.InitializablePlugin;
import org.hyperion.plugin.Plugin;
import org.hyperion.plugin.PluginManager;
import org.hyperion.plugin.PluginManifest;
import org.hyperion.plugin.PluginType;
import org.hyperion.plugin.impl.OptionHandler;
import org.hyperion.rs2.model.Entity;
import org.hyperion.rs2.model.NPC;
import org.hyperion.rs2.model.Player;
import org.hyperion.rs2.model.dialogue.Dialogue;

/**
 * Handles the general talking by NPCs by getting their dialogue and starting it if it exists.
 * @author jamix77
 *
 */
@InitializablePlugin
@PluginManifest(authors = { "jamix77" }, version = 1.2, type = PluginType.ACTION)
public class TalkHandlerPlugin extends OptionHandler {

	@Override
	public Plugin<Object> newInstance(Object arg) throws Throwable {
		return new TalkHandlerPlugin();
	}

	@Override
	public void init() throws Throwable {
		PluginManager.getOptionHandlerPlugins().put("npc:talk-to", this);
	}

	@Override
	public boolean handle(Player player, Entity node, String option) {
		Dialogue d = PluginManager.getDialoguePlugins().get(((NPC)node).getDefinition().getId());
		if (d != null) {
			try {
				player.getDialogueManager().start((Dialogue)d.newInstance(player));
				return true;
			} catch (Throwable e) {
			}
		}
		player.getActionSender().sendMessage(((NPC)node).getDefinition().getName() + " isn't interested in talking.");
		return true;
	}



}