CREATE TABLE pull_request (
    id VARCHAR2(36) PRIMARY KEY,
    title VARCHAR2(255),
    description CLOB,
    status VARCHAR2(50),
    created_at TIMESTAMP
);

CREATE TABLE pull_request_file (
    id VARCHAR2(36) PRIMARY KEY,
    pr_id VARCHAR2(36),
    file_name VARCHAR2(255),
    old_content CLOB,
    new_content CLOB
);

CREATE TABLE review (
    id VARCHAR2(36) PRIMARY KEY,
    pr_id VARCHAR2(36),
    reviewer_id VARCHAR2(36),
    status VARCHAR2(50),
    comment CLOB,
    created_at TIMESTAMP
);

CREATE TABLE review_comment (
    id VARCHAR2(36) PRIMARY KEY,
    review_id VARCHAR2(36),
    file_id VARCHAR2(36),
    line_number NUMBER,
    comment CLOB
);