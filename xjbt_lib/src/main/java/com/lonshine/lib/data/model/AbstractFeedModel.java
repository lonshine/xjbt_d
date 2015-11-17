package com.lonshine.lib.data.model;

/**
 * 实现 通用函数
 */
public abstract class AbstractFeedModel implements FeedModel {



//    public String getCoverImageUrl() {
//        Image cover = getCoverImage();
//        if (cover == null) return null;
//        return cover.url;
//    }

//    @Override
//    public Image getCoverImage() {
//        Image cover = getCoverImageFromVideos();
//        if (cover == null) {
//            cover = getCoverImageFromImages();
//        }
//        return cover;
//    }
//    private Image getCoverImageFromImages() {
//        List<Image> images = images();
//        if (images == null || images.isEmpty()) {
//            return null;
//        }
//        return images.get(0);
//    }
//    private Image getCoverImageFromVideos() {
//        List<Video> videos = videos();
//        if (videos == null || videos.isEmpty()) return null;
//
//        Video video = videos.get(0);
//        if (video.images == null || video.images.isEmpty()) return null;
//
//        return video.images.get(0);
//    }
}
