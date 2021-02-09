package com.todo.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.todo.base.entity.InquiryEntity;
import com.todo.base.form.InquiryForm;
import com.todo.base.service.InquiryContentInsertService;


@Controller
@RequestMapping("/inquiry")
public class InquiryController {
	 @Autowired
	    InquiryContentInsertService inquiryContentService;

	@GetMapping({"/form"})
	public String form(InquiryForm inquiryForm,Model model) {
		model.addAttribute("title","お問い合わせ");
		model.addAttribute("form",inquiryForm);

		return "/inquiry/form";
	}


	@PostMapping({"/form"})
	public String backForm(InquiryForm inquiryForm,Model model) {
		model.addAttribute("title","お問い合わせ");
		model.addAttribute("form",inquiryForm);

		return "/inquiry/form";
	}

	/**
	 * 入力結果検証メソッド
	 * @param result　エラー検証結果
	 * @return　view名（検証成功なら結果画面、失敗なら入力画面）
	 */

	@PostMapping("/confirm")
	public String confirm(@Validated InquiryForm inquiryForm,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("title", "お問い合わせ内容エラー");

			return "inquiry/form";
		}
		model.addAttribute("title", "お問い合わせ内容確認");

		return "/inquiry/confirm";
	}

	/**
	 * /completeにデータが送信されたときの処理
	 * @param inquiryForm　Formの内容をチェックする
	 * @param result　チェック結果にエラーがあるか判定
	 * @param model　titleを渡す
	 * @param redirectAttributes　リダイレクト先のcompleteに値を渡す
	 * @return
	 */
	
	@PostMapping("/complete")
	public String complete(@Validated InquiryForm inquiryForm,BindingResult result, Model model,RedirectAttributes redirectAttributes){

		if(result.hasErrors()) {
			model.addAttribute("title", "お問い合わせ内容エラー");

			return "/inquiry/form";
		}

		// inquiryEntityをインスタンス化、値を入れていく

				InquiryEntity inquiryEntity = new InquiryEntity();

				inquiryEntity.setInquiryType(inquiryForm.getInquiryType());
				inquiryEntity.setInquiryUser(inquiryForm.getInquiryUser());
				inquiryEntity.setInquiryUserMail(inquiryForm.getInquiryUserMail());
				inquiryEntity.setInquiryInfo(inquiryForm.getInquiryInfo());
				// DBへの登録処理
				inquiryContentService.inquiryContentInsert(inquiryEntity);

				redirectAttributes.addFlashAttribute("complete", "送信完了");

		return "redirect:/inquiry/form";

	}

}
