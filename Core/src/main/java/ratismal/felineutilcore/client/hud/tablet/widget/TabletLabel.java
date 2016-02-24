package ratismal.felineutilcore.client.hud.tablet.widget;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by Ratismal on 2016-02-23.
 */

public class TabletLabel extends TabletWidget {

    public String message;
    public boolean visible = true;


    public TabletLabel(int id, int xPosition, int yPosition, int width, int height, String message) {
        super(id, xPosition, yPosition, width, height);
        this.message = message;
    }

    public void render() {
        GL11.glPushMatrix();

        GL11.glTranslatef(0f, 0f, getDepth());

        Minecraft mc = Minecraft.getMinecraft();
        FontRenderer fontRender = mc.fontRendererObj;

        fontRender.drawString(message, xPosition, yPosition, 0xFFFFFF);

        GL11.glPopMatrix();
    }
}
