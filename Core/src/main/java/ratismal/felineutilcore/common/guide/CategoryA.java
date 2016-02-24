package ratismal.felineutilcore.common.guide;

import net.minecraft.util.ResourceLocation;
import ratismal.felineutilcore.api.guide.GuideCategory;
import ratismal.felineutilcore.client.hud.tablet.ref.RefTabletHUD;
import ratismal.felineutilcore.common.ref.RefGuide;

/**
 * Created by Ratismal on 2016-02-23.
 */

public class CategoryA extends GuideCategory {

    public CategoryA(String unlocalizedName, int priority) {
        super(RefGuide.CATEGORY.PREFIX + unlocalizedName);
        setIcon(RefTabletHUD.CATEGORY_BASIC);
        setPriority(priority);
    }

}
