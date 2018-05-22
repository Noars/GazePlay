package net.gazeplay.games.labyrinth;

import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Dimension2D;
import javafx.scene.Parent;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import net.gazeplay.GameContext;
import net.gazeplay.commons.gaze.devicemanager.GazeEvent;
import net.gazeplay.commons.utils.stats.Stats;
import net.gazeplay.games.labyrinth.Labyrinth;

public class Mouse extends Parent {

    private final GameContext gameContext;

    private final Labyrinth gameInstance;

    private ProgressIndicator progressIndicator;

    final Stats stats;

    private Rectangle mouse;

    private int indiceX;
    private int indiceY;

    private Rectangle buttonUp;
    private Rectangle buttonDown;
    private Rectangle buttonRight;
    private Rectangle buttonLeft;

    public final EventHandler<Event> buttonUpEvent;
    public final EventHandler<Event> buttonDownEvent;
    public final EventHandler<Event> buttonRightEvent;
    public final EventHandler<Event> buttonLeftEvent;

    public Mouse(double positionX, double positionY, double width, double height, GameContext gameContext, Stats stats,
            Labyrinth gameInstance) {

        this.gameContext = gameContext;
        this.gameInstance = gameInstance;
        this.stats = stats;

        this.mouse = new Rectangle(positionX, positionY, width, height);
        this.mouse.setFill(new ImagePattern(new Image("data/labyrinth/images/mouse.png"), 5, 5, 1, 1, true));
        this.getChildren().add(mouse);

        this.indiceX = 0; // largeur
        this.indiceY = 0; // hauteur

        this.buttonUpEvent = buildButtonUp();
        this.buttonDownEvent = buildButtonDownEvent();
        this.buttonRightEvent = buildButtonRightEvent();
        this.buttonLeftEvent = buildButtonLeftEvent();

        Dimension2D dimension2D = gameContext.getGamePanelDimensionProvider().getDimension2D();

        double buttonDimHeight = dimension2D.getHeight() / 10;
        double buttonDimWidth = dimension2D.getWidth() / 10;

        this.buttonUp = new Rectangle(dimension2D.getWidth() * 0.1, dimension2D.getHeight() * 0.1, buttonDimWidth,
                buttonDimHeight);
        this.buttonUp.setFill(new ImagePattern(new Image("data/labyrinth/images/upArrow.png"), 5, 5, 1, 1, true));

        this.buttonDown = new Rectangle(dimension2D.getWidth() * 0.1, dimension2D.getHeight() * 0.1, buttonDimWidth,
                buttonDimHeight);
        this.buttonDown.setFill(new ImagePattern(new Image("data/labyrinth/images/downArrow.png"), 5, 5, 1, 1, true));

        this.buttonLeft = new Rectangle(dimension2D.getWidth() * 0.1, dimension2D.getHeight() * 0.1, buttonDimWidth,
                buttonDimHeight);
        this.buttonLeft.setFill(new ImagePattern(new Image("data/labyrinth/images/leftArrow.png"), 5, 5, 1, 1, true));

        this.buttonRight = new Rectangle(dimension2D.getWidth() * 0.1, dimension2D.getHeight() * 0.1, buttonDimWidth,
                buttonDimHeight);
        this.buttonRight.setFill(new ImagePattern(new Image("data/labyrinth/images/rightArrow.png"), 5, 5, 1, 1, true));

    }

    public EventHandler<Event> buildButtonUp() {
        return new EventHandler<Event>() {
            @Override
            public void handle(Event e) {
                if (indiceY + 1 < gameInstance.nbCasesLignes && !gameInstance.isAWall(indiceY + 1, indiceX)) {
                    indiceY = indiceY + 1;
                    mouse.setY(gameInstance.positionY(indiceY));
                }
            }
        };
    }

    public EventHandler<Event> buildButtonDownEvent() {
        return new EventHandler<Event>() {
            @Override
            public void handle(Event e) {
                if (indiceY - 1 >= 0 && !gameInstance.isAWall(indiceY - 1, indiceX)) {
                    indiceY = indiceY - 1;
                    mouse.setY(gameInstance.positionY(indiceY));
                }
            }
        };
    }

    public EventHandler<Event> buildButtonRightEvent() {
        return new EventHandler<Event>() {
            @Override
            public void handle(Event e) {
                if (indiceX + 1 < gameInstance.nbCasesColonne && !gameInstance.isAWall(indiceY, indiceX + 1)) {
                    indiceX = indiceX + 1;
                    mouse.setX(gameInstance.positionX(indiceX));
                }
            }
        };
    }

    public EventHandler<Event> buildButtonLeftEvent() {
        return new EventHandler<Event>() {
            @Override
            public void handle(Event e) {
                if (indiceX - 1 >= 0 && !gameInstance.isAWall(indiceY, indiceX - 1)) {
                    indiceX = indiceX - 1;
                    mouse.setX(gameInstance.positionX(indiceX));
                }
            }
        };
    }

}