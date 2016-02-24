package ratismal.felineutilcore.common.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ratismal.felineutilcore.client.hud.tablet.TabletHUD;
import ratismal.felineutilcore.common.ref.RefItem;

/**
 * Created by Ratismal on 2016-02-22.
 */

public class ItemCatTablet extends BaseItem {

    public ItemCatTablet() {
        super(RefItem.CAT_TABLET);

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onRenderWorldLast(RenderWorldLastEvent event) {
        //LogHelper.debugInfo("Rendering shit");
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        ItemStack stack = player.getCurrentEquippedItem();
        if (stack != null && stack.getItem() == this) {
            if (!TabletHUD.isInitialized) {
                TabletHUD.init(stack, player, event.partialTicks);
            }
            TabletHUD.update(stack, player, event.partialTicks);
        }
    }

    //@SideOnly(Side.CLIENT)
    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
        if (worldIn.isRemote) {
            TabletHUD.notifyMouseRightClick();

            if (GuiScreen.isShiftKeyDown()) {
                TabletHUD.clear();
            }
        }
        return super.onItemRightClick(itemStackIn, worldIn, playerIn);
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        if (entityLiving.worldObj.isRemote)
            TabletHUD.notifyMouseLeftClick();
        return super.onEntitySwing(entityLiving, stack);
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player) {
        return true;
    }


    @SideOnly(Side.CLIENT)
    public static void renderHUD(ScaledResolution resolution, EntityPlayer player, ItemStack stack) {

    }
}
