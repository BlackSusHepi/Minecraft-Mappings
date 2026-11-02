package org.mtr.mapping.test;

import org.junit.jupiter.api.Test;

// Minecraft 26.3 (Mojang names, unobfuscated). Class names verified against the 26.3 jar.
public final class ClassScannerTest {

	@Test
	public void scan() {
		final ClassScannerBase scanner = ClassScannerBase.getInstance();
		scanner.put("AbstractTexture", net.minecraft.client.renderer.texture.AbstractTexture.class);
		scanner.put("ActionResult", net.minecraft.world.InteractionResult.class);
		scanner.put("Axis", net.minecraft.core.Direction.Axis.class);
		scanner.put("Biome", net.minecraft.world.level.biome.Biome.class);
		scanner.put("BiomeSource", net.minecraft.world.level.biome.BiomeSource.class);
		scanner.put("BlockEntityType", net.minecraft.world.level.block.entity.BlockEntityType.class);
		scanner.put("BlockHitResult", net.minecraft.world.phys.BlockHitResult.class);
		scanner.put("BlockPos", net.minecraft.core.BlockPos.class);
		scanner.put("BlockRenderType", net.minecraft.world.level.block.RenderShape.class);
		scanner.put("BlockRenderView", net.minecraft.client.renderer.block.BlockAndTintGetter.class);
		scanner.put("BlockRotation", net.minecraft.world.level.block.Rotation.class);
		scanner.put("Blocks", net.minecraft.world.level.block.Blocks.class);
		scanner.put("BlockSettings", net.minecraft.world.level.block.state.BlockBehaviour.Properties.class);
		scanner.put("BlockState", net.minecraft.world.level.block.state.BlockState.class);
		scanner.put("BlockView", net.minecraft.world.level.BlockGetter.class);
		scanner.put("BooleanBiFunction", net.minecraft.world.phys.shapes.BooleanOp.class);
		scanner.put("BooleanProperty", net.minecraft.world.level.block.state.properties.BooleanProperty.class);
		scanner.put("BossBarManager", net.minecraft.server.bossevents.CustomBossEvents.class);
		scanner.put("Box", net.minecraft.world.phys.AABB.class);
		scanner.put("BufferBuilder", com.mojang.blaze3d.vertex.BufferBuilder.class);
		scanner.put("BufferBuilderStorage", net.minecraft.client.renderer.RenderBuffers.class);
		scanner.put("Camera", net.minecraft.client.Camera.class);
		scanner.put("ClientChunkManager", net.minecraft.client.multiplayer.ClientChunkCache.class);
		scanner.put("Chunk", net.minecraft.world.level.chunk.ChunkAccess.class);
		scanner.put("ChunkGenerator", net.minecraft.world.level.chunk.ChunkGenerator.class);
		scanner.put("ChunkManager", net.minecraft.world.level.chunk.ChunkSource.class);
		scanner.put("ChunkPos", net.minecraft.world.level.ChunkPos.class);
		scanner.put("ChunkSection", net.minecraft.world.level.chunk.LevelChunkSection.class);
		scanner.put("ChunkStatus", net.minecraft.world.level.chunk.status.ChunkStatus.class);
		scanner.put("ClientPlayerEntity", net.minecraft.client.player.LocalPlayer.class, "damageArmor", "damageHelmet", "damageShield", "getType");
		scanner.put("ClientPlayNetworkHandler", net.minecraft.client.multiplayer.ClientPacketListener.class);
		scanner.put("ClientWorld", net.minecraft.client.multiplayer.ClientLevel.class);
		scanner.put("CommandFunctionManager", net.minecraft.server.ServerFunctionManager.class);
		scanner.put("CompoundTag", net.minecraft.nbt.CompoundTag.class);
		scanner.put("DataCommandStorage", net.minecraft.world.level.storage.CommandStorage.class);
		scanner.put("DefaultParticleType", net.minecraft.core.particles.SimpleParticleType.class);
		scanner.put("Difficulty", net.minecraft.world.Difficulty.class);
		scanner.put("DimensionOptions", net.minecraft.world.level.dimension.LevelStem.class);
		scanner.put("DimensionType", net.minecraft.world.level.dimension.DimensionType.class);
		scanner.put("Direction", net.minecraft.core.Direction.class);
		scanner.put("DirectionProperty", net.minecraft.world.level.block.state.properties.EnumProperty.class);
		scanner.put("EntityPose", net.minecraft.world.entity.Pose.class);
		scanner.put("EntityRenderDispatcher", net.minecraft.client.renderer.entity.EntityRenderDispatcher.class);
		scanner.put("EntityType", net.minecraft.world.entity.EntityType.class);
		scanner.put("EnumProperty", net.minecraft.world.level.block.state.properties.EnumProperty.class);
		scanner.put("Explosion", net.minecraft.world.level.Explosion.class);
		scanner.put("FlowableFluid", net.minecraft.world.level.material.FlowingFluid.class);
		scanner.put("Fluids", net.minecraft.world.level.material.Fluids.class);
		scanner.put("FluidState", net.minecraft.world.level.material.FluidState.class);
		scanner.put("Frustum", net.minecraft.client.renderer.culling.Frustum.class);
		scanner.put("GameMode", net.minecraft.world.level.GameType.class);
		scanner.put("GameOptions", net.minecraft.client.Options.class);
		scanner.put("GameRenderer", net.minecraft.client.renderer.GameRenderer.class);
		scanner.put("Hand", net.minecraft.world.InteractionHand.class);
		scanner.put("HeightMap", net.minecraft.world.level.levelgen.Heightmap.class);
		scanner.put("HeightMapType", net.minecraft.world.level.levelgen.Heightmap.Types.class);
		scanner.put("HitResult", net.minecraft.world.phys.HitResult.class);
		scanner.put("HitResultType", net.minecraft.world.phys.HitResult.Type.class);
		scanner.put("Identifier", net.minecraft.resources.Identifier.class);
		scanner.put("IntegerProperty", net.minecraft.world.level.block.state.properties.IntegerProperty.class);
		scanner.put("Inventory", net.minecraft.world.Container.class);
		scanner.put("ItemConvertible", net.minecraft.world.level.ItemLike.class);
		scanner.put("ItemPlacementContext", net.minecraft.world.item.context.BlockPlaceContext.class);
		scanner.put("Items", net.minecraft.world.item.Items.class);
		scanner.put("ItemSettings", net.minecraft.world.item.Item.Properties.class);
		scanner.put("ItemStack", net.minecraft.world.item.ItemStack.class);
		scanner.put("ItemUsageContext", net.minecraft.world.item.context.UseOnContext.class);
		scanner.put("KeyBinding", net.minecraft.client.KeyMapping.class);
		scanner.put("LightType", net.minecraft.world.level.LightLayer.class);
		scanner.put("LivingEntity", net.minecraft.world.entity.LivingEntity.class, "getType");
		scanner.put("MapColor", net.minecraft.world.level.material.MapColor.class);
		scanner.put("MathHelper", net.minecraft.util.Mth.class, "MathHelper");
		scanner.put("Matrix3f", org.joml.Matrix3f.class);
		scanner.put("Matrix4f", org.joml.Matrix4f.class);
		scanner.put("MinecraftClient", net.minecraft.client.Minecraft.class, "ask", "askFallible");
		scanner.put("MinecraftServer", net.minecraft.server.MinecraftServer.class, "ask", "askFallible");
		scanner.put("MinecraftVersion", net.minecraft.DetectedVersion.class);
		scanner.put("Mirror", net.minecraft.world.level.block.Mirror.class);
		scanner.put("ModelPart", net.minecraft.client.model.geom.ModelPart.class);
		scanner.put("MutableText", net.minecraft.network.chat.MutableComponent.class);
		scanner.put("NativeImage", com.mojang.blaze3d.platform.NativeImage.class);
		scanner.put("NativeImageBackedTexture", net.minecraft.client.renderer.texture.DynamicTexture.class);
		scanner.put("NativeImageFormat", com.mojang.blaze3d.platform.NativeImage.Format.class);
		scanner.put("OperatingSystem", net.minecraft.util.Util.OS.class);
		scanner.put("OrderedText", net.minecraft.util.FormattedCharSequence.class);
		scanner.put("OverlayTexture", net.minecraft.client.renderer.texture.OverlayTexture.class);
		scanner.put("PacketBuffer", net.minecraft.network.FriendlyByteBuf.class);
		scanner.put("ParticleEffect", net.minecraft.core.particles.ParticleOptions.class);
		scanner.put("ParticleTypes", net.minecraft.core.particles.ParticleTypes.class);
		scanner.put("PlayerEntity", net.minecraft.world.entity.player.Player.class, "damageArmor", "damageHelmet", "damageShield", "getType");
		scanner.put("PlayerInventory", net.minecraft.world.entity.player.Inventory.class);
		scanner.put("PlayerListEntry", net.minecraft.client.multiplayer.PlayerInfo.class);
		scanner.put("PlayerManager", net.minecraft.server.players.PlayerList.class);
		scanner.put("Position", net.minecraft.core.Position.class);
		scanner.put("Property", net.minecraft.world.level.block.state.properties.Property.class);
		scanner.put("Random", net.minecraft.util.RandomSource.class);
		scanner.put("RenderLayer", net.minecraft.client.renderer.rendertype.RenderType.class);
		scanner.put("Resource", net.minecraft.server.packs.resources.Resource.class);
		scanner.put("ResourceManager", net.minecraft.server.packs.resources.ResourceManager.class);
		scanner.put("SaveProperties", net.minecraft.world.level.storage.WorldData.class);
		scanner.put("Scoreboard", net.minecraft.world.scores.Scoreboard.class);
		scanner.put("ScoreboardCriterion", net.minecraft.world.scores.criteria.ObjectiveCriteria.class);
		scanner.put("ScoreboardCriterionRenderType", net.minecraft.world.scores.criteria.ObjectiveCriteria.RenderType.class);
		scanner.put("ScoreboardObjective", net.minecraft.world.scores.Objective.class);
		scanner.put("ScoreboardScore", net.minecraft.world.scores.ScoreAccess.class);
		scanner.put("ServerChunkManager", net.minecraft.server.level.ServerChunkCache.class);
		scanner.put("ServerPlayerEntity", net.minecraft.server.level.ServerPlayer.class, "damageArmor", "damageHelmet", "damageShield", "getType");
		scanner.put("ServerWorld", net.minecraft.server.level.ServerLevel.class);
		scanner.put("ServerWorldAccess", net.minecraft.world.level.ServerLevelAccessor.class);
		scanner.put("ShapeContext", net.minecraft.world.phys.shapes.CollisionContext.class);
		scanner.put("SlabType", net.minecraft.world.level.block.state.properties.SlabType.class);
		scanner.put("SoundCategory", net.minecraft.sounds.SoundSource.class);
		scanner.put("SoundEvent", net.minecraft.sounds.SoundEvent.class);
		scanner.put("SoundEvents", net.minecraft.sounds.SoundEvents.class);
		scanner.put("SoundInstance", net.minecraft.client.resources.sounds.SoundInstance.class);
		scanner.put("SoundManager", net.minecraft.client.sounds.SoundManager.class);
		scanner.put("SpriteProvider", net.minecraft.client.particle.SpriteSet.class);
		scanner.put("StairShape", net.minecraft.world.level.block.state.properties.StairsShape.class);
		scanner.put("Style", net.minecraft.network.chat.Style.class);
		scanner.put("Team", net.minecraft.world.scores.PlayerTeam.class);
		scanner.put("Text", net.minecraft.network.chat.Component.class);
		scanner.put("TextColor", net.minecraft.network.chat.TextColor.class);
		scanner.put("TextFormatting", net.minecraft.ChatFormatting.class);
		scanner.put("TextRenderer", net.minecraft.client.gui.Font.class);
		scanner.put("TextureManager", net.minecraft.client.renderer.texture.TextureManager.class);
		scanner.put("TooltipContext", net.minecraft.world.item.Item.TooltipContext.class);
		scanner.put("Util", net.minecraft.util.Util.class);
		scanner.put("Vector3d", net.minecraft.world.phys.Vec3.class);
		scanner.put("Vector3f", org.joml.Vector3f.class);
		scanner.put("Vector3i", net.minecraft.core.Vec3i.class);
		scanner.put("VertexFormats", com.mojang.blaze3d.vertex.DefaultVertexFormat.class, "VertexFormats");
		scanner.put("VoxelShape", net.minecraft.world.phys.shapes.VoxelShape.class);
		scanner.put("VoxelShapes", net.minecraft.world.phys.shapes.Shapes.class, "VoxelShapes");
		scanner.put("Window", com.mojang.blaze3d.platform.Window.class);
		scanner.put("World", net.minecraft.world.level.Level.class);
		scanner.put("WorldAccess", net.minecraft.world.level.LevelAccessor.class);
		scanner.put("WorldChunk", net.minecraft.world.level.chunk.LevelChunk.class);
		scanner.put("WorldRenderer", net.minecraft.client.renderer.LevelRenderer.class);
		scanner.put("WorldSavePath", net.minecraft.world.level.storage.LevelResource.class);
		scanner.putAbstract("AbstractSoundInstance", net.minecraft.client.resources.sounds.AbstractSoundInstance.class);
		scanner.putAbstract("BillboardParticle", net.minecraft.client.particle.SingleQuadParticle.class);
		scanner.putAbstract("Block", net.minecraft.world.level.block.Block.class);
		scanner.putAbstract("BlockEntity", net.minecraft.world.level.block.entity.BlockEntity.class, "getType");
		scanner.putAbstract("BlockItem", net.minecraft.world.item.BlockItem.class);
		scanner.putAbstract("ButtonWidget", net.minecraft.client.gui.components.Button.class);
		scanner.putAbstract("CheckboxWidget", net.minecraft.client.gui.components.Checkbox.class);
		scanner.putAbstract("ClickableWidget", net.minecraft.client.gui.components.AbstractWidget.class);
		scanner.putAbstract("DoorBlock", net.minecraft.world.level.block.DoorBlock.class);
		scanner.putAbstract("Entity", net.minecraft.world.entity.Entity.class, "getType");
		scanner.putAbstract("EntityModel", net.minecraft.client.model.EntityModel.class);
		scanner.putAbstract("FenceBlock", net.minecraft.world.level.block.FenceBlock.class);
		scanner.putAbstract("Fluid", net.minecraft.world.level.material.Fluid.class);
		scanner.putAbstract("Item", net.minecraft.world.item.Item.class);
		scanner.putAbstract("Model", net.minecraft.client.model.Model.class);
		scanner.putAbstract("MovingSoundInstance", net.minecraft.client.resources.sounds.AbstractTickableSoundInstance.class);
		scanner.putAbstract("Particle", net.minecraft.client.particle.Particle.class);
		scanner.putAbstract("PersistentState", net.minecraft.world.level.saveddata.SavedData.class);
		scanner.putAbstract("PlaceableOnWaterItem", net.minecraft.world.item.PlaceOnWaterBlockItem.class);
		scanner.putAbstract("PressableWidget", net.minecraft.client.gui.components.AbstractButton.class);
		scanner.putAbstract("Screen", net.minecraft.client.gui.screens.Screen.class);
		scanner.putAbstract("SlabBlock", net.minecraft.world.level.block.SlabBlock.class);
		scanner.putAbstract("SliderWidget", net.minecraft.client.gui.components.AbstractSliderButton.class);
		scanner.putAbstract("StairsBlock", net.minecraft.world.level.block.StairBlock.class);
		scanner.putAbstract("TextFieldWidget", net.minecraft.client.gui.components.EditBox.class);
		scanner.putAbstract("TexturedButtonWidget", net.minecraft.client.gui.components.ImageButton.class);
		scanner.putInterface("PressAction", net.minecraft.client.gui.components.Button.OnPress.class);
		scanner.putInterface("StringIdentifiable", net.minecraft.util.StringRepresentable.class);
		scanner.putInterface("TickableSoundInstance", net.minecraft.client.resources.sounds.TickableSoundInstance.class);
		scanner.putInterface("Waterloggable", net.minecraft.world.level.block.SimpleWaterloggedBlock.class);
		// TODO(26.3) not found in the jar yet, needs a manual look:
		//  InternalFormat (was guessed as com.mojang.blaze3d.platform.NativeImage$InternalGlFormat)
		//  LightmapTextureManager (was guessed as net.minecraft.client.renderer.LightTexture)
		//  Tessellator (was guessed as com.mojang.blaze3d.vertex.Tesselator)
		//  VertexFormat (was guessed as com.mojang.blaze3d.vertex.VertexFormat)
		//  VertexFormatElement (was guessed as com.mojang.blaze3d.vertex.VertexFormatElement)
		//  SpriteBillboardParticle (was guessed as net.minecraft.client.particle.TextureSheetParticle)
		//  ToggleButtonWidget (was guessed as net.minecraft.client.gui.components.StateSwitchingButton)
		//  BlockColorProvider (was guessed as net.minecraft.client.color.block.BlockColor)
		//  ItemColorProvider (was guessed as net.minecraft.client.color.item.ItemColor)
		scanner.generate();
	}
}
