package com.longlian.model;

/**
 * Created by liuhan on 2017-06-01.
 */
public class IMMessage {
    public IMMessage(String type, String fromNick, String fromAvatar, String from, String content, String fileUrl, String text, String attach, String fromClientType, String msgidClient, long msgTimestamp) {
        this.type = type;
        this.fromNick = fromNick;
        this.fromAvatar = fromAvatar;
        this.from = from;
        this.content = content;
        this.fileUrl = fileUrl;
        this.text = text;
        this.attach = attach;
        this.fromClientType = fromClientType;
        this.msgidClient = msgidClient;
        this.msgTimestamp = msgTimestamp;
    }

    private String type ; //收到消息类型
    private String fromNick;//呢称

    public IMMessage() {
    }

    private String fromAvatar;//头像
    private String from; // 账号
    private String content; // 自定义消息内容
    private String fileUrl;//图片、语音消息
    private String text;//文本消息
    private String attach;//通知信息
    private String fromClientType;//来自那个端的消息

    public long getMsgTimestamp() {
        return msgTimestamp;
    }

    public void setMsgTimestamp(long msgTimestamp) {
        this.msgTimestamp = msgTimestamp;
    }

    private String msgidClient;//msgid生成的clientid
    private long msgTimestamp;//发送时间

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getFromClientType() {
        return fromClientType;
    }

    public void setFromClientType(String fromClientType) {
        this.fromClientType = fromClientType;
    }

    public String getMsgidClient() {
        return msgidClient;
    }

    public void setMsgidClient(String msgidClient) {
        this.msgidClient = msgidClient;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFromNick() {
        return fromNick;
    }

    public void setFromNick(String fromNick) {
        this.fromNick = fromNick;
    }

    public String getFromAvatar() {
        return fromAvatar;
    }

    public void setFromAvatar(String fromAvatar) {
        this.fromAvatar = fromAvatar;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
