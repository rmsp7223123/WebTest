package rxo.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttachmentVO {
	int attachment_Id, board_Id;
	String file_Path;
	public int getAttachment_Id() {
		return attachment_Id;
	}
	public void setAttachment_Id(int attachment_Id) {
		this.attachment_Id = attachment_Id;
	}
	public int getBoard_Id() {
		return board_Id;
	}
	public void setBoard_Id(int board_Id) {
		this.board_Id = board_Id;
	}
	public String getFile_Path() {
		return file_Path;
	}
	public void setFile_Path(String file_Path) {
		this.file_Path = file_Path;
	}
	
	
}
