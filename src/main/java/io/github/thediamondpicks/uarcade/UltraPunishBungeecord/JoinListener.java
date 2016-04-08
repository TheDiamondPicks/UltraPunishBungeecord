package io.github.thediamondpicks.uarcade.UltraPunishBungeecord;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.UUID;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class JoinListener implements Listener {

	@EventHandler

	public void onPlayerConnect(ServerConnectEvent event) {
		ProxiedPlayer player = event.getPlayer();
		UUID uid = player.getUniqueId();
		String uids = uid.toString();
		String players = player.getName();
		try {
			Statement statement = Main.c.createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM bans WHERE TargetUUID = '" + uids + "';");
			res.next();
			if (res.getString("TargetUUID") != null) {
				String reason = res.getString("Reason");
				player.disconnect(new TextComponent(
						"§4§lKicked whilst connecting to §f§l" + player.getServer().getInfo().getName() + "§4§l:"
								+ "\n§c§lYou have been permanently banned from this server!" + "\n" + "\n§bReason: §f"
								+ reason + "\n" + "\n§bUnfairly banned? Appeal at §f192.168.1.23"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Statement statement = Main.c.createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM bans WHERE TargetUUID = '" + uids + "';");
			res.next();
			if (res.getString("TargetUUID") != null) {
				boolean hasSent = res.getBoolean("hasSent");
				if (hasSent == false) {
					int id = res.getInt("id");
					String reason = res.getString("reason");
					Timestamp date = res.getTimestamp("columnname");
					String dateString = new SimpleDateFormat("dd MMMM YYYY HH:mm:ss").format(date);
					player.sendMessage(new TextComponent(players
							+ "§6, you have recieved a warning whilst you were offline for §f" + reason + "§6 at §f"
							+ dateString
							+ "! Note that warning point are as the name suggests \"warnings\" and have no punishment directly assosiated with them. However they can compound into infractions which §odo §6incur punishments. For more information on the infraction system please type §f/help infractions"));
					statement
							.executeUpdate("INSERT INTO warns." + id + "(`hasWarned`) VALUES ('true');");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
