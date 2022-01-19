package lilypuree.decorative_compat;


import lilypuree.decorative_compat.core.DCBlocks;
import lilypuree.decorative_compat.core.DCItems;
import net.fabricmc.api.ModInitializer;

public class DecorativeCompatFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        registerBlocks();
        registerItems();
    }

    public void registerBlocks() {
        DCBlocks.init();
    }

    public static void registerItems() {
        DCItems.init();
    }

}
