package constants;

/**
 * Constants for game messages (for potential i18n support)
 */
public class Messages {
    // Welcome messages
    public static final String GAME_TITLE = "********** Macera oyununa hoşgeldiniz **********";
    public static final String ENTER_NAME = "Lütfen isminizi giriniz: ";
    public static final String WELCOME_MESSAGE = "Bu karanlık ve sisli adaya hoşgeldin %s. Burda her şey gerçek.";
    public static final String SELECT_CHARACTER = "Oyuna başlamak için bir karakter seçiniz.";
    
    // Menu messages
    public static final String REGIONS_TITLE = "********** Bölgeler **********:";
    public static final String SELECT_REGION = "Lütfen gitmek istediğiniz bölgeyi seçiniz: ";
    public static final String INVALID_REGION = "Lütfen Geçerli Bir Bölge Seçiniz: ";
    public static final String QUIT_MESSAGE = "Bu karanlık ve sisli dünyadan çabuk vazgeçtin";
    
    // Location names
    public static final String SAFE_HOUSE = "Güvenli Ev";
    public static final String TOOL_STORE = "Demirci";
    public static final String CAVE = "Mağara";
    public static final String FOREST = "Orman";
    public static final String RIVER = "Nehir";
    
    // Combat messages
    public static final String CURRENT_LOCATION = "Şu an buradasınız: %s";
    public static final String ENEMY_WARNING = "Dikkatli ol. Burada %d tane %s yaşıyor";
    public static final String FIGHT_OR_RUN = "<S>avaş veya <K>aç: ";
    public static final String HIT_OR_RUN = "<V>ur veya <K>aç: ";
    public static final String YOU_HIT = "Siz vurdunuz: ";
    public static final String ENEMY_HIT = "Canavar size vurdu: ";
    public static final String ENEMY_DEFEATED = "Düşmanı Yendiniz!";
    public static final String ALL_ENEMIES_DEFEATED = "%s Tüm düşmanları yendiniz.";
    public static final String MONEY_EARNED = "%d TL kazandınız!";
    public static final String CURRENT_MONEY = "Güncel Paranız: %d";
    public static final String GAME_OVER = "GAME OVER";
    public static final String YOU_DIED = "Öldünüz!";
    
    // Character selection
    public static final String CHARACTERS_TITLE = "Karakterler";
    public static final String SELECT_CHARACTER_PROMPT = "Lütfen bir karakter seçiniz";
    public static final String INVALID_CHARACTER = "Geçersiz karakter!";
    
    // Stats
    public static final String PLAYER_STATS = "Oyuncu İstatikleri:";
    public static final String ENEMY_STATS = "%d. %s İstatistikleri";
    public static final String HEALTH = "Sağlık: %d";
    public static final String DAMAGE = "Hasar: %d";
    public static final String WEAPON = "Silah: %s";
    public static final String ARMOR = "Zırh: %s";
    public static final String BLOCK = "Bloklama: %d";
    public static final String MONEY = "Para: %d";
    public static final String AWARD = "Ödül: %d";
    
    // Store messages
    public static final String WELCOME_STORE = "********** Mağazaya Hoşgeldiniz. **********";
    public static final String WEAPONS_TITLE = "********** Silahlar **********";
    public static final String ARMORS_TITLE = "********** Zırhlar **********";
    public static final String SELECT_WEAPON = "Almak istediğiniz silahi seçiniz: ";
    public static final String SELECT_ARMOR = "Almak istediğiniz zırhı seçiniz: ";
    public static final String INSUFFICIENT_BALANCE = "Yetersiz bakiye.";
    public static final String WEAPON_PURCHASED = "%s silahını satın aldınız";
    public static final String ARMOR_PURCHASED = "%s zırhını satın aldınız";
    public static final String REMAINING_BALANCE = "Kalan bakiyeniz: %d";
    public static final String COME_AGAIN = "Yine Bekleriz :)";
    public static final String INVALID_VALUE = "Geçersiz değer, tekrar giriniz: ";
    
    // Safe House messages
    public static final String SAFE_HOUSE_MESSAGE = "Güvenli Evdesiniz!";
    public static final String HEALTH_RESTORED = "Canınız Yenilendi!";
    
    // Reward messages - ÖDEV 1
    public static final String REWARD_EARNED = "Tebrikler! %s kazandınız!";
    public static final String AREA_ALREADY_COMPLETED = "Bu bölgeyi zaten tamamladınız!";
    public static final String GAME_WON = "🎉🎉🎉 TEBRİKLER! TÜM ÖDÜLLERI TOPLADINIZ VE OYUNU KAZANDINIZ! 🎉🎉🎉";
    public static final String CHECKING_WIN_CONDITION = "Ödülleriniz kontrol ediliyor...";
    
    // Combat messages - ÖDEV 2
    public static final String FIRST_STRIKE_PLAYER = "İlk hamleyi SİZ yapıyorsunuz!";
    public static final String FIRST_STRIKE_ENEMY = "İlk hamleyi DÜŞMAN yapıyor!";
    
    // Loot messages - ÖDEV 3
    public static final String LOOT_DROPPED = "🎁 Düşman bir şey düşürdü!";
    public static final String LOOT_WEAPON = "⚔️ %s kazandınız!";
    public static final String LOOT_ARMOR = "🛡️ %s kazandınız!";
    public static final String LOOT_MONEY = "💰 %d TL kazandınız!";
    public static final String LOOT_NOTHING = "Düşman hiçbir şey düşürmedi.";
    public static final String MINE = "Maden";
    
    private Messages() {
        // Prevent instantiation
    }
}

