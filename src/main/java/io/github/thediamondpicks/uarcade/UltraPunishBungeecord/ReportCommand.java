package io.github.thediamondpicks.uarcade.UltraPunishBungeecord;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ReportCommand extends Command {
	public ReportCommand() {
		super("report");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer s = (ProxiedPlayer) sender;
		String formatted = s.getName();
		if (args.length <= 1) {
		
		sender.sendMessage(new TextComponent("§8-----------------------------------------------------\n§f/report §6is used to alert online staff of a rule-breaker. The staff are alerted of the reported player's name, server, reason for reporting and your username. Staff are not guarenteed to read your report so for certainty use the forums. For help use §f/help §6and for bug reports use §f/bugs§6."
				+ "\n§cPlease not that false reporting is §4§lbannable §cso please do not \"test\" it or report for things which are not against the rules (Type §f/rules §cfor a list of them)"
				+ "\n§8-----------------------------------------------------"));
		}
		else {
			TextComponent message = new TextComponent("§2[Reports] §f" + args[0] + " §awas reported!");
			TextComponent hover = new TextComponent( " §2Claim and view information by hovering here" );
			hover.setClickEvent( new ClickEvent( ClickEvent.Action.RUN_COMMAND, "claimreport " + args[0] + "," + sender ) );
			hover.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§5Reported Player: §f" + args[1] + "\n§5Reason: §f" + "soontm" + "\nServer: §f" + s.getServer().getInfo().getName() + "\n§5Reporter: §f" + formatted + "\n§dClick to claim").create() ) );
			message.addExtra(hover);
			// Send it to da online staff
			sender.sendMessage(message);
		}
	}
}
