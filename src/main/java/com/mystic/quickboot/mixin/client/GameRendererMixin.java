package com.mystic.quickboot.mixin.client;

import com.mystic.quickboot.util.obj_holders.MutableObjectHolder;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import java.util.List;

import static com.mystic.quickboot.client.QBClientEvents.Locations.WORLD_ICON;
import static com.mystic.quickboot.common.QBCommonEvents.Events.INTEGER_EVENT;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @ModifyConstant(method = "takeAutoScreenshot(Ljava/nio/file/Path;)V", constant = @Constant(intValue = 10))
    private static int delayWorldIcon(int constant) {
        final var returnValue = new MutableObjectHolder<>(constant);
        if (INTEGER_EVENT.isNotEmpty(WORLD_ICON))
            INTEGER_EVENT.execute(List.of(WORLD_ICON), true, returnValue);
        return returnValue.getHeldObj();
    }
}
