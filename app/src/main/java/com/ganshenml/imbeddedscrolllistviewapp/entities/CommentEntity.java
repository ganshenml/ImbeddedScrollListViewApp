package com.ganshenml.imbeddedscrolllistviewapp.entities;

import java.io.Serializable;

public class CommentEntity implements Serializable {
    private String CommentID;
    private String NickName;
    private String Avatar;
    private String Content;
    private String PostDate;
    private String ConvetDate;


    public CommentEntity(String CommentID, String NickName, String Avatar, String Content, String PostDate, String ConvetDate) {
        this.CommentID = CommentID;
        this.NickName = NickName;
        this.Avatar = Avatar;
        this.Content = Content;
        this.PostDate = PostDate;
        this.ConvetDate = ConvetDate;

    }

    public String getCommentID() {
        return CommentID;
    }

    public void setCommentID(String commentID) {
        CommentID = commentID;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getPostDate() {
        return PostDate;
    }

    public void setPostDate(String postDate) {
        PostDate = postDate;
    }

    public String getConvetDate() {
        return ConvetDate;
    }

    public void setConvetDate(String convetDate) {
        ConvetDate = convetDate;
    }
}
