package com.codinglitch.simpleradio.core.central;

import com.codinglitch.lexiconfig.classes.LexiconPageData;
import com.codinglitch.simpleradio.CommonSimpleRadio;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ItemHolder<I extends Item> {
    private final I item;
    private final ResourceLocation location;
    public boolean enabled = true;

    protected ItemHolder(I item, ResourceLocation location) {
        this.item = item;
        this.location = location;
    }

    public static <I extends Item> ItemHolder<I> of(I item, ResourceLocation location, boolean state) {
        ItemHolder<I> holder = new ItemHolder<>(item, location);
        holder.enabled = state;

        LexiconPageData configData = CommonSimpleRadio.SERVER_CONFIG.getPage(location.getPath());
        if (configData != null && state) {
            Object field = configData.getEntry("enabled");
            holder.enabled = field == null || (boolean) field;
        }

        return holder;
    }

    public Item get() {
        return this.item;
    }
}