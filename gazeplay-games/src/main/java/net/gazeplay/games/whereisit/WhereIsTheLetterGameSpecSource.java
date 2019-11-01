package net.gazeplay.games.whereisit;

import net.gazeplay.GameCategories;
import net.gazeplay.GameSpec;
import net.gazeplay.GameSpecSource;
import net.gazeplay.GameSummary;

public class WhereIsTheLetterGameSpecSource implements GameSpecSource {
    @Override
    public GameSpec getGameSpec() {
        return new GameSpec(
            GameSummary.builder().nameCode("WhereIsTheLetter").gameThumbnail("data/Thumbnails/Where-is-the-Letter.png").category(GameCategories.Category.MEMORIZATION).build(),
            new WhereIsTheLetterGameVariantGenerator(), new WhereIsTheLetterGameLauncher());
    }
}