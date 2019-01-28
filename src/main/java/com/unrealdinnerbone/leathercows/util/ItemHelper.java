package com.unrealdinnerbone.leathercows.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemHelper
{
    public static void givePlayerMagicItem(EntityPlayer entityPlayer, Item item) {
        ItemStack stack = new ItemStack(item);
        if (!entityPlayer.inventory.hasItemStack(stack)) {
            stack.addEnchantment(Enchantments.UNBREAKING, 10);
            stack.addEnchantment(Enchantments.EFFICIENCY, 10);
            entityPlayer.inventory.addItemStackToInventory(stack);
        }
    }
}
