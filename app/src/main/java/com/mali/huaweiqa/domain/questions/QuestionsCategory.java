package com.mali.huaweiqa.domain.questions;

import java.util.ArrayList;

/**
 * It holds a list of questions specific to a single category.
 */

public class QuestionsCategory {

    private String categoryTitle;
    private ArrayList<Question> categoryQuestions;

    public QuestionsCategory(){}
    public QuestionsCategory(String categoryTitle) {
        this.categoryTitle = categoryTitle;
        this.categoryQuestions = new ArrayList<>();
    }

    public QuestionsCategory(String categoryTitle, ArrayList<Question> categoryQuestions) {
        this.categoryTitle = categoryTitle;
        this.categoryQuestions = categoryQuestions;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public ArrayList<Question> getCategoryQuestions() {
        return categoryQuestions;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public void addQuestion(Question question){
        this.getCategoryQuestions().add(question);
    }
}
