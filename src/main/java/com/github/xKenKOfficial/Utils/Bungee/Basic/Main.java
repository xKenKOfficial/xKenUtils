package com.github.xKenKOfficial.Utils.Bungee.Basic;

import com.github.xKenKOfficial.Utils.Bungee.Commands.xKenUtilsCommand;

import com.google.common.io.ByteStreams;

import net.md_5.bungee.api.Favicon;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class Main extends Plugin implements Listener
{
    private static Main plugin;

    private Configuration configuration;
    public static Favicon favicon;

    public void onEnable()
    {
        (plugin) = this;
        this.saveDefaultConfig();
        this.registerCommands();
        this.registerListeners();
        System.out.println("###########################################################");
        System.out.println(this.getDescription().getName());
        System.out.println("Wersja: " + this.getDescription().getVersion());
        System.out.println("Aktywowany");
        System.out.println("Wszelkie Edycje i Naruszanie Praw Autorskich - ZABRONIONE!");
        System.out.println("###########################################################");
    }

    public void onDisable()
    {
        this.saveDefaultConfig();
        System.out.println("###########################################################");
        System.out.println(this.getDescription().getName());
        System.out.println("Wersja: " + this.getDescription().getVersion());
        System.out.println("Dezaktywowany");
        System.out.println("Wszelkie Edycje i Naruszanie Praw Autorskich - ZABRONIONE!");
        System.out.println("###########################################################");
    }

    private void registerCommands()
    {
        this.getLogger().info("Ladowanie komend z pluginu: " + this.getDescription().getName());
        this.getProxy().getPluginManager().registerCommand((Plugin)this, new xKenUtilsCommand("xkenutils"));
    }

    private void registerListeners()
    {
        this.getLogger().info("Ladowanie eventow z pluginu: " + this.getDescription().getName());
        this.getProxy().getPluginManager().registerListener((Plugin)this, (Listener)this);
    }

    public Configuration getConfiguration()
    {
        try {
            this.configuration = ConfigurationProvider.getProvider((Class)YamlConfiguration.class).load(new File(this.getDataFolder(), "config.yml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return configuration;
    }

    public static Favicon getFavicon()
    {
        return favicon;
    }

    protected void reloadConfig() {
        try {
            this.configuration = ConfigurationProvider.getProvider((Class)YamlConfiguration.class).load(new File(this.getDataFolder(), "config.yml"));
        }
        catch (IOException e) {
            throw new RuntimeException("Unable to load configuration", e);
        }
        final File file = new File(this.getDataFolder(), "server-icon.png");
        if (file.exists()) {
            try {
                final BufferedImage bufferedImage = ImageIO.read(file);
                this.favicon = Favicon.create(bufferedImage);
            }
            catch (IOException e2) {
                this.getLogger().warning("Favicon file is invalid or missing.");
            }
        }
    }

    protected void saveConfig() {
        try {
            ConfigurationProvider.getProvider((Class) YamlConfiguration.class).save(this.getConfiguration(), new File(this.getDataFolder(), "config.yml"));
        }
        catch (IOException e) {
            throw new RuntimeException("Unable to save configuration", e);
        }
    }

    private void saveDefaultConfig() {
        if (!this.getDataFolder().exists()) {
            this.getDataFolder().mkdir();
        }
        final File configFile = new File(this.getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
                Throwable t = null;
                try {
                    final InputStream is = this.getResourceAsStream("config.yml");
                    try {
                        final OutputStream os = new FileOutputStream(configFile);
                        try {
                            ByteStreams.copy(is, os);
                        }
                        finally {
                            if (os != null) {
                                os.close();
                            }
                        }
                        if (is != null) {
                            is.close();
                        }
                    }
                    finally {
                        if (t == null) {
                            final Throwable t2 = new Throwable();
                            t = t2;
                        }
                        else {
                            final Throwable t2 = new Throwable();
                            if (t != t2) {
                                t.addSuppressed(t2);
                            }
                        }
                        if (is != null) {
                            is.close();
                        }
                    }
                }
                finally {
                    if (t == null) {
                        final Throwable t3 = new Throwable();
                        t = t3;
                    }
                    else {
                        final Throwable t3 = new Throwable();
                        if (t != t3) {
                            t.addSuppressed(t3);
                        }
                    }
                }
            }
            catch (IOException e) {
                throw new RuntimeException("Unable to create configuration file", e);
            }
        }
    }

    public static Main getPlugin()
    {
        return plugin;
    }
}
