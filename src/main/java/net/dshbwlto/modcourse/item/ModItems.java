package net.dshbwlto.modcourse.item;

import net.dshbwlto.modcourse.ModCourse;
import net.dshbwlto.modcourse.item.custom.*;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ModCourse.MOD_ID);

    public static final DeferredItem<Item> BLACK_OPAL = ITEMS.registerSimpleItem("black_opal");
    public static final DeferredItem<Item> RAW_BLACK_OPAL =
            ITEMS.registerItem("raw_black_opal", Item::new, new Item.Properties());

    public static final DeferredItem<Item> CHAINSAW =
            ITEMS.registerItem("chainsaw", ChainsawItem::new, new Item.Properties().durability(32));

    public static final DeferredItem<Item> TOMATO =
            ITEMS.registerItem("tomato", properties -> new Item(properties) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.modcourse.tomato.1"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            }, new Item.Properties().food(ModFoodProperties.TOMATO));
    public static final DeferredItem<Item> FROSTFIRE_ICE =
            ITEMS.registerItem("frostfire_ice", properties -> new FuelItem(properties, 800), new Item.Properties());

    public static final DeferredItem<Item> BLACK_OPAL_SWORD = ITEMS.register("black_opal_sword",
            () -> new ModEffectSwordItem(ModToolTiers.BLACK_OPAL,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.BLACK_OPAL, 3, -2.4f)), MobEffects.WITHER));
    public static final DeferredItem<Item> BLACK_OPAL_PICKAXE = ITEMS.register("black_opal_pickaxe",
            () -> new PickaxeItem(ModToolTiers.BLACK_OPAL,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.BLACK_OPAL, 1, -2.8f))));
    public static final DeferredItem<Item> BLACK_OPAL_SHOVEL = ITEMS.register("black_opal_shovel",
            () -> new ShovelItem(ModToolTiers.BLACK_OPAL,
                    new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.BLACK_OPAL, 1.5f, -3.0f))));
    public static final DeferredItem<Item> BLACK_OPAL_AXE = ITEMS.register("black_opal_axe",
            () -> new AxeItem(ModToolTiers.BLACK_OPAL,
                    new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.BLACK_OPAL, 6, -3.2f))));
    public static final DeferredItem<Item> BLACK_OPAL_HOE = ITEMS.register("black_opal_hoe",
            () -> new HoeItem(ModToolTiers.BLACK_OPAL,
                    new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.BLACK_OPAL, 0, -3f))));
    public static final DeferredItem<Item> BLACK_OPAL_HAMMER = ITEMS.register("black_opal_hammer",
            () -> new HammerItem(ModToolTiers.BLACK_OPAL,
                    new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.BLACK_OPAL, 6, -3))));

    public static final DeferredItem<Item> BLACK_OPAL_HELMET = ITEMS.register("black_opal_helmet",
            () -> new ModArmorItem(ModArmorMaterials.BLACK_OPAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability((ArmorItem.Type.HELMET.getDurability(16)))));
    public static final DeferredItem<Item> BLACK_OPAL_CHESTPLATE = ITEMS.register("black_opal_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.BLACK_OPAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability((ArmorItem.Type.CHESTPLATE.getDurability(16)))));
    public static final DeferredItem<Item> BLACK_OPAL_LEGGINGS = ITEMS.register("black_opal_leggings",
            () -> new ModArmorItem(ModArmorMaterials.BLACK_OPAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability((ArmorItem.Type.LEGGINGS.getDurability(16)))));
    public static final DeferredItem<Item> BLACK_OPAL_BOOTS = ITEMS.register("black_opal_boots",
            () -> new ModArmorItem(ModArmorMaterials.BLACK_OPAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability((ArmorItem.Type.BOOTS.getDurability(16)))));

    public static final DeferredItem<Item> BLACK_OPAL_HORSE_ARMOR = ITEMS.register("black_opal_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.BLACK_OPAL, AnimalArmorItem.BodyType.EQUESTRIAN, false, new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> DSHBWLTO_SMITHING_TEMPLATE = ITEMS.register("dshbwlto_armor_trim_smithing_template",
            () -> SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(ModCourse.MOD_ID, "dshbwlto")));

    public static final DeferredItem<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));
    public static final DeferredItem<Item> DATA_TABLET = ITEMS.register("data_tablet",
            () -> new DataTabletItem(new Item.Properties().stacksTo(1)));




    public static void register(IEventBus eventBus) { ITEMS.register(eventBus); }
}
