package org.mtr.mapping.mapper;

import org.mtr.mapping.holder.ScoreboardCriterion;
import org.mtr.mapping.tool.HolderBase;

public interface ScoreboardCriteria {

	ScoreboardCriterion DUMMY = new ScoreboardCriterion(net.minecraft.world.scores.criteria.ObjectiveCriteria.DUMMY);
	ScoreboardCriterion TRIGGER = new ScoreboardCriterion(net.minecraft.world.scores.criteria.ObjectiveCriteria.TRIGGER);
	ScoreboardCriterion DEATH_COUNT = new ScoreboardCriterion(net.minecraft.world.scores.criteria.ObjectiveCriteria.DEATH_COUNT);
	ScoreboardCriterion PLAYER_KILL_COUNT = new ScoreboardCriterion(net.minecraft.world.scores.criteria.ObjectiveCriteria.PLAYER_KILL_COUNT);
	ScoreboardCriterion TOTAL_KILL_COUNT = new ScoreboardCriterion(net.minecraft.world.scores.criteria.ObjectiveCriteria.TOTAL_KILL_COUNT);
	ScoreboardCriterion HEALTH = new ScoreboardCriterion(net.minecraft.world.scores.criteria.ObjectiveCriteria.HEALTH);
	ScoreboardCriterion FOOD = new ScoreboardCriterion(net.minecraft.world.scores.criteria.ObjectiveCriteria.FOOD);
	ScoreboardCriterion AIR = new ScoreboardCriterion(net.minecraft.world.scores.criteria.ObjectiveCriteria.AIR);
	ScoreboardCriterion ARMOR = new ScoreboardCriterion(net.minecraft.world.scores.criteria.ObjectiveCriteria.ARMOR);
	ScoreboardCriterion XP = new ScoreboardCriterion(net.minecraft.world.scores.criteria.ObjectiveCriteria.XP);
	ScoreboardCriterion LEVEL = new ScoreboardCriterion(net.minecraft.world.scores.criteria.ObjectiveCriteria.LEVEL);
	ScoreboardCriterion[] TEAM_KILLS = HolderBase.convertArray(net.minecraft.world.scores.criteria.ObjectiveCriteria.TEAM_KILLS, ScoreboardCriterion[]::new, ScoreboardCriterion::new);
	ScoreboardCriterion[] KILLED_BY_TEAMS = HolderBase.convertArray(net.minecraft.world.scores.criteria.ObjectiveCriteria.KILLED_BY_TEAMS, ScoreboardCriterion[]::new, ScoreboardCriterion::new);
}
