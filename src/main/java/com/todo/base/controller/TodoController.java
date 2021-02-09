package com.todo.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todo.base.URL;
import com.todo.base.entity.TodoEntity;
import com.todo.base.form.TodoForm;
import com.todo.base.service.TodoService;

@Controller
@RequestMapping(URL.TODO)
public class TodoController {

	@Autowired
	TodoService todoService;

	//ホーム
	@GetMapping(URL.LIST)

	public String displayList(Model model, TodoForm todoForm) {

		//DBからデータ探してくる
		List<TodoEntity> todoList = todoService.searchAll();

		model.addAttribute("todoLists", todoList);

		//タイトル追加
		model.addAttribute("title", "todoList");

		//http://localhost:8080/todo/list
		return URL.TODO + URL.LIST;

	}

	/*
			//作成押下時
			@PostMapping(URL.CREATE)
			public String complete( @Validated TodoForm todoForm,
					Model model) {

				//エンティティのインスタンス作成
				TodoEntity todoEntity = new TodoEntity();

				//エンティティにタイトルを渡す
				todoEntity.setTodoTitle(todoForm.getTodoTitle());

				//日付を入れる（今の）
				//taskEntity.setTodo_date(taskEntity.getTodo_date());

				//DBへインサートする
				todoService.todoInsert(todoEntity);


				model.addAttribute("title", "toDoList");


				 //http://localhost:8080/todo/list
				//return URL.TODO + URL.LIST;
				return "redirect:/todo/list";

			}


			 * 詳細画面へ遷移
			 * データを一件取得する処理
			 * データベースにはtodo_idをformから受け取り条件式Whereで絞り込む
			 *
			@GetMapping(URL.DETAILS)
			public String displayDtl(TodoForm todoForm, Model model) {

				//決まったデータ表示
				TodoEntity oneTask = todoService.getOne(todoForm.getTodoId());

				//タイトル
				model.addAttribute("title","My Task");

				//Entityを渡す
				model.addAttribute("oneTask", oneTask);

				//詳細画面へ
				return URL.TODO + URL.DETAILS;


			}

			*//**
				* 詳細画面からホームに戻ったときの処理
				* @param Formに入っているものを保持
				* @param model　titleを渡す
				* @return list画面
				*//*

					@PostMapping(URL.LIST)
					public String taskUpdate(@Validated TodoForm todoForm, Model model) {

					//updateするため
					//DBへ渡すEntitiy
					TodoEntity updateEntity = new TodoEntity();

					//idを入れる
					updateEntity.setTodoId(todoForm.getTodoId());

					//タイトルを更新＝入れる
					updateEntity.setTodoTitle(todoForm.getTodoTitle());

					//場所を更新＝入れる
					updateEntity.setTodoPlace(todoForm.getTodoPlace());





					 try {
					String stDate ="2020/10/14 01:23:34";
					SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd E HH:mm:ss");
					System.out.println("koko");
					System.out.println(todoForm.getTodoDate());
					Date dates = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").parse(todoForm.getTodoDate()); //StringからDateへ

					//Date dates = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").parse(stDate); //StringからDateへ
					updateEntity.setTodoDate(dates);
					System.out.println(dates);
					 }catch(ParseException ex){
					 	ex.printStackTrace();
					 }


					//データを更新する
					taskAcsServ.taskUpdatek(updateEntity); //落ちる。。。。。。。。。。。。。。。


					//全データを取得してくる
					//DBからデータ探してくる
					 List<taskEntity> todolists =taskAcsServ.searchAll();

					model.addAttribute("todolists",todolists);

					//タイトル追加
					model.addAttribute("title", "toDoList");

					//http://localhost:8080/todo/list
					//return URL.TODO + URL.LIST;
					return "redirect:/todo/list";
					}

					*/
}
