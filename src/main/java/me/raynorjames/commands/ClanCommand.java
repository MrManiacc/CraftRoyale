package me.raynorjames.commands;

import me.raynorjames.misc.ChatHelper;
import me.raynorjames.misc.PermissionHelper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

/**
 * Created by productionaccount on 3/5/16.
 */
public class ClanCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof ConsoleCommandSender)
            commandSender.sendMessage(ChatHelper.getNotPlayerCommand());
        else {
            Player player = (Player) commandSender;
            if (args.length == 0) {
                if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.HelpClan))
                    ChatHelper.sendStringArray(player, ChatHelper.getClanHelpMessages());
                else
                    player.sendMessage(ChatHelper.getNoPermissionMessage());
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("chat")) {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.ChatClan)) {
                        //TODO process chat toggle
                    } else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                } else if (args[0].equalsIgnoreCase("join")) {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.JoinClan)) {
                        //TODO send invalid args message
                    } else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                } else if (args[0].equalsIgnoreCase("leave")) {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.LeaveClan)) {
                        //TODO process leave clan request
                    } else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                } else if (args[0].equalsIgnoreCase("list")) {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.ListClan)) {
                        //TODO list all clan
                    } else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                } else if (args[0].equalsIgnoreCase("help")) {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.HelpClan)) {
                        ChatHelper.sendStringArray(player, ChatHelper.getClanHelpMessages());
                    } else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                } else if (args[0].equalsIgnoreCase("create")) {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.CreateClan)) {
                        //TODO process clan creation request
                    } else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                } else if (args[0].equalsIgnoreCase("promote")) {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.PromoteClan)) {
                        //TODO send invalid args message
                    } else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                } else if (args[0].equalsIgnoreCase("demote")) {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.DemoteClan)) {
                        //TODO send invalid args message
                    } else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                }
            } else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("join")) {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.JoinClan)) {
                        String clanName = args[1];
                        //TODO process clan join request
                    } else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                } else if (args[0].equalsIgnoreCase("promote")) {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.PromoteClan)) {
                        String playerName = args[1];
                        //TODO process promote request
                    } else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                } else if (args[0].equalsIgnoreCase("demote")) {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.DemoteClan)) {
                        String playerName = args[1];
                        //TODO process demote request
                    } else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                }
            }

        }
        return false;
    }
}
