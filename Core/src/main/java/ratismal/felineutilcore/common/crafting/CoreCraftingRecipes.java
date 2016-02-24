package ratismal.felineutilcore.common.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;
import ratismal.felineutilcore.common.init.ModItems;

import java.util.List;

/**
 * Created by Ratismal on 2016-02-23.
 */

public class CoreCraftingRecipes {

    public static IRecipe recipeCatTablet;

    public static void init() {

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemCatTablet), new ItemStack(Items.book), new ItemStack(Items.fish));
        recipeCatTablet = getLatestAddedRecipe();

    }

    public static IRecipe getLatestAddedRecipe() {
        List<IRecipe> list = CraftingManager.getInstance().getRecipeList();
        return list.get(list.size() - 1);
    }
}
