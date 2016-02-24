package ratismal.felineutilcore.client.core.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.profiler.Profiler;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ratismal.felineutilcore.client.hud.tablet.TabletHUD;
import ratismal.felineutilcore.common.init.ModItems;
import ratismal.felineutilcore.common.item.ItemCatTablet;
import ratismal.felineutilcore.common.ref.RefItem;

/**
 * Created by Ratismal on 2016-02-22.
 */

public class HUDHandler {

    @SubscribeEvent
    public void onDrawScreen(RenderGameOverlayEvent.Post event) {
        Minecraft mc = Minecraft.getMinecraft();
        Profiler profiler = mc.mcProfiler;
        ItemStack equippedStack = mc.thePlayer.getCurrentEquippedItem();

        if (event.type == RenderGameOverlayEvent.ElementType.ALL) {
            if (equippedStack != null && equippedStack.getItem() == ModItems.itemCatTablet) {
                profiler.startSection(RefItem.CAT_TABLET);
                ItemCatTablet.renderHUD(event.resolution, mc.thePlayer, equippedStack);
                profiler.endSection();
            }
        }
        if (equippedStack == null || equippedStack.getItem() != ModItems.itemCatTablet) {
            TabletHUD.isInitialized = false;
        }
    }
}
