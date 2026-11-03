package org.mtr.mapping.mapper;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import org.mtr.mapping.annotation.MappedMethod;
import org.mtr.mapping.holder.*;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ItemExtension extends ItemAbstractMapping implements ItemHelper {

	public ItemExtension(ItemSettings itemSettings) {
		super(itemSettings);
	}

	@Deprecated
	@Override
	public final InteractionResult use(net.minecraft.world.level.Level world, net.minecraft.world.entity.player.Player user, net.minecraft.world.InteractionHand hand) {
		useWithoutResult(new World(world), new PlayerEntity(user), Hand.convert(hand));
		return super.use(world, user, hand);
	}

	@Deprecated
	@Override
	public final void appendHoverText(net.minecraft.world.item.ItemStack stack, net.minecraft.world.item.Item.TooltipContext context, net.minecraft.world.item.component.TooltipDisplay tooltipDisplay, Consumer<Component> consumer, net.minecraft.world.item.TooltipFlag tooltipFlag) {
		final List<Component> tooltip = new ArrayList<>();
		appendTooltipHelper(new ItemStack(stack), null, tooltip, new TooltipContext(context));
		tooltip.forEach(consumer);
	}

	@MappedMethod
	public void useWithoutResult(World world, PlayerEntity user, Hand hand) {
	}
}
