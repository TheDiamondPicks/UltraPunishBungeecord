package io.github.thediamondpicks.uarcade.UltraPunishBungeecord;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class JoinListener implements Listener {

	private static Map<UUID, Integer> coins = new HashMap<>();

	private static final String INSERT = "INSERT INTO Coins VALUES(?,?,?) ON DUPLICATE KEY UPDATE name=?";
	private static final String SELECT = "SELECT * FROM Coins WHERE uuid=?";
	private static final String SAVE = "UPDATE Coins SET coins=? WHERE uuid=?";

	@EventHandler

	public void onPlayerConnect(ServerConnectEvent event) {
		ProxiedPlayer player = event.getPlayer();
		UUID uid = player.getUniqueId();
		String uids = uid.toString();
	    try {
			Statement statement = Main.c.createStatement();
		    ResultSet res = statement.executeQuery("SELECT * FROM bans WHERE TargetUUID = '" + uids + "';");
		    res.next();
		    if(res.getString("TargetUUID") != null) {
		    	String reason = res.getString("Reason");
		    	player.disconnect(new TextComponent("§4§lKicked whilst connecting to §f§l" + player.getServer().getInfo().getName() + "§4§l:"
		    			+ "\n§c§lYou have been permanently banned from this server!"
		    			+ "\n"
		    			+ "\n§3Reason: §f" + reason
		    			+ "\n"
		    			+ "\n§bUnfairly banned? Appeal at §f192.168.1.23")); 
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}
