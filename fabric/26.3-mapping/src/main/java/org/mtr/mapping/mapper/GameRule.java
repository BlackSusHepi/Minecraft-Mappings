package org.mtr.mapping.mapper;

import net.minecraft.world.level.gamerules.GameRules;
import org.mtr.mapping.annotation.MappedMethod;
import org.mtr.mapping.holder.MinecraftServer;

/**
 * Minecraft 26.x redesigned game rules: they are now typed {@code GameRule<Boolean>} / {@code GameRule<Integer>}
 * and many were renamed. The enum constants below keep the names used by MTR; the constructor arguments are the 26.3 rules.
 * <ul>
 * <li>{@code inverted}: the old rule was "disableX", the new rule is "X" (so the value is flipped).</li>
 * <li>{@code integerAsBoolean}: the old rule was a boolean but the new one is an integer (value != 0 means true).</li>
 * </ul>
 */
public enum GameRule {

	ANNOUNCE_ADVANCEMENTS(GameRules.SHOW_ADVANCEMENT_MESSAGES, false, false),
	BLOCK_EXPLOSION_DROP_DECAY(GameRules.BLOCK_EXPLOSION_DROP_DECAY, false, false),
	COMMAND_BLOCK_OUTPUT(GameRules.COMMAND_BLOCK_OUTPUT, false, false),
	DISABLE_ELYTRA_MOVEMENT_CHECK(GameRules.ELYTRA_MOVEMENT_CHECK, true, false),
	DISABLE_RAIDS(GameRules.RAIDS, true, false),
	DO_DAYLIGHT_CYCLE(GameRules.ADVANCE_TIME, false, false),
	DO_ENTITY_DROPS(GameRules.ENTITY_DROPS, false, false),
	DO_FIRE_TICK(GameRules.FIRE_SPREAD_RADIUS_AROUND_PLAYER, false, true),
	DO_IMMEDIATE_RESPAWN(GameRules.IMMEDIATE_RESPAWN, false, false),
	DO_INSOMNIA(GameRules.SPAWN_PHANTOMS, false, false),
	DO_LIMITED_CRAFTING(GameRules.LIMITED_CRAFTING, false, false),
	DO_MOB_GRIEFING(GameRules.MOB_GRIEFING, false, false),
	DO_MOB_LOOT(GameRules.MOB_DROPS, false, false),
	DO_MOB_SPAWNING(GameRules.SPAWN_MOBS, false, false),
	DO_PATROL_SPAWNING(GameRules.SPAWN_PATROLS, false, false),
	DO_TILE_DROPS(GameRules.BLOCK_DROPS, false, false),
	DO_TRADER_SPAWNING(GameRules.SPAWN_WANDERING_TRADERS, false, false),
	DO_VINES_SPREAD(GameRules.SPREAD_VINES, false, false),
	DO_WARDEN_SPAWNING(GameRules.SPAWN_WARDENS, false, false),
	DO_WEATHER_CYCLE(GameRules.ADVANCE_WEATHER, false, false),
	DROWNING_DAMAGE(GameRules.DROWNING_DAMAGE, false, false),
	ENDER_PEARLS_VANISH_ON_DEATH(GameRules.ENDER_PEARLS_VANISH_ON_DEATH, false, false),
	FALL_DAMAGE(GameRules.FALL_DAMAGE, false, false),
	FIRE_DAMAGE(GameRules.FIRE_DAMAGE, false, false),
	FORGIVE_DEAD_PLAYERS(GameRules.FORGIVE_DEAD_PLAYERS, false, false),
	FREEZE_DAMAGE(GameRules.FREEZE_DAMAGE, false, false),
	GLOBAL_SOUND_EVENTS(GameRules.GLOBAL_SOUND_EVENTS, false, false),
	KEEP_INVENTORY(GameRules.KEEP_INVENTORY, false, false),
	LAVA_SOURCE_CONVERSION(GameRules.LAVA_SOURCE_CONVERSION, false, false),
	LOG_ADMIN_COMMANDS(GameRules.LOG_ADMIN_COMMANDS, false, false),
	MOB_EXPLOSION_DROP_DECAY(GameRules.MOB_EXPLOSION_DROP_DECAY, false, false),
	NATURAL_REGENERATION(GameRules.NATURAL_HEALTH_REGENERATION, false, false),
	PROJECTILES_CAN_BREAK_BLOCKS(GameRules.PROJECTILES_CAN_BREAK_BLOCKS, false, false),
	REDUCED_DEBUG_INFO(GameRules.REDUCED_DEBUG_INFO, false, false),
	SEND_COMMAND_FEEDBACK(GameRules.SEND_COMMAND_FEEDBACK, false, false),
	SHOW_DEATH_MESSAGES(GameRules.SHOW_DEATH_MESSAGES, false, false),
	SPECTATORS_GENERATE_CHUNKS(GameRules.SPECTATORS_GENERATE_CHUNKS, false, false),
	TNT_EXPLOSION_DROP_DECAY(GameRules.TNT_EXPLOSION_DROP_DECAY, false, false),
	UNIVERSAL_ANGER(GameRules.UNIVERSAL_ANGER, false, false),
	WATER_SOURCE_CONVERSION(GameRules.WATER_SOURCE_CONVERSION, false, false),
	COMMAND_MODIFICATION_BLOCK_LIMIT(GameRules.MAX_BLOCK_MODIFICATIONS, false, false),
	MAX_COMMAND_CHAIN_LENGTH(GameRules.MAX_COMMAND_SEQUENCE_LENGTH, false, false),
	MAX_COMMAND_FORK_COUNT(GameRules.MAX_COMMAND_FORKS, false, false),
	MAX_ENTITY_CRAMMING(GameRules.MAX_ENTITY_CRAMMING, false, false),
	PLAYERS_NETHER_PORTAL_CREATIVE_DELAY(GameRules.PLAYERS_NETHER_PORTAL_CREATIVE_DELAY, false, false),
	PLAYERS_NETHER_PORTAL_DEFAULT_DELAY(GameRules.PLAYERS_NETHER_PORTAL_DEFAULT_DELAY, false, false),
	PLAYERS_SLEEPING_PERCENTAGE(GameRules.PLAYERS_SLEEPING_PERCENTAGE, false, false),
	RANDOM_TICK_SPEED(GameRules.RANDOM_TICK_SPEED, false, false),
	SNOW_ACCUMULATION_HEIGHT(GameRules.MAX_SNOW_ACCUMULATION_HEIGHT, false, false),
	SPAWN_RADIUS(GameRules.RESPAWN_RADIUS, false, false);

