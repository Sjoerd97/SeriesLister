package com.example.serieslister.domain;

public class Series {

    private String title;
    private float score;
    private byte[] image;
    private String description;

    private Series(Series.Builder builder) {
         this.title = builder.title;
         this.description = builder.description;
         this.score = builder.score;
         this.image = builder.image;
    }

    public String getTitle() {
        return title;
    }

    public float getScore() {
        return score;
    }

    public byte[] getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder {

        private String title;
        private float score;
        private byte[] image;
        private String description;

        public Builder() {
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder score(float score) {
            this.score = score;
            return this;
        }

        public Builder image(byte[] image) {
            this.image = image;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Series build(){
            return new Series(this);
        }

    }

}
