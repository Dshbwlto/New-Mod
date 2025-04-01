package net.dshbwlto.modcourse.item.custom;

import net.dshbwlto.modcourse.component.ModDataComponentTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class DataTabletItem extends Item {
    public DataTabletItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if(player.getItemInHand(usedHand).get(ModDataComponentTypes.FOUND_BLOCK.get()) != null) {
            player.getItemInHand(usedHand).set(ModDataComponentTypes.FOUND_BLOCK.get(), null);
        }

        return InteractionResultHolder.success(player.getItemInHand(usedHand));
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return stack.get(ModDataComponentTypes.FOUND_BLOCK.get()) != null;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> toolTipComponents, TooltipFlag toolTipFlag) {
        if(stack.get(ModDataComponentTypes.FOUND_BLOCK.get()) != null) {
            toolTipComponents.add(Component.literal(stack.get(ModDataComponentTypes.FOUND_BLOCK.get()).getOutputString()));
        }

        super.appendHoverText(stack, context, toolTipComponents, toolTipFlag);
    }
}