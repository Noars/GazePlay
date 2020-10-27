package net.gazeplay.commons.utils.games;

import javafx.scene.image.Image;
import net.gazeplay.commons.random.ReplayablePseudoRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import java.util.Set;

@ExtendWith(ApplicationExtension.class)
class ResourceImageLibraryTest {

    @Test
    void shouldGetTheCorrectCountOfFiles() {
        ResourceImageLibrary resourceImageLibrary = new ResourceImageLibrary("data/common", new ReplayablePseudoRandom());
        assert resourceImageLibrary.getImagesCount() == 2;
    }

    @Test
    void shouldLoadTheImageAtAnIndex() {
        ResourceImageLibrary resourceImageLibrary = new ResourceImageLibrary("data/common", new ReplayablePseudoRandom());
        for (int i = 0; i < resourceImageLibrary.getImagesCount(); i++) {
            Image testImage = resourceImageLibrary.loadImageAtIndex(i);
            assert testImage != null;
        }
    }

    @Test
    void shouldGetMultipleRandomDistinctImages() {
        ResourceImageLibrary fallbackImageLibrary = new ResourceImageLibrary("data/biboule", new ReplayablePseudoRandom());
        ResourceImageLibrary resourceImageLibrary = new ResourceImageLibrary("data/common", fallbackImageLibrary, new ReplayablePseudoRandom());
        Set<Image> randomDistinctImages = resourceImageLibrary.pickMultipleRandomDistinctImages(2);
        assert randomDistinctImages.size() == 2;
        assert !randomDistinctImages.contains(null);
    }

    @Test
    void shouldPickRandomImage() {
        ResourceImageLibrary fallbackImageLibrary = new ResourceImageLibrary("data/biboule", new ReplayablePseudoRandom());
        ResourceImageLibrary resourceImageLibrary = new ResourceImageLibrary("data/common", fallbackImageLibrary, new ReplayablePseudoRandom());
        Image randomImage = resourceImageLibrary.pickRandomImage();
        assert randomImage != null;
        assert randomImage.getUrl().contains("data");
    }
}
