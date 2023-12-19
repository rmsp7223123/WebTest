package rxo.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttachmentVO {
	int attachmentId, boardId;
	String filePath;
}
