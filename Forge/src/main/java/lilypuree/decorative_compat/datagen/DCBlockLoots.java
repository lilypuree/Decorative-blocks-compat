package lilypuree.decorative_compat.datagen;

import lilypuree.decorative_blocks.core.DBBlocks;
import lilypuree.decorative_blocks.datagen.BlockLootTableAccessor;
import lilypuree.decorative_compat.core.DCBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.function.BiConsumer;

public class DCBlockLoots extends BlockLootTableAccessor {
    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> biConsumer) {
        DCBlocks.BEAMS.values().forEach(this::dropSelf);
        DCBlocks.PALISADES.values().forEach(this::dropSelf);
        DCBlocks.SEATS.values().forEach(this::dropSelf);
        DCBlocks.SUPPORTS.values().forEach(this::dropSelf);
        map.forEach(biConsumer);
    }
}
