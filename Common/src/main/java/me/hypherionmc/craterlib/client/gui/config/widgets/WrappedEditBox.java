package me.hypherionmc.craterlib.client.gui.config.widgets;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.network.chat.Component;

public class WrappedEditBox extends EditBox {

    public WrappedEditBox(Font font, int i, int j, int k, int l, Component component) {
        super(font, i, j, k, l, component);
    }

    @Override
    public void setFocus(boolean bl) {
        for (GuiEventListener child : Minecraft.getInstance().screen.children()) {
            if (child instanceof TextConfigOption<?> option) {
                WrappedEditBox box = option.widget;
                box.setFocused(box == this);
            }
        }
        super.setFocus(bl);
    }
}
