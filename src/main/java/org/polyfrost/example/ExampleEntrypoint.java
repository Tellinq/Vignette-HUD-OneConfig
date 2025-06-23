package org.polyfrost.example;

//#if FABRIC
//$$ import net.fabricmc.api.ModInitializer;
//$$ import net.fabricmc.api.ClientModInitializer;
//$$ import net.fabricmc.api.DedicatedServerModInitializer;
//#elseif FORGE
//#if MC >= 1.16.5
//$$ import net.minecraftforge.eventbus.api.IEventBus;
//$$ import net.minecraftforge.fml.common.Mod;
//$$ import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
//$$ import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
//$$ import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
//$$ import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
//#else
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
//#endif
//#elseif NEOFORGE
//$$ import net.neoforged.bus.api.IEventBus;
//$$ import net.neoforged.fml.common.Mod;
//$$ import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
//$$ import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
//$$ import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
//#endif

import org.polyfrost.example.Example;
import org.polyfrost.example.client.ExampleClient;
import org.polyfrost.example.server.ExampleServer;

//#if FORGE-LIKE
//$$ import org.polyfrost.example.ExampleConstants;
//$$
//#if MC >= 1.16.5
//$$ @Mod(ExampleConstants.ID)
//#else
@Mod(modid = ExampleConstants.ID, version = ExampleConstants.VERSION)
//#endif
//#endif
public class ExampleEntrypoint
    //#if FABRIC
    //$$ implements ModInitializer, ClientModInitializer, DedicatedServerModInitializer
    //#endif
{

    //#if FORGE && MC >= 1.16.5
    //$$ public ExampleEntrypoint() {
    //$$     setupForgeEvents(FMLJavaModLoadingContext.get().getModEventBus());
    //$$ }
    //#elseif NEOFORGE
    //$$ public ExampleEntrypoint(IEventBus modEventBus) {
    //$$     setupForgeEvents(modEventBus);
    //$$ }
    //#endif

    //#if FABRIC
    //$$ @Override
    //#elseif FORGE && MC <= 1.12.2
    @Mod.EventHandler
    //#endif
    public void onInitialize(
            //#if FORGE-LIKE
            //#if MC >= 1.16.5
            //$$ FMLCommonSetupEvent event
            //#else
            FMLInitializationEvent event
            //#endif
            //#endif
    ) {
        Example.INSTANCE.initialize();
    }

    //#if FABRIC
    //$$ @Override
    //#elseif FORGE && MC <= 1.12.2
    @Mod.EventHandler
    //#endif
    public void onInitializeClient(
            //#if FORGE-LIKE
            //#if MC >= 1.16.5
            //$$ FMLClientSetupEvent event
            //#else
            FMLInitializationEvent event
            //#endif
            //#endif
    ) {
        //#if FORGE && MC <= 1.12.2
        //$$ if (!event
        //#if MC <= 1.8.9
        //$$ .side.isClient
        //#else
        //$$ .getSide().isClient()
        //#endif
        //$$ ) {
        //$$     return;
        //$$ }
        //#endif

        ExampleClient.INSTANCE.initialize();
    }

    //#if FABRIC
    //$$ @Override
    //#elseif FORGE && MC <= 1.12.2
    @Mod.EventHandler
    //#endif
    public void onInitializeServer(
            //#if FORGE-LIKE
            //#if MC >= 1.16.5
            //$$ FMLDedicatedServerSetupEvent event
            //#else
            FMLInitializationEvent event
            //#endif
            //#endif
    ) {
        //#if FORGE && MC <= 1.12.2
        //$$ if (!event.
        //#if MC <= 1.8.9
        //$$ side.isServer
        //#else
        //$$ getSide().isServer()
        //#endif
        //$$ ) {
        //$$     return;
        //$$ }
        //#endif

        ExampleServer.INSTANCE.initialize();
    }

    //#if FORGE-LIKE && MC >= 1.16.5
    //$$ private void setupForgeEvents(IEventBus modEventBus) {
    //$$     modEventBus.addListener(this::onInitialize);
    //$$     modEventBus.addListener(this::onInitializeClient);
    //$$     modEventBus.addListener(this::onInitializeServer);
    //$$ }
    //#endif

}
