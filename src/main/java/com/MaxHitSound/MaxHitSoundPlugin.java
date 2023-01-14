package com.MaxHitSound;


import com.google.inject.Provides;
import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.api.Hitsplat;

import java.net.URL;

import jaco.mp3.player.MP3Player;

import javax.inject.Inject;
import java.net.URL;

@Slf4j
@PluginDescriptor(
	name = "MaxHitSound"
)
public class MaxHitSoundPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private MaxHitSoundConfig config;
	private MP3Player trackPlayer = new MP3Player(getClass().getClassLoader().getResource("MaxHitSound.mp3"));
	private MP3Player customtrack = new MP3Player(getClass().getClassLoader().getResource("MaxHitSound.mp3"));


	@Subscribe
	public void onHitsplatApplied(HitsplatApplied hitsplatApplied) throws Exception {
		Actor target = hitsplatApplied.getActor();
		Hitsplat hitsplat = hitsplatApplied.getHitsplat();
			if (hitsplat.isMine()) {
				if(hitsplat.getHitsplatType() == 43){
					trackPlayer.setVolume(config.volume());
					if (config.customjingle()) {
						if (config.custompath().endsWith(".mp3") || config.custompath().endsWith(".MP3")) {
							if (config.custompath().startsWith("http://") || config.custompath().startsWith("https://")) {
							customtrack = new MP3Player(new URL(config.custompath()));
							}
						} else {
						customtrack = new MP3Player(getClass().getClassLoader().getResource("MaxHitSound.mp3"));
					}
					customtrack.play();
				} else
				trackPlayer.play();
			}
		}
	}



	@Provides
	MaxHitSoundConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MaxHitSoundConfig.class);
	}
}
