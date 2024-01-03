package basic_board;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ContentController {

	private final ContentService contentService;
	private final FileStore fileStore;

	@RequestMapping("")
	public String home(Model model) {
		model.addAttribute("contents", contentService.getAllContents());
		return "home";
	}

	@GetMapping("/")
	public String redirectHome() {
		return "redirect:/basic_board";
	}

	@GetMapping("/content/write")
	public String writePage() {
		return "write-page";
	}

	@PostMapping("/content/write")
	public String writeContent(ContentForm form) throws IOException {
		Content content = new Content();
		content.setTitle(form.getTitle());
		content.setWriter(form.getWriter());
		content.setTexts(form.getTexts());

		LocalDateTime NowTime = LocalDateTime.now();
		String formatDate = NowTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		content.setUpdateDate(formatDate);

		UploadFile attachFile = fileStore.storeFile(form.getAttachFile());
		List<UploadFile> imageFiles = fileStore.storeFiles(form.getImageFiles());
		content.setAttachFile(attachFile);
		content.setImageFiles(imageFiles);

		contentService.writeContent(content);

		return "redirect:/basic_board";
	}

	@GetMapping("/content/{id}")
	public String showContent(@PathVariable int id, Model model) {
		model.addAttribute("content", contentService.getContent(id));
		return "basic_board/content-page";
	}

	@PostMapping("/content/{id}")
	public String editContent(@PathVariable int id, Content content) {
		contentService.editContent(id, content.getTexts(), content.getPassword());
		return "redirect:/basic_board";
	}

	@PostMapping("/content/delete/{id}")
	public String deleteContent(@PathVariable int id, Content content) {
		contentService.deleteContent(id, content.getPassword());
		return "redirect:/basic_board";
	}

}