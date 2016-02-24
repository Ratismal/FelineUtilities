package ratismal.felineutilcore.common.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import ratismal.felineutilcore.common.ref.RefGui;

/**
 * Created by Ratismal on 2016-02-22.
 */

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case RefGui.PLACEHOLDER:
                return null;
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case RefGui.PLACEHOLDER:
                return null;
        }

        return null;
    }

}