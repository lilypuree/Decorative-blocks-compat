package lilypuree.decorative_compat.datagen;

import com.mojang.datafixers.util.Pair;
import lilypuree.decorative_blocks.datagen.DBBlockLoots;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class DCLootTables extends LootTableProvider {
    public DCLootTables(DataGenerator pGenerator) {
        super(pGenerator);
    }

    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return List.of(Pair.of(DCBlockLoots::new, LootContextParamSets.BLOCK));
    }

    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {
    }
}
