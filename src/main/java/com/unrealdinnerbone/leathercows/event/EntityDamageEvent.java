package com.unrealdinnerbone.leathercows.event;

import com.unrealdinnerbone.leathercows.LeatherCows;
import com.unrealdinnerbone.leathercows.entities.EntityLeatherCow;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = LeatherCows.MOD_ID)
public class EntityDamageEvent {

    @SubscribeEvent
    public static void onEntityEvent(EntityStruckByLightningEvent entityStruckByLightningEvent) {
        Entity entity = entityStruckByLightningEvent.getEntity();
        if(entity instanceof EntityCow) {
            if (!(entity instanceof EntityLeatherCow)) {
                EntityCow entityCow = (EntityCow) entity;
                if (!entity.world.isRemote && !entity.isDead) {
                    EntityLeatherCow leatherPopCow = new EntityLeatherCow(entity.world);
                    leatherPopCow.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);
                    leatherPopCow.setNoAI(entityCow.isAIDisabled());
                    if (entity.hasCustomName()) {
                        leatherPopCow.setCustomNameTag(entityCow.getCustomNameTag());
                        leatherPopCow.setAlwaysRenderNameTag(entityCow.getAlwaysRenderNameTag());
                    }
                    entityCow.world.spawnEntity(leatherPopCow);
                    entityCow.setDead();
                }
            }
        }
    }
}
