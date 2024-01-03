package basic_board;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContentService {

	private final ContentRepository contentRepository;

	public void writeContent(Content content) {
		contentRepository.save(content);
	}

	public void editContent(int id, String texts, String password) {
		Content content = contentRepository.findById(id);
		if (!content.getPassword().equals(password)) {
			return;
		}

		content.setTexts(texts);

		LocalDateTime now = LocalDateTime.now();
		String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		content.setUpdateDate(formattedDate);

		contentRepository.edit(id, content);
	}

	public void deleteContent(int id, String password) {
		Content content = contentRepository.findById(id);
		if (!content.getPassword().equals(password)) {
			return;
		}
		contentRepository.delete(id);
	}

	public List<Content> getAllContents() {
		return contentRepository.findAll();
	}

	public Content getContent(int id) {
		return contentRepository.findById(id);
	}

	public void deleteAllContent() {
		contentRepository.deleteAll();
	}

}
