package rxo.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO {
	int boardId;
	String boardTitle, boardContent, boardVisible, boardWriter;
}
