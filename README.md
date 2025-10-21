# 🎮 Adventure Game - Macera Oyunu

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Console](https://img.shields.io/badge/Console-Game-blue?style=for-the-badge)
![OOP](https://img.shields.io/badge/OOP-Design-green?style=for-the-badge)

**Metin tabanlı RPG macera oyunu - Java ile geliştirilmiştir**

[Özellikler](#-özellikler) • [Nasıl Oynanır](#-nasıl-oynanır) • [Kurulum](#-kurulum) • [Oyun Mekaniği](#-oyun-mekaniği) • [Mimari](#-mimari)

</div>

---

## 📖 Hakkında

Adventure Game, klasik metin tabanlı RPG oyunlarından esinlenilerek geliştirilmiş bir konsol oyunudur. Oyuncular farklı karakterler seçerek çeşitli lokasyonlarda düşmanlarla savaşır, para kazanır, ekipman satın alır ve sonunda tüm ödülleri toplayarak oyunu kazanır.

## ✨ Özellikler

- 🎭 **3 Farklı Karakter**: Her biri benzersiz özellikler ve başlangıç statlarına sahip
- 🗺️ **6 Lokasyon**: Güvenli bölgeler, mağaza ve savaş alanları
- ⚔️ **4 Düşman Türü**: Zombiler, Vampirler, Ayılar ve Yılanlar
- 🛡️ **Ekipman Sistemi**: Silahlar ve zırhlar satın alarak karakterini güçlendir
- 🎁 **Loot Sistemi**: Madende düşmanları yenerek rastgele eşya kazan
- 🏆 **Ödül Sistemi**: 3 farklı ödülü toplayarak oyunu kazan
- 💰 **Ekonomi Sistemi**: Para kazan ve harca
- 🎯 **SOLID Prensipleri**: Temiz, modüler ve genişletilebilir kod yapısı

## 🎮 Nasıl Oynanır

### Oyun Akışı

1. **Karakter Seçimi**: Oyuna başlarken 3 karakter arasından birini seç
2. **Lokasyon Seçimi**: Ana menüden gitmek istediğin lokasyonu seç
3. **Savaş veya Alışveriş**: Lokasyona göre düşmanlarla savaş veya ekipman satın al
4. **Ödül Toplama**: Her savaş alanından bir ödül kazan
5. **Kazanma**: Tüm ödülleri toplayıp Güvenli Eve döndüğünde oyunu kazanırsın!

### Karakterler

| Karakter | Hasar | Can | Başlangıç Parası | Özellik |
|----------|-------|-----|------------------|---------|
| 🗡️ **Samuray** | 5 | 21 | 15₺ | Dengeli bir savaşçı |
| 🏹 **Okçu** | 7 | 18 | 20₺ | Yüksek hasar, orta can |
| 🛡️ **Şövalye** | 8 | 24 | 5₺ | Yüksek can ama az para |

### Lokasyonlar

#### 🏠 Güvenli Ev (Safe House)
- Canını tamamen iyileştirir
- **Tüm ödülleri topladıysan burada oyunu kazanırsın!**

#### 🏪 Mağaza (Tool Store)
**Silahlar:**
- ⚔️ Kılıç: +2 Hasar (15₺)
- 🔫 Tabanca: +3 Hasar (35₺)
- 🎯 Tüfek: +7 Hasar (45₺)

**Zırhlar:**
- 🥋 Hafif Zırh: 1 Blok (15₺)
- 🛡️ Orta Zırh: 3 Blok (25₺)
- 🏰 Ağır Zırh: 5 Blok (40₺)

#### ⚔️ Savaş Alanları

| Lokasyon | Düşman | Düşman Sayısı | Hasar | Can | Ödül | Para |
|----------|--------|---------------|-------|-----|------|------|
| 🦇 **Mağara** | Zombi | 3 | 3 | 10 | 🍖 Food | 4₺ |
| 🌲 **Orman** | Vampir | 3 | 4 | 14 | 🪵 Firewood | 7₺ |
| 🌊 **Nehir** | Ayı | 2 | 7 | 20 | 💧 Water | 12₺ |
| ⛏️ **Maden** | Yılan | 1-5 (rastgele) | 3-6 | 12 | 🎁 Loot | - |

#### 🎁 Özel: Maden Loot Sistemi

Madendeki yılanlar yenildiğinde rastgele loot düşürürler:

- **%15 İhtimal** - Rastgele Silah
- **%15 İhtimal** - Rastgele Zırh
- **%25 İhtimal** - Para
- **%45 İhtimal** - Hiçbir şey

**Loot Kaliteleri:**
- 🟢 Yaygın (%50): Kılıç, Hafif Zırh
- 🔵 Nadir (%30): Tabanca, Orta Zırh
- 🟣 Efsanevi (%20): Tüfek, Ağır Zırh

### 🏆 Kazanma Koşulu

Oyunu kazanmak için:

1. ✅ **Mağara**'yı tamamla → 🍖 Food ödülünü kazan
2. ✅ **Orman**'ı tamamla → 🪵 Firewood ödülünü kazan
3. ✅ **Nehir**'i tamamla → 💧 Water ödülünü kazan
4. ✅ 3 ödülle birlikte **Güvenli Eve** dön

**🎉 TEBRİKLER! OYUNU KAZANDIN! 🎉**

## 🚀 Kurulum

### Gereksinimler

- ☕ Java 8 veya üzeri
- 📦 JDK yüklü olmalı

### Oyunu Çalıştırma

#### Windows

```bash
# Projeyi klonla
git clone https://github.com/sezgineken/AdventureGame.git
cd AdventureGame

# Derle
javac -d out/production/AdventureGame -sourcepath src src/Main.java

# Çalıştır
java -cp out/production/AdventureGame Main
```

#### Linux / macOS

```bash
# Projeyi klonla
git clone https://github.com/sezgineken/AdventureGame.git
cd AdventureGame

# Derle
javac -d out/production/AdventureGame -sourcepath src src/Main.java

# Çalıştır
java -cp out/production/AdventureGame Main
```

#### IDE ile (IntelliJ IDEA, Eclipse)

1. Projeyi IDE'nize import edin
2. `src` klasörünü source root olarak işaretleyin
3. `Main.java` dosyasını çalıştırın

## 🎯 Oyun Mekaniği

### Savaş Sistemi

- Oyuncu önce saldırır
- Her saldırı: `Toplam Hasar = Karakter Hasarı + Silah Hasarı`
- Düşman saldırısı: `Alınan Hasar = Düşman Hasarı - Zırh Bloklaması`
- Can 0'a düşerse oyun biter

### Strateji İpuçları

1. 💡 **İlk önce para biriktir**: Mağaradan başla, zombiler kolay ve para kazandırır
2. 💡 **Ekipman al**: Mağazadan silah ve zırh almadan zorlu düşmanlara gitme
3. 💡 **Can kontrolü**: Canın azaldıysa Güvenli Eve git ve iyileş
4. 💡 **Madeni son bırak**: Maden loot çiftliği için idealdir, güçlendikten sonra git
5. 💡 **Zırh öncelikli**: İyi zırh seni uzun süre hayatta tutar

## 🏗️ Mimari

Proje, **SOLID prensipleri** ve **Design Patterns** kullanılarak geliştirilmiştir.

### Klasör Yapısı

```
AdventureGame/
├── src/
│   ├── Main.java                 # Giriş noktası
│   ├── Game.java                 # Ana oyun döngüsü
│   ├── constants/                # Sabitler
│   │   ├── GameConstants.java
│   │   └── Messages.java
│   ├── factory/                  # Factory Pattern
│   │   ├── CharacterFactory.java
│   │   ├── LocationFactory.java
│   │   └── ObstacleFactory.java
│   ├── interfaces/               # Arayüzler
│   │   ├── Combatable.java
│   │   ├── Damageable.java
│   │   ├── Healable.java
│   │   └── Purchasable.java
│   ├── location/                 # Lokasyonlar
│   │   ├── Location.java
│   │   ├── NormalLoc.java
│   │   ├── BattleLoc.java
│   │   ├── SafeHouse.java
│   │   ├── ToolStore.java
│   │   ├── Cave.java
│   │   ├── Forest.java
│   │   ├── River.java
│   │   └── Mine.java
│   ├── managers/                 # Yönetici sınıflar
│   │   ├── CharacterSelector.java
│   │   ├── CombatManager.java
│   │   ├── CombatUI.java
│   │   ├── LootSystem.java
│   │   └── MenuManager.java
│   ├── model/                    # Veri modelleri
│   │   ├── Player.java
│   │   ├── GameChar.java
│   │   ├── Samurai.java
│   │   ├── Archer.java
│   │   ├── Knight.java
│   │   ├── Obstacle.java
│   │   ├── Zombie.java
│   │   ├── Vampire.java
│   │   ├── Bear.java
│   │   ├── Snake.java
│   │   ├── Inventory.java
│   │   ├── Weapon.java
│   │   └── Armor.java
│   └── utils/                    # Yardımcı sınıflar
│       └── InputHandler.java
└── out/                          # Derlenmiş dosyalar
```

### Kullanılan Design Patterns

- **Factory Pattern**: Karakter, lokasyon ve düşman oluşturma
- **Singleton Pattern**: InputHandler için tek instance
- **Strategy Pattern**: Savaş ve iyileşme mekanikleri
- **Template Method Pattern**: Lokasyon davranışları

### SOLID Prensipleri

- ✅ **Single Responsibility**: Her sınıf tek bir sorumluluğa sahip
- ✅ **Open/Closed**: Yeni özellikler mevcut kodu değiştirmeden eklenebilir
- ✅ **Liskov Substitution**: Alt sınıflar üst sınıfların yerine kullanılabilir
- ✅ **Interface Segregation**: Küçük, odaklanmış arayüzler
- ✅ **Dependency Inversion**: Yüksek seviye modüller soyutlamalara bağımlı

## 🎨 Ekran Görüntüleri

### Karakter Seçimi
```
Lütfen isminizi giriniz: Sezgin
***********************************************
Hoşgeldin Sezgin, Macera Oyununa! Riskli bir dünyaya adım attın...
***********************************************
Karakter Seçiniz:
----------------------------------------------------------------------------------------
ID    | Karakter    | Hasar   | Sağlık  | Para
----------------------------------------------------------------------------------------
1     | Samuray     | 5       | 21      | 15
2     | Okçu        | 7       | 18      | 20
3     | Şövalye     | 8       | 24      | 5
----------------------------------------------------------------------------------------
Karakter ID'si giriniz: 
```

### Lokasyon Menüsü
```
Bölgeler:
1 - Güvenli Ev        --> Burası sizin için güvenli bir ev. Canlılığınız yenilenir
2 - Eşya Dükkanı      --> Buradan silah veya zırh satın alabilirsiniz.
3 - Mağara            --> Ödül: <Food> | Zombi
4 - Orman             --> Ödül: <Firewood> | Vampir
5 - Nehir             --> Ödül: <Water> | Ayı
6 - Maden             --> Ödül: <Loot> | Yılan
0 - ÇIKIŞ             --> Oyundan çıkmak için
```

### Savaş Ekranı
```
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
⚔️  SAVAŞ BAŞLADI!
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
Karşınızda: Zombi
Düşman Sayısı: 3
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

--- TUR 1 ---
Zombi'ye 7 hasar vurdunuz!
Zombi'nin kalan canı: 3
Zombi size 2 hasar vurdu!
Sağlığınız: 19
```

## 📝 Geliştirme Süreci

Bu proje, aşağıdaki ödevler kapsamında geliştirilmiştir:

- **ÖDEV 1**: Ödül sistemi ve kazanma koşulu
- **ÖDEV 2**: Factory Pattern ve SOLID prensipleri uygulaması
- **ÖDEV 3**: Maden lokasyonu ve loot sistemi

## 🤝 Katkıda Bulunma

Katkılarınızı bekliyoruz! Lütfen şu adımları takip edin:

1. Projeyi fork'layın
2. Feature branch oluşturun (`git checkout -b feature/YeniOzellik`)
3. Değişikliklerinizi commit edin (`git commit -m 'Yeni özellik eklendi'`)
4. Branch'inizi push edin (`git push origin feature/YeniOzellik`)
5. Pull Request oluşturun

## 📜 Lisans

Bu proje eğitim amaçlı geliştirilmiştir.

## 👨‍💻 Geliştirici

**Sezgin Eken**

- GitHub: [@sezgineken](https://github.com/sezgineken)

---

<div align="center">

**⭐ Projeyi beğendiyseniz yıldız vermeyi unutmayın! ⭐**

Made with ☕ and Java

</div>

