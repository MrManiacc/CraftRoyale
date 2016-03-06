package me.raynorjames.misc;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by JamesRaynor on 3/5/16.
 */
public class ChatHelper {
    public static String getFormattedMessage(String input) {
        return new String(ChatColor.GOLD + "[Clash" + ChatColor.AQUA + "Royale] " + ChatColor.WHITE + input);
    }

    public static String[] getHelpMessages() {
        String[] helpMessages = new String[3];
        helpMessages[0] = getFormattedMessage("/clan help - display clan command help.");
        helpMessages[1] = getFormattedMessage("/royale help - display royale command help.");
        helpMessages[2] = getFormattedMessage("/arena help - display arena command help.");
        return helpMessages;
    }

    public static String[] getClanHelpMessages() {
        String[] clanHelpMessages = new String[7];
        clanHelpMessages[0] = getFormattedMessage("/clan create - creates a clan.");
        clanHelpMessages[1] = getFormattedMessage("/clan list - list possible clans to join.");
        clanHelpMessages[2] = getFormattedMessage("/clan join (clan name) - join a clan with the specified name.");
        clanHelpMessages[3] = getFormattedMessage("/clan promote (player name) - promote a player to the next tier in clan.");
        clanHelpMessages[4] = getFormattedMessage("/clan demote (player name) - demote a player to the next lower tier in clan.");
        clanHelpMessages[5] = getFormattedMessage("/clan chat - toggle focus between clan chat and global chat.");
        clanHelpMessages[6] = getFormattedMessage("/clan leave - leave your current command.");
        return clanHelpMessages;
    }

    public static String[] getRoyaleHelpMessages() {
        String[] royaleHelpMessages = new String[4];
        royaleHelpMessages[0] = getFormattedMessage("/royale purchase - gives link to purchase more gems.");
        royaleHelpMessages[1] = getFormattedMessage("/royale battle - starts search for a battle.");
        royaleHelpMessages[2] = getFormattedMessage("/royale cards - displays your full deck of cards.");
        royaleHelpMessages[3] = getFormattedMessage("/royale manage - displays your upgradable cards.");
        return royaleHelpMessages;
    }

    public static String[] getArenaHelpMessage() {
        String[] arenaHelpMessages = new String[4];
        arenaHelpMessages[0] = getFormattedMessage("/arena start - starts the creation of an arena.");
        arenaHelpMessages[1] = getFormattedMessage("/arena finish - finishes the creation of an arena.");
        arenaHelpMessages[2] = getFormattedMessage("/arena set (component) - sets the specified component to current world edit selection.");
        arenaHelpMessages[3] = getFormattedMessage("/arena list - lists all components to be set in an arena.");
        return arenaHelpMessages;
    }

    public static String[] getComponentMessage() {
        String[] componentMessages = new String[11];
        componentMessages[0] = getFormattedMessage("ENTIRE_SELECTION - component for the entire arena selection. (required)");
        componentMessages[1] = getFormattedMessage("RED_SIDE_SELECTION - component for red side selection. (required)");
        componentMessages[2] = getFormattedMessage("BLUE_SIDE_SELECTION - component for the blue side selection.  (required)");
        componentMessages[3] = getFormattedMessage("RED_KING_TOWER - component for the red king tower.  (required)");
        componentMessages[4] = getFormattedMessage("BLUE_KING_TOWER - component for the blue king tower. (required)");
        componentMessages[5] = getFormattedMessage("RED_KING_TOWER_STAND - component for the red king's stand inside the king tower. (required)");
        componentMessages[6] = getFormattedMessage("BLUE_KING_TOWER_STAND - component for the blue king's stand inside the king tower. (required)");
        componentMessages[7] = getFormattedMessage("RED_LEFT_TOWER - component for the red side's left tower. (required)");
        componentMessages[8] = getFormattedMessage("BLUE_LEFT_TOWER - component for the blue side's left tower. (required)");
        componentMessages[9] = getFormattedMessage("RED_RIGHT_TOWER - component for the red side's right tower. (required)");
        componentMessages[10] = getFormattedMessage("BLUE_RIGHT_TOWER - component for the blue side's right tower. (required)");
        componentMessages[11] = getFormattedMessage("SPECTATOR_SPAWN - component for the spectator spawn. (optional)");
        componentMessages[12] = getFormattedMessage("ARENA_LEVEL (level) - component to set arena level from 1 to 8 if not set defaults to 1. (optional)");
        return componentMessages;
    }

    public static String getNoPermissionMessage() {
        return getFormattedMessage("You don't have permission to preform this command!");
    }

    public static String getNotPlayerCommand() {
        return getFormattedMessage("You must be a player to preform this command!");
    }

    public static int getInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }


    public static void sendStringArray(Player player, String[] array) {
        for (int i = 0; i < array.length; i++) player.sendMessage(array[i]);
    }
}
