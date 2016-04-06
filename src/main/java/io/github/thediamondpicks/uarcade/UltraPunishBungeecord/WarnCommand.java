package io.github.thediamondpicks.uarcade.UltraPunishBungeecord;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
// TODO fix class name/boolean thingie
public class WarnCommand extends Command {
	public WarnCommand() {
		super("warn");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer s = (ProxiedPlayer) sender;
		// TODO Implement command sender
		if (args.length < 2) {
			s.sendMessage(new TextComponent(
					"§f/warn §3replaces the method of messaging players if they are breaking the rules in a minor fashion. Use §f/infract §3 for more severe cases.\n §cNot enough arguments! Usage: §f/warn [player] [predefined reason]"
							+ "\n§bAvaliable predefined reasons: §fspamming§3, §fsymbols§3, §fcaps§3, §fharassment§3, §fadvertising§3, §fharassment§3, §fprofanity§3 and §finappropriate"));
		} else if (args.length == 2) {
			// TODO check through player DB to check if they have logged in,
			// update DB with points, implement Auto-Infract, and /warn [p] [r]
			// confirm
			if (args[2].equalsIgnoreCase("spamming") || args[2].equalsIgnoreCase("symbols")
					|| args[2].equalsIgnoreCase("caps") || args[2].equalsIgnoreCase("harassment")
					|| args[2].equalsIgnoreCase("advertising") || args[2].equalsIgnoreCase("harassment")
					|| args[2].equalsIgnoreCase("profanity") || args[2].equalsIgnoreCase("inappropriate")) {
				// TODO loop through *all* online players and notify online
				// staff!
				s.sendMessage(new TextComponent("§5[Warnings] §dYou warned player §f" + args[1] + "§d for §f" + args[2]
						+ "§d! Please note that if this warning was unintentional please contact a Moderator or higher with the warning ID (Avaliable in §f/check). No punisment wil occour on the first few offences however repeated miswarns could lead to further action!"));
			} else {
				s.sendMessage(new TextComponent("§cInvalid reason! Usage: §f/warn [player] [predefined reason]"
						+ "\n§bAvaliable predefined reasons: §fspamming§3, §fsymbols§3, §fcaps§3, §fharassment§3, §fadvertising§3, §fharassment§3, §fprofanity§3 and §finappropriate"));
			}

		} else if (args.length == 3 || args[3].equals("confirm")) {
			if (args[2].equalsIgnoreCase("spamming") || args[2].equalsIgnoreCase("symbols")
					|| args[2].equalsIgnoreCase("caps") || args[2].equalsIgnoreCase("harassment")
					|| args[2].equalsIgnoreCase("advertising") || args[2].equalsIgnoreCase("harassment")
					|| args[2].equalsIgnoreCase("profanity") || args[2].equalsIgnoreCase("inappropriate")) {
				// TODO loop through *all* online players and notify online
				// staff!
				s.sendMessage(new TextComponent("§5[Warnings] §dYou warned player §f" + args[1] + "§d for §f" + args[2]
						+ "§d! Please note that if this warning was unintentional please contact a Moderator or higher with the warning ID (Avaliable in §f/check). No punisment wil occour on the first few offences however repeated miswarns could lead to further action!"));
			} else {
				s.sendMessage(new TextComponent("§cInvalid reason! Usage: §f/warn [player] [predefined reason]"
						+ "\n§bAvaliable predefined reasons: §fspamming§3, §fsymbols§3, §fcaps§3, §fharassment§3, §fadvertising§3, §fharassment§3, §fprofanity§3 and §finappropriate"));
			}

		} else {
			s.sendMessage(new TextComponent(
					"§f/warn §3replaces the method of messaging players if they are breaking the rules in a minor fashion. Use §f/infract §3 for more severe cases.\n §cToo many arguments! Usage: §f/warn [player] [predefined reason]"
							+ "\n§bAvaliable predefined reasons: §fspamming§3, §fsymbols§3, §fcaps§3, §fharassment§3, §fadvertising§3, §fharassment§3, §fprofanity§3 and §finappropriate"));
		}
		
	}

}
