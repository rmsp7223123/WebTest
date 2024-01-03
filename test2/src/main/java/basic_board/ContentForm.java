package basic_board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ContentForm {
	private int id;
	private String title;
	private String texts;

	private String writer;
	private String password;

	private String updateDate;

	private MultipartFile attachFile;
	private List<MultipartFile> imageFiles;
}
