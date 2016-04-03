package io.github.thediamondpicks.uarcade.UltraPunishBungeecord;

import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerListener(this, new LoginListener());
    }

}
