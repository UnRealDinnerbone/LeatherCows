package com.unrealdinnerbone.leathercows;

import com.unrealdinnerbone.leathercows.entities.EntityLeatherCow;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import org.apache.logging.log4j.Logger;

@Mod(modid = LeatherCows.MOD_ID, name = LeatherCows.MOD_NAME, version = LeatherCows.VERSION)
public class LeatherCows
{
    public static final String MOD_ID = "leathercows";
    public static final String MOD_NAME = "Leather Cows";
    public static final String VERSION = "@VERSION@";
    public static Logger LOGGER;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        LOGGER = event.getModLog();
        EntityRegistry.registerModEntity(new ResourceLocation(MOD_ID, "cow"), EntityLeatherCow.class, "leathercow", 1, this, 64, 3, true, 10592673, 4470310);
    }

}
