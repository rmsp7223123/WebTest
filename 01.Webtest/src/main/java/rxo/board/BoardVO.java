package rxo.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO {
	int board_Id;
	String board_Title, board_Content, board_Visible, board_Writer;
	public int getBoard_Id() {
		return board_Id;
	}
	public void setBoard_Id(int board_Id) {
		this.board_Id = board_Id;
	}
	public String getBoard_Title() {
		return board_Title;
	}
	public void setBoard_Title(String board_Title) {
		this.board_Title = board_Title;
	}
	public String getBoard_Content() {
		return board_Content;
	}
	public void setBoard_Content(String board_Content) {
		this.board_Content = board_Content;
	}
	public String getBoard_Visible() {
		return board_Visible;
	}
	public void setBoard_Visible(String board_Visible) {
		this.board_Visible = board_Visible;
	}
	public String getBoard_Writer() {
		return board_Writer;
	}
	public void setBoard_Writer(String board_Writer) {
		this.board_Writer = board_Writer;
	}
	
	
	
}
