package com.mohammed.todo_mohammed.model;


import javax.persistence.*;

@Entity
@Table(name="Todo")
public class Todo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long item_id;

    private String item_content;

    public boolean isImportant() {
        if (item_content.length() > 20 && item_content.contains("study"))
            return true;

        return false;
    }
    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public String getItem_content() {
        return item_content;
    }

    public void setItem_content(String item_content) {
        this.item_content = item_content;
    }
}
