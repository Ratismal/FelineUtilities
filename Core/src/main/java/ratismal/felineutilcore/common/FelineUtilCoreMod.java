package ratismal.felineutilcore.common;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import ratismal.felineutilcore.client.core.handler.HUDHandler;
import ratismal.felineutilcore.common.crafting.CoreCraftingRecipes;
import ratismal.felineutilcore.common.guide.GuideData;
import ratismal.felineutilcore.common.handler.ConfigHandler;
import ratismal.felineutilcore.common.handler.GuiHandler;
import ratismal.felineutilcore.common.init.ModBlocks;
import ratismal.felineutilcore.common.init.ModItems;
import ratismal.felineutilcore.common.network.PacketHandler;
import ratismal.felineutilcore.common.util.LogHelper;

/**
 * Created by Ratismal on 2016-01-11.
 */

@Mod(modid = FelineUtilCoreMod.MODID, name = FelineUtilCoreMod.MODNAME, version = "1.0.0", dependencies = "required-after:Forge@[11.15.0.1634,)", useMetadata = true)
public class FelineUtilCoreMod {

    public static final String MODID = "felineutilcore";
    public static final String MODNAME = "Feline Utilities: Core";

    @SidedProxy
    public static CommonProxy proxy;

    @Mod.Instance
    public static FelineUtilCoreMod instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        logger = event.getModLog();
        proxy.preInit(event);

        /*
        Temp test stuff
         */

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

    public static class CommonProxy {

        /**
         * Returns a side-appropriate EntityPlayer for use during message handling
         */
        public EntityPlayer getPlayerEntity(MessageContext ctx) {
            return ctx.getServerHandler().playerEntity;
        }

        public void preInit(FMLPreInitializationEvent e) {
            LogHelper.info("Doing a really cool preInit().");
            ConfigHandler.init(e.getSuggestedConfigurationFile());
            ModBlocks.init();
            ModItems.init();
            PacketHandler.init();
            GuideData.init();
        }

        public void init(FMLInitializationEvent e) {
            LogHelper.info("Doing a so-so clear().");
            NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
            CoreCraftingRecipes.init();
        }

        public void postInit(FMLPostInitializationEvent e) {
            LogHelper.info("Doing a kinda meh postInit().");
            LogHelper.info("Job done.");
        }
    }


    public static class ClientProxy extends CommonProxy {

        public static EntityPlayer getThePlayer() {
            return FMLClientHandler.instance().getClientPlayerEntity();
        }

        @Override
        public EntityPlayer getPlayerEntity(MessageContext ctx) {
            // Note that if you simply return 'Minecraft.getMinecraft().thePlayer',
            // your packets will not work because you will be getting a client
            // player even when you are on the server! Sounds absurd, but it's true.

            // Solution is to double-check side before returning the player:
            return (ctx.side.isClient() ? Minecraft.getMinecraft().thePlayer : super.getPlayerEntity(ctx));
        }

        @Override
        public void preInit(FMLPreInitializationEvent e) {
            super.preInit(e);

            OBJLoader.instance.addDomain(MODID);

            // Typically initialization of models and such goes here:
            ModBlocks.initModels();
            ModItems.initModels();
        }

        @Override
        public void init(FMLInitializationEvent e) {
            super.init(e);
            MinecraftForge.EVENT_BUS.register(new HUDHandler());
            //ModBlocks.initItemModels();
        }
    }

    public static class ServerProxy extends CommonProxy {



    }
}