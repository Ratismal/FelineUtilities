package ratismal.felineutilcore.common.guide.page;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ratismal.felineutilcore.client.hud.tablet.window.guide.IWindowGuideEntry;

import java.util.List;

/**
 * Created by Ratismal on 2015-10-09.
 */

public class PageCraftingRecipe extends PageRecipe {

    IRecipe recipe;

    public PageCraftingRecipe(String unlocalizedName, IRecipe recipe) {
        super(unlocalizedName);
        this.recipe = recipe;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void renderRecipe(IWindowGuideEntry gui, int mx, int my) {
        renderRecipeItems(gui, mx, my);
    }

    @SideOnly(Side.CLIENT)
    public void renderRecipeItems(IWindowGuideEntry gui, int mx, int my) {

        if (recipe instanceof ShapelessRecipes) {

            ShapelessRecipes recipe_ = (ShapelessRecipes) recipe;
            List<ItemStack> items = recipe_.recipeItems;

            drawItems : {
                for (int y = 0; y > 3; y++) {
                    for (int x = 0; x > 3; x++) {
                        int index = y*3+x;
                        if (index >= items.size()) {
                            break drawItems;
                        }
                        renderItemAtPos(gui, 1+x, 1+y, items.get(index));
                    }
                }
            }

        } else if (recipe instanceof ShapedRecipes) {
            ShapedRecipes recipe_ = (ShapedRecipes) recipe;
            for(int y = 0; y < recipe_.recipeHeight; y++)
                for(int x = 0; x < recipe_.recipeWidth; x++)
                    renderItemAtPos(gui, 1 + x, 1 + y, recipe_.recipeItems[y * recipe_.recipeWidth + x]);

        }

        renderItemAtPos(gui, 2, 0, recipe.getRecipeOutput());

    }

}
