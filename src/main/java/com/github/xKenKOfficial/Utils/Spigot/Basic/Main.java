package com.github.xKenKOfficial.Utils.Spigot.Basic;

import com.github.xKenKOfficial.Utils.Spigot.Listeners.PlayerJoin;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener
{
    private static Main plugin;

    public void onEnable()
    {
        (plugin) = this;
        this.saveDefaultConfig();
        this.registerListeners();
        System.out.println("###########################################################");
        System.out.println(this.getName());
        System.out.println("Wersja: " + this.getDescription().getVersion());
        System.out.println("Wykryta wersja Bukkit: " + Bukkit.getBukkitVersion());
        System.out.println(this.isEnabled() ? "Aktywowany" : "Dezaktywowany");
        System.out.println("Jakiekolwiek edycje i naruszenie praw autorskich - ZABRONIONE!");
        System.out.println("###########################################################");
    }

    public void onDisable()
    {
        this.saveDefaultConfig();
        System.out.println("###########################################################");
        System.out.println(this.getName());
        System.out.println("Wersja: " + this.getDescription().getVersion());
        System.out.println("Wykryta wersja Bukkit: " + Bukkit.getBukkitVersion());
        System.out.println(this.isEnabled() ? "Aktywowany" : "Dezaktywowany");
        System.out.println("Jakiekolwiek edycje i naruszenie praw autorskich - ZABRONIONE!");
        System.out.println("###########################################################");
    }

    private void registerListeners()
    {
        this.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new PlayerJoin(), (Plugin)this);
    }

    public static Main getPlugin()
    {
        return plugin;
    }
}
