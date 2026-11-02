package org.mtr.mapping.mapper;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import org.mtr.mapping.annotation.MappedMethod;
import org.mtr.mapping.holder.*;

public abstract class BlockEntityExtension extends BlockEntityAbstractMapping {

	@MappedMethod
	public BlockEntityExtension(BlockEntityType<?> type, BlockPos blockPos, BlockState blockState) {
		super(type, blockPos, blockState);
	}

	/**
	 * Minecraft 26.x saves block entities through ValueOutput/ValueInput instead of raw NBT.
	 * The mod still works with a CompoundTag, which is stored flat in the block entity data (same layout as before).
	 */
	@Deprecated
	@Override
	protected final void saveAdditional(ValueOutput valueOutput) {
		super.saveAdditional(valueOutput);
		final net.minecraft.nbt.CompoundTag nbt = new net.minecraft.nbt.CompoundTag();
		writeCompoundTag(new CompoundTag(nbt));
		valueOutput.store(MapCodec.assumeMapUnsafe(net.minecraft.nbt.CompoundTag.CODEC), nbt);
	}

	@Deprecated
	@Override
	protected final void loadAdditional(ValueInput valueInput) {
		super.loadAdditional(valueInput);
		readCompoundTag(new CompoundTag(valueInput.read(MapCodec.assumeMapUnsafe(net.minecraft.nbt.CompoundTag.CODEC)).orElseGet(net.minecraft.nbt.CompoundTag::new)));
	}

	@MappedMethod
	public void writeCompoundTag(CompoundTag compoundTag) {
	}

	@MappedMethod
	public void readCompoundTag(CompoundTag compoundTag) {
	}

	@Deprecated
	@Override
	public final Packet<ClientGamePacketListener> getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Deprecated
	@Override
	public final net.minecraft.nbt.CompoundTag getUpdateTag(HolderLookup.Provider registries) {
		return saveWithoutMetadata(registries);
	}

	@MappedMethod
	public void blockEntityTick() {
	}

	@MappedMethod
	@Override
	public void markDirty2() {
		super.markDirty2();
		final net.minecraft.world.level.block.state.BlockState blockState = getBlockState();
		if (level != null && !level.isClientSide() && blockState != null) {
			level.sendBlockUpdated(worldPosition, blockState, blockState, net.minecraft.world.level.block.Block.UPDATE_CLIENTS);
		}
	}

	@MappedMethod
	public double getRenderDistance2() {
		return 0;
	}
}
