package ratismal.felineutilcore.common.guide;

import ratismal.felineutilcore.api.guide.Guide;
import ratismal.felineutilcore.api.guide.GuideCategory;
import ratismal.felineutilcore.api.guide.GuideEntry;
import ratismal.felineutilcore.client.hud.tablet.ref.RefTabletHUD;
import ratismal.felineutilcore.common.crafting.CoreCraftingRecipes;
import ratismal.felineutilcore.common.guide.page.PageCraftingRecipe;
import ratismal.felineutilcore.common.guide.page.PageText;
import ratismal.felineutilcore.common.ref.RefGuide;

/**
 * Created by Ratismal on 2016-02-23.
 */

public class GuideData {

    //Guide.addCategory(Guide.categoryBasic = new CategoryA(RefGuide.CATEGORY.BASIC, 9));

    public static GuideEntry guide;

    static GuideCategory test1;
    static GuideCategory test2;
    static GuideCategory test3;
    static GuideCategory test4;
    static GuideCategory test5;
    static GuideCategory test6;
    static GuideCategory test7;
    static GuideCategory test8;
    static GuideCategory test9;

    public static void init() {
        Guide.addCategory(Guide.categoryBasic = new CategoryA(RefGuide.CATEGORY.BASIC, 9));

        GuideCategory categoryBasic = Guide.categoryBasic;

        Guide.addCategory(test1 = new CategoryA("test1", 8));
        Guide.addCategory(test2 = new CategoryA("test2", 8));
        Guide.addCategory(test3 = new CategoryA("test3", 8));
        Guide.addCategory(test4 = new CategoryA("test4", 9));
        Guide.addCategory(test5 = new CategoryA("test5", 8));
        Guide.addCategory(test6 = new CategoryA("test6", 8));
        Guide.addCategory(test7 = new CategoryA("test7", 8));
        Guide.addCategory(test8 = new CategoryA("test8", 8));
        Guide.addCategory(test9 = new CategoryA("test9", 8));
        //categoryBasic.setIcon(RefTabletHUD.CATEGORY_BASIC);

        guide = new EntryA(RefGuide.ENTRY.GUIDE, categoryBasic);
        guide.setPages(new PageText("0"), new PageCraftingRecipe("1", CoreCraftingRecipes.recipeCatTablet));
        guide.setPriority(0);

    }
}
