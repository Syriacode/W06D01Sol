package example.org.test.w06d01sol.restcalls.model;

import example.org.test.w06d01sol.restcalls.model.images.ImageResponse;
import example.org.test.w06d01sol.restcalls.model.images.Item;
import example.org.test.w06d01sol.restcalls.model.images.Media;

public class Images {

    Item item;
    Media media;
    ImageResponse imageResponse;
    public Images(){}

    public Images(Item item, Media media, ImageResponse imageResponse) {
        this.item = item;
        this.media = media;
        this.imageResponse = imageResponse;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public ImageResponse getImageResponse() {
        return imageResponse;
    }

    public void setImageResponse(ImageResponse imageResponse) {
        this.imageResponse = imageResponse;
    }
}
