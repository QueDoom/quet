package net.quedoom.quet.datagen.sound;

import net.fabricmc.fabric.api.client.datagen.v1.builder.SoundTypeBuilder;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricSoundsProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.quedoom.quet.init.ModRegistrator;

public record QTSoundExporter(FabricSoundsProvider.SoundExporter exporter) {
    public static QTSoundExporter of(FabricSoundsProvider.SoundExporter exporter) {
        return new QTSoundExporter(exporter);
    }

    public void addDisc(SoundEvent event) {
        this.exporter.add(event, SoundTypeBuilder.of(event)
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(event.location()).stream(true)));
    }

    public void add(SoundEvent event, String... sounds) {
        for (String sound : sounds) {
            this.exporter.add(event, SoundTypeBuilder.of(event)
                    .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), sound))));
        }
    }

    public void add(SoundEvent event) {
        this.exporter.add(event, SoundTypeBuilder.of(event)
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(event.location())));
    }

    public void add(SoundEvent event, String event0) {
        this.exporter.add(event, SoundTypeBuilder.of(event)
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event0)))
        );
    }

    public void add(SoundEvent event, String event0, String event1) {
        this.exporter.add(event, SoundTypeBuilder.of(event)
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event0)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event1)))
        );
    }

    public void add(SoundEvent event, String event0, String event1, String event2) {
        this.exporter.add(event, SoundTypeBuilder.of(event)
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event0)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event1)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event2)))
        );
    }

    public void add(SoundEvent event, String event0, String event1, String event2, String event3) {
        this.exporter.add(event, SoundTypeBuilder.of(event)
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event0)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event1)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event2)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event3)))
        );
    }

    public void add(SoundEvent event, String event0, String event1, String event2, String event3, String event4) {
        this.exporter.add(event, SoundTypeBuilder.of(event)
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event0)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event1)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event2)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event3)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event4)))
        );
    }

    public void add(SoundEvent event, String event0, String event1, String event2, String event3, String event4, String event5) {
        this.exporter.add(event, SoundTypeBuilder.of(event)
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event0)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event1)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event2)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event3)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event4)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event5)))
        );
    }

    public void add(SoundEvent event, String event0, String event1, String event2, String event3, String event4, String event5, String event6) {
        this.exporter.add(event, SoundTypeBuilder.of(event)
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event0)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event1)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event2)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event3)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event4)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event5)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event6)))
        );
    }

    public void add(SoundEvent event, String event0, String event1, String event2, String event3, String event4, String event5, String event6, String event7) {
        this.exporter.add(event, SoundTypeBuilder.of(event)
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event0)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event1)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event2)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event3)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event4)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event5)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event6)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event7)))
        );
    }

    public void add(SoundEvent event, String event0, String event1, String event2, String event3, String event4, String event5, String event6, String event7, String event8) {
        this.exporter.add(event, SoundTypeBuilder.of(event)
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event0)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event1)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event2)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event3)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event4)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event5)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event6)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event7)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event8)))
        );
    }

    public void add(SoundEvent event, String event0, String event1, String event2, String event3, String event4, String event5, String event6, String event7, String event8, String event9) {
        this.exporter.add(event, SoundTypeBuilder.of(event)
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event0)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event1)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event2)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event3)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event4)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event5)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event6)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event7)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event8)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event9)))
        );
    }

    public void add(SoundEvent event, String event0, String event1, String event2, String event3, String event4, String event5, String event6, String event7, String event8, String event9, String event10) {
        this.exporter.add(event, SoundTypeBuilder.of(event)
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event0)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event1)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event2)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event3)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event4)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event5)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event6)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event7)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event8)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event9)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event10)))
        );
    }

    public void add(SoundEvent event, String event0, String event1, String event2, String event3, String event4, String event5, String event6, String event7, String event8, String event9, String event10, String event11) {
        this.exporter.add(event, SoundTypeBuilder.of(event)
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event0)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event1)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event2)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event3)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event4)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event5)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event6)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event7)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event8)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event9)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event10)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event11)))
        );
    }

    public void add(SoundEvent event, String event0, String event1, String event2, String event3, String event4, String event5, String event6, String event7, String event8, String event9, String event10, String event11, String event12) {
        this.exporter.add(event, SoundTypeBuilder.of(event)
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event0)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event1)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event2)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event3)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event4)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event5)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event6)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event7)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event8)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event9)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event10)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event11)))
                .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(ModRegistrator.namespace(), event12)))
        );
    }
}
