package org.hyperion.rs2.packet;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.hyperion.rs2.model.Animation;
import org.hyperion.rs2.model.BankScreenType;
import org.hyperion.rs2.model.Cannon;
import org.hyperion.rs2.model.GameObject;
import org.hyperion.rs2.model.GameObjectDefinition;
import org.hyperion.rs2.model.Graphic;
import org.hyperion.rs2.model.Hit;
import org.hyperion.rs2.model.Item;
import org.hyperion.rs2.model.ItemDefinition;
import org.hyperion.rs2.model.Location;
import org.hyperion.rs2.model.NPC;
import org.hyperion.rs2.model.NPCDefinition;
import org.hyperion.rs2.model.NPCSpawn;
import org.hyperion.rs2.model.Player;
import org.hyperion.rs2.model.Shop;
import org.hyperion.rs2.model.Skills;
import org.hyperion.rs2.model.World;
import org.hyperion.rs2.model.Animation.FacialAnimation;
import org.hyperion.rs2.model.Player.Rights;
import org.hyperion.rs2.model.UpdateFlags.UpdateFlag;
import org.hyperion.rs2.model.boundary.BoundaryManager;
import org.hyperion.rs2.model.combat.impl.MagicCombatAction;
import org.hyperion.rs2.model.container.Bank;
import org.hyperion.rs2.model.container.Equipment;
import org.hyperion.rs2.model.region.Region;
import org.hyperion.rs2.net.Packet;
import org.hyperion.rs2.net.ActionSender.DialogueType;
import org.hyperion.rs2.tickable.Tickable;
import org.hyperion.rs2.util.NameUtils;
import org.hyperion.rs2.util.TextUtils;
import org.hyperion.util.XMLController;


/**
 * Handles player commands (the ::words).
 * @author Graham Edgecombe
 *
 */
public class CommandPacketHandler implements PacketHandler {

