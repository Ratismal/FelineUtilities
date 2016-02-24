package ratismal.felineutilcore.common.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import ratismal.felineutilcore.common.FelineUtilCoreMod;
import ratismal.felineutilcore.common.init.ModItems;


/**
 * Created by Ratismal on 2016-01-12.
 */

public class CreativeTabCore {
    public static final CreativeTabs TAB_CORE = new CreativeTabs(FelineUtilCoreMod.MODID) {
        
        @Override
        public Item getTabIconItem() {
            return ModItems.itemCatTablet;
        }

        @Override
        public String getTranslatedTabLabel() {
            return "Feline Utilities: Core";
        }
    };
}
