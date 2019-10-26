package net.gazeplay.games.memory;

import net.gazeplay.GameCategories;
import net.gazeplay.GameSpec;
import net.gazeplay.GameSpecSource;
import net.gazeplay.GameSummary;

public class OpenMemoryGameSpecSource implements GameSpecSource {
    @Override
    public GameSpec getGameSpec() {
        return new GameSpec(
            GameSummary.builder().nameCode("OpenMemory").gameThumbnail("data/Thumbnails/openMemory.png").category(GameCategories.Category.ACTION_REACTION).build(),
            new OpenMemoryGameVariantGenerator(), new OpenMemoryGameLauncher());
    }
}
