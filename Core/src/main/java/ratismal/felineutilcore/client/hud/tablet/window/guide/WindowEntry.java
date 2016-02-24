package ratismal.felineutilcore.client.hud.tablet.window.guide;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import ratismal.felineutilcore.api.guide.Guide;
import ratismal.felineutilcore.api.guide.GuideCategory;
import ratismal.felineutilcore.client.hud.tablet.TabletHUD;
import ratismal.felineutilcore.client.hud.tablet.widget.TabletButton;
import ratismal.felineutilcore.client.hud.tablet.widget.TabletButtonBack;
import ratismal.felineutilcore.client.hud.tablet.widget.TabletButtonCategory;
import ratismal.felineutilcore.client.hud.tablet.widget.TabletLabel;
import ratismal.felineutilcore.client.hud.tablet.window.Window;
import ratismal.felineutilcore.common.util.LogHelper;

import java.util.Collections;

/**
 * Created by Ratismal on 2016-02-23.
 */

public class WindowEntry extends Window {

    public static final int FIRST_LABEL = 6;
    public static final int BUTTON_BACK = 7;
    public static final int BUTTON_NEXT = 8;
    public static final int BUTTON_CATEGORY = 0;

    WindowGuide parent;

    public WindowEntry(ItemStack stack, EntityPlayer player, float partialTicks, int segment, WindowGuide parent) {
        super(stack, player, partialTicks, segment);
        this.parent = parent;
    }

    @Override
    public void init() {
        super.init();


        TabletButtonBack nextButton = new TabletButtonBack(BUTTON_NEXT, 125, 232, false);
       // if (page > categories.size()/6) nextButton.setEnabled(false);

        TabletButtonBack backButton = new TabletButtonBack(BUTTON_BACK, 75, 232, true);
     //   if (page <= 0) backButton.setEnabled(false);

        nextButton.setEnabled(true);

      //  LogHelper.debugInfo("Page - " + page + " - " + categories.size() / 6);

        TabletLabel firstLabel = new TabletLabel(FIRST_LABEL, 0, 0, 0, 0, "Feline Utilities Guidebook");
        labelList.add(firstLabel);

        buttonList.add(backButton);
        buttonList.add(nextButton);




        TabletHUD.currentGuide = this;

    }

    @Override
    public void actionPerformed(TabletButton button) {
        switch (button.id) {
            case BUTTON_BACK:
                //if (page > 0) page--;
                init();
                break;
            case BUTTON_NEXT:
                LogHelper.debugInfo("Next button");
                //if (page < categories.size() / 6) page++;
                init();
                break;
        }
        //LogHelper.debugInfo("Page: " + page);
    }

}
