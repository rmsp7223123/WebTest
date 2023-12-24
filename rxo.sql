
CREATE TABLE members (
    user_id NVARCHAR2(255) NOT NULL PRIMARY KEY,
    username NVARCHAR2(255) NOT NULL UNIQUE,
    user_password NVARCHAR2(255) NOT NULL
);

select * from members;

CREATE INDEX idx_username ON members(username);

CREATE TABLE board (
    board_id INT PRIMARY KEY,
    board_title NVARCHAR2(255) NOT NULL,
    board_content NVARCHAR2(2000),
    board_visible CHAR(1) DEFAULT 'N' NOT NULL,
    board_writer NVARCHAR2(255) NOT NULL,
    FOREIGN KEY (board_writer) REFERENCES members(username) ON DELETE CASCADE
)

select * from board;

CREATE TABLE attachments (
    attachment_id INT PRIMARY KEY,
    board_id INT,
    file_path NVARCHAR2(255),
    file_name NVARCHAR2(255),
    FOREIGN KEY (board_id) REFERENCES board(board_id) ON DELETE CASCADE
);


select * from attachments;

CREATE SEQUENCE board_id_seq
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;


CREATE SEQUENCE attachment_id_seq
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;    

COMMIT;


ALTER TABLE members ADD (user_role VARCHAR2(50) DEFAULT 'user' NOT NULL);

select * from members;

CREATE OR REPLACE TRIGGER board_id_trigger
BEFORE INSERT ON board
FOR EACH ROW
BEGIN
    SELECT board_id_seq.NEXTVAL INTO :NEW.board_id FROM DUAL;
    :NEW.board_visible := CASE WHEN :NEW.board_writer = 'admin' THEN 'Y' ELSE 'N' END;
END;
/


CREATE OR REPLACE TRIGGER attachment_id_trigger
BEFORE INSERT ON attachments
FOR EACH ROW
BEGIN
    SELECT attachment_id_seq.NEXTVAL INTO :NEW.attachment_id FROM DUAL;
END;
/

COMMIT;

select * from members;
select * from board;
select * from attachments;
