package org.mtr.mapping.mapper;

import org.mtr.mapping.holder.ScoreboardCriterion;
import org.mtr.mapping.tool.HolderBase;

public interface ScoreboardCriteria {

	ScoreboardCriterion DUMMY = new ScoreboardCriterion(net.minecraft.world.scores.criteria.ObjectiveCriteria.DUMMY);
	ScoreboardCriterion TRIGGER = new ScoreboardCriterion(net.minecraft.world.scores.criteria.ObjectiveCriteria.TRIGGER);
	ScoreboardCriterion DEATH_COUNT = new ScoreboardCriterion(net.minecraft.world.scores.criteria.ObjectiveCriteria.DEATH_COUNT);
	ScoreboardCriterion PLAYER_KILL_COUNT = new ScoreboardCriterion(net.minecraft.world.scores.criteria.ObjectiveCriteria.KILL_COUNT_PLAYERS);
	ScoreboardCriterion TOTAL_KILL_COUNT = new ScoreboardCriterion(net.minecraft.world.scores.criteria.ObjectiveCriteria.KILL_COUNT_ALL);
	ScoreboardCriterion HEALTH = new ScoreboardCriterion(net.minecraft.world.scores.criteria.ObjectiveCriteria.HEALTH);
	ScoreboardCriterion FOOD = new ScoreboardCriterion(net.minecraft.world.scores.criteria.ObjectiveCriteria.FOOD);
	ScoreboardCriterion AIR = new ScoreboardCriterion(net.minecraft.world.scores.criteria.ObjectiveCriteria.AIR);
	ScoreboardCriterion ARMOR = new ScoreboardCriterion(net.minecraft.world.scores.criteria.ObjectiveCriteria.ARMOR);
	ScoreboardCriterion XP = new ScoreboardCriterion(net.minecraft.world.scores.criteria.ObjectiveCriteria.EXPERIENCE);
	ScoreboardCriterion LEVEL = new ScoreboardCriterion(net.minecraft.world.scores.criteria.ObjectiveCriteria.LEVEL);
	ScoreboardCriterion[] TEAM_KILLS = HolderBase.convertArray(net.minecraft.world.scores.criteria.ObjectiveCriteria.TEAM_KILL.values().toArray(new net.minecraft.world.scores.criteria.ObjectiveCriteria[0]), ScoreboardCriterion[]::new, ScoreboardCriterion::new);
	ScoreboardCriterion[] KILLED_BY_TEAMS = HolderBase.convertArray(net.minecraft.world.scores.criteria.ObjectiveCriteria.KILLED_BY_TEAM.values().toArray(new net.minecraft.world.scores.criteria.ObjectiveCriteria[0]), ScoreboardCriterion[]::new, ScoreboardCriterion::new);
}
