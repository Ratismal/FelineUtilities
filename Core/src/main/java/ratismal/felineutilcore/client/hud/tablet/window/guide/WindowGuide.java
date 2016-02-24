package ratismal.felineutilcore.client.hud.tablet.window.guide;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;
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
import java.util.List;

/**
 * Created by Ratismal on 2016-02-23.
 */

public class WindowGuide extends Window {

    public static final int FIRST_LABEL = 6;
    public static final int BUTTON_BACK = 7;
    public static final int BUTTON_NEXT = 8;
    public static final int PAGE_LABEL = 9;
    public static final int BUTTON_CATEGORY = 0;


    public int page = 0;
    List<GuideCategory> categories;


    public WindowGuide(ItemStack stack, EntityPlayer player, float partialTicks, int segment) {
        super(stack, player, partialTicks, segment);
    }

    @Override
    public void init() {
        super.init();

        categories = Guide.getCategories();
        Collections.sort(categories);

        TabletButtonBack nextButton = new TabletButtonBack(BUTTON_NEXT, 125, 232, false);
        //if (page > categories.size()/6) nextButton.setEnabled(false);

        TabletButtonBack backButton = new TabletButtonBack(BUTTON_BACK, 75, 232, true);
        //if (page <= 0) backButton.setEnabled(false);

        nextButton.setEnabled(true);

        LogHelper.debugInfo("Page - " + page + " - " + categories.size() / 6);

        TabletLabel firstLabel = new TabletLabel(FIRST_LABEL, 0, 0, 0, 0, "Feline Utilities Guidebook");
        labelList.add(firstLabel);

        TabletLabel pageLabel = new TabletLabel(PAGE_LABEL, 84, 150, 0, 0, String.valueOf(page + 1));
        labelList.add(pageLabel);

        buttonList.add(backButton);
        buttonList.add(nextButton);


        int categoriesSize = categories.size();
        for (int i = 0; i < categoriesSize && i <= 5; i++) {
            GuideCategory category = i + page*6 >= categoriesSize ? null : categories.get(i + page*6);
            if (category != null) {
                int x = i % 3;
                //LogHelper.debugInfo("x: " + x);
                int y = i / 3;
                //LogHelper.debugInfo("y: " + y);
                int xSize = 70;
                int ySize = 80;

                TabletButtonCategory button = new TabletButtonCategory(i + BUTTON_CATEGORY, 8 + x * xSize, 64 + y * ySize, category);
                //TabletButtonCategory button = new TabletButtonCategory(i + BUTTON_CATEGORY, 8, 50, category);
                buttonList.add(button);
            }
        }

        TabletHUD.currentGuide = this;

    }

    @Override
    public void actionPerformed(TabletButton button) {
        switch (button.id) {
            case BUTTON_BACK:
                if (page > 0) page--;
                init();
                break;
            case BUTTON_NEXT:
                LogHelper.debugInfo("Next button");
                if (page < categories.size() / 6) page++;
                init();
                break;
        }
        //LogHelper.debugInfo("Page: " + page);
    }

}
