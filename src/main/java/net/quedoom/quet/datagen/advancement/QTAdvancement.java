package net.quedoom.quet.datagen.advancement;

import net.minecraft.advancements.*;
import net.minecraft.resources.Identifier;
import net.quedoom.quet.datagen.lang.QTTranslationBuilder;
import net.quedoom.quet.misc.QueTObjectStorage;
import org.jspecify.annotations.Nullable;

import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public class QTAdvancement {
    private final AdvancementHolder holder;
    private final String untranslatedName;
    public String pageName, translatedName, translatedDescription;

    public QTAdvancement(AdvancementHolder holder, String untranslatedName, String pageName,
                         @Nullable String translatedName, @Nullable String translatedDescription) {
        this.holder = holder;
        this.pageName = pageName;
        this.untranslatedName = untranslatedName;
        this.translatedName = translatedName;
        this.translatedDescription = translatedDescription;
    }

    @Override
    public String toString() {
        return "QTAdvancement@[Holder: {" + this.holder.toString() + "}, " +
                "Advancement: \"namespace:" + pageName + '/' + untranslatedName + "\", " +
                "Translation: {Translated Name: " + translatedName + ", Translated Description: " + translatedDescription + "}]";
    }

    public AdvancementHolder holder() {
        return this.holder;
    }
    public String untranslatedName() {
        return this.untranslatedName;
    }

    public QTAdvancement append(String name, String description) {
        this.translatedName = name;
        this.translatedDescription = description;
        return this;
    }
    public QTAdvancement appendName(String name) {
        this.translatedName = name;
        return this;
    }
    public QTAdvancement appendDescription(String description) {
        this.translatedDescription = description;
        return this;
    }

    public static class Builder {
        private Advancement.Builder advancementBuilder;
        private final String untranslatedName, namespace, pageName;

        public Builder(Advancement.Builder builder, String untranslatedName, String namespace, String pageName) {
            this.advancementBuilder = builder;
            this.untranslatedName = untranslatedName;
            this.pageName = pageName;
            this.namespace = namespace;
        }

        public Builder(Advancement.Builder builder, String untranslatedName, Identifier identifier) {
            this.advancementBuilder = builder;
            this.untranslatedName = untranslatedName;
            this.pageName = QTTranslationBuilder.getLastPartOfPath(identifier.getPath());
            this.namespace = identifier.getNamespace();
        }

        public Builder rewards(final AdvancementRewards.Builder rewards) {
            return this.rewards(rewards.build());
        }

        public Builder rewards(final AdvancementRewards rewards) {
            this.advancementBuilder = this.advancementBuilder.rewards(rewards);
            return this;
        }

        public Builder addCriterion(final String name, final Criterion<?> criterion) {
            this.advancementBuilder.criteria.put(name, criterion);
            return this;
        }

        public Builder requirements(final AdvancementRequirements.Strategy strategy) {
            this.advancementBuilder.requirementsStrategy = strategy;
            return this;
        }

        public Builder requirements(final AdvancementRequirements requirements) {
            this.advancementBuilder.requirements = Optional.of(requirements);
            return this;
        }

        /**
         * Finish the Advancement creation
         * @param output It will be called "consumer" in the generator
         * @param translatedName The name of the advancement to see in-game
         * @param translatedDescription The description you'll see if you hover the advancement in chat or in the menu
         * @return Finished {@link QTAdvancement} with translations (if you run {@link QTTranslationBuilder#autoTranslateAllAdvancements()}
         */
        public QTAdvancement buildWithTranslations(final Consumer<AdvancementHolder> output,
                                   @Nullable String translatedName, @Nullable String translatedDescription) {
            Map<String, Criterion<?>> criteria = this.advancementBuilder.criteria.buildOrThrow();
            AdvancementRequirements requirements = this.advancementBuilder.requirements.orElseGet(() -> this.advancementBuilder.requirementsStrategy.create(criteria.keySet()));
            Advancement advancement = new Advancement(this.advancementBuilder.parent, this.advancementBuilder.display, this.advancementBuilder.rewards, criteria, requirements, false);
            AdvancementHolder aHolder = new AdvancementHolder(Identifier.fromNamespaceAndPath(this.namespace, this.pageName + '/' + this.untranslatedName), advancement);
            output.accept(aHolder);
            QTAdvancement qtAdvancement = new QTAdvancement(aHolder, untranslatedName, pageName, translatedName, translatedDescription);
            QueTObjectStorage.addAutotranslate(qtAdvancement);
            return qtAdvancement;
        }

        /**
         * Use this only for advancements that are never shown.
         * @param output It will be called "consumer" in the generator
         * @return Finished {@link QTAdvancement}
         */
        public QTAdvancement build(final Consumer<AdvancementHolder> output) {
            Map<String, Criterion<?>> criteria = this.advancementBuilder.criteria.buildOrThrow();
            AdvancementRequirements requirements = this.advancementBuilder.requirements.orElseGet(() -> this.advancementBuilder.requirementsStrategy.create(criteria.keySet()));
            Advancement advancement = new Advancement(this.advancementBuilder.parent, this.advancementBuilder.display, this.advancementBuilder.rewards, criteria, requirements, false);
            AdvancementHolder aHolder = new AdvancementHolder(Identifier.fromNamespaceAndPath(this.namespace, this.pageName + '/' + this.untranslatedName), advancement);
            output.accept(aHolder);
            QTAdvancement qtAdvancement = new QTAdvancement(aHolder, untranslatedName, pageName, null, null);
            QueTObjectStorage.addAutotranslate(qtAdvancement);
            return qtAdvancement;
        }
    }
}
