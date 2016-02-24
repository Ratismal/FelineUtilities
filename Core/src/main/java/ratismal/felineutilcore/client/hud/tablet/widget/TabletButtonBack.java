package ratismal.felineutilcore.client.hud.tablet.widget;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;
import ratismal.felineutilcore.client.hud.tablet.ref.RefTabletHUD;
import ratismal.felineutilcore.client.util.RenderHelper;
import ratismal.felineutilcore.common.util.LogHelper;

/**
 * Created by Ratismal on 2016-02-23.
 */

public class TabletButtonBack extends TabletButton {

    boolean next;

    public TabletButtonBack(int id, int xPosition, int yPosition, boolean next) {
        super(id, xPosition, yPosition, 36, 20);
        this.next = next;
        //setEnabled(true);
    }


    @Override
    public void drawButton() {
        if (isVisible() && isEnabled()) {
            super.drawButton();

            Minecraft.getMinecraft().renderEngine.bindTexture(RefTabletHUD.RES_BUTTONS);


            //LogHelper.debugInfo(hover + "");
            drawTexturedModalRect(-xPosition, 256 - yPosition, hover ? 0 : 18, next ? 10 : 0, width, height, 2);
            //RenderHelper.renderTessalator(256, 256, 0, 0);
        }
    }

}
