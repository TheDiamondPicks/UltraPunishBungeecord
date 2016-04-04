package io.github.thediamondpicks.uarcade.UltraPunishBungeecord;

import java.sql.PreparedStatement;

import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin implements Listener {
	private MySQL mysql;
	private static Main instance;

	@Override
	public void onEnable() {
		getProxy().getPluginManager().registerListener(this, this);
		getProxy().getPluginManager().registerCommand(this, new Commands());
		instance = this;
		connectMySQL();
	}
	@Override
	public void onDisable() {
		mysql.close();
	}
	public static Main getInstance(){
	       return instance;
	   }

	   public MySQL getMySQL(){
	       return mysql;
	   }

	   public void connectMySQL() {
	        mysql = new MySQL("localhost", "Punish",
	               "user", "pass");
	        PreparedStatement warnstatement = mysql.prepareStatement(
	        	       "CREATE TABLE IF NOT EXISTS Warns(TargetUUID varchar(36), ExecutorUUID VARCHAR(32), Reason CHAR(15), Issued TIMESTAMP, Expires TIMESTAMP, hasSent BOOLEAN, type INT(1)");
	        	       mysql.update(warnstatement);
	    }
	}


