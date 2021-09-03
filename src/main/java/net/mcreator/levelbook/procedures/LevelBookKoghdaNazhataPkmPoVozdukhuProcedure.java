package net.mcreator.levelbook.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.levelbook.item.LevelBookItem;
import net.mcreator.levelbook.LevelBookMod;

import java.util.Map;

public class LevelBookKoghdaNazhataPkmPoVozdukhuProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LevelBookMod.LOGGER.warn("Failed to load dependency entity for procedure LevelBookKoghdaNazhataPkmPoVozdukhu!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				LevelBookMod.LOGGER.warn("Failed to load dependency itemstack for procedure LevelBookKoghdaNazhataPkmPoVozdukhu!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LevelBookMod.LOGGER.warn("Failed to load dependency x for procedure LevelBookKoghdaNazhataPkmPoVozdukhu!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LevelBookMod.LOGGER.warn("Failed to load dependency y for procedure LevelBookKoghdaNazhataPkmPoVozdukhu!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LevelBookMod.LOGGER.warn("Failed to load dependency z for procedure LevelBookKoghdaNazhataPkmPoVozdukhu!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LevelBookMod.LOGGER.warn("Failed to load dependency world for procedure LevelBookKoghdaNazhataPkmPoVozdukhu!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((Math.random() < 0.9)) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).addExperienceLevel((int) 5);
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown((itemstack).getItem(), (int) 100);
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.HAPPY_VILLAGER, x, y, z, (int) 60, 1, 1, 1, 1);
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(LevelBookItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
		} else {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).addExperienceLevel(-((int) 50));
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown((itemstack).getItem(), (int) 100);
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.ANGRY_VILLAGER, x, y, z, (int) 60, 1, 1, 1, 1);
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(LevelBookItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
		}
	}
}
