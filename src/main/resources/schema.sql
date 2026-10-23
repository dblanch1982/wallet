CREATE TABLE IF NOT EXISTS `wallet` (
  `wallet_id` int AUTO_INCREMENT  PRIMARY KEY,
  `name` varchar2(100) NOT NULL,
  `description` varchar(500),
  `created_at` date NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `updated_at` date DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL
);