	private final net.minecraft.world.level.gamerules.GameRule<?> gameRule;
	private final boolean inverted;
	private final boolean integerAsBoolean;

	@Deprecated
	GameRule(net.minecraft.world.level.gamerules.GameRule<?> gameRule, boolean inverted, boolean integerAsBoolean) {
		this.gameRule = gameRule;
		this.inverted = inverted;
		this.integerAsBoolean = integerAsBoolean;
	}

	@MappedMethod
	public boolean getBooleanGameRule(MinecraftServer minecraftServer) {
		if (!hasBooleanGameRule()) {
			return false;
		}
		final Object value = minecraftServer.data.getGameRules().get(gameRule);
		final boolean result = integerAsBoolean ? ((Integer) value) != 0 : (Boolean) value;
		return inverted != result;
	}

	@MappedMethod
	public int getIntegerGameRule(MinecraftServer minecraftServer) {
		return hasIntegerGameRule() ? (Integer) minecraftServer.data.getGameRules().get(gameRule) : 0;
	}

	@MappedMethod
	public boolean hasBooleanGameRule() {
		return integerAsBoolean || gameRule.valueClass() == Boolean.class;
	}

	@MappedMethod
	public boolean hasIntegerGameRule() {
		return !integerAsBoolean && gameRule.valueClass() == Integer.class;
	}
}
