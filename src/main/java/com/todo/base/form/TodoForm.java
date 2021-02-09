package com.todo.base.form;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.sun.istack.NotNull;

@Component
public class TodoForm {
	/*
	 *ユーザーID
	 *@Size(min = 1,max = 60,message = "お名前を入力してください")
	 */
	@Id //エンティティの主キーを示す

    @Column(name = "{TODO_ID}")
    @NotNull
    private int todoId;

    @Column(name = "{TODO_TITLE}")
    @NotNull
    private String todoTitle;


    @Column(name = "{PLACE}")
    @NotNull
    private String Place;


    @Column(name = "{CREATE_TIME}")
    @NotNull
    private String createTime;

    @Column(name = "{COMPLETE_TIME}")
    @NotNull
    private Time completeTime;

	/**
	 * @return todoId
	 */
	public int getTodoId() {
		return todoId;
	}


    /*
   	 * getter setter メソッド
   	 *
   	 */


	/**
	 * @param todoId セットする todoId
	 */
	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}

	/**
	 * @return todoTitle
	 */
	public String getTodoTitle() {
		return todoTitle;
	}

	/**
	 * @param todoTitle セットする todoTitle
	 */
	public void setTodoTitle(String todoTitle) {
		this.todoTitle = todoTitle;
	}

	/**
	 * @return todoPleace
	 */
	public String getTodoPlace() {
		return Place;
	}

	/**
	 * @param todoPleace セットする todoPleace
	 */
	public void setTodoPlace(String todoPlace) {
		this.Place = todoPlace;
	}


	/**
	 * @return createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime セットする createTime
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return completeTime
	 */
	public Time getCompleteTime() {
		return completeTime;
	}

	/**
	 * @param completeTime セットする completeTime
	 */
	public void setCompleteTime(Time completeTime) {
		this.completeTime = completeTime;
	}


}
