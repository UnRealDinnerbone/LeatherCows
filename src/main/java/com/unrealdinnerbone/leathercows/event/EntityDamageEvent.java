package com.unrealdinnerbone.leathercows.event;

import com.unrealdinnerbone.leathercows.LeatherCows;
import com.unrealdinnerbone.leathercows.LeatherCowsConfig;
import com.unrealdinnerbone.leathercows.entities.EntityLeatherCow;
import com.unrealdinnerbone.leathercows.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
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

    @SubscribeEvent
    public void livingUpdateEvent(LivingEvent.LivingUpdateEvent event){
        if(LeatherCowsConfig.normalCowsDropLeather) {
            if (event.getEntityLiving() != null && event.getEntityLiving().world != null) {
                World world = event.getEntityLiving().world;
                if (!world.isRemote) {
                    if (event.getEntityLiving() instanceof EntityCow && !(event.getEntityLiving() instanceof EntityLeatherCow)) {
                        EntityCow entityCow = (EntityCow) event.getEntityLiving();
                        if (!entityCow.isChild() && world.rand.nextInt(LeatherCowsConfig.dropChance) == 0) {
                            entityCow.dropItem(Items.LEATHER, MathHelper.getRandomInt(world.rand, LeatherCowsConfig.cowMinDrop, LeatherCowsConfig.cowMaxDrop));
                        }
                    }

                }
            }
        }
    }
}
