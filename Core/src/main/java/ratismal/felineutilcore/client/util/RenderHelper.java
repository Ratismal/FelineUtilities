package ratismal.felineutilcore.client.util;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import ratismal.felineutilcore.client.hud.tablet.ref.RefTabletHUD;

/**
 * Created by Ratismal on 2016-02-22.
 */

public class RenderHelper {

    public static void renderTessalator(float x, float y) {
        Tessellator tess = Tessellator.getInstance();
        WorldRenderer wr = tess.getWorldRenderer();
        wr.begin(7, DefaultVertexFormats.POSITION_TEX);
        wr.pos(0, y, x).tex(1, 0).endVertex();
        wr.pos(0, y, 0).tex(0, 0).endVertex();
        wr.pos(0, 0, 0).tex(0, 1).endVertex();
        wr.pos(0, 0, x).tex(1, 1).endVertex();
        tess.draw();
    }

    public static void renderTessalator(float x1, float y1, float x2, float y2) {
        Tessellator tess = Tessellator.getInstance();
        WorldRenderer wr = tess.getWorldRenderer();
        wr.begin(7, DefaultVertexFormats.POSITION_TEX);
        wr.pos(0, y2, x2).tex(1, 0).endVertex();
        wr.pos(0, y2, x1).tex(0, 0).endVertex();
        wr.pos(0, y1, x1).tex(0, 1).endVertex();
        wr.pos(0, y1, x2).tex(1, 1).endVertex();
        tess.draw();
    }

    public static void renderTessalatorUV(float x, float y, float u, float v) {
        Tessellator tess = Tessellator.getInstance();
        WorldRenderer wr = tess.getWorldRenderer();
        wr.begin(7, DefaultVertexFormats.POSITION_TEX);
        wr.pos(0, y, x).tex(u, 0).endVertex();
        wr.pos(0, y, 0).tex(0, 0).endVertex();
        wr.pos(0, 0, 0).tex(0, v).endVertex();
        wr.pos(0, 0, x).tex(u, v).endVertex();
        tess.draw();
    }

    public static void renderTessalatorUV(float x1, float y1, float x2, float y2, float u, float v) {
        Tessellator tess = Tessellator.getInstance();
        WorldRenderer wr = tess.getWorldRenderer();
        wr.begin(7, DefaultVertexFormats.POSITION_TEX);
        wr.pos(0, y2, x2).tex(u, 0).endVertex();
        wr.pos(0, y2, x1).tex(0, 0).endVertex();
        wr.pos(0, y1, x1).tex(0, v).endVertex();
        wr.pos(0, y1, x2).tex(u, v).endVertex();
        tess.draw();
    }

}