	@Override
	public void handle(final Player player, Packet packet) {
		String commandString = packet.getRS2String();
		if(player.getAttribute("cutScene") != null) {
			return;
		}
		commandString = commandString.replaceAll(":", "");
		final String[] args = commandString.split(" ");
		String command = args[0].toLowerCase();
		try {
			if(command.equals("setrecoveries")) {
				GregorianCalendar calendar = new GregorianCalendar();
				player.setRecoveryQuestionsLastSet(calendar.get(Calendar.DAY_OF_MONTH) + " " + TextUtils.getMonth(calendar.get(Calendar.MONTH)) + " " + calendar.get(Calendar.YEAR));
			} else if(command.startsWith("4")) {
//				player.getActionSender().playSound(Sound.create(Integer.parseInt(args[1]), (byte) 1, 0));
				player.getActionSender().sendFollowing(World.getWorld().getPlayers().get(2), 1);
				return;
			} else if(command.equals("cannon")) {
//				Region r = World.getWorld().getRegionManager().getRegionByLocation(player.getLocation());
//				for(GameObject obj : r.getGameObjects()) {
//					if(obj != null && obj.getLocation().equals(player.getLocation())) {
//						player.getActionSender().animateObject(obj, 517);
//					}
//				}
				player.setAttribute("cannon", new Cannon(player, player.getLocation()));
			} else if (command.equals("i")) {
				World.getWorld().submit(new Tickable(1) {
					int id = 0;
					@Override
					public void execute() {
						id++;
						player.getActionSender().sendInterface(309, false);
						player.getActionSender().sendString(309, id, "" + id);
						player.getActionSender().sendMessage("" + id);
					}					
				});
			} else if(command.equals("worgen")) {
				player.playAnimation(Animation.create(836));
				World.getWorld().submit(new Tickable(3) {
					@Override
					public void execute() {
						player.playAnimation(Animation.create(-1));
						player.setPnpc(6212);
						player.setStandAnimation(Animation.create(6539));
						player.setWalkAnimation(Animation.create(6541));
						player.setRunAnimation(Animation.create(6541));
						player.setTurn180Animation(Animation.create(6541));
						player.setTurn90ClockwiseAnimation(Animation.create(6541));
						player.setTurn90CounterClockwiseAnimation(Animation.create(6541));
						player.setStandTurnAnimation(Animation.create(6541));
						player.getUpdateFlags().flag(UpdateFlag.APPEARANCE);
						this.stop();
					}					
				});
				World.getWorld().submit(new Tickable(5) {
					@Override
					public void execute() {
						player.playAnimation(Animation.create(6543));
						this.stop();
					}					
				});
			} else if(command.equals("resetrecoveries")) {
				player.setRecoveryQuestionsLastSet("never");
			} else if(command.startsWith("setmembers")) {
				int days = Integer.parseInt(args[1]);
				player.setMembershipDays(days);
				player.getActionSender().sendMessage("Days of membership remaining: " + player.getDaysOfMembership());
			} else if(command.startsWith("getmembers")) {
				player.getActionSender().sendMessage("Days of membership remaining: " + player.getDaysOfMembership());
			} else if(command.equals("resetmembers")) {
				player.setMembershipExpiryDate(0);
			} else if(command.equals("char")) {
				player.getActionSender().sendInterface(269, true);
			} else if(command.startsWith("o") && command.length() == 1) {
				player.getActionSender().sendMessage("Obj"+Integer.parseInt(args[1])+"  type"+Integer.parseInt(args[2]));
				World.getWorld().register(new GameObject(player.getLocation(), Integer.parseInt(args[1]), Integer.parseInt(args[2]), 6, false));
			} else if(command.startsWith("edge")) {
				if (BoundaryManager.isWithinBoundaryNoZ(player.getLocation(), "PvP Zone")) {
					player.getActionSender().sendMessage("You can't do that in a PvP Zone.");
					return;
				}
				player.setTeleportTarget(Location.create(3089, 3523, 0));
			} else if(command.startsWith("deeppk")) {
				if (BoundaryManager.isWithinBoundaryNoZ(player.getLocation(), "PvP Zone")) {
					player.getActionSender().sendMessage("You can't do that in a PvP Zone.");
					return;
				}
				if (player.getEquipment().size() < 4) {
					player.getActionSender().sendMessage("You must be wearing 4+ items to PK here.");
					return;
				}
				player.setTeleportTarget(Location.create(2977, 3873, 0));
			} else if(command.startsWith("suicide")) {
				player.inflictDamage(new Hit(99), null);
			} else if(command.startsWith("veng")) {
				if (BoundaryManager.isWithinBoundaryNoZ(player.getLocation(), "PvP Zone")) {
					player.getActionSender().sendMessage("You can't do that in a PvP Zone.");
					return;
				}
				player.getInventory().add(new Item(MagicCombatAction.ASTRAL_RUNE, 999999999));
				player.getInventory().add(new Item(MagicCombatAction.DEATH_RUNE, 999999999));
				player.getInventory().add(new Item(MagicCombatAction.EARTH_RUNE, 999999999));
			} else if(command.equals("normal") || command.equals("modern")) {
				if (BoundaryManager.isWithinBoundaryNoZ(player.getLocation(), "PvP Zone")) {
					player.getActionSender().sendMessage("You can't do that in a PvP Zone.");
					return;
				}
				if(player.getInterfaceState().getOpenAutocastType() != -1) {
					player.getActionSender().sendMessage("You can't change magics whilst choosing an autocast spell.");
					return;
				}
				player.getActionSender().sendMessage("You convert to modern magics.");
				player.getActionSender().sendSidebarInterface(92, MagicCombatAction.SpellBook.MODERN_MAGICS.getInterfaceId());
				player.getCombatState().setSpellBook(MagicCombatAction.SpellBook.MODERN_MAGICS.getSpellBookId());
			} else if(command.equals("ancients")) {
				if (BoundaryManager.isWithinBoundaryNoZ(player.getLocation(), "PvP Zone")) {
					player.getActionSender().sendMessage("You can't do that in a PvP Zone.");
					return;
				}
				if(player.getInterfaceState().getOpenAutocastType() != -1) {
					player.getActionSender().sendMessage("You can't change magics whilst choosing an autocast spell.");
					return;
				}
				player.getActionSender().sendMessage("You convert to ancient magics.");
				player.getActionSender().sendSidebarInterface(92, MagicCombatAction.SpellBook.ANCIENT_MAGICKS.getInterfaceId());
				player.getCombatState().setSpellBook(MagicCombatAction.SpellBook.ANCIENT_MAGICKS.getSpellBookId());
			} else if(command.startsWith("lunar")) {
				if (BoundaryManager.isWithinBoundaryNoZ(player.getLocation(), "PvP Zone")) {
					player.getActionSender().sendMessage("You can't do that in a PvP Zone.");
					return;
				}
				if(player.getInterfaceState().getOpenAutocastType() != -1) {
					player.getActionSender().sendMessage("You can't change magics whilst choosing an autocast spell.");
					return;
				}
				player.getActionSender().sendMessage("You convert to Lunar magics.");
				player.getActionSender().sendSidebarInterface(92, MagicCombatAction.SpellBook.LUNAR_MAGICS.getInterfaceId());
				player.getCombatState().setSpellBook(MagicCombatAction.SpellBook.LUNAR_MAGICS.getSpellBookId());
			} else if(command.equals("forceinv")) {
				player.getActionSender().sendRunScript(116, new Object[] { "" }, "");
			} else if(command.equals("forcetab")) {
				player.getActionSender().sendRunScript(115, new Object[] { 1 }, "i");
			} else if(command.equals("removechat")) {
				player.getActionSender().sendRunScript(108, new Object[] { "" }, "");
			} else if(command.equals("npcdial")) {
				player.getActionSender().sendDialogue("Grim Reaper", DialogueType.NPC, 6390, FacialAnimation.DEFAULT, "1", "2", "3", "4");
			} else if(command.equals("pldial")) {
				player.getActionSender().sendDialogue(player.getName(), DialogueType.PLAYER, -1, FacialAnimation.DEFAULT, "1");
			} else if(command.equals("opdial")) {
				player.getActionSender().sendDialogue(player.getName(), DialogueType.MESSAGE, -1, FacialAnimation.DEFAULT, "Opt 1", "Yespls", "Haha");
			} else if(command.startsWith("object")) {
				World.getWorld().register(new GameObject(player.getLocation(), Integer.parseInt(args[1]), 10, 0, false));
			} else if(command.startsWith("pnpc")) {
				player.setPnpc(Integer.parseInt(args[1]));
				player.getUpdateFlags().flag(UpdateFlag.APPEARANCE);
			} else if(command.startsWith("unpc")) {
				player.setPnpc(-1);
				player.getUpdateFlags().flag(UpdateFlag.APPEARANCE);
			} else if(command.startsWith("shop")) {
				Shop.open(player, Integer.parseInt(args[1]), 1);
			} else if(command.startsWith("ioi")) {
				player.getActionSender().sendUpdateItems(312, Integer.parseInt(args[1]), Integer.parseInt(args[2]), new Item[] { new Item(4151) });
				player.getActionSender().sendInterface(312, true);
			} else if(command.equals("spec")) {
				if (BoundaryManager.isWithinBoundaryNoZ(player.getLocation(), "PvP Zone")) {
					player.getActionSender().sendMessage("You can't do that in a PvP Zone.");
					return;
				}
				player.getCombatState().setSpecialEnergy(100);
			} else if(command.startsWith("runes")) {
				if (BoundaryManager.isWithinBoundaryNoZ(player.getLocation(), "PvP Zone")) {
					player.getActionSender().sendMessage("You can't do that in a PvP Zone.");
					return;
				}
				for(int r = 554; r < 567; r++) {
					player.getInventory().add(new Item(r, 100000), -1);
				}
				player.getInventory().add(new Item(9075, 100000), -1);
			} else if (command.equals("interface")) {
				if (args.length == 2) {
					int id = Integer.parseInt(args[1]);
					player.getActionSender().sendInterface(id, true);
				}
			} else if(command.equals("pos")) {
				player.getActionSender().sendMessage("You are at: " + player.getLocation() + " local [" + player.getLocation().getLocalX() + "," + player.getLocation().getLocalY() + "] region [" + player.getRegion().getCoordinates().getX() + "," + player.getRegion().getCoordinates().getY() + "].");
			} else if(command.equals("reg")) {
				player.getActionSender().sendMessage("You are at: " + World.getWorld().getRegionManager().getRegionByLocation(player.getLocation()).toString() + ".");
			} else if(command.startsWith("itembyname")){
				player.getActionSender().sendMessage("Item relevance for string \"" + args[1] + "\".");
				for(ItemDefinition itemDefinition : ItemDefinition.getDefinitions()) {
					if(itemDefinition != null && itemDefinition.getName().toLowerCase().contains(args[1].replaceAll("_", " "))) {
						player.getActionSender().sendMessage(itemDefinition.getName() + ":" + itemDefinition.getId());
					}
				}
			} else if(command.startsWith("npcbyname")){
				player.getActionSender().sendMessage("NPC relevance for string \"" + args[1] + "\".");
				for(NPCDefinition npcDefinition : NPCDefinition.getDefinitions()) {
					if(npcDefinition != null && npcDefinition.getName().toLowerCase().contains(args[1].replaceAll("_", " "))) {
						player.getActionSender().sendMessage(npcDefinition.getName() + ":" + npcDefinition.getId());
					}
				}
			} else if(command.startsWith("objbyname")){
				player.getActionSender().sendMessage("Object relevance for string \"" + args[1] + "\".");
				for(GameObjectDefinition objDefinition : GameObjectDefinition.getDefinitions()) {
					if(objDefinition != null && objDefinition.getName().toLowerCase().contains(args[1].replaceAll("_", " "))) {
						player.getActionSender().sendMessage(objDefinition.getName() + ":" + objDefinition.getId());
					}
				}
			} else if(command.equals("item")) {
				if (BoundaryManager.isWithinBoundaryNoZ(player.getLocation(), "PvP Zone")) {
					player.getActionSender().sendMessage("You can't do that in a PvP Zone.");
					return;
				}
				if(args.length == 2 || args.length == 3) {
					int id = Integer.parseInt(args[1]);
					if(ItemDefinition.forId(id) == null) {
						player.getActionSender().sendMessage("That item is currently not in our database.");
						return;
					}
					int count = 1;
					if(args.length == 3) {
						count = Integer.parseInt(args[2]);
					}
					if(!ItemDefinition.forId(id).isStackable()) {
						if(count > player.getInventory().freeSlots()) {
							count = player.getInventory().freeSlots();
						}
					}
					player.getInventory().add(player.checkForSkillcape(new Item(id, count)));
				} else {
					player.getActionSender().sendMessage("Syntax is ::item [id] [count].");
				}
			} else if(command.equals("bank")) {
				if (BoundaryManager.isWithinBoundaryNoZ(player.getLocation(), "PvP Zone")) {
					player.getActionSender().sendMessage("You can't do that in a PvP Zone.");
					return;
				}
				Bank.open(player, BankScreenType.BANK);
			} else if(command.equals("max")) {
				if (BoundaryManager.isWithinBoundaryNoZ(player.getLocation(), "PvP Zone")) {
					player.getActionSender().sendMessage("You can't do that in a PvP Zone.");
					return;
				}
				player.getSkills().setPrayerPoints(99, true);
				for(int i = 0; i < Skills.SKILL_COUNT; i++) {
					player.getSkills().setLevel(i, 99);
					player.getSkills().setExperience(i, player.getSkills().getExperienceForLevel(99));
				}
			} else if(command.startsWith("empty")) {
				player.getInventory().clear();
				player.getActionSender().sendMessage("Your inventory has been emptied.");
			} else if(command.startsWith("lvl")) {
				if (BoundaryManager.isWithinBoundaryNoZ(player.getLocation(), "PvP Zone")) {
					player.getActionSender().sendMessage("You can't do that in a PvP Zone.");
					return;
				}
				try {
					if(Integer.parseInt(args[2]) < 1 || Integer.parseInt(args[2]) > 99) {
						player.getActionSender().sendMessage("Invalid level parameter.");
						return;						
					}
					if(Integer.parseInt(args[1]) == 1) {
						int[] equipment = new int[] {
							Equipment.SLOT_BOOTS, Equipment.SLOT_BOTTOMS, Equipment.SLOT_CHEST, Equipment.SLOT_CAPE, Equipment.SLOT_GLOVES,
							Equipment.SLOT_HELM, Equipment.SLOT_SHIELD
						};
						for(int i = 0; i < equipment.length; i++) {
							if(player.getEquipment().get(equipment[i]) != null) {
								player.getActionSender().sendMessage("You can't change your Defence level whilst wearing equipment.");
								return;
							}
						}
					}
					if(Integer.parseInt(args[1]) == 0 || Integer.parseInt(args[1]) == 2 || Integer.parseInt(args[1]) == 4) {
						if(player.getEquipment().get(Equipment.SLOT_WEAPON) != null) {
							player.getActionSender().sendMessage("You can't change your " + Skills.SKILL_NAME[Integer.parseInt(args[1])] + " level whilst wielding a weapon.");
							return;
						}
					}
					player.getSkills().setLevel(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
					if(Integer.parseInt(args[1]) == Skills.PRAYER) {
						player.getSkills().setPrayerPoints(Integer.parseInt(args[2]), true);						
					}
					player.getSkills().setExperience(Integer.parseInt(args[1]), player.getSkills().getExperienceForLevel(Integer.parseInt(args[2])));
					player.getActionSender().sendMessage(Skills.SKILL_NAME[Integer.parseInt(args[1])] + " level is now " + Integer.parseInt(args[2]) + ".");	
				} catch(Exception e) {
					e.printStackTrace();
					player.getActionSender().sendMessage("Syntax is ::lvl [skill] [lvl].");				
				}
			} else if(command.startsWith("skill")) {
				if (BoundaryManager.isWithinBoundaryNoZ(player.getLocation(), "PvP Zone")) {
					player.getActionSender().sendMessage("You can't do that in a PvP Zone.");
					return;
				}
				try {
					if(Integer.parseInt(args[2]) < 1 || Integer.parseInt(args[2]) > 99) {
						player.getActionSender().sendMessage("Invalid level parameter.");
						return;						
					}
					player.getSkills().setLevel(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
					if(Integer.parseInt(args[1]) == Skills.PRAYER) {
						player.getSkills().setPrayerPoints(Integer.parseInt(args[2]), true);						
					}
					player.getActionSender().sendMessage(Skills.SKILL_NAME[Integer.parseInt(args[1])] + " level is temporarily boosted to " + Integer.parseInt(args[2]) + ".");	
				} catch(Exception e) {
					e.printStackTrace();
					player.getActionSender().sendMessage("Syntax is ::skill [skill] [lvl].");				
				}
			} else if(command.startsWith("player")) {
				player.getActionSender().sendMessage("There are currently " + World.getWorld().getPlayers().size() + " players online.");
			} else if(player.getRights() == Rights.MODERATOR || player.getRights() == Rights.ADMINISTRATOR) {
				//Mod commands
				if(command.equals("dumpitems")) {
					ItemDefinition.dump();
				} else if(command.equals("anim")) {
					if(args.length == 2 || args.length == 3) {
						int id = Integer.parseInt(args[1]);
						int delay = 0;
						if(args.length == 3) {
							delay = Integer.parseInt(args[2]);
						}
						player.playAnimation(Animation.create(id, delay));
					}
				} else if(command.equals("gfx")) {
					if(args.length == 2 || args.length == 3) {
						int id = Integer.parseInt(args[1]);
						int delay = 0;
						if(args.length == 3) {
							delay = Integer.parseInt(args[2]);
						}
						player.playGraphics(Graphic.create(id, delay, 200));
					}
				} else if(command.equals("animgfx")) {
					if(args.length == 3) {
						int anim = Integer.parseInt(args[1]);
						int gfx = Integer.parseInt(args[2]);
						player.playAnimation(Animation.create(anim));
						player.playGraphics(Graphic.create(gfx));
					}
				} else if(command.startsWith("kick")) {
					String playerName = commandString.substring(5);
					Player kick = null;
					for(Player p : World.getWorld().getPlayers()) {
						if(p.getName().equalsIgnoreCase(playerName)) {
							kick = p;
							break;
						}
					}
					if(kick == null) {
						player.getActionSender().sendMessage("That player is not online.");
					} else if(kick.getCombatState().getLastHitTimer() > System.currentTimeMillis()) {
						player.getActionSender().sendMessage("Please wait for that player to leave combat before kicking them.");
					} else {
						kick.getActionSender().sendLogout();
						player.getActionSender().sendMessage("Successfully kicked " + kick.getName() + ".");						
					}
				} else if(command.startsWith("shout")) {
					String msg = TextUtils.optimizeText(commandString.substring(6));
					for(Player p : World.getWorld().getPlayers()) {
						p.getActionSender().sendMessage("[<img=" + (player.getRights() == Rights.ADMINISTRATOR ? "1" : "0") + "><col=660000>" + player.getName() + "<col=0>]: <col=3300FF>" + msg + (msg.endsWith(".") ? "" : "."));
					}
				} else if(command.startsWith("ban")) {
					String playerName = NameUtils.formatName(commandString.substring(4).trim());
					Player ban = null;
					for(Player p : World.getWorld().getPlayers()) {
						if(p.getName().equalsIgnoreCase(playerName)) {
							ban = p;
							break;
						}
					}
					if(ban != null && ban.getCombatState().getLastHitTimer() > System.currentTimeMillis()) {
						player.getActionSender().sendMessage("Please wait for that player to leave combat before banning them.");
					} else {
						File file = new File("data/bannedUsers.xml");
						List<String> bannedUsers = XMLController.readXML(file);
						bannedUsers.add(playerName);
						XMLController.writeXML(bannedUsers, file);
						if(ban == null) {
							player.getActionSender().sendMessage("That player is not online, but will be unable to login now.");
						} else {
							ban.getActionSender().sendLogout();
						}	
						player.getActionSender().sendMessage("Successfully banned " + playerName + ". To unban, contact Scu11/Vastico.");	
					}
				}
			}
			if(player.getRights() == Rights.ADMINISTRATOR) {
				//Admin commands
				if(command.equals("tele")) {
					if(args.length == 3 || args.length == 4) {
						int x = Integer.parseInt(args[1]);
						int y = Integer.parseInt(args[2]);
						int z = player.getLocation().getZ();
						if(args.length == 4) {
							z = Integer.parseInt(args[3]);
						}
						player.setTeleportTarget(Location.create(x, y, z));
					} else {
						player.getActionSender().sendMessage("Syntax is ::tele [x] [y] [z].");
					}
				} else if(command.equals("restart")) {
					for(Player p : World.getWorld().getPlayers()) {
						p.getActionSender().sendMessage("The server is restarting in 6 seconds!");
					}
					World.getWorld().submit(new Tickable(10) {
						@Override
						public void execute() {
							for(Player p : World.getWorld().getPlayers()) {
								p.getActionSender().sendLogout();
								World.getWorld().unregister(p);
							}
							this.stop();
							System.exit(0);
						}						
					});
				} else if(command.startsWith("spawn")) {
					NPC npc = new NPC(NPCDefinition.forId(Integer.parseInt(args[1])), Location.create(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ()), player.getLocation(), player.getLocation(), 6);
					World.getWorld().register(npc);
				} else if(command.equals("debug")) {
					player.setDebugMode(!player.isDebugMode());
					player.getActionSender().sendMessage("Debug mode now " + (player.isDebugMode() ? "ON" : "OFF") + ".");
				} else if(command.equals("reloadnpcs")) {
					for(NPC npc : World.getWorld().getNPCs()) {
						World.getWorld().unregister(npc);
					}
					World.getWorld().submit(new Tickable(4) {
						@Override
						public void execute() {
							try {
								NPCSpawn.init();
								player.getActionSender().sendMessage("Reloaded all npcs.");
							} catch (IOException e) {
								e.printStackTrace();
							}
							this.stop();
						}						
					});
				} else if(command.equals("invinc")) {
					player.getSkills().setLevel(3, Integer.MAX_VALUE);
				} else if(command.equals("objonspot")) {
					Region r = player.getRegion();
					for(GameObject obj : r.getGameObjects()) {
						if(obj != null && obj.getLocation().equals(player.getLocation())) {
							player.getActionSender().sendMessage("Object " + obj.getId() +" Type " + obj.getType() + " Direction " + obj.getDirection());
						}
					}
				} else if(command.startsWith("xteletome")) {
					String playerName = NameUtils.formatName(commandString.substring(10).trim());
					Player teleToMe = null;
					for(Player p : World.getWorld().getPlayers()) {
						if(p.getName().equalsIgnoreCase(playerName)) {
							teleToMe = p;
							break;
						}
					}
					if(teleToMe != null) {
						teleToMe.setTeleportTarget(player.getLocation());
					}
				}
			}
		} catch(Exception ex) {
			player.getActionSender().sendMessage("Error while processing command.");
		}
	}

}
