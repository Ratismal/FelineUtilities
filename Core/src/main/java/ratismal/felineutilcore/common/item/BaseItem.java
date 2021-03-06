package ratismal.felineutilcore.common.item;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ratismal.felineutilcore.common.tab.CreativeTabCore;

/**
 * Created by Ratismal on 2016-02-10.
 */

public class BaseItem extends Item {

    public BaseItem(String name) {
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTabCore.TAB_CORE);
        setMaxStackSize(1);
        GameRegistry.registerItem(this);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }


}
