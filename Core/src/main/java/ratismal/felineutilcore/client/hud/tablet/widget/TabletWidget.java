package ratismal.felineutilcore.client.hud.tablet.widget;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

/**
 * Created by Ratismal on 2016-02-23.
 */

public class TabletWidget {

    public int id;
    public int xPosition, yPosition, width, height;
    public int depth = 0;
    public boolean enabled = true;
    public boolean visible = true;

    public TabletWidget(int id, int xPosition, int yPosition, int width, int height) {
        this.id = id;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height, double factor)
    {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos((double)(0), (double)(y + height), (double)x + 0).tex((double) ((float) (textureX + 0) * f), (double) ((float) (textureY + height / factor) * f1)).endVertex();
        worldrenderer.pos((double)(0), (double)(y + height), (double)x + width).tex((double) ((float) (textureX + width / factor) * f), (double) ((float) (textureY + height / factor) * f1)).endVertex();
        worldrenderer.pos((double)(0), (double)(y + 0), (double)x + width).tex((double) ((float) (textureX + width / factor) * f), (double) ((float) (textureY + 0) * f1)).endVertex();
        worldrenderer.pos((double)(0), (double)(y + 0), (double)x + 0).tex((double) ((float) (textureX + 0) * f), (double) ((float) (textureY + 0) * f1)).endVertex();
        tessellator.draw();
    }

    public void drawTexturedModalRect(int x, int y, int width, int height)
    {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos((double)(0), (double)(y + height), (double)x + 0).tex(0, 1).endVertex();
        worldrenderer.pos((double)(0), (double)(y + height), (double)x + width).tex(1, 1).endVertex();
        worldrenderer.pos((double)(0), (double)(y + 0), (double)x + width).tex(1, 0).endVertex();
        worldrenderer.pos((double)(0), (double)(y + 0), (double)x + 0).tex(0, 0).endVertex();
        tessellator.draw();
    }
}
