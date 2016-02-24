package ratismal.felineutilcore.client.hud.tablet.window;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import ratismal.felineutilcore.client.hud.tablet.ref.RefTabletHUD;
import ratismal.felineutilcore.client.hud.tablet.widget.TabletLabel;
import ratismal.felineutilcore.client.util.RenderHelper;

/**
 * Created by Ratismal on 2016-02-22.
 */

public class WindowIntro extends Window {

    public static final int LABEL_SEGMENT = 0;

    public WindowIntro(ItemStack stack, EntityPlayer player, float partialTicks, int segment) {
        super(stack, player, partialTicks, segment);
    }

    @Override
    public void init() {
        super.init();

        TabletLabel segLabel = new TabletLabel(LABEL_SEGMENT, 0, 0, 0, 0, "Segment: " + segment);
        labelList.add(segLabel);

    }

    @Override
    public void render() {
        super.render();
        Minecraft.getMinecraft().renderEngine.bindTexture(RefTabletHUD.RES_WIN_INTRO);
        RenderHelper.renderTessalator(RefTabletHUD.SEGMENT_X, RefTabletHUD.SEGMENT_Y);
    }

}
