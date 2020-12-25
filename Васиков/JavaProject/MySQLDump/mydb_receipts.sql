-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `receipts`
--

DROP TABLE IF EXISTS `receipts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receipts` (
  `ID` int unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Ingredients` varchar(1000) DEFAULT NULL,
  `Author` varchar(45) DEFAULT NULL,
  `Size` varchar(45) DEFAULT NULL,
  `Category` varchar(45) DEFAULT NULL,
  `Algorythm` varchar(1000) DEFAULT NULL,
  `PicturePath` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipts`
--

LOCK TABLES `receipts` WRITE;
/*!40000 ALTER TABLE `receipts` DISABLE KEYS */;
INSERT INTO `receipts` VALUES (0,'Картофельное пюре','Картофель - 1 кг, Сливочное масло - 30 г, Соль - по вкусу, Вода - 1 л.','Ivan','1 кг ','Гарниры','Очищенный картофель кладём в кастрюлю и заливаем водой, так, чтобы картошка была покрыта ею. Даём воде закипеть. Солим по вкусу и варим картофель 25-30 минут. Сливаем с картофеля воду. НО не выливаем жидкость в умывальник, она нам еще пригодится. Кладем к картофелю кусочек сливочного масла.Берем погружной блендер или толкушку и разминаем картофель сначала без жидкости. Затем по необходимости подливаем воду (в которой варился картофель), доводя наше пюре до желаемой консистенции. Вот и всё! ','src/pictures/potato.jpg'),(1,'Крабовый салат','Крабовые палочки - 300 г, Рис отварной - 300 г, Кукуруза консервированная - 250 г, яйца - 4 шт, огурцы, майонез - 100 г, соль - по вкусу','Ivan','800 г','Салаты','Варим заранее рис. Первым делом ставим отвариваться яйца. Минут 10-12 пусть варятся, желток схватится за это время. Режем огурцы и складируем их вместе с кукурузой (только зёрна, без «воды»!) и рисом в миску средних размеров. Нарезаем отваренные яйца (для салата я варю 12-15 минут) и добавляем их к остальным ингредиентам. Аккуратно перемешиваем. Солим по вкусу, заправляем майонезом и убираем в холодильник как минимум на 1 час, салат должен настояться. И вот, салат с крабовыми палочками готов. Приятного аппетита! ','src/pictures/crab_salad.jpg'),(2,'Оливье','3 картофелины среднего размера, 3-4 моркови, 4-5 яиц, 350 г ветчины или докторской колбасы, 450 г консервированного зеленого горошка, 5-6 соленых огурцов, 5 побегов зеленого лука, 1 пучок укропа, 250 г майонеза, соль, черный молотый перец','Ivan','500 г','Салаты','Картофель и морковь вымойте щеткой и отварите в подсоленной воде до готовности. Яйца отварите отдельно, не допуская переваривания желтка. Очистите и нарежьте кубиками со стороной 5 мм. Такими же кубиками нарежьте ветчину. Затем смешайте все ингредиенты в салатнике, добавьте мелко нарезанный зеленый лук и укроп. Приправьте черным перцем, заправьте майонезом и поставьте в холодильник. Если соленые огурцы с крупными семенами - удалите их. Затем нарежьте кубиками такого же размера. Сложите в отдельный контейнер. Слейте жидкость с горошка, горошек переложите в отдельный контейнер. Перед подачей на стол добавьте в салат соленые огурцы и зеленый горошек. Еще раз перемешайте салат, попробуйте и при необходимости добавьте соль и черный перец.  ','src/pictures/olivie.jpg'),(3,'Компот','Замороженные ягоды - 500 г, Вода - 2 л, Сахар - 1 стакан','Ivan','10 порций','Напитки','В кастрюлю объемом 5 литров (можно меньше) вливаем воду и добавляем сахар. Доводим до кипения. Замороженные ягоды отправляем в кипящую воду и снова ждем, пока вода закипит и уменьшаем огонь. Варим компот на маленькой температуре около 5 минут, после чего закрываем крышкой и оставляем в стороне на 30 минут.Остужаем, при желании можно процедить.','src/pictures/kompot.jpg'),(4,'Салат \"Цезарь\" традиционный','Зеленый салат - 1 пучок, Помидоры - 1 шт, Куриное филе - 300 г, белый хлеб - 6 кусков, Соус \"Цезарь\" по вкусу, Сливочное масло - 2 ст.л., чеснок - 2 зубчика, Сыр пармезан -  по вкусу.','Ivan','4 порции','Салаты','Промыть, просушить и нарвать на небольшие кусочки листья салата, отложить в холодильник. В горячую сковородку положить 1 столовую ложку сливочного масла. После того, как оно полностью расплавится и начнет шипеть, кинуть нарезанный на пластины зубчик чеснока. Куриную грудку нарезать на кусочки приблизительно 1х3 см. Положить в сковороду к чесноку и маслу. Обжаривать на сильном огне приблизительно 10 минут до румяной корочки. Снять с огня. В ту же сковородку добавить еще одну столовую ложку сливочного масла и второй зубчик чеснока. В это время нарезать на небольшие кубики хлеб. Положить в сковороду и обжаривать до румяной корочки. Желательно непрерывно помешивать, чтобы не подгорело. Достать листья салата, туда же положить обжаренную куриную грудку, помидоры, нарезанные тонкой соломкой. Заправить соусом «Цезарь». Перемешать. Сверху положить получившиеся сухарики и натереть сыр.','src/pictures/cesar.jpg');
/*!40000 ALTER TABLE `receipts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-25 20:53:38
