
package net.mcreator.levelbook;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import net.mcreator.levelbook.item.EssenceXPItem;

@LevelBookModElements.ModElement.Tag
public class ExBotleCraftBrewingRecipe extends LevelBookModElements.ModElement {
	public ExBotleCraftBrewingRecipe(LevelBookModElements instance) {
		super(instance, 5);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe());
	}
	public static class CustomBrewingRecipe implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack input) {
			return input.getItem() == Items.POTION;
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem() == EssenceXPItem.block;
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return new ItemStack(Items.EXPERIENCE_BOTTLE);
			}
			return ItemStack.EMPTY;
		}
	}
}
