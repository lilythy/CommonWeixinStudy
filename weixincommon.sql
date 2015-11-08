create database weixincommon default character set utf8;  

CREATE TABLE `weixincommon`.`feedback` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(50) default NULL,
  `senddate` varchar(30) default NULL,
  `feedcontent` varchar(300) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



