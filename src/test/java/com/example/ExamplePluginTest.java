package com.example;

import com.MaxHitSound.MaxHitSoundPlugin;
import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class ExamplePluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(MaxHitSoundPlugin.class);
		RuneLite.main(args);
	}
}