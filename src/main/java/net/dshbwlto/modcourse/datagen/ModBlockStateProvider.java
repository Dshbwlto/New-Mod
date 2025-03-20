package net.dshbwlto.modcourse.datagen;

import net.dshbwlto.modcourse.ModCourse;
import net.dshbwlto.modcourse.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ModCourse.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BLACK_OPAL_BLOCK);
        blockWithItem(ModBlocks.RAW_BLACK_OPAL_BLOCK);

        blockWithItem(ModBlocks.BLACK_OPAL_ORE);
        blockWithItem(ModBlocks.BLACK_OPAL_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.BLACK_OPAL_NETHER_ORE);
        blockWithItem(ModBlocks.BLACK_OPAL_END_ORE);

        blockWithItem(ModBlocks.MAGIC_BLOCK);

        stairsBlock(((StairBlock) ModBlocks.BLACK_OPAL_STAIRS.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.BLACK_OPAL_SLAB.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));

    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
