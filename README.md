# Sistem Pakar Diagnosa Kerusakan Mesin Injection Roda Dua

Proyek ini adalah implementasi dari sistem pakar yang digunakan untuk mendiagnosa kerusakan pada mesin injeksi roda dua menggunakan metode Forward Chaining. Aplikasi ini dikembangkan menggunakan Java dengan antarmuka pengguna berbasis Swing.

## Fitur

- **Manajemen Gejala:** Tambahkan, hapus, dan lihat gejala yang mungkin terjadi pada mesin injeksi.
- **Manajemen Kerusakan:** Tambahkan, hapus, dan lihat jenis kerusakan yang mungkin terjadi.
- **Manajemen Aturan:** Tambahkan, hapus, dan lihat aturan yang menghubungkan gejala dengan kerusakan.
- **Diagnosa:** Pilih gejala-gejala yang terdeteksi dan dapatkan hasil diagnosa berupa kerusakan yang mungkin terjadi.

## Prasyarat

Pastikan Anda memiliki hal-hal berikut terinstal di sistem Anda:

- [Java Development Kit (JDK) 8 atau lebih baru](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Apache NetBeans IDE](https://netbeans.apache.org/download/index.html)

## Struktur Proyek

```plaintext
SistemPakarDiagnosis
├── src
│   └── com
│       └── sistem
│           └── pakar
│               ├── Condition.java
│               ├── Damage.java
│               ├── Rule.java
│               ├── ExpertSystem.java
│               ├── KnowledgeBase.java
│               ├── DiagnosisUI.java
│               └── Main.java
└── pom.xml
```
## Keterangan File
### `KnowledgeBase.java`
`KnowledgeBase.java` adalah kelas yang menyimpan dan mengelola basis pengetahuan yang mencakup gejala, kerusakan, dan aturan diagnosis. Kelas ini memungkinkan penambahan, penghapusan, dan pengambilan data yang diperlukan untuk proses diagnosis.

#### Atribut:
- `conditions`: Daftar objek `Condition` yang merepresentasikan gejala.
- `damages`: Daftar objek `Damage` yang merepresentasikan kerusakan.
- `rules`: Daftar objek `Rule` yang mendefinisikan aturan diagnosis.

#### Metode:
- **Constructor**: Menginisialisasi basis pengetahuan dengan data awal (gejala, kerusakan, aturan).
- **addCondition(Condition condition)**: Menambahkan gejala baru ke basis pengetahuan.
- **addDamage(Damage damage)**: Menambahkan kerusakan baru ke basis pengetahuan.
- **addRule(Rule rule)**: Menambahkan aturan baru ke basis pengetahuan.
- **getConditions()**: Mengembalikan daftar gejala yang ada.
- **getDamages()**: Mengembalikan daftar kerusakan yang ada.
- **getRules()**: Mengembalikan daftar aturan yang ada.

Kelas ini mengelola semua data yang diperlukan untuk diagnosis dan menyediakan metode untuk mengakses serta memodifikasi data tersebut.

### `DiagnosisUI.java`
`DiagnosisUI.java` adalah kelas yang menyediakan antarmuka pengguna grafis (GUI) untuk aplikasi sistem pakar. Kelas ini memungkinkan pengguna untuk memasukkan gejala, menambahkan data baru, dan melihat hasil diagnosis.

#### Metode Utama:
- **Constructor**: Menginisialisasi antarmuka pengguna, termasuk komponen untuk memilih gejala dan menampilkan hasil diagnosis.
- **initUI()**: Mengatur dan menampilkan elemen GUI.
- **addCondition()**: Menambahkan gejala baru melalui formulir.
- **removeCondition()**: Menghapus gejala yang dipilih.
- **diagnose()**: Menjalankan proses diagnosis dan menampilkan hasil.
- **updateKnowledgeBase()**: Memperbarui basis pengetahuan dengan data baru yang dimasukkan oleh pengguna.

Kelas ini adalah titik interaksi antara pengguna dan sistem pakar, memungkinkan pengguna untuk berinteraksi dengan aplikasi dan mendapatkan diagnosis berdasarkan gejala yang dimasukkan.

### `Rule.java`
`Rule.java` adalah kelas yang mendefinisikan aturan diagnosis dalam sistem pakar. Kelas ini menyimpan informasi tentang aturan yang menghubungkan gejala dengan kerusakan.

#### Atribut:
- `damageCode`: Kode kerusakan yang dihasilkan jika aturan cocok.
- `conditions`: Daftar kode gejala yang harus ada untuk menerapkan aturan ini.

#### Metode:
- **Constructor**: Digunakan untuk membuat instance `Rule` dengan kode kerusakan dan daftar gejala.
- **getDamageCode()**: Mengembalikan kode kerusakan.
- **getConditions()**: Mengembalikan daftar kode gejala.
- **setDamageCode(String damageCode)**: Mengatur kode kerusakan.
- **setConditions(List<String> conditions)**: Mengatur daftar kode gejala.

Kelas ini digunakan untuk menentukan aturan yang harus dipenuhi agar kerusakan tertentu dapat didiagnosis.

### `Condition.java`
`Condition.java` adalah kelas yang mendefinisikan objek gejala dalam sistem pakar. Kelas ini memiliki atribut dan metode untuk merepresentasikan gejala yang dapat terdeteksi oleh sistem.

#### Atribut:
- `code`: Kode identifikasi gejala (misalnya, "G01").
- `name`: Nama gejala (misalnya, "Bau aneh pada knalpot").

#### Metode:
- **Constructor**: Digunakan untuk membuat instance `Condition` dengan kode dan nama gejala.
- **getCode()**: Mengembalikan kode gejala.
- **getName()**: Mengembalikan nama gejala.
- **setCode(String code)**: Mengatur kode gejala.
- **setName(String name)**: Mengatur nama gejala.

Kelas ini biasanya digunakan dalam proses diagnosis untuk mencocokkan gejala yang dilaporkan dengan kerusakan yang sesuai berdasarkan aturan yang telah ditentukan.

### `Damage.java`
`Damage.java` adalah kelas yang mendefinisikan objek kerusakan dalam sistem pakar. Kelas ini memiliki atribut dan metode untuk merepresentasikan kerusakan yang dapat terdeteksi oleh sistem.

#### Atribut:
- `code`: Kode identifikasi kerusakan (misalnya, "K01").
- `name`: Nama kerusakan (misalnya, "Kerusakan pada sensor MAP").

#### Metode:
- **Constructor**: Digunakan untuk membuat instance `Damage` dengan kode dan nama kerusakan.
- **getCode()**: Mengembalikan kode kerusakan.
- **getName()**: Mengembalikan nama kerusakan.
- **setCode(String code)**: Mengatur kode kerusakan.
- **setName(String name)**: Mengatur nama kerusakan.

Kelas ini biasanya digunakan dalam proses diagnosis untuk mencocokkan gejala dengan kerusakan yang sesuai berdasarkan aturan yang telah ditentukan.

### `ExpertSystem.java`
`ExpertSystem.java` adalah kelas utama yang mengelola data gejala, kerusakan, dan aturan dalam sistem pakar. Kelas ini menyimpan informasi dan melakukan diagnosis berdasarkan aturan yang diberikan.

#### Atribut:
- `conditions`: Daftar objek `Condition` yang merepresentasikan gejala.
- `damages`: Daftar objek `Damage` yang merepresentasikan kerusakan.
- `rules`: Daftar objek `Rule` yang mendefinisikan aturan diagnosis.

#### Metode:
- **Constructor**: Digunakan untuk membuat instance `ExpertSystem` dan menginisialisasi daftar gejala, kerusakan, dan aturan.
- **addCondition(Condition condition)**: Menambahkan gejala baru ke daftar.
- **addDamage(Damage damage)**: Menambahkan kerusakan baru ke daftar.
- **addRule(Rule rule)**: Menambahkan aturan baru ke daftar.
- **diagnose(Set<String> symptoms)**: Melakukan diagnosis berdasarkan gejala yang diberikan dan mengembalikan daftar kerusakan yang sesuai.

Kelas ini merupakan pusat logika dari sistem pakar yang mengatur semua data dan menjalankan proses diagnosis.


## Diagram Alur
```
Pilih Gejala
     |
     v
Mencari Aturan yang Sesuai
     |
     v
Hasil Diagnosa (Kerusakan yang Teridentifikasi)
```

## Clone Repository
```
git clone https://github.com/username/SistemPakarDiagnosis.git
cd SistemPakarDiagnosis
```
## Instalasi dan Menjalankan Aplikasi

### Buka Proyek di NetBeans

1. Buka NetBeans IDE.
2. Pilih `File > Open Project`.
3. Arahkan ke folder `SistemPakarDiagnosis` yang telah di-clone dan pilih folder tersebut.
4. Klik `Open Project`.

### Bangun Proyek

Setelah proyek terbuka di NetBeans, bangun proyek dengan:

1. Klik kanan pada proyek di panel `Projects`.
2. Pilih `Clean and Build`.

### Jalankan Aplikasi

Untuk menjalankan aplikasi:

1. Klik kanan pada proyek di panel `Projects`.
2. Pilih `Run`.

## Penulis

Proyek ini dikembangkan oleh Van Lyubov.

## Lisensi

Proyek ini dilisensikan di bawah lisensi MIT.





