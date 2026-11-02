package org.mtr.mapping.mapper;

import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.LevelReader;
import org.mtr.mapping.annotation.MappedMethod;
import org.mtr.mapping.holder.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class BlockExtension extends BlockAbstractMapping implements BlockHelper {

	@MappedMethod
	public BlockExtension(BlockSettings blockSettings) {
		super(blockSettings);
	}

	@MappedMethod
	public void onBreak2(World world, BlockPos pos, BlockState state, PlayerEntity player) {
		super.playerWillDestroy(world.data, pos.data, state.data, player.data);
	}

	@Deprecated
	@Override
	public final net.minecraft.world.level.block.state.BlockState playerWillDestroy(net.minecraft.world.level.Level world, net.minecraft.core.BlockPos pos, net.minecraft.world.level.block.state.BlockState state, net.minecraft.world.entity.player.Player player) {
		onBreak2(new World(world), new BlockPos(pos), new BlockState(state), new PlayerEntity(player));
		return state;
	}

	@Nonnull
	@MappedMethod
	public ItemStack getPickStack2(BlockView world, BlockPos pos, BlockState state) {
		return world.data instanceof LevelReader ? new ItemStack(super.getCloneItemStack((LevelReader) world.data, pos.data, state.data, true)) : ItemStack.getEmptyMapped();
	}

	@Nonnull
	@Deprecated
	@Override
	protected final net.minecraft.world.item.ItemStack getCloneItemStack(LevelReader world, net.minecraft.core.BlockPos pos, net.minecraft.world.level.block.state.BlockState state, boolean includeData) {
		return getPickStack2(new BlockView(world), new BlockPos(pos), new BlockState(state)).data;
	}

	@Deprecated
	@Override
	protected final void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block, net.minecraft.world.level.block.state.BlockState> builder) {
		appendPropertiesHelper(builder);
	}

	// TODO(26.3): Block#appendHoverText no longer exists (tooltips are built by Item#appendHoverText).
	// Block tooltips from addTooltips() need to be hooked up through the block's item instead.

	@MappedMethod
	public static void scheduleBlockTick(World world, BlockPos pos, Block block, int ticks) {
		world.data.scheduleTick(pos.data, block.data, ticks);
	}

	@MappedMethod
	public static boolean hasScheduledBlockTick(World world, BlockPos pos, Block block) {
		return world.data.getBlockTicks().hasScheduledTick(pos.data, block.data);
	}

	@MappedMethod
	public static void scheduleFluidTick(World world, BlockPos pos, Fluid fluid, int ticks) {
		world.data.scheduleTick(pos.data, fluid.data, ticks);
	}

	@MappedMethod
	public static boolean hasScheduledFluidTick(World world, BlockPos pos, Fluid fluid) {
		return world.data.getFluidTicks().hasScheduledTick(pos.data, fluid.data);
	}
}
