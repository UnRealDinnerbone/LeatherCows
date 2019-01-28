package com.unrealdinnerbone.leathercows;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = LeatherCows.MOD_ID)
@Mod.EventBusSubscriber
public class LeatherCowsConfig {

    @Config.Comment("min time in ticks before a cow drops leather")
    public static int minTimeBeforeDrop = 6000;
    @Config.Comment("Max time in ticks before a cow drops leather")
    public static int maxTimeBeforeDrop = 12000;

    @SubscribeEvent
    public static void onConfigChangEvent(ConfigChangedEvent event) {
        if(event.getModID().equalsIgnoreCase(LeatherCows.MOD_ID)) {
            ConfigManager.sync(LeatherCows.MOD_ID, Config.Type.INSTANCE);
        }
    }
}
