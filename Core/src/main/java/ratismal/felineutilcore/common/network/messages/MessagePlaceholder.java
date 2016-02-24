package ratismal.felineutilcore.common.network.messages;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import ratismal.felineutilcore.common.network.ITMessage;

/**
 * Created by Ratismal on 2016-01-20.
 */

public class MessagePlaceholder implements ITMessage {

    private int temp;

    // The basic, no-argument constructor MUST be included to use the new automated handling
    public MessagePlaceholder() {
    }

    // if there are any class fields, be sure to provide a constructor that allows
    // for them to be initialized, and use that constructor when sending the packet


    public MessagePlaceholder(String name, int flag, BlockPos pos) {
        this.temp = flag;
    }

    @Override
    public void fromBytes(ByteBuf buffer) {
        // basic Input/Output operations, very much like DataInputStream
        temp = buffer.readInt();
    }

    @Override
    public void toBytes(ByteBuf buffer) {
        // basic Input/Output operations, very much like DataOutputStream
        buffer.writeInt(temp);
    }

    @Override
    public void onMessage(final MessageContext context) {
        FMLCommonHandler.instance().getMinecraftServerInstance().addScheduledTask(new Runnable() {
            @Override
            public void run() {
                if (context.netHandler instanceof NetHandlerPlayServer) {

                    //NO-OP

                }
            }
        });

    }

    @Override
    public Side getHandlingSide() {
        return Side.SERVER;
    }
}
