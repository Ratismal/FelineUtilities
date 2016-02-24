package ratismal.felineutilcore.common.ref;

import net.minecraft.util.ResourceLocation;
import ratismal.felineutilcore.common.FelineUtilCoreMod;

/**
 * Created by Ratismal on 2016-02-23.
 */

public class RefGuide {




    public static final class BASE {
        public static final String PREFIX = FelineUtilCoreMod.MODID.toLowerCase();
    }

    public static class RESOURCE {
        public static final String PREFIX_HUD = BASE.PREFIX + ":textures/hud/tablet";

    }

    public static class CATEGORY {
        public static final String PREFIX = BASE.PREFIX + ".category.";
        public static final String BASIC = "basic";
    }

    public static class ENTRY {
        public static final String PREFIX = BASE.PREFIX + ".entry.";
        public static final String GUIDE = "guide";
    }

    public static class PAGE {
        public static final String PREFIX = BASE.PREFIX + ".page.";
    }

}
