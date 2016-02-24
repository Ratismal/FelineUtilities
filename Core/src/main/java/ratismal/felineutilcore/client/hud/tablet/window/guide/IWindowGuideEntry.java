package ratismal.felineutilcore.client.hud.tablet.window.guide;

import ratismal.felineutilcore.api.guide.GuideEntry;

/**
 * Created by Ratismal on 2016-02-23.
 */

public interface IWindowGuideEntry {

    public GuideEntry getEntry();

    public int getPageOn();

    public int getLeft();

    public int getTop();

    public int getWidth();

    public int getHeight();

    public float getZLevel();


}
