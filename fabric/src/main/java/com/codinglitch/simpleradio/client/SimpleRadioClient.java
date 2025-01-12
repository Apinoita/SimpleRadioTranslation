package com.codinglitch.simpleradio.client;

import com.codinglitch.simpleradio.core.FabricLoader;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;

public class SimpleRadioClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        FabricLoader.loadClientPackets();

        CommonSimpleRadioClient.initialize();
        CommonSimpleRadioClient.loadScreens();
        CommonSimpleRadioClient.loadProperties(ItemProperties::register);
        CommonSimpleRadioClient.loadRenderTypes(BlockRenderLayerMap.INSTANCE::putBlock);
        CommonSimpleRadioClient.loadLayerDefinitions((location, definition) -> EntityModelLayerRegistry.registerModelLayer(location, definition::get));
        CommonSimpleRadioClient.loadBlockEntityRenderers(BlockEntityRenderers::register);
    }
}
