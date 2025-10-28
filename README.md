# 📚 Kitabxana İdarəetmə Sistemi (Library Management System)

Bu layihə **Core Java** istifadə edilərək hazırlanmış sadə bir **Kitabxana İdarəetmə Sistemi**dir.  
Layihə kitabların və istifadəçilərin siyahısını idarə etməyə, kitabların icarəyə verilməsinə və geri qaytarılmasına imkan yaradır.

---

## 🧩 Layihənin məqsədi
Bu proqram **obyekt yönlü proqramlaşdırma (OOP)** prinsiplərini praktiki şəkildə tətbiq etmək və:
- class-lar arası əlaqələri (`BookEntity`, `AuthorEntity`, `UserEntity`)
- istisna (exception) idarəetməsini
- `java.util.logging` vasitəsilə log mexanizmini
- Stream API və filter əməliyyatlarını
öyrənmək məqsədilə hazırlanmışdır.

---

## ⚙️ İstifadə olunan əsas texnologiyalar
- **Java SE (Core Java)**
- **java.util.List**, **Map**
- **java.util.logging** (log yazmaq üçün)
- **Stream API**
- **Custom Exception-lar**

---

## 🏗️ Layihə strukturu

src/
└── main/
└── java/
├── entity/
│ ├── BookEntity.java
│ ├── AuthorEntity.java
│ └── UserEntity.java
├── dto/
│ ├── BookRequest.java
│ └── BookResponse.java
├── service/
│ └── LibraryService.java
├── exception/
│ └── CustomException.java
└── Main.java

markdown
Kodu kopyala

---

## 🧠 Əsas class-lar

### 🔹 `BookEntity`
Kitabın məlumatlarını saxlayır:
- `id`
- `name`
- `author`
- `available` (true/false)
- `borrowedByUserId`
- `borrowedAt`

### 🔹 `AuthorEntity`
Müəllif haqqında məlumatları saxlayır:
- `id`
- `name`
- `List<BookEntity> books`

### 🔹 `UserEntity`
İstifadəçi haqqında məlumatları saxlayır:
- `id`
- `fullName`

### 🔹 `LibraryService`
Sistemin əsas əməliyyatlarını idarə edir:
- `addBook(BookRequest book)`
- `borrowBook(Long userId, Long bookId)`
- `returnBook(Long bookId)`
- `getAllAvailableBooks()`
- `getBooksByAuthor(String author)`

Həmçinin burada:
- **log yazılışları** (`java.util.logging`)
- **custom exception-lar**
- **stream filter əməliyyatları**
istifadə olunur.

---

## 🧰 Əməliyyatların izahı

| Metod | Təyinat | Qeyd |
|--------|----------|------|
| `addBook()` | Yeni kitab əlavə edir | `BookRequest` ilə məlumat alır |
| `borrowBook()` | Kitabı icarəyə verir | `available = false` olur |
| `returnBook()` | Kitabı geri qaytarır | `available = true` olur |
| `getAllAvailableBooks()` | Mövcud (icarədə olmayan) kitabların siyahısı | Stream ilə filter edilir |
| `getBooksByAuthor()` | Müəllifə görə kitabları qaytarır | Baş hərfə görə filter olunur |

---

## 🧮 Pagination (Səhifələmə)
- `getAll` metodlarında pagination dəstəklənir.
- Default olaraq, heç bir parametr ötürülməsə, **1-ci səhifə və 5 kitab** göstərilir.
- Əgər səhifə nömrəsi ötürülərsə, həmin səhifənin kitabları göstərilir.

---

## 🚀 Proqramın işə salınması

1. Layihəni klonla:
   ```bash
   git clone https://github.com/Penah-M/simple-library-management.git
IDE-də (IntelliJ IDEA, Eclipse və s.) aç.

Main.java faylını çalışdır.

Konsolda əməliyyatları və logları müşahidə et.

🧾 Nümunə çıxış
yaml
Kodu kopyala
INFO: Yeni kitab əlavə edildi: Java Fundamentals
WARNING: İstifadəçi 1 kitabı icarəyə götürdü: 3
SEVERE: Kitab tapılmadı: id=99
🧱 Layihə məhdudiyyətləri
Layihə bazadan istifadə etmir — bütün məlumatlar List və Map strukturlarında saxlanılır.

Yalnız Core Java istifadə olunur (heç bir Spring və ya əlavə jar yoxdur).

Postman və ya REST API interfeysi yoxdur — bütün əməliyyatlar main() üzərindən aparılır.

✍️ Müəllif
Penah Mohbalizade
📅 Oktyabr, 2025
🧠 Core Java – OOP & Stream Practice Project
