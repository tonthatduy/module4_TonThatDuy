package com.example.cau_hinh_hom_thu_dien_tu.model;

public class Email {
    private int id;
    private String language;
    private int pageSize;
    private boolean spamFiler;
    private String signature;

    public Email() {
    }

    public Email(String language, int pageSize, boolean isSpamFilter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spamFiler = isSpamFilter;
        this.signature = signature;
    }

    public Email(int id, String language, int pageSize, boolean spamFiler, String signature) {
        this.id = id;
        this.language = language;
        this.pageSize = pageSize;
        this.spamFiler = spamFiler;
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean getSpamFiler() {
        return spamFiler;
    }

    public void setSpamFiler(boolean spamFiler) {
        this.spamFiler = spamFiler;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
