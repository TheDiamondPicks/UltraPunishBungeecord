package io.github.thediamondpicks.uarcade.UltraPunishBungeecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {
    MySQL MySQL = new MySQL("host.name", "port", "database", "user");
    static Connection c = null;

	@Override
	public void onEnable() {
		getProxy().getPluginManager().registerListener(this, new JoinListener());
		getProxy().getPluginManager().registerCommand(this, new Commands());
		
		try {
			c = MySQL.openConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connectMySQL();
	}

	@Override
	public void onDisable() {
	    
	}


	public void connectMySQL() {
		PreparedStatement ps;
		try {
			ps = c.prepareStatement(
					"CREATE TABLE IF NOT EXISTS Warns(TargetUUID varchar(36), ExecutorUUID VARCHAR(32), Reason CHAR(15), Issued TIMESTAMP, Expires TIMESTAMP, hasSent BOOLEAN, type INT(1)");
			ps.executeUpdate();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		PreparedStatement ps1;
		try {
			ps1 = c.prepareStatement(
					"CREATE TABLE IF NOT EXISTS Bans(TargetUUID varchar(36), ExecutorUUID VARCHAR(32), Reason CHAR(15), Issued TIMESTAMP");
			ps1.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
