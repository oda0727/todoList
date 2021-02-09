package com.todo.base.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.base.dao.TodoDao;
import com.todo.base.entity.TodoEntity;

	/*
		登録・更新・完了・削除　のビジネスロジック
	*/
@Service
@Transactional
public class TodoService {

	@Autowired
	TodoDao todoDao;

	public List<TodoEntity> searchAll() {
        return todoDao.findAll();
    }


	/*
	public void todoInsert(TodoEntity todoEntity) {
		todoDao.todoInsert(todoEntity);
	}

	public void updateDetails(TodoEntity updateTodoEntity) {
		todoDao.updateDetails(updateTodoEntity);
	}

	public void createTask(TodoEntity todoEntity) {
		todoDao.todoInsert(todoEntity);
	 }

	public TodoEntity getOne(int id) {
		return todoDao.getOne(id);

	 }
	public void todoComplete(int id) {
		todoDao.todoComplete(id);
	}

	public void todoDelete(int id) {

		todoDao.todoDelete(id);
	}
	*/

}
