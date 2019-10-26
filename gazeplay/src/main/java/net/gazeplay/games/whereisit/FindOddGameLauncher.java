package net.gazeplay.games.whereisit;

import javafx.scene.Scene;
import net.gazeplay.GameContext;
import net.gazeplay.GameLifeCycle;
import net.gazeplay.GameSpec;
import net.gazeplay.commons.utils.stats.Stats;

public class FindOddGameLauncher implements GameSpec.GameLauncher<Stats, GameSpec.DimensionGameVariant> {
    @Override
    public Stats createNewStats(Scene scene) {
        return new WhereIsItStats(scene, WhereIsIt.WhereIsItGameType.FINDODD.getGameName());
    }

    @Override
    public GameLifeCycle createNewGame(GameContext gameContext,
                                       GameSpec.DimensionGameVariant gameVariant, Stats stats) {
        return new WhereIsIt(WhereIsIt.WhereIsItGameType.FINDODD, gameVariant.getWidth(),
            gameVariant.getHeight(), false, gameContext, stats);
    }
}