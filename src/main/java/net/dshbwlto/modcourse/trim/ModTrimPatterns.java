package net.dshbwlto.modcourse.trim;

import net.dshbwlto.modcourse.ModCourse;
import net.dshbwlto.modcourse.item.ModItems;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.Map;

public class ModTrimPatterns {
    public static final ResourceKey<TrimPattern> DSHBWLTO = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(ModCourse.MOD_ID, "dshbwlto"));

    public static void bootstrap(BootstrapContext<TrimPattern> context) {
        register(context, ModItems.DSHBWLTO_SMITHING_TEMPLATE, DSHBWLTO);
    }

    private static void register(BootstrapContext<TrimPattern> context, DeferredItem<Item> item, ResourceKey<TrimPattern> key) {
        TrimPattern trimPattern = new TrimPattern(key.location(), item.getDelegate(),
                Component.translatable(Util.makeDescriptionId("trim_pattern", key.location())), false);
        context.register(key, trimPattern);
    }

}
