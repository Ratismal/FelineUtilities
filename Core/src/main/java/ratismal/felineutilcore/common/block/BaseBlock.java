package ratismal.felineutilcore.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ratismal.felineutilcore.common.tab.CreativeTabCore;

/**
 * Created by Ratismal on 2016-02-22.
 */

public class BaseBlock extends Block {

    public BaseBlock(String name, Material material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabCore.TAB_CORE);
        GameRegistry.registerBlock(this, name);
    }

    public BaseBlock(String name, float hardness) {
        super(Material.rock);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(hardness);
        setCreativeTab(CreativeTabCore.TAB_CORE);
        GameRegistry.registerBlock(this, name);
    }

    public BaseBlock(String name) {
        super(Material.rock);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabCore.TAB_CORE);
        GameRegistry.registerBlock(this, name);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}