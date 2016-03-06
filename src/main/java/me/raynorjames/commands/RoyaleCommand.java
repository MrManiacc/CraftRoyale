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
public class RoyaleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof ConsoleCommandSender)
            commandSender.sendMessage(ChatHelper.getNotPlayerCommand());
        else {
            Player player = (Player) commandSender;
            if (args.length == 0) {
                if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.HelpRoyale))
                    ChatHelper.sendStringArray(player, ChatHelper.getRoyaleHelpMessages());
                else
                    player.sendMessage(ChatHelper.getNoPermissionMessage());
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("purchase")) {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.PurchaseRoyale)) {
                        //TODO send purchase link
                    } else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                } else if (args[0].equalsIgnoreCase("battle")) {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.BattleRoyale)) {
                        //TODO process battle request
                    } else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                } else if (args[0].equalsIgnoreCase("cards")) {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.CardsRoyale)) {
                        //TODO process cards request
                    } else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                } else if (args[0].equalsIgnoreCase("manage")) {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.ManageRoyale)) {
                        //TODO process manage request
                    } else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                } else if (args[0].equalsIgnoreCase("help")) {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.HelpRoyale))
                        ChatHelper.sendStringArray(player, ChatHelper.getRoyaleHelpMessages());
                    else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                } else {
                    if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.HelpRoyale))
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                    else
                        player.sendMessage(ChatHelper.getNoPermissionMessage());
                }
            } else {
                if (player.hasPermission(PermissionHelper.all) || player.hasPermission(PermissionHelper.HelpRoyale))
                    player.sendMessage(ChatHelper.getNoPermissionMessage());
                else
                    player.sendMessage(ChatHelper.getNoPermissionMessage());
            }
        }
        return false;
    }
}
