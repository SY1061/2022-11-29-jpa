drop table if exists Users;

CREATE TABLE IF NOT EXISTS `Users`(
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
);

merge into `Users` key(`id`) values ( 1,  'sunny', '1234');
merge into `Users` key(`id`) values ( 2,  'sun', '1');
merge into `Users` key(`id`) values ( 3,  'young', '5678');

create table IF NOT EXISTS `Posts`(
    `id` BIGINT NOT NULL auto_increment,
    `title` varchar(50) NOT NULL,
    `user_id` INT NOT NULL,
    `modify_id` INT null,
    `content` varchar(200) NOT NULL,
    `comment_count` INT NULL,
    `created_at` Datetime NOT NULL DEFAULT NOW(),
    `modify_at` Datetime,
    PRIMARY KEY(`id`)
);

MERGE INTO `Posts` KEY (`id`) VALUES (1, 'test1', 1, NULL, 'test1', 0, '2022-11-29 10:30:00', NULL);
MERGE INTO `Posts` KEY (`id`) VALUES (2, 'test2', 2, NULL, 'test2', 0, '2022-11-26 10:30:00', NULL);
MERGE INTO `Posts` KEY (`id`) VALUES (3, 'test3', 3, NULL, 'test3', 0, '2022-11-20 10:30:00', NULL);
MERGE INTO `Posts` KEY (`id`) VALUES (4, 'test4', 1, NULL, 'test4', 0, '2022-11-15 10:30:00', NULL);
MERGE INTO `Posts` KEY (`id`) VALUES (5, 'test5', 1, NULL, 'test5', 0, '2022-10-17 10:30:00', NULL);
MERGE INTO `Posts` KEY (`id`) VALUES (6, 'test6', 2, NULL, 'test6', 0, '2022-09-29 10:30:00', NULL);
MERGE INTO `Posts` KEY (`id`) VALUES (7, 'test7', 3, NULL, 'test7', 0, '2022-09-06 10:30:00', NULL);
MERGE INTO `Posts` KEY (`id`) VALUES (8, 'test8', 3, NULL, 'test8', 0, '2022-08-01 10:30:00', NULL);
MERGE INTO `Posts` KEY (`id`) VALUES (9, 'test9', 3, NULL, 'test9', 0, '2022-06-29 10:30:00', NULL);
MERGE INTO `Posts` KEY (`id`) VALUES (10, 'test10', 1, NULL, 'test10', 0, '2022-01-29 10:30:00', NULL);

create table IF NOT EXISTS `Comments`(
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `post_id` INT NOT NULL,
    `content` varchar(100) NOT NULL,
    `created_at` Datetime NOT NULL default now(),
    `parent_id` INT NULL,
    PRIMARY KEY (`id`)
);

merge into `Comments` key(`id`) values ( 1, 3, 1, '댓글 너무 좋습니다', '2022-09-06 10:30:00', null);
merge into `Comments` key(`id`) values ( 2, 2, 6, '댓글4', '2022-09-07 10:40:00', null);
merge into `Comments` key(`id`) values ( 3, 1, 5, '댓글3', '2022-09-08 10:50:00', null);
merge into `Comments` key(`id`) values ( 4, 1, 2, '댓글테스트', '2022-09-09 10:00:00', null);
merge into `Comments` key(`id`) values ( 5, 2, 10, '집가고싶다', '2022-09-10 17:20:00', null);

create table if not exists `Likes`(
    `user_id` INT NOT NULL,
    `post_id` INT NOT NULL,
    `like_count` INT NULL,
    primary key (`user_id`, `post_id`)
);

merge into `Likes` key(`user_id`, `post_id`) values (1, 4, 1);
merge into `Likes` key(`user_id`, `post_id`) values (1, 6, 1);


