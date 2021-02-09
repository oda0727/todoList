package com.todo.base.entity;


import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="todo")//RDBのtable名を指定

public class TodoEntity {

	@Id //主キーの自動生成(フィールド変数を主キーに)

    @Column(name = "TODO_ID")//フィールドに対応するカラムを指定する
							//割付け先tableでのカラム名の指定
    @NotNull
    private int TodoId;

    @Column(name = "TODO_TITLE")
    @NotNull
    private String TodoTitle;

    @Column(name = "PLACE")
    @NotNull
    private String Place;


    @Column(name = "CREATE_TIME")
    @NotNull
    private Time createTime;

    @Column(name = "COMPLETE_TIME")
    @NotNull
    private Time completeTime;



	/**
	 * @return todoId
	 */
	public int getTodoId() {
		return TodoId;
	}

	/**
	 * @param todoId セットする todoId
	 */
	public void setTodoId(int todoId) {
		TodoId = todoId;
	}

	/**
	 * @return todoTitle
	 */
	public String getTodoTitle() {
		return TodoTitle;
	}

	/**
	 * @param todoTitle セットする todoTitle
	 */
	public void setTodoTitle(String todoTitle) {
		TodoTitle = todoTitle;
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
		Place = todoPlace;
	}



	/**
	 * @return createTime
	 */
	public Time getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime セットする createTime
	 */
	public void setCreateTime(Time createTime) {
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
