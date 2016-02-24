package ratismal.felineutilcore.api.guide;

import net.minecraft.client.gui.GuiButton;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ratismal.felineutilcore.client.hud.tablet.window.guide.IWindowGuideEntry;

/**
 * Created by Ratismal on 2016-02-23.
 */

public abstract class GuidePage {

    public String unlocalizedName;
    public boolean skipRegistry;

    public GuidePage(String unlocalizedName) {
        this.unlocalizedName = unlocalizedName;
    }

    @SideOnly(Side.CLIENT)
    public abstract void renderScreen(IWindowGuideEntry gui, int mx, int my);

    @SideOnly(Side.CLIENT)
    public void updateScreen() {}

    @SideOnly(Side.CLIENT)
    public void updateScreen(IWindowGuideEntry gui) {}

    @SideOnly(Side.CLIENT)
    public void onOpened(IWindowGuideEntry gui) {}

    @SideOnly(Side.CLIENT)
    public void onClosed(IWindowGuideEntry gui) {}

    @SideOnly(Side.CLIENT)
    public void onActionPerformed(IWindowGuideEntry gui, GuiButton button) {}

    @SideOnly(Side.CLIENT)
    public void onKeyPressed(char c, int index) {}

    @SideOnly(Side.CLIENT)
    public void onPageAdded(GuideEntry entry, int index) {}

    public String getUnlocalizedName() {
        return unlocalizedName;
    }

    public GuidePage setSkipRegistry() {
        skipRegistry = true;
        return this;
    }

}
