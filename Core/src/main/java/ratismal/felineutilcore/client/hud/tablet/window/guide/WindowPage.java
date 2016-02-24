package ratismal.felineutilcore.client.hud.tablet.window.guide;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import ratismal.felineutilcore.client.hud.tablet.window.Window;

/**
 * Created by Ratismal on 2016-02-23.
 */

public class WindowPage extends Window {

    WindowEntry parent;

    public WindowPage(ItemStack stack, EntityPlayer player, float partialTicks, int segment, WindowEntry parent) {
        super(stack, player, partialTicks, segment);
        this.parent = parent;
    }
}
