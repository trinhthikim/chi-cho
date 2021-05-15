-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost:3306
-- Thời gian đã tạo: Th5 08, 2021 lúc 07:58 AM
-- Phiên bản máy phục vụ: 10.3.16-MariaDB
-- Phiên bản PHP: 7.3.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `id16441573_appmusic`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `adv`
--

CREATE TABLE `adv` (
  `id` int(11) NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `content` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `song_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `adv`
--

INSERT INTO `adv` (`id`, `image`, `content`, `song_id`) VALUES
(1, 'http://127.0.0.1:8000/img/YeuDiDungSo.jpg', 'Only C bla bla', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `album`
--

CREATE TABLE `album` (
  `album_id` int(11) NOT NULL,
  `album_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `singer_id` int(11) NOT NULL,
  `album_image_url` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `album`
--

INSERT INTO `album` (`album_id`, `album_name`, `singer_id`, `album_image_url`) VALUES
(1, 'Đếm ngày xa em', 1, 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/0/0/0037fa44fb1ffa4a5ec148a4c14dccdf_1463244937.jpg'),
(2, 'Everyday', 1, 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/f/b/fb33ee2485cb6e482f8f60e5cae1a7fb_1514451464.jpg'),
(3, 'Đừng về trễ', 2, 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/d/3/d3987e294552bfd40eeb770946a8db2d_1375685055.jpg'),
(4, 'Lạc trôi', 2, 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/9/8/98e3677733fe52439823d1b1992d9ae0_1483242323.jpg'),
(5, 'Sky Tour', 2, 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/cover/0/6/0/4/0604b2039e6be2b7c8d4f3243b24594d.jpg'),
(6, 'Nhớ', 3, 'https://photo-playlist-zmp3.zadn.vn/mixartist?src=HavwqN7EvKCI1og5AfZbHm1SAjXgcELRKKigsp6GuWfG7dpOFP3c2GTCB8qubx05KKuir32ItLLTJqFKD97SN5HK69ngdPeEHnDCoY_Qs5WnyiMBI7S3sgizpaZUz1IT_sk83voYQrv-yEMwvBacA7q&size=thumb/240_240'),
(7, 'Tri âm', 3, 'https://musicplay0123456789.000webhostapp.com/img/Album_TriAm.jpg'),
(8, 'Anh cứ đi đi', 4, 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/7/e/7efa1b239a5907a2ea291b1cb4a3e52d_1465209187.jpg'),
(9, 'Yêu không hối hận', 4, 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/3/8/3817d14f631a726d55d2aa5b3bd8e3c8_1476895754.jpg'),
(10, 'Chỉ có thể là đen', 5, 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/cover/f/b/d/1/fbd1aad21670248c7ed9057ad403131c.jpg'),
(11, 'Một triệu like', 5, 'https://t2.genius.com/unsafe/300x300/https%3A%2F%2Fimages.genius.com%2F2a64371f71238a7bcc8c861ed74a2ecc.600x600x1.jpg'),
(12, 'Ngày lang thang', 5, 'https://musicplay0123456789.000webhostapp.com/img/Album_NgayLangThang.jpg'),
(13, 'Chờ', 6, 'https://musicplay0123456789.000webhostapp.com/img/Album_Cho.png'),
(14, 'Ngốc 2', 6, 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/5/6/56449711879e488387c2aeb9c0765a24_1473675774.jpg'),
(15, 'Hoàng', 7, 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/cover/8/c/6/7/8c679f8c2d79bfc1bd7b7d0b7be1f28f.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `banner`
--

CREATE TABLE `banner` (
  `banner_id` int(11) NOT NULL,
  `banner_name` varchar(255) NOT NULL,
  `banner_image_url` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `banner`
--

INSERT INTO `banner` (`banner_id`, `banner_name`, `banner_image_url`) VALUES
(1, 'nhạc hit quốc dân', 'https://photo-zmp3.zadn.vn/banner/b/b/a/3/bba3aa0509af25e96452c2fe3221346e.jpg'),
(2, 'Nhạc V-POP', 'https://photo-zmp3.zadn.vn/banner/7/b/3/c/7b3cc839dd0ba23b59e0a21191d472df.jpg'),
(3, 'Back to 90s', 'https://photo-zmp3.zadn.vn/banner/c/f/5/2/cf52aefdb0007185aeeb7a3e00d7eed6.jpg'),
(4, 'Chỉ có trên zing', 'https://photo-zmp3.zadn.vn/banner/3/e/3/3/3e3302046317c8c42e61568364251d75.jpg'),
(5, 'Rap việt ngày nay', 'https://photo-zmp3.zadn.vn/banner/1/a/8/d/1a8dcaac198185f4aba49d96d87ec1d0.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `banner_song`
--

CREATE TABLE `banner_song` (
  `banner_id` int(11) NOT NULL,
  `song_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `banner_song`
--

INSERT INTO `banner_song` (`banner_id`, `song_id`) VALUES
(1, 1),
(1, 2),
(1, 8),
(2, 3),
(2, 4),
(2, 50),
(3, 30),
(3, 31),
(3, 38),
(4, 40),
(5, 50),
(5, 15),
(5, 35),
(5, 45),
(5, 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL,
  `topic_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `category_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `category_image_url` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`category_id`, `topic_id`, `category_name`, `category_image_url`) VALUES
(1, '2', 'Nhạc phim', 'https://photo-zmp3.zadn.vn/cover/d/c/e/d/dced68be2533e35a4819b3961d267319.jpg'),
(2, '2', 'Ballad', 'https://photo-zmp3.zadn.vn/cover/d/6/2/1/d621f4cf5cecdf0ab58f6c4dfd8536a1.jpg'),
(3, '2', 'R&B', 'https://photo-zmp3.zadn.vn/cover/d/3/4/3/d3436727fdc88ee4abe0de9326a7c8da.jpg'),
(4, '1', 'Remix', 'https://photo-zmp3.zadn.vn/cover/7/a/0/8/7a083801926b8a65fa5531b948dcecbb.jpg'),
(5, '1', 'Hip hop', 'https://photo-zmp3.zadn.vn/cover/5/a/6/c/5a6c404b17b90ae8eeb04b2e20b29b5f.jpg'),
(6, '2', 'Acoustic', 'https://photo-zmp3.zadn.vn/cover/3/4/c/6/34c6f0da5bd296e371c7d816a1361848.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `comment`
--

CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL,
  `song_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `comment_content` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `playlist`
--

CREATE TABLE `playlist` (
  `playlist_id` int(11) NOT NULL,
  `playlist_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `playlist_image_url` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `playlist`
--

INSERT INTO `playlist` (`playlist_id`, `playlist_name`, `playlist_image_url`, `user_id`) VALUES
(1, 'Top 10 Nhạc Trẻ Hay Nhất', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/cover/5/4/e/4/54e47c54df51c2ee17ca391a556b790a.jpg', NULL),
(2, 'Top 10 Nhạc Rap Việt Nam Hay Nhất', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/cover/1/8/8/e/188e45098127c7f75cc4b715bf01bcd6.jpg', NULL),
(3, 'Top 10 Nhạc V-POP Hay Nhất', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/cover/0/d/5/9/0d598be8e9769fd3e9c8f655a84ab876.jpg', NULL),
(4, 'Top 10 POP Âu Mỹ Hay Nhất', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/cover/d/b/c/b/dbcb684ed2319a6333917085312999c9.jpg', NULL),
(5, 'Top 10 Nhạc Trữ Tình Hay Nhất', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/cover/6/1/0/f/610f6b9b6d694034c23e4ef48e4ad7b8.jpg', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `singer`
--

CREATE TABLE `singer` (
  `singer_id` int(11) NOT NULL,
  `singer_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `singer_image_url` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `singer`
--

INSERT INTO `singer` (`singer_id`, `singer_name`, `singer_image_url`) VALUES
(1, 'Only C', 'https://zmp3-static.zadn.vn/skins/zmp3-v6.1/images/artists/v2/onlyc.png'),
(2, 'Sơn Tùng M-TP', 'https://photo-resize-zmp3.zadn.vn/w240_r1x1_jpeg/avatars/4/a/9/1/4a91d506fc7144c7716b9d3166f2c4b6.jpg'),
(3, 'Mỹ Tâm', 'https://photo-resize-zmp3.zadn.vn/w240_r1x1_jpeg/avatars/a/3/a3b8a090fa8e0b4e4ac7d4f028022a87_1460105189.jpg'),
(4, 'Hariwon', 'https://photo-resize-zmp3.zadn.vn/w240_r1x1_jpeg/avatars/d/e/de829e6b64eb6f019c2a91298c4b096e_1512470029.jpg'),
(5, 'Đen Vâu', 'https://photo-resize-zmp3.zadn.vn/w240_r1x1_jpeg/avatars/9/0/2/2/90223f08b220e52a78ac5c0dd739256f.jpg'),
(6, 'Hương Tràm', 'https://zmp3-static.zadn.vn/skins/zmp3-v6.1/images/artists/v2/huong-tram.png'),
(7, 'Hoàng Thùy Linh', 'https://photo-resize-zmp3.zadn.vn/w240_r1x1_jpeg/avatars/d/3/d3c93c670a19d6b3bfd3a6d7a4e2f3e2_1490171053.jpg'),
(8, 'Pháo', 'https://zmp3-static.zadn.vn/skins/zmp3-v6.1/images/artists/v2/phao.png'),
(9, 'Will', 'https://zmp3-static.zadn.vn/skins/zmp3-v6.1/images/artists/v2/will.png'),
(10, 'Wonwy', 'https://zmp3-static.zadn.vn/skins/zmp3-v6.1/images/artists/v2/wowy.png'),
(11, 'Hòa Minzy', 'https://zmp3-static.zadn.vn/skins/zmp3-v6.1/images/artists/v2/hoa-minzy.png'),
(12, 'Jack', 'https://zmp3-static.zadn.vn/skins/zmp3-v6.1/images/artists/v2/jack.png'),
(13, 'Chi Dân', 'https://zmp3-static.zadn.vn/skins/zmp3-v6.1/images/artists/v2/chi-dan.png'),
(14, 'Karik', 'https://zmp3-static.zadn.vn/skins/zmp3-v6.1/images/artists/v2/karik.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `song`
--

CREATE TABLE `song` (
  `song_id` int(11) NOT NULL,
  `album_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `playlist_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `category_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `song_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `song_image_url` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `singer_id` int(11) NOT NULL,
  `song_link` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `song_likes` int(11) NOT NULL,
  `user_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `song`
--

INSERT INTO `song` (`song_id`, `album_id`, `playlist_id`, `category_id`, `song_name`, `song_image_url`, `singer_id`, `song_link`, `song_likes`, `user_id`) VALUES
(1, '', '1', '1', 'Yêu đi đừng sợ', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/9/2/9232c4c99c30f665e9326c8bbbcebc0e_1503053668.jpg', 1, 'https://musicplay0123456789.000webhostapp.com/mp3/Yeu-Di-Dung-So-Yeu-Di-Dung-So-OST-OnlyC.mp3', 0, ''),
(2, '', '1', '1', 'Yêu là Tha Thứ', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/c/c/ccba0ba0430c375e16e95309cd534c09_1492130923.jpg', 1, 'https://musicplay0123456789.000webhostapp.com/mp3/YeuLaThaThuEmChua18.mp3', 0, ''),
(3, '', '', '2', 'I love you', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/7/5/75bb9f0f27f05cf7f686e5b27451e9ca_1415354642.jpg', 1, 'https://musicplay0123456789.000webhostapp.com/mp3/ILoveYou.mp3', 0, ''),
(4, '2', '', '3', 'Anh không đòi quà', 'https://photo-resize-zmp3.zadn.vn/w240_r1x1_jpeg/avatars/e/2/e261116fa70a9b7bfb24ecfa9c446704_1489133544.jpg', 1, 'https://musicplay0123456789.000webhostapp.com/mp3/AnhKhongDoiQua.mp3', 0, ''),
(5, '2', '', '6', 'Gọi tên cô đơn', 'https://photo-resize-zmp3.zadn.vn/w240_r1x1_jpeg/avatars/d/f/df9a9c8b48441d9f8585e6f051306639_1467967872.jpg', 1, 'https://musicplay0123456789.000webhostapp.com/mp3/GoiTenCoDon.mp3', 0, ''),
(6, '2', '', '4', 'Quan trọng là thần thái', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/5/0/508f722997dcc455df487b596f963571_1520916889.jpg', 1, 'https://musicplay0123456789.000webhostapp.com/mp3/QuanTrongLaThanThai.mp3', 0, ''),
(7, '1', '', '3', 'Ngày em đi', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/3/9/392580abd4c714c25fb13e93115dd026_1436172339.jpg', 1, 'https://musicplay0123456789.000webhostapp.com/mp3/NgayEmDi.mp3', 0, ''),
(8, '1', '', '2', 'Vì anh', 'https://photo-playlist-zmp3.zadn.vn/s3/user-playlist?src=HavwqN7EvKCI1oYSFOdq0r5DR9myYV03K5HgWJo6fGbJ23YFEjAcMLLRCDbjqwrO1WapssRN_0yHLYBOQf6k15eKQu0XnUTJ5rWiaJsSiWvKM2oEFeJaNrDRB8qxrkHSLbn_YMo6vG5KMIY0ETRbKmHR5D9fXebG15aUqsgSsXDKLLY1OTUOMWiU3CWncjGT6buPWY', 1, 'https://musicplay0123456789.000webhostapp.com/mp3/ViAnh.mp3', 0, ''),
(9, '1', '', '4', 'Anh đã sai', 'https://photo-resize-zmp3.zadn.vn/w240_r1x1_jpeg/avatars/d/f/df9a9c8b48441d9f8585e6f051306639_1467967872.jpg', 1, 'https://musicplay0123456789.000webhostapp.com/mp3/AnhDaSai.mp3', 0, ''),
(10, '5', '', '3', 'Hãy trao cho anh', 'https://musicplay0123456789.000webhostapp.com/img/HayTraoChoAnh1.jpg', 2, 'https://musicplay0123456789.000webhostapp.com/mp3/HayTraoChoAnh.mp3', 0, ''),
(11, '5', '', '3', 'Nơi này có anh', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/c/b/cb61528885ea3cdcd9bdb9dfbab067b1_1504988884.jpg', 2, 'https://musicplay0123456789.000webhostapp.com/mp3/NoiNayCoAnh.mp3', 0, ''),
(12, '', '', '1', 'Chắc ai đó sẽ về', 'https://photo-resize-zmp3.zadn.vn/w240_r1x1_jpeg/avatars/a/4/a40c3d3ebdb380b907546400905b35a0_1470191137.jpg', 2, 'https://musicplay0123456789.000webhostapp.com/mp3/ChacAiDoSeVe.mp3', 0, ''),
(13, '', '', '4', 'Buông đôi tay nhau ra', 'https://photo-zmp3.zadn.vn/audio_default.png', 2, 'https://musicplay0123456789.000webhostapp.com/mp3/BuongDoiTayNhauRa.mp3', 0, ''),
(14, '', '', '3', 'Chúng ta không thuộc về nhau', 'https://musicplay0123456789.000webhostapp.com/img/ChungTaKhongThuocVeNhau1.jpg', 2, 'https://musicplay0123456789.000webhostapp.com/mp3/ChungTaKhongThuocVeNhau.mp3', 0, ''),
(15, '4', '', '4', 'Em của ngày hôm qua', 'https://musicplay0123456789.000webhostapp.com/img/EmCuaNgayHomQua1.jpg', 2, 'https://musicplay0123456789.000webhostapp.com/mp3/EmCuaNgayHomQua.mp3', 0, ''),
(16, '5', '', '4', 'Không phải phải dạng vừa đâu', 'https://musicplay0123456789.000webhostapp.com/img/KhongPhaiDangVuaDau1.jpg', 2, 'https://musicplay0123456789.000webhostapp.com/mp3/KhongPhaiDangVuaDau.mp3', 0, ''),
(17, '3', '', '3', 'Remember me', 'https://avatar-ex-swe.nixcdn.com/playlist/2015/12/13/a/e/a/2/1449940955451_500.jpg', 2, 'https://musicplay0123456789.000webhostapp.com/mp3/RememberMe.mp3', 0, ''),
(18, '', '', '6', 'Như ngày hôm qua', 'https://avatar-ex-swe.nixcdn.com/song/2018/05/05/d/2/4/a/1525507567109_500.jpg', 2, 'https://musicplay0123456789.000webhostapp.com/mp3/NhuNgayHomQua.mp3', 0, ''),
(19, '', '', '4', 'Cơn mưa ngang qua', 'https://avatar-ex-swe.nixcdn.com/song/2018/03/30/b/1/8/8/1522404477634_500.jpg', 2, 'https://musicplay0123456789.000webhostapp.com/mp3/ConMuaNgangQua.mp3', 0, ''),
(21, '3', '', '3', 'Một năm mới bình an', 'https://avatar-ex-swe.nixcdn.com/song/2018/02/26/f/8/3/d/1519612532813_500.jpg', 2, 'https://musicplay0123456789.000webhostapp.com/mp3/MotNamMoiBinhAn.mp3', 0, ''),
(22, '8', '', '2', 'Anh cứ đi đi', 'https://avatar-ex-swe.nixcdn.com/song/2017/11/13/3/e/1/2/1510543585615_500.jpg', 4, 'https://musicplay0123456789.000webhostapp.com/mp3/AnhCuDiDi.mp3', 0, ''),
(23, '', '', '4', 'Hương đêm bay xa', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/e/0/e0df356e3e24b946529e98c9ed001bac_1416453349.jpg', 4, 'https://musicplay0123456789.000webhostapp.com/mp3/HuongDemBayXa.mp3', 0, ''),
(24, '', '', '3', 'Love you hate you', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/e/a/eab1319f6b37e675ca90f401c709b0d1_1434255832.jpg', 4, 'https://musicplay0123456789.000webhostapp.com/mp3/LoveYouHateYou.mp3', 0, ''),
(25, '8', '', '2', 'Tình thân là mãi mãi', 'https://avatar-ex-swe.nixcdn.com/song/2018/11/14/f/5/5/7/1542163719147_500.jpg', 4, 'https://musicplay0123456789.000webhostapp.com/mp3/TinhThanLaMaiMai.mp3', 0, ''),
(26, '', '', '3', 'Yêu không hối hận', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/3/8/3817d14f631a726d55d2aa5b3bd8e3c8_1476895754.jpg', 4, 'https://musicplay0123456789.000webhostapp.com/mp3/YeuKhongHoiHan.mp3', 0, ''),
(27, '9', '', '2', 'Là cả bầu trời', 'https://avatar-ex-swe.nixcdn.com/song/2018/10/17/d/0/b/7/1539746774638_500.jpg', 4, 'https://musicplay0123456789.000webhostapp.com/mp3/LaCaBauTroi.mp3', 0, ''),
(28, '9', '', '2', 'Làm sao để yêu', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/c/d/cd6ddb141f5046f25952e7670d9f214e_1481540479.jpg', 4, 'https://musicplay0123456789.000webhostapp.com/mp3/LamSaoDeYeu.mp3', 0, ''),
(29, '9', '', '2', 'It\'s you', 'https://avatar-ex-swe.nixcdn.com/song/2019/08/13/0/a/f/3/1565686973276_500.jpg', 4, 'https://musicplay0123456789.000webhostapp.com/mp3/ItsYou.mp3', 0, ''),
(30, '6', '', '2', 'Cho một tình yêu', 'https://musicplay0123456789.000webhostapp.com/img/ChoMotTinhYeu1.jpg', 3, 'https://musicplay0123456789.000webhostapp.com/mp3/ChoMotTinhYeu.mp3', 0, ''),
(31, '6', '', '2', 'Chỉ yêu mình anh', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/d/1/d1d0a43c3145fe3dae67fc108e77a8e6_1351681856.jpg', 3, 'https://musicplay0123456789.000webhostapp.com/mp3/ChiYeuMinhAnh.mp3', 0, ''),
(32, '', '', '6', 'Nụ hôn bất ngờ', 'https://photo-resize-zmp3.zadn.vn/w240_r1x1_jpeg/covers/4/b/4b1c59c7728e2b1cb65f6cb20aaf5cf9_1285661989.jpg', 3, 'https://musicplay0123456789.000webhostapp.com/mp3/NuHonBatNgo.mp3', 0, ''),
(33, '', '', '2', 'Tìm mẹ', 'https://avatar-ex-swe.nixcdn.com/singer/avatar/2019/10/02/2/c/8/c/1569987761461_600.jpg', 3, 'https://musicplay0123456789.000webhostapp.com/mp3/TinhMe.mp3', 0, ''),
(34, '7', '', '6', 'Cây đàn sinh viên', 'https://avatar-ex-swe.nixcdn.com/singer/avatar/2019/10/02/2/c/8/c/1569987761461_600.jpg', 3, 'https://musicplay0123456789.000webhostapp.com/mp3/CayDanSinhVien.mp3', 0, ''),
(35, '7', '', '6', 'Niềm tin chiến thắng', 'https://avatar-ex-swe.nixcdn.com/singer/avatar/2019/10/02/2/c/8/c/1569987761461_600.jpg', 3, 'https://musicplay0123456789.000webhostapp.com/mp3/NiemTinChienThang.mp3', 0, ''),
(36, '', '', '1', 'Chuyện như chưa bắt đầu', 'https://musicplay0123456789.000webhostapp.com/img/ChuyenNhuChuaBatDau.jpg', 3, 'https://musicplay0123456789.000webhostapp.com/mp3/ChuyenNhuChuaBatDau.mp3', 0, ''),
(37, '', '', '4', 'Dấu yêu', 'https://musicplay0123456789.000webhostapp.com/img/DauYeu.jpg', 3, 'https://musicplay0123456789.000webhostapp.com/mp3/DauYeu.mp3', 0, ''),
(38, '12', '', '5', 'Đưa nhau đi trốn', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/cover/0/f/5/7/0f5766ce97b1da7a7f14446d2d2f0d7e.jpg', 5, 'https://musicplay0123456789.000webhostapp.com/mp3/DuaNhauDiTronChill.mp3', 0, ''),
(39, '12', '', '5', 'Bài này chill phết', 'https://avatar-ex-swe.nixcdn.com/playlist/2019/10/29/a/a/e/d/1572332102923_500.jpg', 5, 'https://musicplay0123456789.000webhostapp.com/mp3/BaiNayChillPhet.mp3', 0, ''),
(40, '12', '', '5', 'Đố em biết anh đang nghĩ gì', 'https://avatar-ex-swe.nixcdn.com/playlist/2019/10/30/2/a/7/1/1572403446376_500.jpg', 5, 'https://musicplay0123456789.000webhostapp.com/mp3/Do-Em-Biet-Anh-Dang-Nghi-Gi.mp3', 0, ''),
(41, '11', '', '5', 'Hai triệu năm', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/cover/9/4/7/a/947a2a574c9e45bcc9e6dad7336141c2.jpg', 5, 'https://musicplay0123456789.000webhostapp.com/mp3/HaiTrieuNam.mp3', 0, ''),
(42, '11', '', '2', 'Lộn xộn', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/6/4/64ba602113f251c498d3d2ae1d4f9d17_1520220501.jpg', 5, 'https://musicplay0123456789.000webhostapp.com/mp3/Lon-Xon-II.mp3', 0, ''),
(43, '11', '', '5', 'Mười năm (Lộn xộn 3)', 'https://musicplay0123456789.000webhostapp.com/img/MuoiNam.jpg', 5, 'https://musicplay0123456789.000webhostapp.com/mp3/MuoiNamLonXon3.mp3', 0, ''),
(44, '10', '', '5', 'Đừng gọi anh là idol', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/cover/b/4/f/4/b4f41abcc367dc204f4e0f5ee2d08709.jpg', 5, 'https://musicplay0123456789.000webhostapp.com/mp3/Dung-Goi-Anh-La-Idol.mp3', 0, ''),
(45, '10', '', '5', 'Cảm ơn', 'https://musicplay0123456789.000webhostapp.com/img/CamOn1.jpg', 5, 'https://musicplay0123456789.000webhostapp.com/mp3/CamOn1.mp3', 0, ''),
(46, '', '', '5', 'Lối nhỏ', 'https://avatar-ex-swe.nixcdn.com/playlist/2019/10/28/7/5/c/e/1572272131336_500.jpg', 5, 'https://musicplay0123456789.000webhostapp.com/mp3/LoiNho1.mp3', 0, ''),
(47, '14', '', '2', 'Em gái mưa', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/e/4/e4ad98e7656f451b0c9eba0aa03c7ddb_1504595022.jpg', 6, 'https://musicplay0123456789.000webhostapp.com/mp3/EmGaiMua.mp3', 0, ''),
(48, '', '', '1', 'Cánh hoa tàn', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/5/8/58766910d61bcb394facd51139a0796c_1512273799.jpg', 6, 'https://musicplay0123456789.000webhostapp.com/mp3/CanhHoaTanMeChongOST.mp3', 0, ''),
(49, '13', '', '2', 'Người từng yêu anh rất sâu nặng', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/2/d/2dde012cec8c6d01c452573dafc1ead7_1438336555.jpg', 6, 'https://musicplay0123456789.000webhostapp.com/mp3/NguoiTungYeuAnhRatSauNang.mp3', 0, ''),
(50, '13', '', '2', 'Với em là mãi mãi', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/f/4/f4830a694c6e18bbaa18a2eeae7dd730_1374562721.jpg', 6, 'https://musicplay0123456789.000webhostapp.com/mp3/VoiEmLaMaMai.mp3', 0, ''),
(51, '14', '', '2', 'Ngốc', 'https://avatar-ex-swe.nixcdn.com/playlist/2016/02/18/5/c/3/4/1455760490646_500.jpg', 6, 'https://musicplay0123456789.000webhostapp.com/mp3/Ngoc.mp3', 0, ''),
(52, '14', '', '2', 'Cho em gần anh thêm một chút', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/covers/c/c/cc7ed4169790aa2c71d7c194cb0ee12f_1479986251.jpg', 6, 'https://musicplay0123456789.000webhostapp.com/mp3/ChoEmGanAnhThemChutNua.mp3', 0, ''),
(53, '13', '', '2', 'Duyên mình lỡ', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/cover/a/9/0/8/a90839d864c557bc429152e90bc231f3.jpg', 6, 'https://musicplay0123456789.000webhostapp.com/mp3/DuyenMinhLo.mp3', 0, ''),
(54, '', '', '2', 'Đi để trở về', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/cover/5/6/5/2/56527419ccee46419c1be309d57c0d51.jpg', 6, 'https://musicplay0123456789.000webhostapp.com/mp3/DiDeTroVe5.mp3', 0, ''),
(55, '15', '', '6', 'Để mị nói cho mà nghe', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/cover/1/c/4/6/1c4628cbb1072f9ac1e2eb6011555790.jpg', 7, 'https://musicplay0123456789.000webhostapp.com/mp3/DeMiNoiChoMaNghe.mp3', 0, ''),
(56, '15', '', '6', 'Tứ phủ', 'https://photo-resize-zmp3.zadn.vn/w320_r1x1_jpeg/cover/b/8/9/9/b899b049c6e380a84e82c60733366030.jpg', 7, 'https://musicplay0123456789.000webhostapp.com/mp3/TuPhu.mp3', 0, ''),
(57, '15', '', '6', 'Em đây chẳng phải Thúy Kiều', 'https://avatar-ex-swe.nixcdn.com/song/2019/10/18/2/0/b/1/1571380902194_500.jpg', 7, 'https://musicplay0123456789.000webhostapp.com/mp3/EmDayChangPhaiThuyKieu.mp3', 0, ''),
(58, '15', '', '3', 'Kẻ cắp gặp bà già', 'https://musicplay0123456789.000webhostapp.com/img/KeCaoGapBaGia.jpg', 7, 'https://musicplay0123456789.000webhostapp.com/mp3/KeCapGapBaGia.mp3', 0, ''),
(59, '', '', '4', 'Bánh trôi nước', 'https://musicplay0123456789.000webhostapp.com/img/BanhTroiNuoc.jpg', 7, 'https://musicplay0123456789.000webhostapp.com/mp3/BanhTroiNuocTheRemix.mp3', 0, ''),
(60, '', '', '4', 'I\'m gonna break', 'https://musicplay0123456789.000webhostapp.com/img/I\'mGonnaBreak.jpg', 7, 'https://musicplay0123456789.000webhostapp.com/mp3/ImGonnaBreak.mp3', 0, ''),
(61, '15', '', '3', 'Kẽo cà kẽo kẹt', 'https://musicplay0123456789.000webhostapp.com/img/KeoCaKeoKet.jpg', 7, 'https://musicplay0123456789.000webhostapp.com/mp3/KeoCaKeoKet.mp3', 0, ''),
(62, '', '', '6', 'Lắm mối tối ngồi không', 'https://musicplay0123456789.000webhostapp.com/img/LamMoiToiNgoiKhong.jpg', 7, 'https://musicplay0123456789.000webhostapp.com/mp3/LamMoiToiNgoiKhong.mp3', 0, '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `topic`
--

CREATE TABLE `topic` (
  `topic_id` int(11) NOT NULL,
  `topic_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `topic_image_url` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `topic`
--

INSERT INTO `topic` (`topic_id`, `topic_name`, `topic_image_url`) VALUES
(1, 'Nhạc điện tử', 'http://127.0.0.1:8000/img/nhacDienTu.jfif'),
(2, 'Nhạc nhẹ', 'http://127.0.0.1:8000/img/nhacNhe.jfif');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `user_password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `user_avatar_url` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `user_password`, `user_avatar_url`) VALUES
(1, 'kim', '123', 'https://musicplay0123456789.000webhostapp.com/img/avatar.jpg');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `adv`
--
ALTER TABLE `adv`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`album_id`);

--
-- Chỉ mục cho bảng `banner`
--
ALTER TABLE `banner`
  ADD PRIMARY KEY (`banner_id`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);

--
-- Chỉ mục cho bảng `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`comment_id`);

--
-- Chỉ mục cho bảng `playlist`
--
ALTER TABLE `playlist`
  ADD PRIMARY KEY (`playlist_id`);

--
-- Chỉ mục cho bảng `singer`
--
ALTER TABLE `singer`
  ADD PRIMARY KEY (`singer_id`),
  ADD UNIQUE KEY `name` (`singer_name`);

--
-- Chỉ mục cho bảng `song`
--
ALTER TABLE `song`
  ADD PRIMARY KEY (`song_id`);

--
-- Chỉ mục cho bảng `topic`
--
ALTER TABLE `topic`
  ADD PRIMARY KEY (`topic_id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `adv`
--
ALTER TABLE `adv`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `album`
--
ALTER TABLE `album`
  MODIFY `album_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `banner`
--
ALTER TABLE `banner`
  MODIFY `banner_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `comment`
--
ALTER TABLE `comment`
  MODIFY `comment_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `playlist`
--
ALTER TABLE `playlist`
  MODIFY `playlist_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `singer`
--
ALTER TABLE `singer`
  MODIFY `singer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `song`
--
ALTER TABLE `song`
  MODIFY `song_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT cho bảng `topic`
--
ALTER TABLE `topic`
  MODIFY `topic_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
