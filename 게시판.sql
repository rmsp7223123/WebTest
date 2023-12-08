-- 회원 테이블 생성
CREATE TABLE members (
    user_id INT PRIMARY KEY,
    username NVARCHAR2(255) NOT NULL,
    password NVARCHAR2(255) NOT NULL
);

-- 게시판 테이블 생성
CREATE TABLE boards (
    board_id INT PRIMARY KEY,
    board_title NVARCHAR2(255) NOT NULL,
    board_content NVARCHAR2(3000),
    board_visible BOOLEAN,
    board_writer INT,
    FOREIGN KEY (board_writer) REFERENCES members(user_id) ON DELETE CASCADE
);

-- 첨부 파일 테이블
CREATE TABLE attachments (
    attachment_id INT PRIMARY KEY,
    board_id INT,
    file_path NVARCHAR2(255),
    FOREIGN KEY (board_id) REFERENCES boards(board_id) ON DELETE CASCADE
);