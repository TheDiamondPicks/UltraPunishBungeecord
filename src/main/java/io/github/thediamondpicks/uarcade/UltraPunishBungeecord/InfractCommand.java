package io.github.thediamondpicks.uarcade.UltraPunishBungeecord;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class InfractCommand extends Command {
	public InfractCommand() {
		super("infract");
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer s = (ProxiedPlayer) sender;
		if (args.length < 2) {
			s.sendMessage( new ComponentBuilder( "/infract " ).color( ChatColor.WHITE ).append( "is used to punish players in a consistant and easy to understand way. For detailed information regarding infractions please type " ).color( ChatColor.DARK_AQUA ).append( "/help staff infractions" ).color( ChatColor.WHITE ).append("\n Not enough arguments! Usage: /infract [player] [predefined reason]").color(" ChatColor.RED ").append("\n§bPredefined Reasons: Minor: caps, minorspamming and symbols. Mild: advertising, bypassing (for swear filter only), harassment, inappropriate, minorspamming, racism and url. Major: ip and phishing (Bans user for 1 day, contact a §5Moderator+ or higher for final ban)").color( ChatColor.AQUA ).create() );

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
			if (args[1].equalsIgnoreCase("minorspamming") || args[1].equalsIgnoreCase("symbols")
					|| args[1].equalsIgnoreCase("caps")) {
				// TODO send message to staff on the same server
				s.sendMessage(new TextComponent("§5[Infraction] §dYou §dinfracted §dplayer §f" + args[0] + "§d for §f"
						+ args[1]
						+ "§d! §dPlease §dnote §dthat §dif §dthis §dinfraction §dwas §dunintentional §dplease §dcontact §da §dModerator §dor §dhigher §dwith §dthe §dinfraction §dID §d(Avaliable §din §f/check)"));
			
			} else if (args[1].equalsIgnoreCase("harassment") || args[1].equalsIgnoreCase("advertising")
					|| args[1].equalsIgnoreCase("inappropriate") || args[1].equalsIgnoreCase("profanity")
					|| args[1].equalsIgnoreCase("racism") || args[1].equalsIgnoreCase("bypassing")
					|| args[1].equalsIgnoreCase("majorspamming") || args[1].equalsIgnoreCase("url")) {
				s.sendMessage(new TextComponent("§5[Infraction] §dYou §dinfracted §dplayer §f" + args[0] + "§d for §f"
						+ args[1]
						+ "§d! §dPlease §dnote §dthat §dif §dthis §dinfraction §dwas §dunintentional §dplease §dcontact §da §dModerator §dor §dhigher §dwith §dthe §dinfraction §dID §d(Avaliable §din §f/check)"));
			} 
			
			else if (args[1].equalsIgnoreCase("ip") || args[1].equalsIgnoreCase("phishing")) {
				s.sendMessage(new TextComponent("§5[Infraction] §dYou §dinfracted §dplayer §f" + args[0] + "§d for §f"
						+ args[1]
						+ "§d! §dPlease §dnote §dthat §dif §dthis §dinfraction §dwas §dunintentional §dplease §dcontact §da §dModerator §dor §dhigher §dwith §dthe §dinfraction §dID §d(Avaliable §din §f/check)"));
				ProxiedPlayer victim = ProxyServer.getInstance().getPlayer(args[0]);
				System.out.println(victim);
					victim.disconnect("§4§lYou have been kicked from §f§l" + victim.getServer().getInfo().getName() + " §4§l:\n§cYou have recieved an infraction!\n"
							+ "\n§5Reason: §f" + args[1] + "\n§d§oFor more information about infractions please type §r§o/help infractions §d§owhen you join again\n\n§3Do you think you have been unfairly warned? Appeal at §fultraarcade.coming.never §3and a staff member will review your case");
				
				
			}
			
			else {

				s.sendMessage(new TextComponent("§cInvalid §creason! §cUsage: §f/infract [player] [predefined reason]"
						+ "\n§bPredefined Reasons: §3Minor: §fcaps§3, §fminorspamming§3 and §fsymbols§3. §3Mild: §fadvertising§3, §fbypassing§3 §3(for §3swear §3filter §3only), §fharassment§3, §finappropriate§3, §fminorspamming§3, §fracism§3 and §furl§3. §3Major: §fip§3 §3and §fphishing§3 §3(Bans §3user §3for §31 §3day, §3contact §3a §5Moderator+ §3or §3higher §3for §3final §3ban)"));
			}

		} else if (args.length == 3 && args[3].equals("confirm")) {
			if (args[1].equalsIgnoreCase("spamming") || args[1].equalsIgnoreCase("symbols")
					|| args[1].equalsIgnoreCase("caps") || args[1].equalsIgnoreCase("harassment")
					|| args[1].equalsIgnoreCase("advertising") || args[1].equalsIgnoreCase("harassment")
					|| args[1].equalsIgnoreCase("profanity") || args[1].equalsIgnoreCase("inappropriate")) {
				// TODO send message to staff on the same server
				s.sendMessage(new TextComponent("§5[Infractions] §dYou §dwarned §dplayer §f" + args[0] + "§d for §f"
						+ args[1]
						+ "§d! §dPlease §dnote §dthat §dif §dthis §dinfraction §dwas §dunintentional §dplease §dcontact §da §dModerator §dor §dhigher §dwith §dthe §dwarning §dID §d(Avaliable §din §f/check§d)"));
			} else {
				s.sendMessage(new TextComponent("§cInvalid reason! Usage: §f/warn [player] [predefined reason]"
						+ "\n§bPredefined Reasons: §3Minor: §fcaps§3, §fminorspamming§3 §3and §fsymbols§3. §3Mild: §fadvertising§3, §fbypassing§3 §3(§3for §3swear §3filter §3only), §fharassment§3, §finappropriate§3, §fminorspamming§3, §fracism§3 and §furl§3. §3Major: §fip§3 and §fphishing§3 §3(Bans §3user §3for §31 §3day, §3contact §3a §5Moderator+ §3or §3higher §3for §3final §3ban)"));
			}

		} else {
			s.sendMessage(new TextComponent(
					"§f/infract §3is §3used §3to §3punish §3players §3in §3a §3consistant §3and §3easy §3to §3understand §3way. §3For §3detailed §3information §3regarding §3infractions §3please §3type §f/help staff infractions\n §cToo §cmany §carguments! §cUsage: §f/infract [player] [predefined reason]"
							+ "\n§bPredefined §bReasons: §3Minor: §fcaps§3, §fminorspamming§3 and §fsymbols§3. §3Mild: §fadvertising§3, §fbypassing§3 §3(for §3swear §3filter §3only), §fharassment§3, §finappropriate§3, §fminorspamming§3, §fracism§3 and §furl§3. §3Major: §fip§3 and §fphishing§3 (§3Bans §3user §3for §31 §3day, §3contact §3a §5Moderator+ §3or §3higher §3for §3final §3ban)"));
		}

	}

}
