package io.github.thediamondpicks.uarcade.UltraPunishBungeecord;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class InfractCommand extends Command {
	public InfractCommand() {
		super("warn");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer s = (ProxiedPlayer) sender;
		if (args.length < 2) {
			s.sendMessage(new TextComponent(
					"§f/infract §3is used to punish players in a consistant and easy to understand way. For detailed information regarding infractions please type §f/help staff infractions\n §cNot enough arguments! Usage: §f/infract [player] [predefined reason]"
							+ "\n§bPredefined Reasons: §3Minor: §fcaps§3, §fminorspamming§3 and §fsymbols§3. Mild: §fadvertising§3, §fbypassing§3 (for swear filter only), §fharassment§3, §finappropriate§3, §fminorspamming§3, §fracism§3 and §furl§3. Major: §fip§3 and §fphishing§3 (Bans user for 1 day, contact a Moderator+ or higher for final ban)"));
		} else if (args.length == 2) {
			// TODO check through player DB to check if they have logged in,
			// update DB with points, implement punishments & tiers, and
			// /infract [p] [r]
			// confirm

			/*
			 * -- Guide to warning types -- 
			 * caps, symbols, minorspamming // Minor 
			 * advertising, harassment, racism, bypassing, majorspamming, url, inappropriate // Mild 
			 * ip, phishing // Major
			 */
			if (args[2].equalsIgnoreCase("minorspamming") || args[2].equalsIgnoreCase("symbols")
					|| args[2].equalsIgnoreCase("caps")) {
				// TODO send message to staff on the same server
				s.sendMessage(new TextComponent("§5[Infraction] §dYou infracted player §f" + args[1] + "§d for §f"
						+ args[2]
						+ "§d! Please note that if this infraction was unintentional please contact a Moderator or higher with the infraction ID (Avaliable in §f/check)"));
			} else if (args[2].equalsIgnoreCase("harassment") || args[2].equalsIgnoreCase("advertising")
					|| args[2].equalsIgnoreCase("inappropriate") || args[2].equalsIgnoreCase("profanity")
					|| args[2].equalsIgnoreCase("racism") || args[2].equalsIgnoreCase("bypassing")
					|| args[2].equalsIgnoreCase("majorspamming") || args[2].equalsIgnoreCase("url")) {
				s.sendMessage(new TextComponent("§5[Infraction] §dYou infracted player §f" + args[1] + "§d for §f"
						+ args[2]
						+ "§d! Please note that if this infraction was unintentional please contact a Moderator or higher with the infraction ID (Avaliable in §f/check)"));
			} 
			
			else if (args[2].equalsIgnoreCase("ip") || args[2].equalsIgnoreCase("phishing")) {
				s.sendMessage(new TextComponent("§5[Infraction] §dYou infracted player §f" + args[1] + "§d for §f"
						+ args[2]
						+ "§d! Please note that if this infraction was unintentional please contact a Moderator or higher with the infraction ID (Avaliable in §f/check)"));
				ProxiedPlayer victim = args[1];
				if (victim != null) {
					victim.disconnect(new TextComponent("§4§lKicked from §f§l") + victim.getServer().getInfo().getName() + " §4§l:\n§cYou have recieved an infraction!\n"
							+ "\n§5Reason: §f" + args[2] + "\n§d§oFor more information about infractions please type §r§o/help infractions §3§owhen you join again\n\n§3Do you think you have been unfairly warned? Appeal at §fultraarcade.coming.never §3and a staff member will review your case");
				}
				
			}
			
			else {

				s.sendMessage(new TextComponent("§cInvalid reason! Usage: §f/infract [player] [predefined reason]"
						+ "\n§bPredefined Reasons: §3Minor: §fcaps§3, §fminorspamming§3 and §fsymbols§3. Mild: §fadvertising§3, §fbypassing§3 (for swear filter only), §fharassment§3, §finappropriate§3, §fminorspamming§3, §fracism§3 and §furl§3. Major: §fip§3 and §fphishing§3 (Bans user for 1 day, contact a Moderator+ or higher for final ban)"));
			}

		} else if (args.length == 3 && args[3].equals("confirm")) {
			if (args[2].equalsIgnoreCase("spamming") || args[2].equalsIgnoreCase("symbols")
					|| args[2].equalsIgnoreCase("caps") || args[2].equalsIgnoreCase("harassment")
					|| args[2].equalsIgnoreCase("advertising") || args[2].equalsIgnoreCase("harassment")
					|| args[2].equalsIgnoreCase("profanity") || args[2].equalsIgnoreCase("inappropriate")) {
				// TODO send message to staff on the same server
				s.sendMessage(new TextComponent("§5[Infractions] §dYou warned player §f" + args[1] + "§d for §f"
						+ args[2]
						+ "§d! Please note that if this infraction was unintentional please contact a Moderator or higher with the warning ID (Avaliable in §f/check§d)"));
			} else {
				s.sendMessage(new TextComponent("§cInvalid reason! Usage: §f/warn [player] [predefined reason]"
						+ "\n§bPredefined Reasons: §3Minor: §fcaps§3, §fminorspamming§3 and §fsymbols§3. Mild: §fadvertising§3, §fbypassing§3 (for swear filter only), §fharassment§3, §finappropriate§3, §fminorspamming§3, §fracism§3 and §furl§3. Major: §fip§3 and §fphishing§3 (Bans user for 1 day, contact a Moderator+ or higher for final ban)"));
			}

		} else {
			s.sendMessage(new TextComponent(
					"§f/infract §3is used to punish players in a consistant and easy to understand way. For detailed information regarding infractions please type §f/help staff infractions\n §cToo many arguments! Usage: §f/infract [player] [predefined reason]"
							+ "\n§bPredefined Reasons: §3Minor: §fcaps§3, §fminorspamming§3 and §fsymbols§3. Mild: §fadvertising§3, §fbypassing§3 (for swear filter only), §fharassment§3, §finappropriate§3, §fminorspamming§3, §fracism§3 and §furl§3. Major: §fip§3 and §fphishing§3 (Bans user for 1 day, contact a Moderator+ or higher for final ban)"));
		}

	}

}
