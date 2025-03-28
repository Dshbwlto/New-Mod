package net.dshbwlto.modcourse.datagen;

import net.dshbwlto.modcourse.ModCourse;
import net.dshbwlto.modcourse.block.ModBlocks;
import net.dshbwlto.modcourse.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> BLACK_OPAL_SMELTABLES = List.of(ModItems.RAW_BLACK_OPAL,
                ModBlocks.BLACK_OPAL_ORE, ModBlocks.BLACK_OPAL_DEEPSLATE_ORE, ModBlocks.BLACK_OPAL_NETHER_ORE, ModBlocks.BLACK_OPAL_END_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_OPAL_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BLACK_OPAL.get())
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BLACK_OPAL_SWORD.get())
                .pattern(" O ")
                .pattern(" O ")
                .pattern(" S ")
                .define('O', ModItems.BLACK_OPAL.get())
                .define('S', Items.STICK)
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BLACK_OPAL_PICKAXE.get())
                .pattern("OOO")
                .pattern(" S ")
                .pattern(" S ")
                .define('O', ModItems.BLACK_OPAL.get())
                .define('S', Items.STICK)
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BLACK_OPAL_SHOVEL.get())
                .pattern(" O ")
                .pattern(" S ")
                .pattern(" S ")
                .define('O', ModItems.BLACK_OPAL.get())
                .define('S', Items.STICK)
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BLACK_OPAL_AXE.get())
                .pattern(" OO")
                .pattern(" SO")
                .pattern(" S ")
                .define('O', ModItems.BLACK_OPAL.get())
                .define('S', Items.STICK)
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BLACK_OPAL_HOE.get())
                .pattern(" OO")
                .pattern(" S ")
                .pattern(" S ")
                .define('O', ModItems.BLACK_OPAL.get())
                .define('S', Items.STICK)
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BLACK_OPAL_HAMMER.get())
                .pattern("OOO")
                .pattern(" S ")
                .pattern(" S ")
                .define('O', ModBlocks.BLACK_OPAL_BLOCK.get())
                .define('S', Items.STICK)
                .unlockedBy("has_black_opal_block", has(ModBlocks.BLACK_OPAL_BLOCK.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BLACK_OPAL_HELMET.get())
                .pattern("OOO")
                .pattern("O O")
                .pattern("   ")
                .define('O', ModItems.BLACK_OPAL.get())
                .unlockedBy("has_black_opal_block", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BLACK_OPAL_CHESTPLATE.get())
                .pattern("O O")
                .pattern("OOO")
                .pattern("OOO")
                .define('O', ModItems.BLACK_OPAL.get())
                .unlockedBy("has_black_opal_block", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BLACK_OPAL_LEGGINGS.get())
                .pattern("OOO")
                .pattern("O O")
                .pattern("O O")
                .define('O', ModItems.BLACK_OPAL.get())
                .unlockedBy("has_black_opal_block", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BLACK_OPAL_BOOTS.get())
                .pattern("   ")
                .pattern("O O")
                .pattern("O O")
                .define('O', ModItems.BLACK_OPAL.get())
                .unlockedBy("has_black_opal_block", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACK_OPAL.get(), 9)
                .requires(ModBlocks.BLACK_OPAL_BLOCK.get())
                .unlockedBy("has_black_opal_block", has(ModBlocks.BLACK_OPAL_BLOCK.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACK_OPAL.get(), 9)
                .requires(ModBlocks.MAGIC_BLOCK.get())
                .unlockedBy("has_magic_block", has(ModBlocks.MAGIC_BLOCK.get())).save(recipeOutput, "modcourse:black_opal_2");

        oreSmelting(recipeOutput, BLACK_OPAL_SMELTABLES, RecipeCategory.MISC, ModItems.BLACK_OPAL.get(), 0.25f, 200, "black_opal");
        oreBlasting(recipeOutput, BLACK_OPAL_SMELTABLES, RecipeCategory.MISC, ModItems.BLACK_OPAL.get(), 0.25f, 100, "black_opal");

        stairBuilder(ModBlocks.BLACK_OPAL_STAIRS.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                        .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_OPAL_SLAB.get(), ModItems.BLACK_OPAL.get());

        pressurePlate(recipeOutput, ModBlocks.BLACK_OPAL_PRESSURE_PLATE.get(), ModItems.BLACK_OPAL.get());
        buttonBuilder(ModBlocks.BLACK_OPAL_BUTTON.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);

        fenceBuilder(ModBlocks.BLACK_OPAL_FENCE.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        fenceGateBuilder(ModBlocks.BLACK_OPAL_FENCE_GATE.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_OPAL_WALL.get(), ModItems.BLACK_OPAL.get());

        doorBuilder(ModBlocks.BLACK_OPAL_DOOR.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.BLACK_OPAL_TRAPDOOR.get(), Ingredient.of(ModItems.BLACK_OPAL.get())).group("black_opal")
                .unlockedBy("has_black_opal", has(ModItems.BLACK_OPAL.get())).save(recipeOutput);

        trimSmithing(recipeOutput, ModItems.DSHBWLTO_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(ModCourse.MOD_ID, "dshbwlto"));

    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result,
                                      float experience, int cookingTime, String group) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, ingredients, category, result,
                experience, cookingTime, group, "_from_smelting");

    }
    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result,
                                      float experience, int cookingTime, String group) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, ingredients, category, result,
                experience, cookingTime, group, "_from_blasting");

    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> cookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group, String recipeName) {
        for(ItemLike itemLike : ingredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemLike), category, result, experience, cookingTime, cookingSerializer, factory).group(group).unlockedBy(getHasName(itemLike), has(itemLike))
                    .save(recipeOutput, ModCourse.MOD_ID + ":" + getItemName(result) + recipeName+ "_" + getItemName(itemLike));
        }
    }
}
