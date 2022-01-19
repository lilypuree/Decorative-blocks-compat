package lilypuree.decorative_compat.datagen;

import biomesoplenty.core.BiomesOPlenty;
import lilypuree.decorative_blocks.blocks.types.IWoodType;
import lilypuree.decorative_blocks.datagen.DBRecipes;
import lilypuree.decorative_compat.BOPWoodTypes;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.function.Consumer;

public class DCRecipes extends RecipeProvider {
    public DCRecipes(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        for (IWoodType wood : BOPWoodTypes.values()) {
            DBRecipes.makeWoodenBlockRecipes(wood, consumer);
        }
    }
}
