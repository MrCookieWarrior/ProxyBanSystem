package de.MineX1991.ProxyBanSystem.Main;

import net.md_5.bungee.api.plugin.Plugin;

/**
 * @author MineX1991
 */
public class Main extends Plugin {
    
    private static Main Instance;
    
    @Override
    public void onEnable() {
        Instance = this;
    }
    @Override
    public void onDisable() {
        
    }
    public static Main getProxyBan() {
        return Instance;
    }
}
