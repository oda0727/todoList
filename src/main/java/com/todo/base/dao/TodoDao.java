package com.todo.base.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todo.base.entity.TodoEntity;

/*
 * DBとSQLで接続するクラスファイル
*/

@Repository
public class TodoDao {
	@Autowired
	EntityManager em;//

	@SuppressWarnings("unchecked")
	/*　↑
	 * Java 5.0 で総称が取り込まれてから、
	 * Object型から総称型（List<String>など）へのキャストなどは「型の安全性に問題がある（キャストに失敗する可能性がある）」
	 * という理由でコンパイラが未検査キャストの警告を出してきます。
	 * 例えば、 ObjectInputStream#readObject()の呼び出しのように
	 *  Object 型で値を受け取った後、想定したクラスにキャストして使用するというケースが該当します。
	 *  参考記事
	 * https://www.javadrive.jp/start/stringbuilder/index1.html
	*/




	public List<TodoEntity>findAll(){

		/*StringBuilderクラス
		新しいオブジェクトを作る事なく　.append()を使用して文字列追加処理が出来る。
		どの型が引数として指定されても、文字列に変換して追加される
		*/
		StringBuilder findAll = new StringBuilder();

		findAll.append("SELECT TODO_ID,"
						+"TODO_TITLE,"
						+ "COMPLETE_FLAG,"
						+ "DELETE_FLAG,"
						+ "CREATE_TIME,"
						+ "COMPLETE_TIME,"
						+ "PLACE "
						+ "FROM TODO");
		//.createNativeQuery SQLを生成
		List<TodoEntity> taskList = (List<TodoEntity>)em.createNativeQuery(findAll.toString(),TodoEntity.class).getResultList();

		return taskList;
	}


	public TodoEntity findOneTask(int id) {

		TodoEntity task = em.find(TodoEntity.class, id);

		return task;
	}


	public TodoEntity getOne(int id) {

		TodoEntity task = em.find(TodoEntity.class, id);

		return task;
	}

	public void todoInsert(TodoEntity todoEntity) {
		//persistでSQL文なしでDB登録できる
		em.persist(todoEntity);
	}

	public void updateDetails(TodoEntity todoEntity) {

		StringBuilder update = new StringBuilder();

		update.append("UPDATE todo SET"
						+ "todo_title = ?1,"
						+ "todo_date = ?2,"
						+ "todo_time = ?3,"
						+ "todo_place = ?4"
						+ "WHERE "
						+ "todo_id  = ?5");

		em.createNativeQuery(update.toString(), TodoEntity.class)
		.setParameter(1, todoEntity.getTodoTitle())
		.setParameter(3, todoEntity.getCreateTime())
		.setParameter(4, todoEntity.getTodoPlace())
		.setParameter(5, todoEntity.getTodoId())
		.executeUpdate();

	}


	public void todoComplete(int id) {

		StringBuilder task = new StringBuilder();

		task.append("UPDATE todo SET complete_flag = true WHERE todo_id = ?1");

		em.createNativeQuery(task.toString(),TodoEntity.class)
							.setParameter(1, id).executeUpdate();

	}

	public void todoDelete(int id) {

		StringBuilder task = new StringBuilder();

		task.append("UPDATE todo SET delete_flag = true WHERE todo_id = ?1");

		em.createNativeQuery(task.toString(),TodoEntity.class)
							.setParameter(1, id).executeUpdate();

	}

}
