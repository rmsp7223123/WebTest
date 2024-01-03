package basic_board;

import java.util.List;

import lombok.Data;

@Data
public class Content {
	private int id;
    private String title;
    private String texts;

    private String writer;
    private String password;

    private String updateDate;

    private UploadFile attachFile;
    private List<UploadFile> imageFiles;
}
