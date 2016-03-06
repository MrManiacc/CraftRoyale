package me.raynorjames.commands;

import me.raynorjames.misc.ChatHelper;
import me.raynorjames.misc.PermissionHelper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

/**
 * Created by JamesRaynor on 3/5/16.
 */
public class ArenaCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof ConsoleCommandSender)
            commandSender.sendMessage(ChatHelper.getNotPlayerCommand());
        else {
            Player player = (Player) commandSender;
            if (args.length == 0) {
                if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.HelpArena))
                    ChatHelper.sendStringArray(player, ChatHelper.getArenaHelpMessage());
                else
                    player.sendMessage(ChatHelper.getNoPermissionMessage());
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("start")) {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.CreateArena)) {
                        //TODO create arena
                    } else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                } else if (args[0].equalsIgnoreCase("help")) {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.HelpArena))
                        ChatHelper.sendStringArray(player, ChatHelper.getArenaHelpMessage());
                    else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                } else if (args[0].equalsIgnoreCase("set")) {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.SetArenaComponent)) {
                        //TODO send message about not enough args
                    } else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                } else if (args[0].equalsIgnoreCase("finish")) {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.FinishArena)) {
                        //TODO finish arena
                    } else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                } else if (args[0].equalsIgnoreCase("list")) {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.ListArena)) {
                        ChatHelper.sendStringArray(player, ChatHelper.getComponentMessage());
                    } else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                }
            } else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("set")) {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.SetArenaComponent)) {
                        String component = args[1];
                        //TODO process set request
                    } else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                } else
                    ChatHelper.sendStringArray(player, ChatHelper.getArenaHelpMessage());
            } else if (args.length == 3) {
                if (args[0].equalsIgnoreCase("set") && args[1].equalsIgnoreCase("level")) {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.SetArenaComponent)) {
                        String component = args[0];
                        int level = ChatHelper.getInt(args[1]);
                        //TODO process set request
                    } else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                }
            }
        }

        return false;
    }
}
