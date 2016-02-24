package ratismal.felineutilcore.client.hud.tablet.ref;

import net.minecraft.util.ResourceLocation;

/**
 * Created by Ratismal on 2016-02-22.
 */

public class RefTabletHUD {

    public static final float SEGMENT_X = 2F;
    public static final float SEGMENT_Y = 2F;

    public static final int SEGMENTS = 6;
    public static final int ANGLES = 360;
    public static final int SEG_ANGLES = ANGLES / SEGMENTS;

    public static final String PREFIX = "felineutilcore:textures/hud/tablet/";

    public static final ResourceLocation RES_BACKGROUND = new ResourceLocation(PREFIX + "runic.png");
    public static final ResourceLocation RES_ICONS = new ResourceLocation(PREFIX + "icons.png");
    public static final ResourceLocation RES_BUTTONS = new ResourceLocation(PREFIX + "buttons.png");
    public static final ResourceLocation RES_WIN_INTRO = new ResourceLocation(PREFIX + "test.png");

    public static final String CATEGORY_PREFIX = PREFIX + "category/";

    public static final ResourceLocation CATEGORY_BASIC = new ResourceLocation(CATEGORY_PREFIX + "basic.png");



}
