package lilypuree.decorative_compat.datagen;

import lilypuree.decorative_blocks.Constants;
import lilypuree.decorative_blocks.datagen.*;
import lilypuree.decorative_compat.DCConstants;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        if (event.includeServer()) {
            generator.addProvider(new DCRecipes(generator));
            generator.addProvider(new DCLootTables(generator));
            BlockTagsProvider blockTagsProvider = new DCBlockTagsProvider(generator, DCConstants.MODID, event.getExistingFileHelper());
            generator.addProvider(blockTagsProvider);
            generator.addProvider(new DCItemTagsProvider(generator, blockTagsProvider, DCConstants.MODID, event.getExistingFileHelper()));
        }
        if (event.includeClient()) {
            generator.addProvider(new DCBlockStates(generator, DCConstants.MODID, event.getExistingFileHelper()));
            generator.addProvider(new DCItemModels(generator, DCConstants.MODID, event.getExistingFileHelper()));
            generator.addProvider(new DCLanguages(generator, "en_us"));
        }
    }
}
