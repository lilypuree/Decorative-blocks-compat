package lilypuree.decorative_compat;

import lilypuree.decorative_blocks.blocks.types.IWoodType;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;


public enum BOPWoodTypes implements IWoodType {
    CHERRY("cherry"), DEAD("dead"), FIR("fir"), HELLBARK("hellbark") {
        @Override
        public boolean isFlammable() {
            return false;
        }
    },
    JACARANDA("jacaranda"), MAGIC("magic"), MAHOGANY("mahogany"), PALM("palm"), REDWOOD("redwood"),
    UMBRAN("umbran"), WILLOW("willow");

    private final String name;

    private BOPWoodTypes(String name) {
        this.name = name;
    }

    public String toString() {
        return this.getName();
    }

    @Override
    public String namespace() {
        return "biomesoplenty";
    }

    public String getName() {
        return this.name;
    }


    public Block getLog() {
        return Registry.BLOCK.get(new ResourceLocation(namespace(), name + "_log"));
    }

    public Block getStrippedLog() {
        return Registry.BLOCK.get(new ResourceLocation(namespace(), "stripped_" + name + "_log"));
    }

    public Block getSlab() {
        return Registry.BLOCK.get(new ResourceLocation(namespace(), name + "_slab"));
    }

    public Block getFence() {
        return Registry.BLOCK.get(new ResourceLocation(namespace(), name + "_fence"));
    }

    public Block getPlanks() {
        return Registry.BLOCK.get(new ResourceLocation(namespace(), name + "_planks"));
    }

    @Override
    public boolean isAvailable() {
        return DCConstants.isBOPLoaded;
    }

    @Override
    public boolean isFlammable() {
        return true;
    }
}
