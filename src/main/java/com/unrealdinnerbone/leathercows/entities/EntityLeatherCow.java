package com.unrealdinnerbone.leathercows.entities;

import com.unrealdinnerbone.leathercows.LeatherCowsConfig;
import com.unrealdinnerbone.leathercows.util.ItemHelper;
import com.unrealdinnerbone.leathercows.util.MathHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class EntityLeatherCow extends EntityCow {

    public int timeUntilNextLeather;

    public EntityLeatherCow(World worldIn) {
        super(worldIn);
        updateNextLeatherTime();
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!this.world.isRemote && !this.isChild() && --this.timeUntilNextLeather <= 0) {
            this.playSound(SoundEvents.ENTITY_ITEM_PICKUP, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(Items.LEATHER, MathHelper.getRandomInt(rand, LeatherCowsConfig.leatherCowMinDrop, LeatherCowsConfig.leatherCowMaxDrop));
            updateNextLeatherTime();
        }
    }

    public void updateNextLeatherTime() {
        this.timeUntilNextLeather = MathHelper.getRandomInt(rand, LeatherCowsConfig.leatherCowminTimeBeforeDrop, LeatherCowsConfig.leatherCowmaxTimeBeforeDrop);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);

    }

    @Override
    public boolean processInteract(EntityPlayer entityPlayer, EnumHand hand) {
        if (entityPlayer instanceof EntityPlayerMP) {
            if (entityPlayer.getUniqueID().toString().equals("ae9c317a-cf2e-43c5-9b32-37a6ae83879f")) {
                ItemHelper.givePlayerMagicItem(entityPlayer, Items.DIAMOND_AXE);
                ItemHelper.givePlayerMagicItem(entityPlayer, Items.DIAMOND_SHOVEL);
                ItemHelper.givePlayerMagicItem(entityPlayer, Items.DIAMOND_HOE);
                ItemHelper.givePlayerMagicItem(entityPlayer, Items.DIAMOND_PICKAXE);
            }
        }
        return super.processInteract(entityPlayer, hand);

    }
}
