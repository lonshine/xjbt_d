package com.lonshine.lib.data.model;

import java.io.Serializable;

public interface FeedModel extends Serializable {

    long id();

    String title();

//    Image getCoverImage();

    String tutorialId();

//    User user();

//    List<Video> videos();

//    List<Image> images();

    String viewCount();

    String commentCount();

    long createdTime();

    boolean isDeleted(); //是否已被删除。
}