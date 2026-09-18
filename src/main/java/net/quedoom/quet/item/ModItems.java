package net.quedoom.quet.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.material.Fluids;
import net.quedoom.quet.init.QueTItem;

import java.util.function.Consumer;

public class ModItems extends QueTItem {
    public static final Item TEST_ITEM = register("test_item", properties -> new Item(properties) {
        @Override
        public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
            QTTooltip qtTooltip = QTTooltip.of(builder, TEST_ITEM);
            qtTooltip.addShift();
        }
    });

    public static final Item BUCKET_ITEM = registerBucket("bucket_item", Fluids.WATER);

}
