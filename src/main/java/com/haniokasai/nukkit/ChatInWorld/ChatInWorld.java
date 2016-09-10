package com.haniokasai.nukkit.ChatInWorld;

import java.util.Map.Entry;
import java.util.UUID;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.plugin.PluginBase;



public class ChatInWorld extends PluginBase implements Listener{
	private static ChatInWorld instance;

	public static ChatInWorld getInstance(){
		return instance;
	}


	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
        this.getServer().getLogger().info("[ChatInWorld] Loaded");
	}


	@EventHandler(ignoreCancelled =  false, priority = EventPriority.LOWEST)
	public void chat(PlayerChatEvent event){
		Player player = event.getPlayer();
		String level = event.getPlayer().getLevel().getName();
		String chat = event.getMessage();
        if(player instanceof Player & !event.isCancelled()){
                String name = player.getDisplayName();
                String format = "<"+name+"> "+chat;
                Server.getInstance().getLogger().info(format);
                for(Player playera : Server.getInstance().getOnlinePlayers().values()){
                    if(playera.getLevel().getName() == level){
                        playera.sendMessage(format);
                    }

                }
        }
		event.setCancelled();
    }

	public boolean sendchat(String sendername,String chat,String levelname){
		if(Server.getInstance().getLevelByName(levelname) != null){
                String format = "<"+sendername+"> "+chat;
                Server.getInstance().getLogger().info(format);
                for (Entry<UUID, Player> p : Server.getInstance().getOnlinePlayers().entrySet()) {
                    if(((Player)p).getLevel().getName()==levelname){
                        ((Player) p).sendMessage(format);
                    }

                }
			return true;
		}

		return false;

	}




}