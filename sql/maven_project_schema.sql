-- maven_project 데이터베이스 생성
CREATE DATABASE maven_project CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- 생성된 데이터베이스 사용
USE maven_project;

-- 회원(member) 테이블 생성
CREATE TABLE member (
    member_no INT AUTO_INCREMENT PRIMARY KEY,
    member_id VARCHAR(50),
    member_pw VARCHAR(100)
);

-- 회원(member) 테이블 데이터 삽입
INSERT INTO member (member_id, member_pw)
VALUES ("asdf", "asdf1234");

-- 회원(member) 테이블 데이터 모두 삭제
delete from member;
truncate member;

-- 게시판(board) 테이블 생성
CREATE TABLE board (
	board_no INT AUTO_INCREMENT PRIMARY KEY,
  board_title VARCHAR(100) NOT NULL,
  board_content TEXT,
  board_writer INT NOT NULL,
  reg_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  mod_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 첨부파일(attach) 테이블 생성
CREATE TABLE attach (
  attach_no INT AUTO_INCREMENT PRIMARY KEY,
  board_no INT NOT NULL,                         
  ori_name VARCHAR(255) NOT NULL,           
  re_name VARCHAR(255) NOT NULL,             
  reg_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- insert
INSERT INTO board (board_title, board_content, board_writer) 
VALUES ('1', '테스트 게시글1', 1);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('1', '테스트 게시글1', 1);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('2', '테스트 게시글2', 2);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('3', '테스트 게시글3', 3);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('4', '테스트 게시글4', 4);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('5', '테스트 게시글5', 5);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('6', '테스트 게시글6', 1);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('7', '테스트 게시글7', 2);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('8', '테스트 게시글8', 3);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('9', '테스트 게시글9', 4);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('10', '테스트 게시글10', 5);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('11', '테스트 게시글11', 1);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('12', '테스트 게시글12', 2);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('13', '테스트 게시글13', 3);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('14', '테스트 게시글14', 4);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('15', '테스트 게시글15', 5);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('16', '테스트 게시글16', 1);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('17', '테스트 게시글17', 2);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('18', '테스트 게시글18', 3);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('19', '테스트 게시글19', 4);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('20', '테스트 게시글20', 5);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('21', '테스트 게시글21', 1);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('22', '테스트 게시글22', 2);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('23', '테스트 게시글23', 3);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('24', '테스트 게시글24', 4);
INSERT INTO board (board_title, board_content, board_writer) VALUES ('25', '테스트 게시글25', 5);


