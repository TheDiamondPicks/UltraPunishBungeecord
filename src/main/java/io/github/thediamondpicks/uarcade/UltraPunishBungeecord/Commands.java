package io.github.thediamondpicks.uarcade.UltraPunishBungeecord;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.plugin.Command;

public class Commands extends Command {
	public Commands() {
	      super("helloworld");
	  }
	@Override
	  public void execute(CommandSender commandSender, String[] strings) {
	      commandSender.sendMessage(new ComponentBuilder("Hello world!").color(ChatColor.GREEN).create());
	  }
}
