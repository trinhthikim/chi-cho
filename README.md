# app-music

# cách để load database khi đăng ký, đăng nhập trong localhost
- File SQL: id16441573_appmusic.sql (đã update file này phía trên- file id16441573_appmusic.sql) 
- Thư mục chưa các file php: LoginRegister (đã update folder này phía trên - file .zip)
- Những file php được đặt trong xampp/htdocs/LoginRegister
- Mở cmd:
  - Nhập ipconfig
  - Tìm chỗ Wireless LAN adapter WiFi: Tìm IPv4 Address: 192.168.1.8 (các máy khác nhau)
  - Thay dãy IP này vào dãy số chỗ đường link 
      - PutData putData = new PutData("http://192.168.1.8/LoginRegister/login.php", "POST", field, data); trong 2 file SignupActivity.java và LoginActivity.java
