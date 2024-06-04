package com.mylog.app;

public class Notification {
    private String type; // 알림의 유형 (댓글 알림, 팔로우 알림)

    // 알림 유형 상수
    public static final String COMMENT_NOTIFICATION = "comment";
    public static final String FOLLOW_NOTIFICATION = "follow";

    // 기본 생성자
    public Notification() {
    }

    // 매개변수 있는 생성자
    public Notification(String type, String message) {
        this.type = type;
    }

    // 유형을 가져오는 getter 메서드
    public String getType() {
        return type;
    }

    // 유형을 설정하는 setter 메서드
    public void setType(String type) {
        this.type = type;
    }

    // 댓글 알림 메시지를 생성하는 메서드
    public static Notification createCommentNotification(String commentMessage) {
        return new Notification(COMMENT_NOTIFICATION, "새로운 댓글: " + commentMessage);
    }

    // 팔로우 알림 메시지를 생성하는 메서드
    public static Notification createFollowNotification(String followerName) {
        return new Notification(FOLLOW_NOTIFICATION, followerName + "님이 당신을 팔로우했습니다.");
    }
}