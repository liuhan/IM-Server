package com.longlian.model;

/**
 *
 * tablename:user
 */
public class User {
    /**
     *
     * field:id  column:id
     * 
     */
    private java.lang.Long id;

    /**
     *
     * field:name  column:name
     * 
     */
    private String name;

    /**
     *
     * field:token  column:token
     * 
     */
    private String token;

    /**
     *
     * field:icon  column:icon
     * 
     */
    private String icon;

    /**
     *
     * field:uuid  column:uuid
     * 
     */
    private String uuid;

    public java.lang.Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }
}