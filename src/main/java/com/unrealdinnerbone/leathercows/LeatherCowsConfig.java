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
    @Config.RangeInt(min = 1)
    public static int leatherCowminTimeBeforeDrop = 3000;
    @Config.Comment({"Max time in ticks before a cow drops leather", "must be bigger then minTimeBeforeDrop"})
    @Config.RangeInt(min = 1)
    public static int leatherCowmaxTimeBeforeDrop = 6000;
    @Config.Comment("The max amount of leather that a cow can drop per drop")
    @Config.RangeInt(min = 1)
    public static int leatherCowMaxDrop = 4;
    @Config.Comment("The max amount of leather that a cow can drop per drop")
    @Config.RangeInt(min = 0)
    public static int leatherCowMinDrop = 1;

    @Config.Comment("Do normal cows drops leather?")
    public static boolean normalCowsDropLeather = true;
    @Config.Comment("The chance the leather drops for a cow")
    public static int dropChance = 6000;
    @Config.RangeInt(min = 1)
    public static int cowMaxDrop = 2;
    @Config.Comment("The max amount of leather that a cow can drop per drop")
    @Config.RangeInt(min = 0)
    public static int cowMinDrop = 1;

    @SubscribeEvent
    public static void onConfigChangEvent(ConfigChangedEvent event) {
        if(event.getModID().equalsIgnoreCase(LeatherCows.MOD_ID)) {
            ConfigManager.sync(LeatherCows.MOD_ID, Config.Type.INSTANCE);
        }
    }
}
