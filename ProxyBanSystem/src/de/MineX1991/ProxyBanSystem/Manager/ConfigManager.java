package de.MineX1991.ProxyBanSystem.Manager;

import de.MineX1991.ProxyBanSystem.Main.Main;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;


/**
 * @author MineX1991
 */
public class ConfigManager {
    
    public static File file = new File(Main.getProxyBan().getDataFolder().getPath(), "config.yml");
    public static String path = ".ProxyBanSystem";
    public static List<String> CanJoin = new ArrayList();
    
    public static void loadConfiguration() {
        if (!Main.getProxyBan().getDataFolder().exists()) {
            Main.getProxyBan().getDataFolder().mkdir();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
                set("GLOBAL_Prefix", "&6Proxy&9Ban§3System: &7");
                set("GLOBAL_NoPermission", "§cYou have no permission");
                set("GLOBAL_BanCommand", "ban");
                set("GLOBAL_KickCommand", "kick");
                set("GLOBAL_TempbanCommand", "tempban");
                set("GLOBAL_UnbanCommand", "unban");
                set("GLOBAL_MuteCommand", "mute");
                set("GLOBAL_TempmuteCommand", "tempmute");
                set("GLOBAL_UnmuteCommand", "unmute");
            } catch (IOException ex) {
                Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "Loading error: ConfigManager.java");
            }
        }
        reloadConfiguration(false);
    }
    public static void reloadConfiguration(boolean done) {
        try {
            if (!done) {
                Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
                return;
            }
            loadConfiguration();
        } catch (IOException ex) {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "Reload error: ConfigManager.java");
        }
    }
    public static void set(String newPath, Object value) {
        try {
            Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
            config.set(path + newPath, value);
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
        } catch (IOException ex) {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "setMethod : ConfigManager.java");
        }
    }
    public static String getString(String newPath) throws IOException {
        Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
        return config.getString(path + newPath);
    }
    public static String getPath() {
        return path;
    }
    public static String getPrefix() {
        try {
            return ChatColor.translateAlternateColorCodes('&', getString("GLOBAL_Prefix"));
        } catch (IOException ex) {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "GLOBAL_Prefix: ConfigManager.java");
        }
        return null;
    }
    public static String getNoPerm() {
        try {
            return ChatColor.translateAlternateColorCodes('&', getString("GLOBAL_NoPermission"));
        } catch (IOException ex) {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "GLOBAL_NoPermission: ConfigManager.java");
        }
        return null;
    }
    public static String getBanCommand() {
        try {
            return ChatColor.translateAlternateColorCodes('&', getString("GLOBAL_BanCommand"));
        } catch (IOException ex) {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "GLOBAL_BanCommand: ConfigManager.java");
        }
        return null;
    }
    public static String getKickCommand() {
        try {
            return ChatColor.translateAlternateColorCodes('&', getString("GLOBAL_KickCommand"));
        } catch (IOException ex) {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "GLOBAL_KickCommand: ConfigManager.java");
        }
        return null;
    }
    public static String getTempbanCommand() {
        try {
            return ChatColor.translateAlternateColorCodes('&', getString("GLOBAL_TempbanCommand"));
        } catch (IOException ex) {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "GLOBAL_TempbanCommand: ConfigManager.java");
        }
        return null;
    }
    public static String getUnbanCommand() {
        try {
            return ChatColor.translateAlternateColorCodes('&', getString("GLOBAL_UnbanCommand"));
        } catch (IOException ex) {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "GLOBAL_UnbanCommand: ConfigManager.java");
        }
        return null;
    }
    public static String getMuteCommand() {
        try {
            return ChatColor.translateAlternateColorCodes('&', getString("GLOBAL_MuteCommand"));
        } catch (IOException ex) {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "GLOBAL_MuteCommand: ConfigManager.java");
        }
        return null;
    }
    public static String getTempmuteCommand() {
        try {
            return ChatColor.translateAlternateColorCodes('&', getString("GLOBAL_TempmuteCommand"));
        } catch (IOException ex) {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "GLOBAL_TempmuteCommand: ConfigManager.java");
        }
        return null;
    }
    public static String getUnmuteCommand() {
        try {
            return ChatColor.translateAlternateColorCodes('&', getString("GLOBAL_UnmuteCommand"));
        } catch (IOException ex) {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "GLOBAL_UnmuteCommand: ConfigManager.java");
        }
        return null;
    }
}