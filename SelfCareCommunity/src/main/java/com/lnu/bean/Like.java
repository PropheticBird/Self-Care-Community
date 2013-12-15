package com.lnu.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: igor
 * Date: 12/15/13
 */
@Entity
@Table(name = "LIKES_TO_USERS")
public class Like {

    public static Like newLike(Long userId, Long postId){
        Like result = new Like();
        LikeId id = new LikeId();
        id.setPostID(postId);
        id.setUserID(userId);
        result.setId(id);
        return result;
    }

    @EmbeddedId
    private LikeId id;

    public LikeId getId() {
        return id;
    }

    public void setId(LikeId id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Like)) return false;

        Like like = (Like) o;

        if (id != null ? !id.getPostID().equals(like.id.getPostID()) : like.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.getPostID().hashCode() : 0;
    }

    @Embeddable
    public static class LikeId implements Serializable {
        @Column(name = "Person_ID")
        private Long userID;

        @Column(name = "Post_ID")
        private Long postID;

        public Long getUserID() {
            return userID;
        }

        public void setUserID(Long userID) {
            this.userID = userID;
        }

        public Long getPostID() {
            return postID;
        }

        public void setPostID(Long postID) {
            this.postID = postID;
        }
    }
}
