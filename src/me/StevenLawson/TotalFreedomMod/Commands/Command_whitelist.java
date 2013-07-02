package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_ServerInterface;
import me.StevenLawson.TotalFreedomMod.TFM_SuperadminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.OP, source = SourceType.BOTH)
@CommandParameters(description = "Manage the whitelist.", usage = "/<command> <on | off | list | count | add <player> | remove <player> | addall | purge>")
public class Command_whitelist extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length < 1)
        {
            return false;
        }

        // list
        if (args[0].equalsIgnoreCase("list"))
        {
            playerMsg("Whitelisted players: " + TFM_Util.playerListToNames(server.getWhitelistedPlayers()));
            return true;
        }

        // count
        if (args[0].equalsIgnoreCase("count"))
        {
            int onlineWPs = 0;
            int offlineWPs = 0;
            int totalWPs = 0;

            for (OfflinePlayer p : server.getWhitelistedPlayers())
            {
                if (p.isOnline())
                {
                    onlineWPs++;
                }
                else
                {
                    offlineWPs++;
                }
                totalWPs++;
            }

            playerMsg("Online whitelisted players: " + onlineWPs);
            playerMsg("Offline whitelisted players: " + offlineWPs);
            playerMsg("Total whitelisted players: " + totalWPs);

            return true;
        }

        // all commands past this line are superadmin-only
        if (!(senderIsConsole || TFM_SuperadminList.isUserSuperadmin(sender)))
        {
            sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);
            return true;
        }

        // on
        if (args[0].equalsIgnoreCase("on"))
        {
            TFM_Util.adminAction(sender.getName(), "Turning the whitelist on.", true);
            server.setWhitelist(true);
            return true;
        }

        // off
        if (args[0].equalsIgnoreCase("off"))
        {
            TFM_Util.adminAction(sender.getName(), "Turning the whitelist off.", true);
            server.setWhitelist(false);
            return true;
        }

        // add
        if (args[0].equalsIgnoreCase("add"))
        {
            if (args.length < 2)
            {
                return false;
            }

            String search_name = args[1].trim().toLowerCase();

            OfflinePlayer p;
            try
            {
                p = getPlayer(search_name);
            }
            catch (CantFindPlayerException ex)
            {
                p = server.getOfflinePlayer(search_name);
            }

            TFM_Util.adminAction(sender.getName(), "Adding " + p.getName() + " to the whitelist.", false);
            p.setWhitelisted(true);
            return true;
        }

        // remove
        if (args[0].equalsIgnoreCase("remove"))
        {
            if (args.length < 2)
            {
                return false;
            }

            String search_name = args[1].trim().toLowerCase();

            OfflinePlayer p;
            try
            {
                p = getPlayer(search_name);
            }
            catch (CantFindPlayerException ex)
            {
                p = server.getOfflinePlayer(search_name);
            }

            if (p.isWhitelisted())
            {
                TFM_Util.adminAction(sender.getName(), "Removing " + p.getName() + " from the whitelist.", false);
                p.setWhitelisted(false);
                return true;
            }
            else
            {
                playerMsg("That player is not whitelisted");
                return true;
            }

        }

        // addall
        if (args[0].equalsIgnoreCase("addall"))
        {
            TFM_Util.adminAction(sender.getName(), "Adding all online players to the whitelist.", false);
            int counter = 0;
            for (Player p : server.getOnlinePlayers())
            {
                if (!p.isWhitelisted())
                {
                    p.setWhitelisted(true);
                    counter++;
                }
            }

            playerMsg("Whitelisted " + counter + " players.");
            return true;
        }

        // all commands past this line are console/telnet only
        if (!senderIsConsole)
        {
            sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);
            return true;
        }

        //purge
        if (args[0].equalsIgnoreCase("purge"))
        {
            TFM_Util.adminAction(sender.getName(), "Removing all players from the whitelist.", false);
            playerMsg("Removed " + TFM_ServerInterface.purgeWhitelist() + " players from the whitelist.");

            return true;
        }

        // none of the commands were executed
        return false;
    }
}
