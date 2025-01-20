# Môn Kiến trúc phần mềm hướng dịch vụ (25D1INF50902201)

## Exercise 1 - La Hoàng Giang

### Mô tả các kiến thức đã áp dụng:
- Spring Web, Spring Data JPA, Validation, Handling Exception
- H2 Database (chạy trong memory, không cần cài phần mềm như SQL Server, MySQL)
- Sử dụng Postman để test các API và dùng H2 Database Console để xem dữ liệu

### Kết quả đạt được:
**1. Thêm mới todo:**

- Trường hợp tạo tên todo đã tồn tại:
![Image](https://github.com/user-attachments/assets/87383aec-5036-455d-b213-ef286fa94038)

- Trường hợp tạo mới thành công:
![image](https://github.com/user-attachments/assets/55f689e0-9329-44be-87d1-cce78ade2507)

**2. Cập nhật todo:**

- Trường hợp cập nhật ID không tồn tại:
![image](https://github.com/user-attachments/assets/80b08352-5f59-45f7-bf1e-ffe960ccdcbc)

- Trường hợp cập nhật thành công:
![image](https://github.com/user-attachments/assets/daff3c51-c689-481d-8a63-e8f6c5422ec8)

**3. Xóa todo:**

![image](https://github.com/user-attachments/assets/f4ef7802-5436-49d5-8758-c99cfd036e98)

**4. Lấy tất cả todo:**

![image](https://github.com/user-attachments/assets/acf6e9dc-1f9f-4bde-966b-68253b1eda7f)

**5. Lấy todo theo id:**

![image](https://github.com/user-attachments/assets/f4518b84-1aa9-4d9b-b80f-4afdc4d877c7)

**6. Lấy tất cả todo đã hoàn thành:**
![image](https://github.com/user-attachments/assets/fba7ffb0-3f79-4a83-8fc7-20b9e4b96c4c)

***

#### Sử dụng Postman để test các API ####

![image](https://github.com/user-attachments/assets/0181cff5-98a7-433c-9e22-be9371f7e3b3)

***

#### Truy cập H2 Database (http://localhost:8080/h2-console) ####

- Đăng nhập vào H2 Database:
 
![image](https://github.com/user-attachments/assets/4fd10a81-6b75-4f15-b47b-cb746764a0a4)

- Đăng nhập thành công:
 
![image](https://github.com/user-attachments/assets/48600813-b28e-424b-8fe3-04568866d369)

- Xem dữ liệu tất cả items:

![image](https://github.com/user-attachments/assets/a427c92f-92d5-40e4-a3b9-cfc2f01f636e)

