package com.example.libs.models;

import java.io.Serializable;

public class Content implements Serializable {

    private Data[] data;

    private String message;

    public static class Data implements Serializable
    {
        private String createdAt;

        private String groupName;

        private String imageUrl;

        private String __v;

        private String _id;

        public Data(String createdAt, String groupName, String imageUrl, String __v, String _id, String title, String content, String updatedAt) {
            this.createdAt = createdAt;
            this.groupName = groupName;
            this.imageUrl = imageUrl;
            this.__v = __v;
            this._id = _id;
            this.title = title;
            this.content = content;
            this.updatedAt = updatedAt;
        }

        private String title;

        private String content;

        private String updatedAt;

        public String getCreatedAt ()
        {
            return createdAt;
        }

        public void setCreatedAt (String createdAt)
        {
            this.createdAt = createdAt;
        }

        public String getGroupName ()
        {
            return groupName;
        }

        public void setGroupName (String groupName)
        {
            this.groupName = groupName;
        }

        public String getImageUrl ()
        {
            return imageUrl;
        }

        public void setImageUrl (String imageUrl)
        {
            this.imageUrl = imageUrl;
        }

        public String get__v ()
        {
            return __v;
        }

        public void set__v (String __v)
        {
            this.__v = __v;
        }

        public String get_id ()
        {
            return _id;
        }

        public void set_id (String _id)
        {
            this._id = _id;
        }

        public String getTitle ()
        {
            return title;
        }

        public void setTitle (String title)
        {
            this.title = title;
        }

        public String getContent ()
        {
            return content;
        }

        public void setContent (String content)
        {
            this.content = content;
        }

        public String getUpdatedAt ()
        {
            return updatedAt;
        }

        public void setUpdatedAt (String updatedAt)
        {
            this.updatedAt = updatedAt;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [createdAt = "+createdAt+", groupName = "+groupName+", imageUrl = "+imageUrl+", __v = "+__v+", _id = "+_id+", title = "+title+", content = "+content+", updatedAt = "+updatedAt+"]";
        }
    }


    public Data[] getData ()
    {
        return data;
    }

    public void setData (Data[] data)
    {
        this.data = data;
    }

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+", message = "+message+"]";
    }
}
