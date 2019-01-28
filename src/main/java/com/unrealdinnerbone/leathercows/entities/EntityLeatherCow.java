package com.unrealdinnerbone.leathercows.entities;

import com.unrealdinnerbone.leathercows.LeatherCowsConfig;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
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
            this.dropItem(Items.LEATHER, 1);
            updateNextLeatherTime();
        }
    }

    public void updateNextLeatherTime() {
        this.timeUntilNextLeather = rand.nextInt(LeatherCowsConfig.maxTimeBeforeDrop - LeatherCowsConfig.minTimeBeforeDrop) + LeatherCowsConfig.minTimeBeforeDrop;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);

    }
}
