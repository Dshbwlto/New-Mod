package net.dshbwlto.modcourse.item;

import net.dshbwlto.modcourse.ModCourse;
import net.dshbwlto.modcourse.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModCourse.MOD_ID);

    public static final Supplier<CreativeModeTab> BLACK_OPAL_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("black_opal_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.modcourse.black_opal_items_tab"))
                    .icon(() -> new ItemStack(ModItems.BLACK_OPAL.get()))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BLACK_OPAL);
                        output.accept(ModItems.RAW_BLACK_OPAL);

                        output.accept(ModItems.BLACK_OPAL_SWORD);
                        output.accept(ModItems.BLACK_OPAL_PICKAXE);
                        output.accept(ModItems.BLACK_OPAL_SHOVEL);
                        output.accept(ModItems.BLACK_OPAL_AXE);
                        output.accept(ModItems.BLACK_OPAL_HOE);
                        output.accept(ModItems.BLACK_OPAL_HAMMER);

                        output.accept(ModItems.BLACK_OPAL_HELMET);
                        output.accept(ModItems.BLACK_OPAL_CHESTPLATE);
                        output.accept(ModItems.BLACK_OPAL_LEGGINGS);
                        output.accept(ModItems.BLACK_OPAL_BOOTS);

                        output.accept(ModItems.BLACK_OPAL_HORSE_ARMOR);

                        output.accept(ModItems.CHAINSAW);

                        output.accept(ModItems.METAL_DETECTOR);
                        output.accept(ModItems.DATA_TABLET);

                        output.accept(ModItems.TOMATO);

                        output.accept(ModItems.FROSTFIRE_ICE);

                        output.accept(ModItems.DSHBWLTO_SMITHING_TEMPLATE);


                    }).build());

    public static final Supplier<CreativeModeTab> BLACK_OPAL_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("black_opal_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.modcourse.black_opal_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.BLACK_OPAL_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ModCourse.MOD_ID, "black_opal_items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.BLACK_OPAL_BLOCK);

                        output.accept(ModBlocks.MAGIC_BLOCK);

                        output.accept(ModBlocks.BLACK_OPAL_STAIRS);
                        output.accept(ModBlocks.BLACK_OPAL_SLAB);

                        output.accept(ModBlocks.BLACK_OPAL_PRESSURE_PLATE);
                        output.accept(ModBlocks.BLACK_OPAL_BUTTON);

                        output.accept(ModBlocks.BLACK_OPAL_FENCE);
                        output.accept(ModBlocks.BLACK_OPAL_FENCE_GATE);
                        output.accept(ModBlocks.BLACK_OPAL_WALL);

                        output.accept(ModBlocks.BLACK_OPAL_DOOR);
                        output.accept(ModBlocks.BLACK_OPAL_TRAPDOOR);

                        output.accept(ModBlocks.BLACK_OPAL_LAMP);

                        output.accept(ModBlocks.RAW_BLACK_OPAL_BLOCK);

                        output.accept(ModBlocks.BLACK_OPAL_ORE);
                        output.accept(ModBlocks.BLACK_OPAL_DEEPSLATE_ORE);
                        output.accept(ModBlocks.BLACK_OPAL_NETHER_ORE);
                        output.accept(ModBlocks.BLACK_OPAL_END_ORE);


                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
