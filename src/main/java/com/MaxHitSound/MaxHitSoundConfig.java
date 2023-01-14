package com.MaxHitSound;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("MaxHitSound")
public interface MaxHitSoundConfig extends Config
{
	@Range(
			max = 100
	)
	@ConfigItem(
			keyName = "volume",
			name = "Volume",
			description = "Specify the volume.",
			position = 1
	)
	default int volume()
	{
		return 100;
	}

	@ConfigItem(
			keyName = "Custom sound",
			name = "Custom Jingle",
			description = "Toggles whether a custom jingle is used",
			position = 2
	)
	default boolean customjingle()
	{
		return false;
	}
	@ConfigItem(
			keyName = "custom path",
			name = "Custom path",
			description = "Specify file path or URL(must contain http:// or https://) to custom MP3",
			position = 3
	)
	default String custompath()
	{
		return "";
	}
}
